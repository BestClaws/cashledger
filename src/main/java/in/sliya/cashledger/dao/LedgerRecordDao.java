package in.sliya.cashledger.dao;

import in.sliya.cashledger.models.LedgerRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class LedgerRecordDao {


    private final Logger logger = LoggerFactory.getLogger(LedgerRecord.class);
    @Autowired
    @PersistenceContext
    EntityManager em;

    public LedgerRecord insert(LedgerRecord record) {
        return em.merge(record);
    }

    public List<LedgerRecord> fetchAll() {
       TypedQuery<LedgerRecord> query = em.createNamedQuery("find_all_records", LedgerRecord.class);
       return query.getResultList();
    }

    @Transactional
    public LedgerRecord removeLatest() {
        TypedQuery<LedgerRecord> query = em.createNamedQuery("find_latest_record", LedgerRecord.class);
        Optional<LedgerRecord> r = query.setMaxResults(1).getResultList().stream().findFirst();
        if (r.isEmpty()) {
            logger.info("invoked undoEntry() but nothing to do, as no latest records or any records were found.");
            return null;
        }
        LedgerRecord record = r.get();
        em.remove(record);
        return record;
    }
}
