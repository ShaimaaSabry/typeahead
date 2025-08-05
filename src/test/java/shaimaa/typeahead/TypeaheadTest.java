package shaimaa.typeahead;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeaheadTest {

    @Test
    void givenItemsInserted_whenSearch_thenReturnCorrectResults() {
        // Given
        Typeahead typeahead = new Typeahead();
        typeahead.insert("camel");
        typeahead.insert("cat");
        typeahead.insert("cat");
        typeahead.insert("cat");
        typeahead.insert("dog");
        typeahead.insert("dangerous");
        typeahead.insert("doctor");
        typeahead.insert("car");
        typeahead.insert("car");
        typeahead.insert("car");
        typeahead.insert("car");
        typeahead.insert("car");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("caramel sauce");
        typeahead.insert("elephant");

        // When
        var results = typeahead.search("ca");

        // Then
        assertEquals(4, results.size());
        assert results.stream().anyMatch(r -> r.equals("camel")) : "Expected 'camel' in results";
        assert results.stream().anyMatch(r -> r.equals("cat")) : "Expected 'cat' in results";
        assert results.stream().anyMatch(r -> r.equals("car")) : "Expected 'car' in results";
        assert results.stream().anyMatch(r -> r.equals("caramel sauce")) : "Expected 'caramel sauce' in results";
    }
}
