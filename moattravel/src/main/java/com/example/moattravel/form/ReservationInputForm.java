package com.example.moattravel.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ReservationInputForm {
	@NotBlank(message = "チェックイン日とチェックアウト日を選択してください。")
	//カレンダーは範囲入力が文字列で送信されるためString
	private String fromCheckinDateToCheckoutDate;

	@NotNull(message = "民宿人数を入力してください。")
	@Min(value = 1, message = "民宿人数は1人以上に設定してください。")
	private Integer numberOfPeople;

	//チェックイン日を取得する
	public LocalDate getCheckinDate() {
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split("から");
		//LocalDate.parse()文字列⇒日付型へ変換
		return LocalDate.parse(checkinDateAndCheckoutDate[0].trim());

	}

	//チェックアウト日を取得する
	public LocalDate getCheckoutDate() {
		//split()後、2026-05-10から2026-05-12を「から」を境に[0]と[1]に文字列として分割
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split("から");
		//parse(）文字列を別の型へ変換する
		return LocalDate.parse(checkinDateAndCheckoutDate[1].trim());
	}
}
