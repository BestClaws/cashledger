package in.sliya.cashledger;

import in.sliya.cashledger.external.synonyms.SynonymsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CashLedgerApplication implements CommandLineRunner {

	@Autowired
	private SynonymsApi api;

	public static void main(String[] args) {
		SpringApplication.run(CashLedgerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("yess");

	}


}
