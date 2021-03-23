package DependencyInjection;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DependencyInjection {
    private final static SpellChecker sc = new SpellChecker(new DutchDictionary());

    public static void main(String[] args) {
        System.out.println(sc.isValid("test"));
        System.out.println(sc.suggestions("tesd"));
    }
}

class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.getWords().contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.getWords().stream()
                .filter(word -> word.startsWith(typo.substring(0, typo.length() - 1)))
                .collect(Collectors.toList());
    }
}

abstract class Lexicon {
    private Set<String> words;

    public abstract Set<String> getWords();
}

class EnglishDictionary extends Lexicon {
    private static final Set<String> WORDS = new TreeSet<>();

    static {
        WORDS.add("test");
    }

    @Override
    public Set<String> getWords() {
        return new TreeSet<>(WORDS);
    }
}

class DutchDictionary extends Lexicon {
    private static final Set<String> WORDS = new TreeSet<>();

    static {
        WORDS.add("test");
    }

    @Override
    public Set<String> getWords() {
        return new TreeSet<>(WORDS);
    }
}