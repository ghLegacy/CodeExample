package com.ghlegacy.bstree;

public class BSTDeleteIterative {
    // first node
    private Node root;
    BSTDeleteIterative(){
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
    
    public boolean delete(int value){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while(current.value != value){
            parent = current;
            if(value < current.value){
                // Move to the left if searched value is less
                current = current.left;
                isLeftChild = true;
            }
            else{
                // Move to the right if searched value is >=
                current = current.right;
                isLeftChild = false;
            }
            if(current == null){
                return false;
            }
        }
        // if reached here means node to be deleted is found
        
        // Leaf node deletion case
        if(current.left == null && current.right == null){
            System.out.println("Leaf node deletion case");
            // if root node is to be deleted
            if(current == root){
                root = null;
            }
            // left child
            else if(isLeftChild){
                parent.left = null;
            }
            // right child
            else{
                parent.right = null;
            }
        }
        // Node to be deleted has one child case
        // Node to be deleted has right child
        else if(current.left == null){
            System.out.println("One right child deletion case");
            // if root node is to be deleted
            if(current == root){
                root = current.right;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.left = current.right;
            }
            // if deleted node is right child
            else{
                parent.right = current.right;
            }
        }
        // Node to be deleted has left child
        else if(current.right == null){
            System.out.println("One left child deletion case");
            if(current == root){
                root = current.left;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.left = current.left;
            }
            // if deleted node is right child
            else{
                parent.right = current.left;
            }
        }
        // Node to be deleted has two children case
        else{
            System.out.println("Two children deletion case");
            // find in-order successor of the node to be deleted
            Node successor = findSuccessor(current);
            if(current == root){
                root = successor;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.left = successor;
            }
            // if deleted node is right child
            else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }
    // Method to find the in-order successor of the deleted node
    private Node findSuccessor(Node node){
        Node successor = node;
        Node successorParent = node;
        // Start from the right child of the node to be deleted
        Node current = node.right;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        // When In-order successor is in the left subtree 
        // perform two ref changes here as we have 
        // access to successorParent
        if(successor != node.right){
            successorParent.left = successor.right;
            // applicable only when successor is not right child
            // so doing here
            successor.right = node.right;
        }
        return successor;
    }
    
    public static void main(String[] args) {
    	BSTDeleteIterative bst = new BSTDeleteIterative();
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
        boolean deleteFlag = bst.delete(35);
        if(deleteFlag)
            System.out.println("Node successfully deleted");
        System.out.println("Inorder traversal after deletion");
        bst.inOrder(bst.root);
        System.out.println();
    }
}
