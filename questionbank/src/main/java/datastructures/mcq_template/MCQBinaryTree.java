/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.mcq_template;

import java.util.Random;

/**
 *
 * @author 00023354 / 00073909
 */
public class MCQBinaryTree {

    public TreeNode root;

    public MCQBinaryTree() {
        root = null;
    }
    
    public TreeNode findOrInsert(NodeData d)
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

    public TreeNode justFindNoInsert(String qID) {
        TreeNode curr = root;
        while (curr != null) {
            int cmp = qID.compareTo(curr.data.getQuestionID());
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

    public void remove(String qID) {
        root = removeNode(root, qID);
    }

    private TreeNode removeNode(TreeNode node, String qID) {
        if (node == null) {
            return null;
        }
        int cmp = qID.compareTo(node.data.getQuestionID());
        if (cmp < 0) {
            node.left = removeNode(node.left, qID);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, qID);
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

    public String getMQCTreeAsString() {
        return getMQCTreeAsString(root);
    }
    
    private String getMQCTreeAsString(TreeNode node) {
        StringBuilder output = new StringBuilder();
        if (node != null) {
            output.append(getMQCTreeAsString(node.left));
            NodeData data = (NodeData) node.data;
            output.append("Question: ").append(data.getQuestion()).append("\n");
            output.append("a: ").append(data.getAnswer()).append("\n");
            output.append("b: ").append(data.getChoiceTwo()).append("\n");
            output.append("c: ").append(data.getChoiceThree()).append("\n");
            output.append("d: ").append(data.getChoiceFour()).append("\n");
            output.append("\n");
            output.append(getMQCTreeAsString(node.right));
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
    NodeData nodeData = (NodeData) node.data;
    nodeData.setQuestionID(String.valueOf(randomID));
}

// Method to insert random nodes from the original tree into a new binary tree
public MCQBinaryTree insertIntoNewTree() {
    MCQBinaryTree newTree = new MCQBinaryTree(); // Create a new binary tree
    insertRandomNodes(root, newTree);
    return newTree;
}

// Method to insert randomized nodes from the original tree into a new binary tree
private void insertRandomNodes(TreeNode node, MCQBinaryTree newTree) {
    if (node == null) {
        return;
    }
    insertRandomNodes(node.left, newTree);
    newTree.findOrInsert((NodeData) node.data); // Insert the current node into the new tree
    insertRandomNodes(node.right, newTree);
}

// Method to pull a specified number of nodes from the new tree
public MCQBinaryTree pullNodesFromNewTree(int amount) {
    // Randomize IDs of the original tree
    randomizeOriginalTree();
    // Insert randomized nodes from the original tree into a new tree
    MCQBinaryTree newTree = insertIntoNewTree();
    // Create a new binary tree for pulled nodes
    MCQBinaryTree pulledNodesTree = new MCQBinaryTree();
    // Pull a specified number of nodes from the new tree
    pullNodes(newTree.root, amount, pulledNodesTree);
    return pulledNodesTree;
}

// Method to pull a specified number of nodes from the new tree
private void pullNodes(TreeNode node, int amount, MCQBinaryTree pulledNodesTree) {
    if (node == null || amount <= 0) {
        return; // Base case: if node is null or amount is 0, stop 
    }
    // Recursively process the left subtree
    pullNodes(node.left, amount, pulledNodesTree);
    // Check if the desired amount of nodes has been reached
    if (pulledNodesTree.countNodes() >= amount) {
        return; // Stop further processing if the desired amount has been reached
    }
    // Insert the current node into the new tree
    pulledNodesTree.findOrInsert((NodeData) node.data);
    // Recursively process the right subtree
    pullNodes(node.right, amount, pulledNodesTree);
}
}//end class BinaryTree



