package com.keyin.binarySearchTree.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TreeNodeTest {

    @Test
    public void testGettersAndSetters() {
        TreeNode treeNode = new TreeNode();
        treeNode.setId(1L);
        treeNode.setValue(10);

        TreeNode leftChild = new TreeNode(5);
        treeNode.setLeftChild(leftChild);

        TreeNode rightChild = new TreeNode(15);
        treeNode.setRightChild(rightChild);

        assertEquals((long) 1L, (long) treeNode.getId());
        assertEquals(10, treeNode.getValue());
        assertEquals(leftChild, treeNode.getLeftChild());
        assertEquals(rightChild, treeNode.getRightChild());

    }

    @Test
    public void testConstructorWithValue() {
        int expectedValue = 10;
        TreeNode node = new TreeNode(expectedValue);
        Assertions.assertEquals(expectedValue, node.getValue(), "TreeNode value should match the constructor argument.");
    }
}
