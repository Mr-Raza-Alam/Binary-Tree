import java.util.ArrayList;
public class RootToLeafPaths {
 // task :- to print all data of nodes which comes under root to leaf for each path
  static class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
    }
  }
  static Node insert(Node root,int val){
     if(root == null){
        root = new Node(val);
        return root;
     }
     else if(root.data>val){
       root.left =  insert(root.left, val);
     } else{
       root.right = insert(root.right, val);
     }
    return root;
  }
static void printPath(ArrayList<Integer> list){
   System.out.println("The values in paths are :- ");
    for(int i = 0; i<list.size(); i++){
    System.out.print(list.get(i) + " ->");
  }
  System.out.println("Null");
}
  static void printRoot2Leaf(Node root,ArrayList<Integer> list){//O(n)
       if(root == null){
        return;
       }
       list.add(root.data);
       if(root.left == null && root.right == null){//  cond. for a leaf node
        printPath(list);
      }
      printRoot2Leaf(root.left, list);
      printRoot2Leaf(root.right, list);
      list.remove(list.size() -1);
  }

  public static void main(String[] args) {
    int values[] = {8,5,6,10,4,1,3,11,14};
   // built the BST
   Node root = null;
   for(int i : values){
    root = insert(root, i);
  }
    System.out.println("Inorder traversal :- ");
    inOrder(root);
    System.out.println(); 
      printRoot2Leaf(root, new ArrayList<>());
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
