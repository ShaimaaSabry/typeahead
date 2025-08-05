package shaimaa.typeahead;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Typeahead {
    private Trie trie;

    public Typeahead() {
        this.trie = new Trie();
    }

    public void insert(String phase) {
        this.trie.insert(phase);
    }

    public List<String> search(String prefix) {
        List<TrieSearchResult> results = this.trie.search(prefix);

        Collections.sort(results, Comparator.comparing(TrieSearchResult::getCount).reversed());

        return results.stream().map(TrieSearchResult::getWord).collect(Collectors.toList());
    }
}
