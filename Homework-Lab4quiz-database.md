###Tạo Database quiz  
```roomsql
CREATE DATABASE quiz
```  
Tạo bảng `questions`  
```roomsql
CREATE TABLE questions(
int INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
question TEXT NOT NULL,
type ENUM('single','multi') NOT NULL
)
```  
Tạo bảng `answers`  
```roomsql
CREATE TABLE answers(
int VARCHAR(7) NOT NULL PRIMARY KEY,
id_question INT NOT NULL,
content TEXT NOT NULL,
check ENUM('true','false') NOT NULL,
FOREIGH KEY(id_question) REFERENCES questions(id)
)
```  
Kết quả liên kết bảng  
![image](https://user-images.githubusercontent.com/95077178/155836938-9880a590-9b62-43f1-bac3-66f58e864d46.png)  
Thêm dữ liệu vào bảng `questions`  
![image](https://user-images.githubusercontent.com/95077178/155836959-581e4323-8cc9-45ce-ad68-16c4a164948f.png)  
Thêm dữ liệu vào bảng `answers`  
![image](https://user-images.githubusercontent.com/95077178/155836982-41c08f47-88f9-4001-951f-53b8a0f12b88.png)  

###Truy vấn kết quả  
Xem đáp án đúng của từng câu hỏi  
```roomsql
SELECT q.question,a.content 
FROM questions q 
INNER JOIN answers a ON q.id =a.id_question
WHERE a.`check` ='true'
```  
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155837130-2e4d22e7-b216-4706-8429-c07351a4d27a.png)  
