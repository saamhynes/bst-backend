package com.keyin.binarySearchTree.dto;

public class TreeNodeDTO {
    private Long id;
    private int value;
    private TreeNodeDTO leftChild;
    private TreeNodeDTO rightChild;

    // constructors
    public TreeNodeDTO() {
    }

    public TreeNodeDTO(Long id, int value) {
        this.id = id;
        this.value = value;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNodeDTO getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNodeDTO leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNodeDTO getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNodeDTO rightChild) {
        this.rightChild = rightChild;
    }
}
