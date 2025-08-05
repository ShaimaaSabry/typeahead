package shaimaa.typeahead;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TrieSearchResult {
    private String word;
    private int count;
}
