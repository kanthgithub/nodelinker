package com.nodelinker;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;


public class NodeLinker2 {

    //rootNode property
    private Node rootNode;
    Integer rootLevel = 0;
    Map<Integer,Node> siblingLevelMap = new LinkedHashMap<Integer,Node>();

    public Node getRootNode() {
        return rootNode;
    }

    public NodeLinker2 setRootNode(Node rootNode) {
        this.rootNode = rootNode;
        return this;
    }


    /**
     *
     * extract Node Siblings at identical level to a bucket
     *
     * total number of buckets collected will be equal to height of the tree
     *
     * link all childNodes - starting from rootNode
     *
     * extract all Nodes with children
     *
     * forEach ParentNode, extract children and link the siblings
     *
     * end result will be that tree contains nodes where all children at same level are linked

     *
     *
     * @return Map of Nodes
     */
    public Map<Integer,Node> extractLinkedSiblingMap(){

        Node node =rootNode;

        while (node.Children!=null )
        {
            //Node node = linkedList.poll();

            if(node!=null && node.Children!=null ) {

                int parentLevel = node.level!=null ? node.level : 0;

                if(node.Children!=null) {
                    linkSiblings( node, parentLevel);
                }
            }
        }

        return siblingLevelMap;
    }

    /**
     * Links siblings of a parentNode
     *
     * @param parentNode
     * @param parentLevel
     */
    public void linkSiblings(Node parentNode, int parentLevel) {

        int nodeLevel;

        //link all child Nodes
        for (Node childNode : parentNode.Children) {

            if (childNode != null) {

                    if (parentLevel > 0) {
                        nodeLevel = parentLevel + 1;
                    } else {
                        nodeLevel = rootLevel + 1;
                    }

                    childNode.level = nodeLevel;

                    if(!siblingLevelMap.containsKey(nodeLevel)){
                        siblingLevelMap.put(nodeLevel,childNode);
                    }else{
                        Node node = siblingLevelMap.get(nodeLevel);

                        Node localNode = null;

                        while(node!=null){
                            localNode = node;
                            node = node.right;
                        }

                        if(localNode!=null) {
                            localNode.right = childNode;
                        }
                    }

            }
        }
    }

    /**
     *
     * @param nodeTreeSetMap
     * @return String with linkedNode-Names
     */
    public String extractPrintableString(Map<Integer,Node> nodeTreeSetMap) {

        StringBuffer stringBuffer = new StringBuffer();

        for (Node nodeItem : nodeTreeSetMap.values()) {

            Node tempNodeItem = nodeItem;

            while(tempNodeItem!=null){
                stringBuffer.append(tempNodeItem.name).append(" -> ");
                tempNodeItem =  tempNodeItem.right;
            }

            stringBuffer.append("END").append("\n");
        }

        return stringBuffer.toString().trim();

    }
}
