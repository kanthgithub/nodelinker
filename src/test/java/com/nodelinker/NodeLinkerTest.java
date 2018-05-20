package com.nodelinker;

import java.util.Map;

public class NodeLinkerTest {

    public static void main(String... args) {

        //node-1 for rootNode
        Node childNode1 = new Node("childNode1");

        Node childNode1_1 = new Node("childNode1_1");
        Node childNode1_2 = new Node("childNode1_2");

        //children of Node1
        Node[] children_Of_Node_1 = new Node[2];

        children_Of_Node_1[0] = childNode1_1;
        children_Of_Node_1[1] = childNode1_2;

        childNode1.Children = children_Of_Node_1;


        //node-2 for rootNode
        Node childNode2 = new Node("childNode2");

        //node-3 for rootNode
        Node childNode3 = new Node("childNode3");
        Node childNode3_1 = new Node("childNode3_1");

        //children of node-3
        Node[] children_Of_Node_3 = new Node[1];

        children_Of_Node_3[0] = childNode3_1;

        childNode3.Children = children_Of_Node_3;

        //rootNode
        Node rootNodeArg = new Node("rootNode");

        //create childNodes (for rootNode)
        Node[] childNodeForRoot = new Node[3];

        childNodeForRoot[0] = childNode1;
        childNodeForRoot[1] = childNode2;
        childNodeForRoot[2] = childNode3;

        //append childs to rootNode
        rootNodeArg.Children = childNodeForRoot;

        //link childNodes as per the assignment
        NodeLinker nodeLinker = new NodeLinker().setRootNode(rootNodeArg);

        Map<Integer, Node[]> nodeArrayMap = nodeLinker.link();

        System.out.println(nodeLinker.extractPrintableString(nodeArrayMap));
    }


}


