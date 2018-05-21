package com.nodelinker;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class NodeLinker_Better {


    //rootNode property
    private Node rootNode;


    public Node getRootNode() {
        return rootNode;
    }

    public NodeLinker_Better setRootNode(Node rootNode) {
        this.rootNode = rootNode;
        return this;
    }

    /**
     * link all childNodes - starting from rootNode
     *
     * extract all Nodes with children
     *
     * forEach ParentNode, extract children and link the siblings
     *
     * end result will be that tree contains nodes where all children at same level are linked
     */
    public Map<Integer,LinkedList<Node>> link() {

        Map<Integer,LinkedList<Node>> nodeTreeSetMap = extractSiblingLevelMap();

        for (LinkedList nodeArray : nodeTreeSetMap.values()) {

            linkSiblings(nodeArray);

        }

        return nodeTreeSetMap;

    }


    /**
     *
     * extract Node Siblings at identical level to a bucket
     * total number of buckets collected will be equal to height of the tree
     *
     * @return Map of Nodes
     */
    public Map<Integer,LinkedList<Node>> extractSiblingLevelMap(){

        AtomicInteger siblingLevelCount = new AtomicInteger(0);
        Integer maxLevel = 0;
        Integer rootLevel = 0;

        LinkedList<Node> linkedList = new LinkedList<Node>();

        linkedList.add(rootNode);

        //
        while (!linkedList.isEmpty())
        {
            Node nodeFromList = linkedList.poll();

            if(nodeFromList!=null ) {

                int mapIndex = siblingLevelCount.getAndAdd(1);

                LinkedList<Node> nodeList = new LinkedList<Node>();

                int parentLevel = nodeFromList.level;

                if(nodeFromList.Children!=null) {
                    for (Node tempNode : nodeFromList.Children) {
                        if (tempNode != null) {

                            if(parentLabel!=null) {
                                tempNode.level = parentLevel + 1;
                            }else{
                                tempNode.level = rootLevel+1;
                            }

                            nodeList.add(tempNode);

                            maxLevel = tempNode.level;
                        }
                    }
                }

                linkedList.addAll(nodeList);
            }
        }

        Map<Integer,LinkedList<Node>> siblingLevelMap = new LinkedHashMap<Integer,LinkedList<Node>>();

        Integer maxLevel = siblingLevelCount.get();

        for(int level=0;level < maxLevel;level++){

            //extract all nodes at level
            


        }




        return siblingLevelMap;
    }





    /**
     * link siblings
     * input argument is an array of siblings
     * link them in the sequence of array
     * linking is done by setting the rightNode for each sibling
     *
     * sample:
     *
     * 0,1,2 are siblings
     *
     * before linking:
     *
     * 0.right = null
     * 1.right = null
     * 2.right = null
     *
     * after linking:
     *
     * 0.right = 1
     * 1.right = 2
     * 2.right = null
     *
     * @param children
     */
    public void linkSiblings(LinkedList<Node> children) {

        int length = children.size();

        for (int index = 0; index < length - 1; index++) {

            children.get(index).right = children.get(index+1);

        }

    }

    /**
     *
     * @param nodeTreeSetMap
     * @return String with linkedNode-Names
     */
    public String extractPrintableString(Map<Integer,LinkedList<Node>> nodeTreeSetMap) {

        StringBuffer stringBuffer = new StringBuffer();

        for (LinkedList<Node> nodeItemArray : nodeTreeSetMap.values()) {

            for(Node nodeChildrenItem : nodeItemArray){

                stringBuffer.append(nodeChildrenItem.name).append(" -> ");

            }

            stringBuffer.append("END").append("\n");
        }

        return stringBuffer.toString().trim();

    }
}
