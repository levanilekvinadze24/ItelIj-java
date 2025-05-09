package fop.w9streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamIntro {
    public static final Person p1 = new Person("Paul", 20);
    public static final Person p2 = new Person("Mia", 23);
    public static final Person p3 = new Person("Leo", 23);
    public static final Person p4 = new Person("Elias", 23);
    public static final Person p5 = new Person("Laura", 22);

    public static double calculate(List<Double> input) {
        return input.stream().filter(x -> x >= 0).map(x -> x * x).reduce(0.0,
                (acc, x) -> acc + x);
    }

    public static Set<Person> toSetForEach(List<Person> input) {
        Set<Person> result = new HashSet<>();
        input.stream().forEach(p -> result.add(p));
        return result;
    }

    public static Set<Person> toSet(List<Person> input) {
        return input.stream().collect(Collectors.toSet());
    }

    public static double average(int[] input) {
        return Arrays.stream(input).average().getAsDouble();
    }

    public static double averageAge(List<Person> input) {
        return input.stream().mapToInt(Person::getAge).average().getAsDouble();
    }

    public static Map<Integer, List<Person>> groupByAgeForEach(
            List<Person> input) {
        Map<Integer, List<Person>> result = new HashMap<Integer, List<Person>>();
        input.stream().forEach(person -> {
            List<Person> l = result.get(person.getAge());
            if (l == null)
                result.put(person.getAge(), (l = new ArrayList<>()));
            l.add(person);
        });
        return result;
    }

    public static Map<Integer, List<Person>> groupByAge(List<Person> input) {
        return input.stream().collect(Collectors.groupingBy(Person::getAge));
    }
}
