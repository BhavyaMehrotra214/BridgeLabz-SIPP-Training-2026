import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SupportTicketAnagramGroups {

    static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {

            char[] chars = s.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            groups.putIfAbsent(key, new ArrayList<>());

            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {

        String[] tickets = {
                "eat", "tea", "tan",
                "ate", "nat", "bat"
        };

        List<List<String>> result = groupAnagrams(tickets);

        System.out.println("Grouped Anagrams:");

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}