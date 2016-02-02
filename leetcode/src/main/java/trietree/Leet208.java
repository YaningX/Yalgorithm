package trietree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 2/2/16.
 */
public class Leet208 {
    class TrieNode {
        // Initialize your data structure here.
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;
        public TrieNode() {

        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
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

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = searchNode(word);
            return (node != null && node.isLeaf == true);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return searchNode(prefix) != null;
        }

        private TrieNode searchNode(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    return null;
                }
                node = node.children.get(ch);
            }
            return node;
        }
    }
}
