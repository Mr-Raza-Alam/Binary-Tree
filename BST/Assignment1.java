import java.util.Scanner;
public class Assignment1{
    // task :- find total sum of nodes b/w the range [k1,k2];
   static class Node{
    int data;
    Node left,right;
    Node(int val){
        this.data = val;
    }
   }

   static Node insert(Node root,int key){
    if(root == null){
        return new Node(key);
    } else if(root.data > key) root.left = insert(root.left, key);
    else root.right = insert(root.right, key);
    return root;
   }
 
   static int sum = 0;
  public static void main(String[] args) {
    Node root = null;
    int values[] = {8,5,11,3,20,6};
    // build a BST
    for(int i : values){
        root = insert(root, i);
    }
    System.out.println("The values are in the BST  through preOrder are :- ");
    preOder(root);
    System.out.println("\nThe values are in the BST are :- ");
    inOder(root);
    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter start-point of the range = ");
    int sp = sc.nextInt();
    System.out.print("\nEnter end-point of the range = ");
    int ep = sc.nextInt();
    getSum(root, sp, ep);
    System.out.println("The sum of values of nodes of BST b/w the range of ["+sp+" , "+ep+"] = "+sum);
  }

  static void inOder(Node root){
    if(root == null) return;
    inOder(root.left);
    System.out.print(root.data + " ");
    inOder(root.right);
  }
  static void preOder(Node root){
    if(root == null) return;
    System.out.print(root.data + " ");
    preOder(root.left);
    preOder(root.right);
  }

  static void getSum(Node root,int k1,int k2){
    if(root == null){
        return;
    }
    if(root.data >= k1 && root.data <= k2){
        getSum(root.left,k1,k2);
        sum +=root.data;
        getSum(root.right,k1,k2);
    } 
    else if(root.data <k1 || root.data >k2){
        getSum(root.left, k1, k2);
    } else{
        getSum(root.right, k1, k2);
    }
  }
  

}
