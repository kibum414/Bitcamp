package kb.dev.api.stream;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

import static kb.dev.api.stream.RefUtil.rangeBelowRandom;

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
        return this.getScore() - s.getScore();
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
            System.out.println("메뉴: 0.EXIT 1.학년 오름차순 2.학년별 성적 내림차순 3.전체 성적 내림차순 4.이름 오름차순 5.ID 오름차순");

            switch (scan.nextInt()) {
                case 0:
                    return;
                case 1:
                    ascGrade().forEach(System.out::println);
                    break;
                case 2:
                    descScoreByGrade().forEach(System.out::println);
                    break;
                case 3:
                    descScore().forEach(System.out::println);
                    break;
                case 4:
                    ascName().forEach(System.out::println);
                    break;
                case 5:
                    ascUsername().forEach(System.out::println);
                    break;
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

    // 학년 오름차순 -> 성적 오름차순
    public static Stream<Student> ascGrade() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getGrade) // Comparator.comparing(String s)
                        .thenComparing(Comparator.naturalOrder())); // Comparable compareTo(Object o)
    }

    // 학년 내림차순 -> 성적 내림차순
    public static Stream<Student> descScoreByGrade() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getGrade).reversed() // Comparator.comparing(String s)
                        .thenComparing(Comparator.reverseOrder())); // Comparable compareTo(Object o)
    }

    // 성적 내림차순
    public static Stream<Student> descScore() {
        return makeStream()
                .sorted(Comparator.reverseOrder()); // Comparable compareTo(Object o)
    }

    // 이름 오름차순 -> 성적 오름차순
    public static Stream<Student> ascName() {
        return makeStream()
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Comparator.naturalOrder()));
    }

    // ID 오름차순
    public static Stream<Student> ascUsername() {
        return makeStream()
                .map(student -> {
                    student.setUsername(student.getUsername().toLowerCase());
                    return student;
                })
                .distinct()
                .sorted(Comparator.comparing(Student::getUsername));
    }
}
