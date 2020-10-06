package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s number matches any of the keywords given.
 */
public class NumberContainsKeywordPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public NumberContainsKeywordPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        /*
        System.out.println("In number predicate: " + person.getPhone().value);
        for(int i = 0; i < keywords.size(); i = i + 1) {
            System.out.println("In number predicate: " + keywords.get(i));
            System.out.println("In number predicate: "
                    + StringUtil.containsWordIgnoreCase(person.getPhone().value, keywords.get(i)));
        }
        */
        return keywords.stream()
                .anyMatch((number) -> person.getPhone().value.toUpperCase().contains(number.toUpperCase()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof NumberContainsKeywordPredicate
                    && this.keywords.equals(((NumberContainsKeywordPredicate) other).keywords));
    }
}
