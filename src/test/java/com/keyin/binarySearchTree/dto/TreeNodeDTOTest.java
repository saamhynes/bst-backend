package com.keyin.binarySearchTree.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TreeNodeDTOTest {

    @Test
    public void testGettersAndSetters() {
        TreeNodeDTO treeNodeDTO = new TreeNodeDTO();
        treeNodeDTO.setValue(10);
        assertEquals(10, treeNodeDTO.getValue());
    }
}
