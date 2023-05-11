package practice1;

import java.util.Scanner;

public class Main {

    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> {
            if (s.length() == 4 || s.length() == 6) {
                try {
                    Integer.parseInt(s);
                    return true;
                } catch(Exception e) {
                    return false;
                }
            }
            return false;
        };
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println(predicate.test(str));
        str = scanner.nextLine();
        System.out.println(predicate.test(str));
    }
}
