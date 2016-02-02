package trietree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 2/2/16.
 */
public class Leet211 {
    public class WordDictionary {
        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
            boolean isLeaf;
        }
        private TrieNode root = new TrieNode();
        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
                if (i == word.length() - 1) {
                    node.isLeaf = true;
                }
            }
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return dfs(root, word, 0);
        }

        private boolean dfs(TrieNode node, String word, int k) {
            if (k == word.length()) {
                return node.isLeaf;
            }
            char ch = word.charAt(k);
            if (ch == '.') {
                for (char c: node.children.keySet()) {
                    if (dfs(node.children.get(c), word, k + 1)) {
                        return true;
                    }
                }
            }
            if (!node.children.containsKey(ch)) {
                return false;
            }
            return dfs(node.children.get(ch), word, k + 1);
        }
    }
}
