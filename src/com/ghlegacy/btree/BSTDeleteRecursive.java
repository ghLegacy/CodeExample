package com.ghlegacy.bstree;

public class BSTDeleteRecursive {
    // first node
    private Node root;
    BSTDeleteRecursive(){
        root = null;
    }
    // Class representing tree nodes
    static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            left = null;
            right = null;        
        }
        public void displayData(){
            System.out.print(value + " ");
        }
    }
    
    public void insert(int i){
        root = insert(root, i);
    }
    
    
    //Inserting node - recursive method
    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        // Move to the left if passed value is 
        // less than the current node
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        // Move to the right if passed value is 
        // greater than the current node
        else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }
    
    // For traversing in order
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            node.displayData();
            inOrder(node.right);
        }
    }
    
    public Node deleteNode_recur(Node node, int value){
        if(node == null)
            return null;
        if(value < node.value){
            node.left = deleteNode_recur(node.left, value);
        }else if (value > node.value){
            node.right = deleteNode_recur(node.right, value);
        }else{
            // Leaf node deletion case
            if(node.left == null && node.right == null){
                System.out.println("Leaf node deletion case");
                node = null;
            }
            // Node to be deleted has one child case
            // Node to be deleted has right child
            else if(node.left == null){
                System.out.println("Having One right child deletion case");
                node = node.right;
            }
            // Node to be deleted has left child
            else if(node.right == null){
                System.out.println("Having One left child deletion case");
                node = node.left;
            }
            // Node to be deleted has two children case
            else{
                System.out.println("Two children deletion case");
                Node successor = findSuccessor_recur(node.right);
                // Copy the value
                node.value = successor.value;
                // delete successor node instead
                node.right = deleteNode_recur(node.right, successor.value);
            }
        }
        return node;
    }
    private Node findSuccessor_recur(Node node){
        if(node.left == null)
            return node;
        else 
            return findSuccessor_recur(node.left);
        
    }
    
    public static void main(String[] args) {
    	BSTDeleteRecursive bst = new BSTDeleteRecursive();
        bst.insert(50);
        bst.insert(70);
        bst.insert(30);
        bst.insert(15);
        bst.insert(35);
        bst.insert(7);
        bst.insert(22);
        bst.insert(31);
        System.out.println("Inorder traversal of binary tree");
        bst.inOrder(bst.root);
        System.out.println();
        
        Node newRoot = bst.deleteNode_recur(bst.root, 15);
        bst.inOrder(newRoot);
        
        System.out.println("Inorder traversal after deletion");
        bst.inOrder(bst.root);
        System.out.println();
    }
}
