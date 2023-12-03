package in.sliya.cashledger.controllers;

import in.sliya.cashledger.models.LedgerRecord;
import in.sliya.cashledger.modules.Ledger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    @Autowired
    Ledger ledger;

    @PostMapping("/records")
    public ResponseEntity<Object> createLedgerRecord(@RequestBody LedgerRecord record) {
        ledger.createLedgerRecord(record);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(12).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/records")
    public List<LedgerRecord> getLedgerRecords() {
        return ledger.getLedgerRecords();
    }

    @DeleteMapping("/records/latest")
    public void undoEntry() {
       ledger.undoEntry();
    }
}

