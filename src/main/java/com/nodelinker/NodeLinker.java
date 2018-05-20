package com.nodelinker;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class NodeLinker {


    //rootNode property
    private Node rootNode;


    public Node getRootNode() {
        return rootNode;
    }

    public NodeLinker setRootNode(Node rootNode) {
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
    public Map<Integer,Node[]> link() {

        Map<Integer,Node[]> nodeTreeSetMap = extractSiblingLevelMap();

        for (Node[] nodeArray : nodeTreeSetMap.values()) {

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
    public Map<Integer,Node[]> extractSiblingLevelMap(){

        Map<Integer,Node[]> siblingLevelMap = new LinkedHashMap<Integer,Node[]>();

        AtomicInteger siblingLevelCount = new AtomicInteger(0);

        LinkedList<Node[]> linkedList = new LinkedList<Node[]>();

        Node[] rootArray = new Node[1];
        rootArray[0]=rootNode;

        linkedList.add(rootArray);


        while (!linkedList.isEmpty())
        {
            Node[] tempNodes = linkedList.poll();

            if(tempNodes!=null && tempNodes.length>0) {

                int mapIndex = siblingLevelCount.getAndAdd(1);

                List<Node> nodeList = new ArrayList<>();

                for(Node tempNode:tempNodes){
                    if(tempNode!=null && tempNode.Children!=null) {
                        nodeList.addAll(Arrays.asList(tempNode.Children));
                    }
                }


                if(nodeList!=null && nodeList.size()>0) {

                    siblingLevelMap.put(mapIndex, nodeList.toArray(new Node[nodeList.size()]));
                }

                linkedList.add(nodeList.toArray(new Node[nodeList.size()]));
            }
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
    public void linkSiblings(Node[] children) {

        int length = children.length;

        for (int index = 0; index < length - 1; index++) {

            children[index].right = children[index + 1];

        }

    }

    /**
     *
     * @param nodeTreeSetMap
     * @return String with linkedNode-Names
     */
    public String extractPrintableString(Map<Integer,Node[]> nodeTreeSetMap) {

        StringBuffer stringBuffer = new StringBuffer();

        for (Node[] nodeItemArray : nodeTreeSetMap.values()) {

            for(Node nodeChildrenItem : nodeItemArray){

                stringBuffer.append(nodeChildrenItem.name).append(" -> ");

            }

            stringBuffer.append("END").append("\n");
        }

        return stringBuffer.toString().trim();

    }
}
