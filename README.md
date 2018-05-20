NodeLinker:

NodeLinker links all sibling nodes at identical level

Algorithm doesn't have any recursive logic

Each Node represents an element of a tree and specifies a list of immediate children

Steps in linkNode algorithm:

Extract Siblings at identical levels in to a bucket (Starting from rootNode)
Link siblings in a bucket

Datastructures used:

Node: contains property: name, Array of Node Objects as children and RightNode

Java DataStructures used:
LinkedList: Ordered List (order of insertion) 
Array: bucket to hold Siblings
Map: to organize siblings at identical level in a bucket


