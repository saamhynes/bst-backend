package com.keyin.binarySearchTree.repository;

import com.keyin.binarySearchTree.model.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<TreeNode, Long> {

    @Query("SELECT t FROM TreeNode t WHERE t.parent IS NULL")
    TreeNode findRoot();

    @Query("SELECT t FROM TreeNode t WHERE t.parent IS NOT NULL")
    List<TreeNode> findAllTrees();
}
