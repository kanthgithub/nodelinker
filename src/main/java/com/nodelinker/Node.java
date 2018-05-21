package com.nodelinker;

import java.util.Arrays;
import java.util.Objects;
import com.google.common.base.MoreObjects;
public class Node {
    public Node[] Children;
    public Node right;
    public String name;
    public Integer level;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Arrays.equals(Children, node.Children) &&
                Objects.equals(right, node.right) &&
                Objects.equals(name, node.name) &&
                Objects.equals(level, node.level) &&

                ;
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(right, name,level);
        result = 31 * result + Arrays.hashCode(Children);

        return result;
    }

    @Override
    public String toString() {

        return MoreObjects
                .toStringHelper(this)
                .add("name", this.name)
                .add("Children", this.Children)
                .add("right", this.right)
                .add("level",this.level)
                .toString();
    }
}
