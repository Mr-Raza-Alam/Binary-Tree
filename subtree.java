public class subtree {
  // return true if subtree is exit in the tree else return false
  static class Node {
    int data;
    Node left;
    Node right;
   public Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  
  public static boolean isSubtree(Node root1,Node root2){// O(n)
      if(root1 == null){// when subroot is not exit in the tree
        return false;
      }
    
        if(root1.data == root2.data){// find is root == subroot or not
             if(isIdentical(root1,root2)){// O(n)
                return true;
             }
        }  // if not then check in left subtree and then if not exit then check in right subtree
       return isSubtree(root1.left, root2) ||  isSubtree(root1.right, root2); 
  }

  public static boolean isIdentical(Node root,Node subRoot){//O(n) 
      // check non-identical condition for the given subtree  
    if(root == null && subRoot == null) return true;
      else if(root == null || subRoot == null || root.data != subRoot.data) return false;    
      if(!isIdentical(root.left, subRoot.left)) return false;//O(1) at each call
      if(!isIdentical(root.right, subRoot.right)) return false;//O(1) at each call
      return true;
  }

  public static void main(String[] args) {

      Node root1 = new Node(5);
      root1.left = new Node(9);
      root1.right = new Node(7);
      root1.left.left = new Node(4);
      root1.left.right = new Node(8);
      root1.right.left = new Node(5);
      root1.right.right = new Node(6);
     // subtree
     Node root2 = new Node(7);
     root2.left = new Node(5);
     root2.right = new Node(6);
     System.out.println("Is subtree exit in the tree ?\nGive answer :- "+isSubtree(root1, root2));
   }
}
