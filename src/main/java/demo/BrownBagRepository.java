package demo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrownBagRepository extends CrudRepository<BrownBag, String> {

    Collection<BrownBag> findBySpeaker(String speaker);
}
