import java.util.ArrayList;
import java.util.Scanner;
public class Assignment3 {
// task :- find the closet element in BST so,that the absolute diff. b/w the node and given target node is minimum

static class Node{
    int data;
    Node left,right;
    Node(int key){
        this.data = key;
    } 
 }

 static Node insert(Node root,int val){
    if(root == null) return new Node(val);
    else if(root.data > val) root.left = insert(root.left, val);
    else root.right = insert(root.right,val);
    return root;
 }

 public static void main(String[] args) {
    Node root = null;
    int values[] = {8,3,5,11,20,6};
    // build a BST
    for(int i : values){
        root = insert(root, i);
    }
    System.out.println("The values in the BST are determine by preOrder traversal :- ");
    preOder(root);
   getClosestElement(root);
 }

 static void preOder(Node root){
    if(root == null) return;
    System.out.print(root.data + " ");
    preOder(root.left);
    preOder(root.right);
 }

 static void  getClosestElement(Node root){
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> diff = new ArrayList<>();
    Inorder(root,list);
  //  System.out.println("\n"+list);
   Scanner sc = new Scanner(System.in);
   System.out.print("\nEnter the target Node = ");
   int k = sc.nextInt();
   for(int i : list){
    //int differnce = k - i;
     if((k-i)>=0)  {
     diff.add(k-i);
     }
   }
   //System.out.println("\n"+diff);
  int Req_node = absoluteMinDiff(diff);
  System.out.println("The closet element,whose absolute difference  in the BST is minimum  = "+list.remove(Req_node));
 }

 static int absoluteMinDiff(ArrayList<Integer> diff){
    int min = Integer.MAX_VALUE,idx = -1;// min = +Infinity
    for(int i = 0; i<diff.size(); i++){
      if(diff.get(i)<min){
        min = diff.get(i);
        idx = i;// it will tell about idx of minimum absolute difference b/w the target element and the required node
      }
    }
    return idx;
 }

 static void Inorder(Node root,ArrayList<Integer> list){
   if(root == null) return;
   Inorder(root.left, list);
   list.add(root.data);
   Inorder(root.right, list);
 }
    
}
