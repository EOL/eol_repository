package org.bibalex.eol.controllers;


import org.bibalex.eol.collections.Node;

import org.bibalex.eol.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.time.Instant;
import java.util.List;

/**
 * Created by maha.mostafa on 11/12/19.
 */
@RestController
@RequestMapping("/nodes")
public class NodeController {
    @Autowired
    private NodeService nodeServ;

    //TODO: get using timestamp
    @RequestMapping(value = "/getAllNodes", method = RequestMethod.GET)
    public List<Node> getAllNodes() {
        return nodeServ.getAllNodes();
    }

    @RequestMapping(value="getByTimestamps", method = RequestMethod.POST)
    public List<Node> getByTimestamps(@RequestParam ("from") String from , @RequestParam ("to") String to)
    {
        return nodeServ.getByTimestamps(Instant.parse(from),
                Instant.parse(to));
    }

    @RequestMapping(value = "/createNode", method = RequestMethod.POST, consumes = "application/json")
    public Node createNode(@RequestBody Node node)
    {
        return nodeServ.createNode(node);
    }

    @RequestMapping(value= "/insert", method = RequestMethod.POST, consumes = "application/json")
    public void insertNodes (@RequestBody List<Node> nodes) throws IOException
    {
        //TODO: security issues (authentication)
        nodeServ.insertNodes(nodes);

    }

    @RequestMapping(value="/getByResource/{resourceId}", method = RequestMethod.GET)
    public List<Node> getByResourceId(@PathVariable("resourceId") int resourceId)
    {
        return nodeServ.getByResourceId(resourceId);

    }

    @RequestMapping(value="/countScientific", method = RequestMethod.GET)
    public long countScientificNames()
    {
        return nodeServ.countScientificNames();

    }
//
    @RequestMapping(value="/getByResourceAndPk/{resourceId}/{nodeId}", method = RequestMethod.GET)
    public Node findByResourceAndNode(@PathVariable("resourceId") int resourceId, @PathVariable("nodeId") String nodeId)
    {
        return nodeServ.getByResourceAndPk(resourceId, nodeId);
    }

    // Nodes are taxa which are not synonms
    @RequestMapping(value="/countNodes", method = RequestMethod.GET)
    public long countNodes()
    {
        return nodeServ.countNodes();
    }

    @RequestMapping(value="/countVernaculars", method = RequestMethod.GET )
    public String countVernaculars()
    {
        return nodeServ.countVernaculars();
    }


    //TODO: reharvest






}