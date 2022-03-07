import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn = connectDatabase.connect();

    public List<Post> getAllPost() {
        String query = "SELECT * FROM post WHERE status='public'";
        List<Post> list = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                LocalDate date = LocalDate.parse(result.getString("create_at"));
                String thumbnail = result.getString("thumnail");

                list.add(new Post(id, title, description, thumbnail, date));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Post_Author getPostById(int searchId) {
        Post_Author findPost = null;
        String query = "SELECT p.id as post_number,p.title,p.content,a.name as name_author,JSON_ARRAYAGG(JSON_OBJECT('tag', t.name)) as tag_name,p.create_at FROM `post` p\n" +
                "INNER JOIN author a ON a.id=p.id_author\n" +
                "INNER JOIN post_tag pt ON pt.id_post=p.id\n" +
                "INNER JOIN tag t ON pt.id_tag=t.id\n" +
                "WHERE p.id=" + searchId;
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("post_number");
                String title = result.getString("title");
                String content = result.getString("content");
                String author_name = result.getString("name_author");
                String tag = result.getString("tag_name");
                LocalDate date = LocalDate.parse((result.getString("create_at")));

                findPost = new Post_Author(id, title, content, author_name, tag, date);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findPost;
    }

    public void updatePost(Post_Author post) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập title mới cho post: ");
        String title = sc.nextLine();
        System.out.println("Nhập content mới cho post");
        String content = sc.nextLine();
        String query = "UPDATE post SET title ='" + title + "',content='" + content + "'WHERE id=" + post.getId();

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Cập nhật thành công!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(Post_Author post) {
        String query = "DELETE FROM post WHERE id=" + post.getId();

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Xoá thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Post_Add createNewPost() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tiêu để bài viết: ");
        String title = sc.nextLine();
        System.out.println("Nội dung bài viết: ");
        String content = sc.nextLine();
        System.out.println("Chú thích");
        String description = sc.nextLine();
        System.out.println("Ảnh: ");
        String thumbnail = sc.nextLine();
        System.out.println("ID tác giả: ");
        int id_author = Integer.parseInt(sc.nextLine());
        System.out.println("ID category: ");
        int id_category = Integer.parseInt(sc.nextLine());
        System.out.println("Trạng thái: ");
        Status status = inputStatus();

        return new Post_Add(title, content, description, thumbnail, id_author, id_category, LocalDate.now(), status);
    }

    public Status inputStatus() {
        System.out.println("1 - Công khai");
        System.out.println("2 - Ẩn");
        System.out.println("3 - Nháp");
        System.out.println("Lựa chọn của bạn là: ");
        Scanner sc = new Scanner(System.in);
        Status status = Status.PUBLIC;
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 2 -> status = Status.HIDDEN;

            case 3 -> status = Status.DRAFT;

        }
        return status;
    }

    public void addNewPost() {
        Post_Add post = createNewPost();
        String query = "INSERT INTO `post`(`id`, `title`, `content`, `description`, `thumnail`, `id_category`, `id_author`, `create_at`, `status`) VALUES (null,'" + post.getTitle() + "','" + post.getContent() + "','" + post.getDescription() + "','"+post.getThumbnail() + "','" + post.getId_author() + "','" + post.getId_category() + "',CURRENT_DATE(),'" + post.getStatus().getValue() + "')";

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void show(List<?> list) {
        list.forEach(System.out::println);
    }
}
