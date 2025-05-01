import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class StreamIntro {
    public static final Person p1 = new Person("Paul", 20);
    public static final Person p2 = new Person("Mia", 23);
    public static final Person p3 = new Person("Leo", 23);
    public static final Person p4 = new Person("Elias", 23);
    public static final Person p5 = new Person("Laura", 23);


    public static double calculate(List<Double> input) {
        return input.stream().filter(x -> x >= 0).map(x -> x * x).reduce(0.0, (acc, x) -> acc + x);
    }

    public static Set<Person> toSetForeach(List<Person> input) {
        Set<Person> result = new HashSet();
        input.stream().forEach(p -> result.add(p));//amatebs setshi titoeul p s
        return result;
    }

    public static Set<Person> toSetCollect(List<Person> input) {
        return input.stream().collect(Collectors.toSet());//agrovebs da setad qmnis ra
    }

    public static double avarage(int[] input) {
        OptionalDouble optionalDouble = Arrays.stream(input).average();//avarage viyneb marto arraystreamze pirdapir
        if(optionalDouble.isPresent()){
            return optionalDouble.getAsDouble();
        }else {
            return 0.0;
        }
    }
    public static double avaragemaptoint(List<Person> input){
        return input.stream().mapToInt(p ->p.getAge()).average().getAsDouble();
    }
    public static Map<Integer , List<Person>> groupingbyageforeach(List<Person> input) {
        Map<Integer , List<Person>> result = new HashMap<Integer , List<Person>>();
        input.stream().forEach(person -> {
            if(result.containsKey(person.getAge())){
                result.get(person.getAge()).add(person);
            }else{
                List<Person> list = new ArrayList<>();
                list.add(person);
                result.put(person.getAge(), list);
            }
        });
        return result;
    }
    public static Map<Integer, List<Person>> groupByAge(List<Person> input){
        return input.stream().collect(Collectors.groupingBy(person -> person.getAge()));
    }

}