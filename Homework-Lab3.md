###Tạo DATABASE quản lý thư viện  
Tạo DATABASE `library`  
```roomsql
CREATE DATABASE library
```  
Tạo bảng `category`  
```roomsql
CREATE TABLE category(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL
)
```  
Tạo bảng Ngôn ngữ `language`  
```roomsql
CREATE TABLE language(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL
)
```
Tạo bảng Đọc giả `users`  
```roomsql
CREATE TABLE users(
id INT NOT NULL PRIMARY KEY,
full_name VARCHAR(255) NOT NULL,
date_of_birth DATE NOT NULL,
mobile VARCHAR(11) NOT NULL,
email VARCHAR(255) NULL,
address TEXT NOT NULL,
passport VARCHAR(255) NOT NULL,
avatar TEXT NOT NULL
)
```  
Tạo bảng Nhân viên `staffs`  
```roomsql
CREATE TABLE staffs(
id INT NOT NULL PRIMARY KEY,
full_name VARCHAR(255) NOT NULL,
date_of_birth DATE NOT NULL,
mobile VARCHAR(11) NOT NULL,
address TEXT NOT NULL,
avatar TEXT NOT NULL
)
```  
Tạo bảng Nhà xuất bản `company`  
```roomsql
CREATE TABLE company(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
address TEXT NOT NULL
)
```  
Tạo bảng Tác giả `authors`  
```roomsql
CREATE TABLE authors(
id INT NOT NULL PRIMARY KEY,
full_name VARCHAR(255) NOT NULL,
birth_year YEAR NOT NULL,
dead_year YEAR NULL,
mobile VARCHAR(11) NOT NULL,
email VARCHAR(255) NULL,
address TEXT NOT NULL,
avatar TEXT NOT NULL

)
```  
Tạo bảng Sách `books`  
```roomsql
CREATE TABLE books(
id INT NOT NULL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
publishYear YEAR NOT NULL,
content TEXT NOT NULL,
id_company INT NOT NULL,
id_language INT NOT NULL,
pages INT NOT NULL,
FOREIGN KEY (id_language) REFERENCES language(id),
FOREIGN KEY (id_company) REFERENCES company(id)
)
```  
Tạo bảng `book_author`  
```roomsql
CREATE TABLE book_author(
id_book INT NOT NULL,
id_author INT NOT NULL,
PRIMARY KEY (id_book,id_author),
FOREIGN KEY (id_book) REFERENCES books(id),
FOREIGN KEY (id_author) REFERENCES authors(id)
)
```  
Tạo bảng `book_category`  
```roomsql
CREATE TABLE book_category(
id_book INT NOT NULL,
id_category INT NOT NULL,
PRIMARY KEY (id_book,id_category),
FOREIGN KEY (id_book) REFERENCES books(id),
FOREIGN KEY (id_category) REFERENCES category(id)
)
```
Tạo bảng Phiếu mượn sách `borrowed_notes`  
```roomsql
CREATE TABLE borrowed_notes(
id INT NOT NULL PRIMARY KEY,
id_user INT NOT NULL,
id_staff INT NOT NULL,
borrowed_date DATE NOT NULL,
deadline_date DATE NOT NULL,
FOREIGN KEY(id_user )REFERENCES users(id),
FOREIGN KEY(id_staff) REFERENCES staffs(id)
)
```   
Tạo bảng `borrow_note_book`  
```roomsql
CREATE TABLE borrowedNote_book(
id_note INT NOT NULL,
id_book INT NOT NULL,
amount INT NOT NULL,
PRIMARY KEY (id_note,id_book),
FOREIGN KEY (id_book) REFERENCES books(id),
FOREIGN KEY (id_note) REFERENCES borrowed_notes(id)
)
```  
Tạo bảng Phiếu trả `return_notes `  
```roomsql
CREATE TABLE return_notes(
id INT NOT NULL PRIMARY KEY,
id_borrowedNote INT NOT NULL,
return_date DATE NOT NULL,
FOREIGN KEY(id_borrowedNote) REFERENCES borrowed_notes(id)
)
```  
Tạo bảng Phạt `punish`  
```roomsql
CREATE TABLE punish(
id INT NOT NULL PRIMARY KEY,
id_borrowedNote INT NOT NULL,
id_returnNote INT NOT NULL,
book_price INT NOT NULL,
price_per_day INT NOT NULL,
FOREIGN KEY(id_borrowedNote) REFERENCES borrowed_notes(id),
FOREIGN KEY(id_returnNote) REFERENCES return_notes(id)
)
```  
###Kết quả liên kết  
![image](https://user-images.githubusercontent.com/95077178/155182030-6f008f34-2bfa-42c6-b662-c784f0a26ef9.png)  
###Thêm dữ liệu vào DATABASE  
Thêm dữ liệu vào bảng `users`  
![image](https://user-images.githubusercontent.com/95077178/155182419-b6b7086c-16d9-4ca0-99b5-803b0b173507.png)
Thêm dữ liệu vào bảng `staff`  
![image](https://user-images.githubusercontent.com/95077178/155182658-e680cf5c-5a23-463c-8d13-5665af66d946.png)  
Thêm dữ liệu vào bảng `language`  
![image](https://user-images.githubusercontent.com/95077178/155106510-8fdb4f58-f113-41a1-9e1d-62fb6a9e2b56.png)  
Thêm dữ liệu vào bảng `company`  
![image](https://user-images.githubusercontent.com/95077178/155183019-65a82dc3-307b-4be4-b249-39fea5347f4f.png)  
Thêm dữ liệu vào bảng `category`  
![image](https://user-images.githubusercontent.com/95077178/155106757-27aa2a1f-16b5-4d75-a594-a9b677586a71.png)  
Thêm dữ liêu vào bảng `authors`  
![image](https://user-images.githubusercontent.com/95077178/155183196-ca64ebce-4dda-4613-b939-7ac38eaa3319.png)  
Thêm dữ liêu vào bảng `books`  
![image](https://user-images.githubusercontent.com/95077178/155184339-8f8d5578-3100-4788-aee6-ce606d01d61b.png)  
Thêm dữ liệu vào bảng `book_author`  
![image](https://user-images.githubusercontent.com/95077178/155184559-6bf9f4f4-028c-415d-801c-db87c71be892.png)  
Thêm dữ liệu vào bảng `book_category`  
![image](https://user-images.githubusercontent.com/95077178/155184878-1211106e-15b1-4018-97b4-1d70dcb25159.png)
Thêm dữ liệu vào bảng `borrowed_notes`  
![image](https://user-images.githubusercontent.com/95077178/155185371-98238749-e444-465a-845f-b2dcadc437b9.png)  
Thêm dữ liệu vào bảng `borrow_note_book`  
![image](https://user-images.githubusercontent.com/95077178/155185578-7d6ffbf3-2a92-4e4f-ab84-7f6ef8b732df.png)
