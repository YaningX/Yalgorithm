package trietree;

import java.util.*;

/**
 * Created by xuyaning on 3/2/16.
 */
public class Leet212 {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;
    }

    class TrieTree {
        TrieNode root = new TrieNode();
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

        public TrieNode searchNode(String word) {
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

    public List<String> findWords(char[][] board, String[] words) {
        TrieTree tree = new TrieTree();
        for (int i = 0; i < words.length; i++) {
            tree.insert(words[i]);
        }
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, tree, result, "", i, j);
            }
        }
        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, TrieTree tree, Set<String> result, String str, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        char ch = board[i][j];
        str += ch;
        TrieNode node = tree.searchNode(str);
        if (node == null) {
            return;
        }
        if (node.isLeaf == true) {
            result.add(str);
        }
        board[i][j] = '#';
        dfs(board, tree, result, str, i - 1, j);
        dfs(board, tree, result, str, i + 1, j);
        dfs(board, tree, result, str, i, j - 1);
        dfs(board, tree, result, str, i, j + 1);
        board[i][j] = ch;
    }
}
