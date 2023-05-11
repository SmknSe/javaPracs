package practice2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Human> input = new ArrayList<>();
        input.add(new Human(20, "Alex", "Brown", LocalDate.of(2010, 10, 10), 40));
        input.add(new Human(45, "Bob", "Grenn", LocalDate.of(1990, 10, 10), 50));
        input.add(new Human(56, "Frank", "Morales", LocalDate.of(1972, 10, 10), 60));
        input.add(new Human(10, "Jason", "Aa", LocalDate.of(1967, 10, 10), 70));
        input.add(new Human(73, "John", "Sklncdslkc", LocalDate.of(2000, 10, 10), 80));
        input.add(new Human(100, "Paul", "Ppop", LocalDate.of(1950, 10, 10), 90));
        input.add(new Human(83, "Martin", "LMKNJd", LocalDate.of(1900, 10, 10), 100));
        input.add(new Human(90, "Kate", "KJSNKCNKSJ", LocalDate.of(1930, 10, 10), 20));
        input.add(new Human(15, "Mary", "Mask", LocalDate.of(1230, 10, 10), 30));
        input.add(new Human(36, "Charly", "XAE-16-28", LocalDate.of(1569, 10, 10), 42));
        Stream<Human> stream = input.stream();
        input = stream.filter(human -> human.weight > human.age).sorted(Comparator.comparing(Human::getLastName).reversed()).toList();
        for (Human h : input) {
            System.out.println(h);
        }
        final int res = input.stream().mapToInt(Human::getWeight).sum();
        System.out.println(res);
    }
}
