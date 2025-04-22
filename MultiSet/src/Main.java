public class Main {
    public static void main(String[] args) {
        // Create an ArrayMultiSet instance with a capacity of 5
        ArrayMultiSet<Integer> multiSet = new ArrayMultiSet<>(5);

        // Add elements to the multiset
        multiSet.add(2);
        multiSet.add(4);
        multiSet.add(2); // Adding duplicate
        multiSet.add(6);
        multiSet.add(4); // Adding duplicate

        // Uncomment the next line to test capacity limit
        // multiSet.add(5); // Should throw an IllegalArgumentException: MultiSet is full!!!

        // Print elements and counts
        System.out.println("Items in the MultiSet:");
        multiSet.prindItems(); // Output: 2 (2), 4 (2), 6 (1)

        // Check the total size of the multiset
        System.out.println("\nTotal size (including duplicates): " + multiSet.size()); // Output: 5

        // Check the number of distinct elements
        System.out.println("Number of distinct elements: " + multiSet.distincsize()); // Output: 3

        // Check if specific elements exist
        System.out.println("\nDoes the multiset contain 2? " + multiSet.contains(2)); // Output: true
        System.out.println("Does the multiset contain 5? " + multiSet.contains(5)); // Output: false

        // Get counts of specific elements
        System.out.println("\nCount of 2: " + multiSet.count(2)); // Output: 2
        System.out.println("Count of 4: " + multiSet.count(4)); // Output: 2
        System.out.println("Count of 6: " + multiSet.count(6)); // Output: 1
        System.out.println("Count of 5: " + multiSet.count(5)); // Output: 0
    }
}
