import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    List<Person> personList = new ArrayList<Person>();

    public List<Person> addList() {
        personList.add(new Person("Tung", "Viet Nam", 26));
        personList.add(new Person("Hoa", "Viet Nam", 27));
        personList.add(new Person("C.Ronaldo", "Portugal", 37));
        personList.add(new Person("NeyMar", "Brazil", 28));
        personList.add(new Person("Embappe", "France", 25));
        personList.add(new Person("Jack", "England", 19));
        personList.add(new Person("Thosmart", "England", 31));

        return personList;
    }

    public void show() {
        System.out.println("List of People");
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    public void filterPeopleByAge() {
        System.out.println("Lọc người có độ tuổi từ 20-30");
        for (Person person : personList) {
            if (person.getAge() >= 20 && person.getAge() <= 30) {
                System.out.println(person);
            }
        }
    }

    public void avgAllAge() {
        Double sumAllAge = 0.0;
        for (Person person : personList) {
            sumAllAge += person.getAge();
        }
        int a = personList.size();
        Double avgAllAge = sumAllAge / a;
        System.out.println("Tuổi trung bình của tất cả mọi người: " + avgAllAge);
    }

    public void avgByAgeofNationality() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tuổi trung bình theo từng quốc tịch");
        System.out.println("------------------------------------------");
        System.out.println("Nhập tên quốc tịch cần tìm");
        String nationality = sc.nextLine();
        for (Person person : personList) {
            if (person.getNationality().equals(nationality)) {
                System.out.println(person);
            }
        }
    }
}