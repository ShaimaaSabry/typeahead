package shaimaa.typeahead;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String phase) {
        TrieNode current = this.root;
        for (char c : phase.toCharArray()) {
            TrieNode next = current.findChild(c);

            if (next == null) {
                next = new TrieNode(c);
                current.addChild(next);
            }

            current = next;
        }

        current.setLeaf();
    }

    private TrieNode find(String prefix) {
        TrieNode current = this.root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = current.findChild(c);

            if (next == null) {
                return null;
            }

            current = next;
        }

        return current;
    }

    public List<TrieSearchResult> search(String prefix) {
        List<TrieSearchResult> results = new ArrayList<>();

        TrieNode current = this.find(prefix);
        if (current != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            backtrack(current, results, sb);
        }

        return  results;
    }

    private void backtrack(TrieNode current, List<TrieSearchResult> results, StringBuilder sb) {
        if (current.isLeaf()) {
            TrieSearchResult word = new TrieSearchResult(sb.toString(), current.getCount());
            results.add(word);
        }

        for (Map.Entry<Character, TrieNode> child : current.getChildren().entrySet()) {
            sb.append(child.getKey());
            backtrack(child.getValue(), results, sb);
            sb.setLength(sb.length() -1);
        }
    }
}
