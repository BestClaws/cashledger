package in.sliya.cashledger.modules;

import in.sliya.cashledger.dao.LedgerRecordDao;
import in.sliya.cashledger.dao.TagDao;
import in.sliya.cashledger.models.LedgerRecord;
import in.sliya.cashledger.modules.partsofspeech.PartType;
import in.sliya.cashledger.modules.partsofspeech.PartsOfSpeech;
import in.sliya.cashledger.util.Tokenizer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static in.sliya.cashledger.modules.partsofspeech.PartType.ADJECTIVE;
import static in.sliya.cashledger.modules.partsofspeech.PartType.NOUN;

@Component
public class Ledger {

    @Autowired
    LedgerRecordDao ledgerRecordDao;

    @Autowired
    TagDao tagDao;

    @Transactional
    public void createLedgerRecord(LedgerRecord record) {
        LedgerRecord insertedRecord = ledgerRecordDao.insert(record);

        List<String> tokens = Tokenizer.tokenize(insertedRecord.getRemarks());

        tokens.forEach(t -> {
            Set<PartType> partTypes = PartsOfSpeech.getPartTypes(t);
            Set<PartType> acceptedTypes = Set.of(NOUN, ADJECTIVE);

            for(PartType acceptedType: acceptedTypes) {
                if (partTypes.contains(acceptedType)) {
                    tagDao.insertOrUpdateFreq(t, 1f);
                    break;
                }
            }
        });

        ledgerRecordDao.insert(insertedRecord);
    }

    public List<LedgerRecord> getLedgerRecords() {
        return ledgerRecordDao.fetchAll();
    }

    public void undoEntry() {
       LedgerRecord record = ledgerRecordDao.removeLatest();
        Tokenizer.tokenize(record.getRemarks()).forEach(token -> {
            // TODO:  count common tokens and make a single call with bigger frequency instead.
            tagDao.updateOrRemoveFreq(token, 1f);
        });
    }
}
