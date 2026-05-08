package com.example.moattravel.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.moattravel.entity.House;
import com.example.moattravel.form.HouseRegisterForm;
import com.example.moattravel.repository.HouseRepository;

@Service//サービスクラス
public class HouseService {
	private final HouseRepository houseRepository;

	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@Transactional//データの整合性を保つ
	public void create(HouseRegisterForm houseRegisterForm) {//データの登録処理
		House house = new House();//エンティティのインスタンス化
		MultipartFile imageFile = houseRegisterForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();//元のファイル名を取得
			String hashedImageName = generateNewFileName(imageName);//ファイル名をUUIDで別名に変更する処理
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);//ファイルのコピー処理 imageFileをfilePathにコピー
			house.setImageName(hashedImageName);
		}

		house.setName(houseRegisterForm.getName());
		house.setDescription(houseRegisterForm.getDescription());
		house.setPrice(houseRegisterForm.getPrice());
		house.setCapacity(houseRegisterForm.getCapacity());
		house.setPostalCode(houseRegisterForm.getPostalCode());
		house.setAddress(houseRegisterForm.getAddress());
		house.setPhoneNumber(houseRegisterForm.getPhoneNumber());

		houseRepository.save(house);//エンティティをデータベースに保存
	}

	//UUIDを使って生成したファイル名を返す
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");
		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}
		String hashedFileName = String.join(".", fileNames);
		return hashedFileName;
	}

	//画像ファイルを指定したファイルにコピーする
	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
