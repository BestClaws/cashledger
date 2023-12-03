package in.sliya.cashledger.external.synonyms;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class SynonymsApiImpl implements SynonymsApi{



    @Override
    public List<String> getSynonynms(String word) {
        final String API_URL = "https://api.api-ninjas.com/v1/thesaurus?word=" + word;
        final String API_KEY = "bK4qZgKdb7EL573lTgHL9A==0DjnCZCzr6tsGy8Q";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", API_KEY);
        HttpEntity<?> reqEntity = new HttpEntity<>(headers);


        ResponseEntity<SynonymsResponse> res = restTemplate.exchange(API_URL, HttpMethod.GET, reqEntity, SynonymsResponse.class);
        return Objects.requireNonNull(res.getBody()).getSynonyms();




    }
}
