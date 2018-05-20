## NodeLinker:

**NodeLinker links all sibling nodes at identical level**

- Algorithm doesn't have any recursive logic

- Each Node represents an element of a tree and specifies a list of immediate children

**Steps in linkNode algorithm:**

1. Extract Siblings at identical levels in to a bucket (Starting from rootNode)
2. Link siblings in a bucket

## **Datastructures used:**

- Custom POJO Node.java with properties:
     1. name
     2. Children (Array of Node Objects as children)
     3. rightNode

## **Java DataStructures used:**
- LinkedList: Ordered List (order of insertion)
- Array: bucket to hold Siblings
- Map: to organize siblings at identical level in a bucket

## **Before Linking siblings:**

![alt text](https://raw.githubusercontent.com/kanthgithub/nodelinker/master/Tree.png)


## **After Linking siblings:**

![alt text](https://raw.githubusercontent.com/kanthgithub/nodelinker/master/After_Linking_Siblings.png)

- childNode1 -> childNode2 -> childNode3 -> END
- childNode1_1 -> childNode1_2 -> childNode3_1 -> END

