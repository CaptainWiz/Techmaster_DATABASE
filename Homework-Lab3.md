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
name VARCHAR(255) NOT NULL,
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
name VARCHAR(255) NOT NULL,
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
name VARCHAR(255) NOT NULL,
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
id_language INT NOT NULL,
pages INT NOT NULL,
FOREIGN KEY (id_language) REFERENCES language(id)
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
Tạo bảng `book_company`  
```roomsql
CREATE TABLE book_company(
id_book INT NOT NULL,
id_company INT NOT NULL,
PRIMARY KEY (id_book,id_company),
FOREIGN KEY (id_book) REFERENCES books(id),
FOREIGN KEY (id_company) REFERENCES company(id)
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
![image](https://user-images.githubusercontent.com/95077178/155095299-6903a358-f84d-495a-ab92-fa9308a7f29e.png)  
###Thêm dữ liệu vào DATABASE  
Thêm dữ liệu vào bảng `users`  
![image](https://user-images.githubusercontent.com/95077178/155097461-c9ef8a51-1efe-40fd-81a0-4508579b88a6.png)
Thêm dữ liệu vào bảng `staff`  
![image](https://user-images.githubusercontent.com/95077178/155106394-193bec0e-a6c9-4e2e-a300-7f73d72ef692.png)  
Thêm dữ liệu vào bảng `language`  
![image](https://user-images.githubusercontent.com/95077178/155106510-8fdb4f58-f113-41a1-9e1d-62fb6a9e2b56.png)  
Thêm dữ liệu vào bảng `company`  
![image](https://user-images.githubusercontent.com/95077178/155106613-d5162d26-d062-4b25-812e-87bc36e0f814.png)  
Thêm dữ liệu vào bảng `category`  
![image](https://user-images.githubusercontent.com/95077178/155106757-27aa2a1f-16b5-4d75-a594-a9b677586a71.png)  
Thêm dữ liêu vào bảng `authors`  
![image](https://user-images.githubusercontent.com/95077178/155106863-90afd269-5f7d-4f16-961b-2d6e9c7572a9.png)  
Thêm dữ liêu vào bảng `books`  
![image](https://user-images.githubusercontent.com/95077178/155106978-94910d78-6ba0-4dfa-9bb1-f70c88dc8453.png)  
Thêm dữ liệu vào bảng `book_author`  
![image](https://user-images.githubusercontent.com/95077178/155107217-eceabf53-797d-4636-b695-0f9db995d90e.png)  
Thêm dữ liệu vào bảng `book_category`  
![image](https://user-images.githubusercontent.com/95077178/155107388-d891f35d-d72e-456a-ae50-732bfb643107.png)  
Thêm dữ liệu vào bảng `book_company`  
![image](https://user-images.githubusercontent.com/95077178/155107486-62cf7765-7b87-41d1-92bc-4c205e8c30e4.png)  
Thêm dữ liệu vào bảng `borrowed_notes`  
![image](https://user-images.githubusercontent.com/95077178/155107612-213fb2a0-041f-4c9a-ab64-e5de84d721ac.png)  
Thêm dữ liệu vào bảng `borrow_note_book`  
![image](https://user-images.githubusercontent.com/95077178/155107901-af282e71-1ff3-48aa-9a79-870f9b9fa1a6.png)