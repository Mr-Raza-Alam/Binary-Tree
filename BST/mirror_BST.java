public class mirror_BST {
  static class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
      this.data = val;
    }
  }

  static Node insert(Node root ,int val){
    if(root == null){
      root = new Node(val);
      return root;
    }
    else if(root.data > val){
      root.left = insert(root.left,val);
    } else{
      root.right = insert(root.right, val);
    }
    return root;
  }

  static Node mirrorImage(Node root){
    if(root == null){
      return null;
    }
    Node left = mirrorImage(root.left);
    Node right = mirrorImage(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
  public static void main(String[] args) {
    int values[] = {10,4,21,2,13,22,6,15,11,25,1};
    // build a BST 
    Node root = null;
    for(int i : values){
      root =  insert(root, i);
    }
    System.out.println("The original BST inorder traversal are :- ");
    inOrder(root);
    Node mirrRoot = mirrorImage(root);
    System.out.println("\nAfter mirror image of BST inorder traversal are :- ");
    inOrder(mirrRoot);

    }

   static void inOrder(Node root){
    if(root == null){
      return ;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);

   }
}
