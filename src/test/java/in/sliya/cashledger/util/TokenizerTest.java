package in.sliya.cashledger.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TokenizerTest {

    @Test
    void tokenize() {

        List<String> tokens = Tokenizer.tokenize("helloWorld foo_bar_split This camelCase_  _BSTUIcsIs Here Multiple   Spaces");
        List<String> expected = Arrays.asList("hello", "World", "foo", "bar", "split", "This", "camel", "Case", "BSTU", "Ics", "Is", "Here", "Multiple", "Spaces");


        Assertions.assertEquals(expected, tokens);
    }
}
