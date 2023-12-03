package in.sliya.cashledger.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NamedQueries({

        @NamedQuery(name="find_all_records", query="select r from LedgerRecord r"),
        @NamedQuery(name="find_latest_record", query = "select r from LedgerRecord r order by r.created")
})
public class LedgerRecord {

    @Id
    @GeneratedValue
    private int id;

    private float amount;
    private String remarks;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ledgerRecordId")
////    @JoinColumn(name="ledgerRecordId") // makes LedgerRecord owning side.
//    private List<Synonym> synonyms;

    public LedgerRecord() {
    }

    public LedgerRecord(float amount, String remarks) {
        this.amount = amount;
        this.remarks = remarks;
//        this.synonyms = synonyms;
    }
}
