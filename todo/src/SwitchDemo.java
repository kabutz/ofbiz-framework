import java.util.concurrent.*;

public class SwitchDemo {
    public static void main(String... args) {
        System.out.println("Enjoy the refactoring!");
        for (int repeat = 0; repeat < 32; repeat++) {
            switch (make()) {
                case Integer i -> System.out.println("Integer i " + i);
                case Long l -> System.out.println("Long l " + l);
                case Double d -> System.out.println("Double d " + d);
                case null -> System.out.println("null");
                default -> System.out.println("default " + make());
            }
        }
    }

    private static Number make() {
        return switch (ThreadLocalRandom.current().nextInt(5)) {
            case 0 -> 1; // Integer
            case 1 -> 1.0; // Double
            case 2 -> 42L; // Long
            case 3 -> 3.14f;
            default -> null;
        };
    }
}