--productsテーブル--
INSERT IGNORE INTO products (id,product_name, origin, roast_level, description, price, image_file_name, created_at, updated_at) VALUES (1,'ブラジル サントス', 'ブラジル', '中煎り', 'ナッツのような香ばしさと甘み', 800, 'beans01.jpeg', NOW(), NOW());
INSERT IGNORE INTO products (id,product_name, origin, roast_level, description, price, image_file_name, created_at, updated_at) VALUES (2,'エチオピア イルガチェフェ', 'エチオピア', '浅煎り', 'フルーティーで華やかな香り', 950, 'beans02.jpeg', NOW(), NOW());
INSERT IGNORE INTO products (id,product_name, origin, roast_level, description, price, image_file_name, created_at, updated_at) VALUES (3,'コロンビア スプレモ', 'コロンビア', '中深煎り', 'バランスが良くコクがある味わい', 900, 'beans03.png', NOW(), NOW());
--rolesテーブル--
INSERT IGNORE INTO roles (id, role_name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, role_name) VALUES (2, 'ROLE_ADMIN');

--usersテーブル--
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (1, 1,  '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO',true);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (2, 2, '侍 花子', 'サムライ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);

-- cartsテーブル --
INSERT IGNORE INTO carts (id, user_id) VALUES (1, 1);