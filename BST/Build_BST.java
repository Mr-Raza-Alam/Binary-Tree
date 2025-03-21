import java.util.Scanner;
public class Build_BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
          this.data = data;
          this.left = null;
          this.right = null;
        }
    }
   public static Node createBST(Node root,int data){//O(H)
      if(root == null){
          root  = new Node(data); //O(1) at each time
          return root;
        }
    else if(data < root.data){
      // left-subtree of bst 
         root.left =  createBST(root.left, data);
       }
       else{
        // right-subtree of bst
       root.right =  createBST(root.right, data);
       }         
          return root;
      }
   
   public static boolean search_BST(Node root,int key){//O(H)
    if(root == null){
      return false;// b/c 
    }
    if(root.data == key) return true;
    else if(root.data > key) return search_BST(root.left, key);
    else return search_BST(root.right, key);
  }

  public static Node delete_BST(Node root,int key){
   if(root.data< key){
   root.right =  delete_BST(root.right,key);
   } else if(root.data > key){
    root.left = delete_BST(root.left, key);
   } else{// the key has been found to be deleted from bst called voila case
     // case-1 : having no childs
     if(root.left == null && root.right == null){
      return null;
     }
     // case-2 :- having 1 child
     if(root.left == null) return root.right;
     else if(root.right == null) return root.left;
     // case-3 :- having 2 childrens
     // very important 
     if(root.left != null && root.right != null){
      Node IS = inOrderSuccessor(root.right);
       root.data = IS.data;
      root.right =  delete_BST(root.right,IS.data);
     }      
   }    
   return root;
  }
  public static Node inOrderSuccessor(Node node){
      while(node.left != null){
         node = node.left;
      } 
    return node;
  }
    
    public static void main(String[] args) {
      Node root = null;
      //int values[] = {5,1,3,4,2,7,6,10,9,8};
      int values[] = {8,5,3,10,11,6,14,1,4};
      for (int i = 0; i<values.length; i++){          
          root = createBST(root,values[i]);
      }
      System.out.println("The values stored in BST are determined by inOrder traversal  :- ");
      inOrder(root);
      Scanner sc = new Scanner(System.in);
    //System.out.print("Enter the key to search in the BST here = ");
    System.out.print("\nEnter the key to delete from the BST here = ");
    int key =  sc.nextInt();
    Node r = delete_BST(root, key);
    System.out.println("After deletion ,The values stored in BST are determined by preOrder traversal  :- ");
    preOrder(r);
  // System.out.println("After deletion ,The values stored in BST are determined by inOrder traversal  :- ");
  //  inOrder(r);
    // if(search_BST(root, key)){
    //   System.out.println("Hurray! key is found");
    // } else{
    //   System.out.println("Sorry! key is unavialable");
    // }
      // System.out.println("The values stored in BST are determined by preOrder traversal :- ");
      // preOrder(root);
      // System.out.println("The values stored in BST are determined by inOrder traversal  :- ");
      // inOrder(root);
    }
 // inOrder traversal
  public static void inOrder(Node root){
     if(root == null) return;
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
  }
   // preOrder traversal
   public static void preOrder(Node root){
    if(root == null) return;
    System.out.print(root.data + " ");
     preOrder(root.left);
     preOrder(root.right);
 }
}
