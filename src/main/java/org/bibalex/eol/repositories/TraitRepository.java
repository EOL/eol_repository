package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.bibalex.eol.collections.Trait;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TraitRepository extends MongoRepository<Trait, String>, NodeRepositoryCustom {

    List<Trait> findByresourceId(int resourceId);

}
