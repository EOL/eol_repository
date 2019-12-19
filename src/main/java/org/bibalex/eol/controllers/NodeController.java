package org.bibalex.eol.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import org.bibalex.eol.collections.Node;
import org.bibalex.eol.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by maha.mostafa on 11/12/19.
 */
@RestController
@RequestMapping("/nodes")
public class NodeController {
    @Autowired
    private NodeRepository nodeRepo;

    @RequestMapping(value = "/getAllNodes", method = RequestMethod.GET)
    public List<Node> getAllNodes() {
        return nodeRepo.findAll();
    }

    @RequestMapping(value = "/createNode", method = RequestMethod.POST, consumes = "application/json")
    public Node createNode(@RequestBody Node node) {
        return nodeRepo.save(node);
    }

    @RequestMapping(value= "/insertNodes", method = RequestMethod.POST, consumes = "application/json")
    public void insertNodes (@RequestBody List<Node> nodes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File nodes_file = new File("nodes.json");
        FileWriter fileWriter = new FileWriter(nodes_file, true);
        mapper.writeValue(nodes_file, nodes);

        ProcessBuilder pb = new ProcessBuilder("/home/ba/eol_repository/nodes.sh", "test", "node", "nodes.json");
        File errorFile = new File("PingErrLog.txt");
        pb.redirectError(errorFile);
        pb.start();
    }

    @RequestMapping(value="/findNodesByResource/{resourceId}", method = RequestMethod.GET)
    public List<Node> findNodesByResource(@PathVariable("resourceId") int resourceId)
    {
        return nodeRepo.findByresourceId(resourceId);

    }

    @RequestMapping(value="/countScientific", method = RequestMethod.GET)
    public Long countScientificNames()
    {
        return nodeRepo.count();

    }

    @RequestMapping(value="/findNodesByResourceAndNode/{resourceId}/{nodeId}", method = RequestMethod.GET)
    public List<Node> findByResourceAndNode(@PathVariable("resourceId") int resourceId, @PathVariable("nodeId") String nodeId)
    {
        return nodeRepo.findByResourceIdAndNodeId(resourceId, nodeId);
    }

    // Nodes are taxa which are not synonms
    @RequestMapping(value="/countNodes", method = RequestMethod.GET)
    public Long countNodes()
    {
        return nodeRepo.countByAcceptedNameUsageId(null);
    }









}