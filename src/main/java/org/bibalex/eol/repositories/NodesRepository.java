package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NodeRepository extends MongoRepository<Node, String> {

    public Node save(Node node);
}
