package in.sliya.cashledger.modules.partsofspeech;

import java.util.ArrayList;
import java.util.Set;

import static in.sliya.cashledger.modules.partsofspeech.PartType.NOUN;
import static in.sliya.cashledger.modules.partsofspeech.PartType.PRONOUN;

public class PartsOfSpeech {

    static public Set<PartType> getPartTypes(String word) {
        return Set.of(NOUN, PRONOUN);
    }
}


