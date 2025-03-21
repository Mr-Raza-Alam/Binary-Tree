public class SizeofLargestBST {
 // task :- to find size of largest BST in BST --> No.of nodes in valid BST
  static class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
    }
  }
  
  static int maxBST_Size = 0;
  static Node maxBst_Node = null;

  static class Info{
    boolean isBST;
    int size;
    int min;
    int max;
    public Info(boolean isBST,int size,int min,int max){
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
  }

  static boolean isValidBST(Node root,Node min,Node max){
     if(root == null){
        return true;
     } 
     if(min != null && root.data <= min.data) return false;
     else if(max != null && root.data >= max.data) return false;    
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

static int getSize(Node root){
  if(root == null){
    return 0;
  }
  int leftSize = getSize(root.left);
  int rightSize = getSize(root.right);
 return (leftSize + rightSize + 1);
}

public static Info largestBST(Node root){
    if(root == null){
        // in case of null Node isBST = true, size = 0,min = +Infinity, max = -Infinty
        return new Info(true, 0,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
     
    Info leftInfo = largestBST(root.left);
    Info rightInfo = largestBST(root.right);
    int size =  leftInfo.size + rightInfo.size +1;
    int min  = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
    int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
    // now check isvalid BST or not 
    if(root.data <= leftInfo.max || root.data >= rightInfo.min){
           return new Info(false, size, min, max);
    }
    // now check if left subtree is BST && right subtree is also BST 
    if(leftInfo.isBST && rightInfo.isBST){
        maxBST_Size = Math.max(maxBST_Size,size);
         maxBst_Node = root;
        return new Info(true, size, min, max);
    }
   return new Info(false, size, min, max);
}

 public static void main(String[] args) {
    Node root = new Node(50);
    root.left = new Node(30);
    root.left.left = new Node(5);
    root.left.right = new Node(20);

    root.right = new Node(60);
    root.right.left = new Node(45);
    root.right.right = new Node(70);
    root.right.right.left = new Node(65);
    root.right.right.right = new Node(80);

   Info res = largestBST(root);
   System.out.println("The largest size of BST in BST = "+maxBST_Size);
   System.out.println("The largest size of valid BST's values are :- "); 
   inOrder(maxBst_Node);
 } 
 static void inOrder(Node root){
    if(root == null){
        return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right); 
 }

}
