public class Main {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new ArrayPriorityQueuue<>(10);

        queue.enqueue("apple", 2);
        queue.enqueue("orange", 1);
        queue.enqueue("banana", 3);

        System.out.println(queue.dequeue());  // Output: "banana" (highest priority)
        System.out.println(queue.size());     // Output: 2
        System.out.println(queue.contains("orange"));  // Output: true
        System.out.println(queue.dequeue());  // Output: "apple" (next highest priority)
    }
}
