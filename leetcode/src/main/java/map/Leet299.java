package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet299 {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> mapSecret = new HashMap<Character, Integer>();
        Map<Character, Integer> mapGuess = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (!mapSecret.containsKey(secret.charAt(i))) {
                    mapSecret.put(secret.charAt(i), 1);
                } else {
                    mapSecret.put(secret.charAt(i), mapSecret.get(secret.charAt(i)) + 1);
                }
                if (!mapGuess.containsKey(guess.charAt(i))) {
                    mapGuess.put(guess.charAt(i), 1);
                } else {
                    mapGuess.put(guess.charAt(i), mapGuess.get(guess.charAt(i)) + 1);
                }
            }
        }

        for (Character ch: mapSecret.keySet()) {
            if (mapGuess.containsKey(ch)) {
                cow += Math.min(mapSecret.get(ch), mapGuess.get(ch));
            }
        }
        return "" + bull + "A" + cow + "B";
    }
}
