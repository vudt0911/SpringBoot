import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        controller.addList();
        Menu.menu();
        System.out.println("----------------------------");
        boolean check = false;
        while (!check) {
            System.out.println("Nhập lựa chọn của bạn");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    controller.show();
                    break;
                case 2:
                    controller.filterPeopleByAge();
                    break;
                case 3:
                    controller.avgAllAge();
                    break;
                case 4:
                    controller.avgByAgeofNationality();
                    break;
                case 5:
                    check = true;
                default:
                    System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }
}
