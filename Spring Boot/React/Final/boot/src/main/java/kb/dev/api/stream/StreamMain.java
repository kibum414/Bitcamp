package kb.dev.api.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static kb.dev.api.stream.RefUtil.rangeBelowRandom;

//class Student implements Comparable<Map<String, Object>> {
class Student implements Comparable<Student> {
    private String name;
    private String username; // ID
    private int grade;
    private int score;

    public Student(String name, String username, int grade, int score) {
        this.name = name;
        this.username = username;
        this.grade = grade;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return s.getScore() - this.getScore();
    }

//    @Override
//    public int compareTo(Map<String, Object> map) {
//        Student student = (Student)map.get("student");
//        String prop = (String)map.get("prop"); // 키값
//        String option = (String)map.get("option");
//
//        switch (prop) {
//            case "name": break;
//            case "username": break;
//            case "grade": return student.getGrade() - this.getGrade();
//            case "score": break;
//        }
//
//        return 0;
//    }
}

public class StreamMain {
    public static void main(String... args) {
//        new StreamUtil().arrayTolist(new String[]{"b", "c", "a"}).forEach(System.out::println);
//        System.out.println(RefUtil.strToInt.apply("1"));
//        RefUtil.print.accept("3");
//        System.out.println(RefUtil.objToStr.apply("5"));
//        System.out.println(RefUtil.equals.apply("1", "1"));

        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("메뉴: 0.EXIT 1.학년 오름차순 2.전학년 성적 내림차순 3.학년별 성적 내림차순 4.이름 오름차순 5.ID 오름차순");

            switch (scan.nextInt()) {
                case 0: return;
                case 1: ascGrade().forEach(System.out::println); break;
                case 2: descScore().forEach(System.out::println); break;
                case 3: ascName().forEach(System.out::println); break;
                case 4: ascUsername().forEach(System.out::println); break;
            }
        }
    }

    public static Stream<Student> makeStream() {
        DummyGenerator dg = new DummyGenerator();

        return
                Stream.of(
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100)),
                        new Student(dg.makeName(), dg.makeUsername(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(0, 100))
                );

    }
    public static Stream<Student> ascGrade() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getGrade) // Comparator.comparing(String s)
                        .thenComparing(Comparator.naturalOrder())); // Comparable compareTo(Object o)
    }

    public static Stream<Student> descGrade() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getScore).reversed() // Comparator.comparing(String s)
                        .thenComparing(Comparator.reverseOrder())); // Comparable compareTo(Object o)
    }

    public static Stream<Student> descScore() {
        return makeStream()
                .sorted(Comparator.naturalOrder()); // Comparable compareTo(Object o)
    }

    public static Stream<Student> ascName() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Comparator.naturalOrder()));
    }

    public static Stream<Student> ascUsername() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getUsername));
    }
}
