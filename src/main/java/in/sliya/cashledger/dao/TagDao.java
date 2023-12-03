package in.sliya.cashledger.dao;

import in.sliya.cashledger.models.Tag;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TagDao {


    @Autowired
    EntityManager em;


    public void insertOrUpdateFreq(String tagName, float frequency) {
       Tag t = getTag(tagName);
       if (t == null) {
           em.persist(new Tag(tagName, frequency));
       } else {
           t.setFrequency(t.getFrequency() + 1);
       }
    }

    public void updateOrRemoveFreq(String tagName, Float frequency) {
        Tag t = getTag(tagName);
        if (t == null) {
            // shouldn't happen throw exception here.
            System.out.println("t is null!");
            return;
        }

        float currentFrequency = t.getFrequency();
        if (currentFrequency > frequency) {
            t.setFrequency(currentFrequency - frequency);
        } else {
            em.remove(t);
        }
    }


    public Tag getTag(String tagName) {
       return em.find(Tag.class, tagName);

    }
}
