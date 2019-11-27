package org.bibalex.eol.controllers;

import org.bibalex.eol.collections.Node;
import org.bibalex.eol.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by maha.mostafa on 11/12/19.
 */
@RestController
@RequestMapping("/nodes")
public class NodeController {
    @Autowired
    private NodeRepository nodeRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Node> getAllNodes() {
        return nodeRepo.findAll();
    }

    @RequestMapping(value = "/createNode", method = RequestMethod.POST, consumes = "application/json")
    public Node createNode(@RequestBody Node node) {
        System.out.println(node.toString());
        return nodeRepo.save(node);
    }

}