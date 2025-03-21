import java.util.ArrayList;
import java.util.Scanner;
public class PrintInRange {
 // task :- to print the BST's data within the given range [k1,k2];
 static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
 }
 static Node insert(Node root,int val){
     if(root == null){
        root = new Node(val);
        return root;
     }
    else if(root.data > val){
        root.left = insert(root.left,val);
    } else{
        root.right = insert(root.right,val);
    }
     return root;
 }

 public static void main(String[] args) {
    Node root = null; 
    int values[] = {8,5,6,4,10,11,1,3,14};
   // build the BST alongwith the given values's element
   for(int i : values){
       root = insert(root, i);
   }
  System.out.println("Inorder traversal :- ");
  inOrder(root);
  Scanner sc = new Scanner(System.in);
  System.out.print("\nEnter the start-point of range = ");
  int k1 = sc.nextInt();
  System.out.print("\nEnter the end-point of range = ");
  int k2 = sc.nextInt();
  System.out.println("The values avialable in BST b/w the range of "+k1 + "<-->"+k2 +" are :- ");
  printInRange1(root, k1, k2);
  
  //printInRange(root, k1, k2);

}
// by didi Approach
static void printInRange1(Node root,int k1,int k2){//O(n)
    if(root == null){
        return;
    } 

    if(root.data >= k1 && root.data <=k2){
        printInRange1(root.left, k1, k2);
        System.out.print(root.data + " ");
        printInRange1(root.right, k1, k2);
    }
   else if(root.data <k1){
    printInRange1(root.left, k1, k2);
   } else {
    printInRange1(root.right, k1, k2);
    }
}

static void printInRange(Node root,int k1,int k2){//O(K1+K2) by my approach
    if(root == null){
        return;
    } 

    if(root.data >= k1 && root.data <=k2){
        System.out.print(root.data + " ");
    }
    printInRange(root.left, k1, k2);
    printInRange(root.right, k1, k2);
}
    
static void inOrder(Node root) {
    if(root == null){
        return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
}

}
