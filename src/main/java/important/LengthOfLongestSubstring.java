package important;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    @Test
    public void testLengthOfLongestSubstring() {
        int i = lengthOfLongestSubstring("123sf113");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int r = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
