package practice4;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        MyExecutorService a = new MyExecutorService(20);
        for (int j = 0; j < 100; j++) {
            final var j1 = j;
            a.submit(() -> System.out.println(j1));
        }
        a.submit(() -> {
            try {
                System.out.println("aa;;a");
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1");
        });
        a.submit(() -> {
            System.out.println("2");
        });

        System.out.println("I finished work");
    }
}
