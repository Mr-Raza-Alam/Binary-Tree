import java.util.LinkedList;
import java.util.Queue;
public class KthLevel {
    // print all the nodes of kth level
// 1st using BFS,i.e. level-order-traversal
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

public static void getKthNodes(Node root,int k){
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()){
       Node currNode = q.remove();
    if(currNode == null){
        if(q.isEmpty()) break;
        else q.add(null);
     } 
     else{
        if(currNode.left != null){
            q.add(currNode.left);
        } 
        if(currNode.right !=null){
            q.add(currNode.right);
        }
        k--;           
       }   
     if(k == 0){
       if(q.peek() == null) q.remove();
      while (!q.isEmpty()){
          Node knode = q.remove();
           System.out.print(knode.data + " ");
          }         
     }
    }

     System.out.println();
 }
 public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(4);
    root.right = new Node(9);
    root.left.left = new Node(2);
    root.left.right = new Node(8);
    root.right.left = new Node(6);
    root.right.right = new Node(1);
    int k = 2;
    System.out.println("Nodes are avialable at "+k+"th level :- ");
    getKthNodes(root, k);
   // kthLevelNodes(root, k, 1);
 }
 // using recurrsion, depth order traversal O(n)
 public static void kthLevelNodes(Node root,int k,int t){
    if(root == null){
        return;
    } else if(t == k){
        System.out.print(root.data + " ");
        return;
    }
    kthLevelNodes(root.left, k, t+1);
    kthLevelNodes(root.right, k, t+1);
 }
    
}
