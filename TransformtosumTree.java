public class TransformtosumTree {
    // make each node = sum(left-subTree + right-subTree)
 static  class Node{
     int data;
     Node left;
     Node right;
     Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
     }
 }

public static int transformToSum(Node root){// O(n)
    if(root == null){
         return 0;
    }
    int leftSum = transformToSum(root.left);
    int rightSum = transformToSum(root.right);
    int data = root.data; 
   int newLeft = root.left == null ? 0: root.left.data;
   int newRight = root.left == null ? 0: root.right.data;
      root. data =  newLeft  + leftSum + rightSum + newRight;
     return data;
}
 
 public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    System.out.println("Before transformation preOder traversal's value are :- ");
     preOder(root);
    transformToSum(root);
    System.out.println("\nAfter transformation preOder traversal's value are :- ");
     preOder(root);
 }
  public static void preOder(Node root){
    if(root == null){
        return;
    }
    System.out.print(root.data + " ");
    preOder(root.left);
    preOder(root.right);
  }
}
