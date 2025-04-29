public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i, "Test" + i), "value" + i);
        }

        for (int i = 0; i < 11; i++) {
            int count = 0;
            var node = table.chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
