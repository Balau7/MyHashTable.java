import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100000), "Name" + i);
            Student value = new Student("Student" + i, random.nextInt(30) + 18);
            table.put(key, value);
        }

        for (int i = 0; i < table.getCapacity(); i++) {
            System.out.println("Bucket " + i + " size: " + table.getBucketSize(i));
        }
    }
}
