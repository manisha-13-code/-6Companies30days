import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class findRepeatedDnaSequences {
    public static List<String> RepeatedDnaSequences(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);

            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }

        return new ArrayList<>(repeated);
    }
    
}
