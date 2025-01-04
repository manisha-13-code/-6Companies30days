import java.util.HashMap;

public class bullsAndCowsSolution {
    public String getHint(String secret, String guess) {
       int bulls = 0;
       int cows = 0; 

       HashMap<Character, Integer> mp = new HashMap<>();

       for(int i = 0; i < secret.length(); i++) {

        if(secret.charAt(i) == guess.charAt(i)) {
            bulls++;
            if(i != 0) {
                guess = guess.substring(0, i) + "X" +guess.substring(i+1);
            } else {
                guess = "X" + guess.substring(i+1);
            }
        } else {
            if(mp.containsKey(secret.charAt(i))) {
                mp.put(secret.charAt(i), mp.get(secret.charAt(i)) + 1);
            } else {
                mp.put(secret.charAt(i), 1);
            }
        }
       }

       for(int i = 0; i < guess.length(); i++) {
        char a = guess.charAt(i);

        if(mp.containsKey(a) && mp.get(a) == 1) {
            cows++;
            mp.remove(a);
        } else if(mp.containsKey(a) && mp.get(a) > 1) {
            cows++;
            mp.put(a, mp.get(a) - 1);
        }
       }

       return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
