###Bài tập truy vấn  
1, Sử dụng database library thực hiện các truy vấn sau:  
<li>Lấy ra các quyển sách được xuất trước năm 1900</li>  
<li>Lấy ra các quyển sách có số lượng trang dưới 100</li>  
<li>Liệt kê các quyển sách có id_publisher = 1 và sắp xếp theo thứ tự tăng dần của số trang</li>  

Câu truy vấn  
```roomsql
SELECT b.title ,b.description ,b.year_of_publication 
FROM book b 
WHERE b.year_of_publication <1900
```  
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155403304-57e0a532-51b4-4366-af48-578428563342.png)

Câu truy vấn  
```roomsql
SELECT b.title ,b.description ,b.page_number 
FROM book b 
WHERE page_number<100
```  
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155403771-858db75d-4375-413c-a27a-8485900ff419.png)

Câu truy vấn  
```roomsql
SELECT b.title ,b.description ,b.id_publisher ,b.page_number 
FROM book b 
WHERE id_publisher =1
ORDER BY page_number ASC
```  
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155404842-ecf81005-c6d5-42b8-89af-8b0f3c251023.png)  

2, Sử dụng database sakila thực hiện các truy vấn sau:  
<li>Tính trung bình cộng rental_rate của các bộ phim có rating là R</li>  
<li>Đếm các bộ phim có special_features là Deleted Scenes</li>  
<li>Tìm các bộ phim theo tên có chứa ‘ACADEMY’</li>  

Câu truy vấn  
```roomsql
SELECT AVG(rental_rate)
FROM  film f 
WHERE f.rating ='R'
```
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155410600-5ece4cf3-939d-43cc-999c-72131f5a13d9.png)  

Câu truy vấn  
```roomsql
SELECT COUNT(film_id)
FROM film f 
WHERE f.special_features ='Deleted Scenes'
```   
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155411551-b8df0981-9d52-4ca3-aafd-a56ea9df9997.png)  

Câu truy vấn  
```roomsql
SELECT f.title ,f.description 
FROM film f 
WHERE f.title LIKE '%ACADEMY%'
```  
Kết quả truy vấn  
![image](https://user-images.githubusercontent.com/95077178/155412099-2b50006f-ae1f-43e7-9adc-09141eb0d5c8.png)

