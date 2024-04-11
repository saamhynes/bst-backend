package com.keyin.binarySearchTree.service;

import com.keyin.binarySearchTree.dto.TreeNodeDTO;
import com.keyin.binarySearchTree.model.TreeNode;
import com.keyin.binarySearchTree.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    @Transactional
    public void insertNumbers(List<Integer> numbers) {
        TreeNode root = null;
        for (Integer number : numbers) {
            root = insertNumber(root, number);
        }
        saveTree(root);
    }

    @Transactional
    public TreeNode constructBinarySearchTree(List<Integer> numbers) {
        TreeNode root = null;
        for (Integer number : numbers) {
            root = insertNumber(root, number);
        }
        return root;
    }

    private TreeNode insertNumber(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.getValue()) {
            TreeNode leftChild = insertNumber(root.getLeftChild(), value);
            leftChild.setParent(root);
            root.setLeftChild(leftChild);
        } else if (value > root.getValue()) {
            TreeNode rightChild = insertNumber(root.getRightChild(), value);
            rightChild.setParent(root);
            root.setRightChild(rightChild);
        }

        return root;
    }

    public TreeNodeDTO convertToDto(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNodeDTO treeNodeDTO = new TreeNodeDTO(treeNode.getId(), treeNode.getValue());
        treeNodeDTO.setLeftChild(convertToDto(treeNode.getLeftChild()));
        treeNodeDTO.setRightChild(convertToDto(treeNode.getRightChild()));

        return treeNodeDTO;
    }


    @Transactional
    public void saveTree(TreeNode root) {
        treeRepository.save(root);
    }

    public TreeNode getRoot() {
        return treeRepository.findRoot();
    }

    public List<TreeNode> getAllTrees() {
        return treeRepository.findAllTrees();
    }
}
