package org.bibalex.eol.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bibalex.eol.collections.Node;
import org.bibalex.eol.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.Document;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
//        return  nodeRepo.insert(nodes);
        ObjectMapper mapper = new ObjectMapper();

        // Java object to JSON file
        for (Node node: nodes) {
            mapper.writeValue(new File("nodes.json"), node);
        }



    }

    @RequestMapping(value="/findNodesByResource/{resourceId}", method = RequestMethod.GET)
    public List<Node> findNodesByResource(@PathVariable("resourceId") int resourceId)
    {
        return nodeRepo.findByresourceId(resourceId);

    }







}