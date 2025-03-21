import java.util.LinkedList;
import java.util.Queue;
public class Assignment_1 {
 // task :- check if a binary tree is univalued or not
  /*
             2
            / \
           2   2
          /\     \
         5  2     2
   */
   static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
     }
   }
     
   public static boolean isUnivalue(Node root){
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      while (!q.isEmpty()){
        Node currNode = q.remove();
       if(currNode.data != root.data) return false;
         if(currNode.left != null){
         q.add(currNode.left);
      }
      if(currNode.right != null){
         q.add(currNode.right);
      }  
    }  
    return true;
} 

   public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(2);
    root.right = new Node(2);
    root.left.left = new Node(2);
    root.left.right = new Node(2);
    System.out.println("The value isUnivalue = "+ isUnivalue(root));
    if(isUnivalue(root)){
        System.out.println("Yes,Univalue is exit");
    } else{
        System.out.println("No,Unique value does not exit");
    }
   }
}
