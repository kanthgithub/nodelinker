## NodeLinker:

**NodeLinker links all sibling nodes at identical level**

- Algorithm doesn't have any recursive logic

- Each Node represents an element of a tree and specifies a list of immediate children

Steps in linkNode algorithm:

1. Extract Siblings at identical levels in to a bucket (Starting from rootNode)
2. Link siblings in a bucket

**Datastructures used:**

   - Node: contains property:
     1. name
     2. Children (Array of Node Objects as children)
     3. rightNode

**Java DataStructures used:**
- LinkedList: Ordered List (order of insertion)
- Array: bucket to hold Siblings
- Map: to organize siblings at identical level in a bucket


