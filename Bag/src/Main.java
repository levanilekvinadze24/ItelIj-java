public class Main {
    public static void main(String[] args){


        ArrayBag<Integer> bag = new ArrayBag(5);
        bag.add(2);
        bag.add(3);

        System.out.println(bag.size());
        System.out.println(bag.contains(2));

    }
}
