package pkb.dev.api.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

import static pkb.dev.api.stream.RefUtil.rangeBelowRandom;

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
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore() - this.getScore();
    }
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
            System.out.println("메뉴: 0.EXIT 1.학년 오름차순 2.성적 내림차순 3.이름 오름차순 4.ID 오름차순");

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
        return makeStream().sorted(Comparator.comparing(Student::getGrade)
                .thenComparing(Comparator.naturalOrder()));
    }

    public static Stream<Student> descScore() {
        return makeStream().sorted(Comparator.comparing(Student::getScore)
                .reversed());
    }

    public static Stream<Student> ascName() {
        Stream<String> studentStream = makeStream().map(Student::getName);

        return null;
    }

    public static Stream<Student> ascUsername() {

        return null;
    }
}
