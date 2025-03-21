public class Assignment3 {
  // deletion of leaf node with value as x;
 public static class  Node {
    int data;
    Node left;
    Node right;
    Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
 }
  public static Node deleteLeafNode(Node root,int x){
    if(root == null){
        return null;
    }
    if(root.data == x && root.left == null && root.right == null){// cond. for a leaf node with value as x
        return null;
    }
    root.left = deleteLeafNode(root.left, x);
    root.right = deleteLeafNode(root.right, x);
    return root;
  }
    public static void main(String[] args) {
    Node root = new Node(1);    
    root.left = new Node(3);
    root.right = new Node(3);
    root.left.left = new Node(3);
    root.left.right = new Node(2);
    int x = 3; 
    Node r = deleteLeafNode(root,x);
    System.out.println("The preOder traversal value's are :- ");
    preOrder(r);
  }
  public static void preOrder(Node root){
      if(root == null){
        return;
      }
    System.out.print(root.data+" ");   
    preOrder(root.left);
    preOrder(root.right);
  }   
}
