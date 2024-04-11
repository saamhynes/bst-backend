package com.keyin.binarySearchTree.controller;

import com.keyin.binarySearchTree.dto.TreeNodeDTO;
import com.keyin.binarySearchTree.model.TreeNode;
import com.keyin.binarySearchTree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping("/process-numbers")
    public ResponseEntity<TreeNodeDTO> processNumbers(@RequestBody List<Integer> numbers) {
        System.out.println("Received numbers: " + numbers);
        TreeNode root = treeService.constructBinarySearchTree(numbers);
        treeService.saveTree(root);
        TreeNodeDTO rootDto = treeService.convertToDto(root);
        return new ResponseEntity<>(rootDto, HttpStatus.OK);
    }



    @GetMapping("/previous-trees")
    public ResponseEntity<List<TreeNodeDTO>> getPreviousTrees() {
        List<TreeNode> previousTrees = treeService.getAllTrees();
        // Convert each TreeNode to TreeNodeDTO
        List<TreeNodeDTO> dtoList = previousTrees.stream()
                .map(treeService::convertToDto) // Assuming convertToDto can handle a TreeNode and return a TreeNodeDTO
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @PostMapping("/enter-numbers")
    public ResponseEntity<String> enterNumbers(@RequestBody List<Integer> numbers) {
        TreeNode root = treeService.constructBinarySearchTree(numbers);
        treeService.saveTree(root);
        return ResponseEntity.ok().body("Numbers entered successfully");
    }
}
