package shaimaa.typeahead;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TrieNode {
    private char c;
    private Map<Character, TrieNode> children;
    private boolean isLeaf;
    private int count = 0;

    TrieNode() {
        this.children = new HashMap<>();
    }

    TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }

    void setLeaf() {
        this.isLeaf = true;
        this.count++;
    }

    public void addChild(TrieNode child) {
        this.children.put(child.getC(), child);
    }

    public TrieNode findChild(char c) {
        return this.children.get(c);
    }
}
