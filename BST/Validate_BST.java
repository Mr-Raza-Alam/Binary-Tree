public class Validate_BST {
    // task :- to check  the given BST is valid or not -> for this we apply Approach-2 i.e 
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
    else if(root.data > val){
      root.left = insert(root.left, val);
    } else{
        root.right = insert(root.right, val);
    }
    return root;
  }

 public static void main(String[] args) {
    int values[] = {1,1,1};
    Node root = null;
    // Build a BST of given above values
    for(int i : values){
        root = insert(root, i);
    }
   if(isValidBST(root, null, null)){
        System.out.println("Valid BST has formed ");
   } else{
    System.out.println("Invalid BST has formed");
   }
 }
 static boolean isValidBST(Node root,Node min,Node max){
  if(root == null){// when there is no node then it is true that valid BST
   return true;
  }
  if(min != null && root.data <= min.data) return false;
 else if (max != null && root.data >= max.data)  return false;
 return isValidBST(root.left, min, root) && isValidBST(root.right,root, max);
 }
}
