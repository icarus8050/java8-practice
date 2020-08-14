package effective_java.item_5;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon lexicon) {
        this.dictionary = Objects.requireNonNull(lexicon);
    }

    public boolean isValid(String word) {
        //something..
        return true;
    }

    public List<String> suggestions(String typo) {
        // something..
        return Collections.singletonList("blah");
    }
}
