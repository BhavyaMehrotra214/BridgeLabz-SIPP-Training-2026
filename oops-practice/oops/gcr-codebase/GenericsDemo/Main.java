import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        Pair<String, Integer> pair =
                new Pair<>("Java", 101);

        System.out.println("Pair");
        System.out.println(pair);



        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nStack");
        stack.display();

        System.out.println("Pop : " + stack.pop());
        System.out.println("Peek : " + stack.peek());



        Integer[] numbers = {15, 8, 29, 45, 12};

        Integer max = GenericUtils.findMax(numbers);

        System.out.println("\nMaximum = " + max);



        Repository<Student> repo = new Repository<>();

        repo.add(new Student(1, "Rahul"));
        repo.add(new Student(2, "Priya"));
        repo.add(new Student(3, "Ankit"));

        System.out.println("\nRepository");
        repo.display();



        List<String> names =
                Arrays.asList("Aman", "Neha", "Riya");

        System.out.println("\nWildcard List");

        GenericUtils.printList(names);
    }
}