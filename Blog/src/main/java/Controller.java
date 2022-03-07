import java.util.List;
import java.util.Scanner;

public class Controller {
    static Scanner sc = new Scanner(System.in);
    static Service service = new Service();

    public static void menu() {
        boolean isContinue = true;
        while (isContinue) {
            mainMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    List<Post> list = service.getAllPost();
                    service.show(list);
                }

                case 2 -> searchPostByID();

                case 3 -> {
                    service.addNewPost();
                    System.out.println("Các bài viết sau khi thêm");
                    List<Post> list = service.getAllPost();
                    service.show(list);
                }
                case 0 -> System.exit(0);
            }

        }
    }

    public static void searchPostByID() {
        System.out.println("Blog có ID là 1:");
        Post_Author post = service.getPostById(1);
        System.out.println(post);
        subMenu();
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> {
                service.updatePost(post);
                System.out.println("Bài viết sau khi cập nhật: ");
                System.out.println(post);
            }
            case 2 -> {
                service.deletePost(post);
                System.out.println("Danh sách các bài viết sau khi xoá: ");
                List<Post> list = service.getAllPost();
                service.show(list);
            }
            case 0 -> menu();
        }
    }

    public static void mainMenu() {
        System.out.println("----------------------------------------------------");
        System.out.println("1 - Xem các bài viết có trạng thái Công khai");
        System.out.println("2 - Tìm thông tin bài viết theo ID");
        System.out.println("3 - Thêm bài viết mới");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là:");
    }

    public static void subMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println("1 - Cập nhật title và content của bài viết");
        System.out.println("2 - Xoá bài viết");
        System.out.println("0 - Về menu chính");
    }
}
