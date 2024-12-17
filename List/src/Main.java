public class Main {
    public static void main(String[] args) {

        List list1 = new List(10, null);


        list1.insert(4);
        list1.insert(5);
        list1.insert(8);
        System.out.println(list1);

        System.out.println("length of list : " + list1.length());

        list1.delete();
        System.out.println("list after deletion" + list1);

        int[] array = {0, 1, 1, 2, 3, 5, 8, 13};
        List listFromArray = List.ArrayToList(array);
        System.out.println("List from array: " + listFromArray);

        int[] ArrFromList = listFromArray.ListToArray();
        System.out.println("array from list is : " + java.util.Arrays.toString(ArrFromList));
    }
}