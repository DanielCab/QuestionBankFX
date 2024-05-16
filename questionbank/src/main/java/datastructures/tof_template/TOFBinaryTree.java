/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tof_template;

import java.util.Random;

/**
 *
 * @author 00023354 / 00073909
 */
public class TOFBinaryTree {

    public TreeNode root;
    public TOFBinaryTree() {
        root = null;
    }
    
    public TreeNode findOrInsert(TNodeData d)
    {
        if(root==null) return root = new TreeNode(d);
        TreeNode curr = root;
        int cmp;
        while((cmp = d.compareTo(curr.data)) != 0){
            if(cmp < 0){ // try left
                if(curr.left == null)return curr.left = new TreeNode(d);
                curr = curr.left;
            }
            else{ //try right
                if((curr.right == null)) return curr.right = new TreeNode(d);
                curr = curr.right;
            }
        }
        return curr;        
    }

    public TreeNode justFindNoInsert(String name) {
        TreeNode curr = root;
        while (curr != null) {
            int cmp = name.compareTo(curr.data.getQuestionID());
            if (cmp == 0) {
                return curr;
            } else if (cmp < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    public void remove(String name) {
        root = removeNode(root, name);
    }

    private TreeNode removeNode(TreeNode node, String name) {
        if (node == null) {
            return null;
        }
        int cmp = name.compareTo(node.data.getQuestionID());
        if (cmp < 0) {
            node.left = removeNode(node.left, name);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, name);
        } else {
            // Once we find the node to be removed
    
            // First and second cases from the video: Node has one or no children
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
    
            // Third Case from deletion video: Node has two children
            TreeNode successor = findMax(node.right);
            node.data = successor.data;
            // Remove the successor from the right subtree
            node.right = removeNode(node.right, successor.data.getQuestionID());
        }
    
        return node;
    }
    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

////////////////////////////////////////////////////////////////////////// Beginning of Custom Code ////////////////////////////////////////////////////////////////////////////////////////

public int countNodes() {
        return countNodes(root);
    }

private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Count the current node and recursively count nodes in left and right subtrees
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

public String getTOFTreeAsString() {
        return getTOFTreeAsString(root);
    }

private String getTOFTreeAsString(TreeNode node) {
    StringBuilder output = new StringBuilder();
    if (node != null) {
        // Traverse left subtree
        output.append(getTOFTreeAsString(node.left));
        // Append current node's data
        TNodeData data = (TNodeData) node.data;
        output.append("Question: ").append(data.getQuestion()).append("\n");
        output.append(data.getAnswer()).append("\n");
        output.append(data.getChoiceTwo()).append("\n");
        output.append("\n");
        
        // Traverse right subtree
        output.append(getTOFTreeAsString(node.right));
    }
    return output.toString();
}

// Method to randomize the questionID of nodes in the original tree
public void randomizeOriginalTree() {
    randomizeIDs(root);
}

// Method to randomize the questionID of nodes in the original tree
private void randomizeIDs(TreeNode node) {
    if (node == null) {
        return;
    }
    randomizeIDs(node.left);
    randomizeIDs(node.right);
    // Generate a random questionID between 0 and 999
    Random ranNum = new Random();
    int randomID = ranNum.nextInt(1000);
    // Set the random questionID to the node
    TNodeData nodeData = (TNodeData) node.data;
    nodeData.setQuestionID(String.valueOf(randomID));
}

// Method to insert random nodes from the original tree into a new binary tree
public TOFBinaryTree insertIntoNewTree() {
    TOFBinaryTree newTree = new TOFBinaryTree(); // Create a new binary tree
    insertRandomNodes(root, newTree);
    return newTree;
}

// Method to insert randomized nodes from the original tree into a new binary tree
private void insertRandomNodes(TreeNode node, TOFBinaryTree newTree) {
    if (node == null) {
        return;
    }
    insertRandomNodes(node.left, newTree);
    newTree.findOrInsert((TNodeData) node.data); // Insert the current node into the new tree
    insertRandomNodes(node.right, newTree);
}

// Method to pull a specified number of nodes from the new tree
public TOFBinaryTree pullNodesFromNewTree(int amount) {
    // Randomize IDs of the original tree
    randomizeOriginalTree();
    // Insert randomized nodes from the original tree into a new tree
    TOFBinaryTree newTree = insertIntoNewTree();
    // Create a new binary tree for pulled nodes
    TOFBinaryTree pulledNodesTree = new TOFBinaryTree();
    // Pull a specified number of nodes from the new tree
    pullRandomNodes(newTree.root, amount, pulledNodesTree);
    return pulledNodesTree;
}

// Method to pull a specified number of nodes from the new tree
private void pullRandomNodes(TreeNode node, int amount, TOFBinaryTree pulledNodesTree) {
    if (node == null || amount <= 0) {
        return; // Base case: if node is null or amount is 0, stop 
    }
    // Recursively process the left subtree
    pullRandomNodes(node.left, amount, pulledNodesTree);
    // Check if the desired amount of nodes has been reached
    if (pulledNodesTree.countNodes() >= amount) {
        return; // Stop further processing if the desired amount has been reached
    }
    // Insert the current node into the new tree
    pulledNodesTree.findOrInsert((TNodeData) node.data);
    // Recursively process the right subtree
    pullRandomNodes(node.right, amount, pulledNodesTree);
}
}//end class BinaryTree