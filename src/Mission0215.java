import java.util.List;
import java.util.stream.Stream;

public class Mission0215 {
    public static void main(String[] args) {
        List<String> names = List.of("이순신", "이성계", "김수로", "이방원", "춘향이", "몽룡이");

        Stream<String> stream1 = names.stream();
        stream1.filter(a -> a.charAt(0) < '이').forEach(n -> System.out.print(n + " "));

        System.out.println();
        stream1 = names.stream();
        stream1.sorted().forEach(n -> System.out.print(n + " "));

        System.out.println();
        stream1 = names.stream();
        System.out.println(stream1.findFirst());

        stream1 = names.stream();
        System.out.println(stream1.findFirst().get());

        stream1 = names.stream();
        System.out.println(stream1.count());
    }
}
