import java.util.*;

public class PhoneBook {
    private HashMap<String, HashSet<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (!book.containsKey(name)) {
            book.put(name, new HashSet<>());
        }
        book.get(name).add(phone);
    }

    public void print() {
        List<Map.Entry<String, HashSet<String>>> list = new LinkedList<>(book.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> o1, Map.Entry<String, HashSet<String>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });

        for (Map.Entry<String, HashSet<String>> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("John", "123-456-7890");
        pb.add("John", "234-567-8901");
        pb.add("Mary", "345-678-9012");
        pb.add("Bob", "456-789-0123");
        pb.add("Mary", "567-890-1234");
        pb.add("John", "678-901-2345"); // добавляем еще один номер для Джона
        pb.print();
    }
}