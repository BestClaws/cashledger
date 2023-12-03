package in.sliya.cashledger.util;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<String> tokenize(String input) {
       List<String> tokens = new ArrayList<>();

       int wordStart = 0;
       int wordLength = 0;

       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);

           if (c == ' ' || c == '_') {
               if (wordLength != 0) {
                   tokens.add(input.substring(wordStart, wordStart + wordLength));
               }
               wordLength = 0;
               wordStart = i + 1;
           } else if (i > 0 && Character.isUpperCase(c) && !Character.isUpperCase(input.charAt(i-1))) {
               if (wordLength != 0) {
                   tokens.add(input.substring(wordStart, wordStart+ wordLength));
               }
               wordStart = i;
               wordLength = 1;
           } else if (Character.isUpperCase(c) && Character.isLowerCase(input.charAt(i + 1))) {
               tokens.add(input.substring(wordStart, wordStart + wordLength));
               wordStart = i;
               wordLength = 1;
           } else {
               wordLength++;
           }
       }

       // append the last word
        if (wordLength != 0) {
            tokens.add(input.substring(wordStart, wordStart + wordLength));
        }

       return tokens;
    }
}
