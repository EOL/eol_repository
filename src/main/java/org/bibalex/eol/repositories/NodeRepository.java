package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NodeRepository extends MongoRepository<Node, String> {

    List<Node> findByresourceId(int resourceId);
    //List<Node> findByresourceIdAndnodeId(int resourceId, String nodeId);
}
