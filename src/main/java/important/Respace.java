package important;

import org.junit.jupiter.api.Test;

public class Respace {
    @Test
    public void testRespace() {
        String[] dictionary = {"wmw", "wmm", "ww"};
        String sentence = "wmwwwmm";
        System.out.println(respace1(dictionary, sentence));
    }

    public int respace1(String[] dictionary, String sentence) {

        int n = sentence.length();
        int m = dictionary.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int j = 0; j < m; j++) {
                if (dictionary[j].length() > i) continue;
                if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
                    dp[i] = Math.max(dp[i - dictionary[j].length()] + dictionary[j].length(), dp[i]);
                }
            }
        }
        return n - dp[n];
    }

    public int respace(String[] dictionary, String sentence) {
        int sum = 0;
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        Trie curPos = trie;
        if (curPos.isEnd) {
            return 0;
        }
        int j;
        int i = 0;
        while (i <= sentence.length() - 1) {
            j = i;
            int pos = sentence.charAt(j) - 'a';
            curPos = trie;

            while (curPos.next[pos] != null) {
                j++;//
                curPos = curPos.next[pos];

                if (curPos.isEnd) {
                    i = j;
                    break;
                }
                if (j >= sentence.length()) {
                    break;
                }

                pos = sentence.charAt(j) - 'a';
            }


            if (i != j) {
                sum += (j - i);
                i++;
            } else if ((!curPos.isEnd) && curPos.next[pos] == null) {
                sum++;
                i++;
            }
        }
        return sum;
    }

    class Trie {
        boolean isEnd;
        Trie[] next;

        public Trie() {
            this.isEnd = false;
            this.next = new Trie[26];
        }

        public void insert(String str) {
            Trie curPos = this;

            for (int i = 0; i <= str.length() - 1; i++) {
                int pos = str.charAt(i) - 'a';
                if (curPos.next[pos] == null) {
                    curPos.next[pos] = new Trie();
                }
                curPos = curPos.next[pos];
            }
            curPos.isEnd = true;
        }

    }
}
