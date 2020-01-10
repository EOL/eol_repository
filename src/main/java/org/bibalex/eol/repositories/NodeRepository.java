package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Node;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NodeRepository extends MongoRepository<Node, String> , NodeRepositoryCustom{

    List<Node> findByresourceId(int resourceId);
    Node findByResourceIdAndNodeId(int resourceId, String nodeId);
    Long countByAcceptedNameUsageId(String acceptedNameUsageId);






}
