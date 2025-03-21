import java.util.ArrayList;
import java.util.Scanner;
public class Assignment2 {
// task :- find kth-smallest element in BST
static class Node{
     int data;
     Node left,right;
     Node(int val){
        this.data = val;
     }
}

static Node insert(Node root,int key){
    if(root == null) return new Node(key);
    else if(root.data > key) root.left = insert(root.left, key);
    else root.right = insert(root.right, key);
    return root;
 }
   public static void main(String args[]){
      Node root = null;
      int values[] = {8,11,5,3,20,6};            
      // build the BST 
      for(int i : values){
         root = insert(root, i);
      }
     System.out.println("The values in the BST are :- ");
     inOder(root);
     getKthSmallest(root);
    }

    static void inOder(Node root){
        if(root == null) return;
        inOder(root.left);
        System.out.print(root.data + " ");
        inOder(root.right);
    }

    static void getKthSmallest(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the kth- value = ");
        int k = sc.nextInt();
        Inorder(root, list);
        int idx = list.size() -k;
        System.out.println("\n"+k + "th smallest element in the BST = "+list.remove(idx));
    }
 
 static void Inorder(Node root, ArrayList<Integer> list){
    if(root == null) return;
      Inorder(root.left, list);
      list.add(root.data);
      Inorder(root.right, list);
 }
    
}
