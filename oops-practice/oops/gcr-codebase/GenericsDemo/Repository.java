import java.util.ArrayList;
import java.util.List;

public class Repository<T> {

    private List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public List<T> getAll() {
        return data;
    }

    public void display() {
        for (T item : data) {
            System.out.println(item);
        }
    }
}