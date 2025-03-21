import java.util.Queue;
import java.util.LinkedList;
public class Built_Tree{
  public static class Node{
    int data;
    Node left;
    Node right;
 public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;  
    }
  }

  public static class BinaryTree{
     static int idx = -1;
     // first function of tree built
     public static Node builtTree(int nodes[]){// O(n)
         idx +=1;
      if(nodes[idx] == -1){
        return null;
      }
      // create a node 
     Node newNode = new Node(nodes[idx]);
     // add left-subTree.
      newNode.left  = builtTree(nodes);
     // add right-subTree.
       newNode.right  = builtTree(nodes);
     return newNode;
     }  
// depth-order traversal are handle through recursively
// a. preOder(DLR)
public static void preOder(Node root){// O(n),where n = no.of node
    if(root == null){// i.e. the leave node
        System.out.print(-1 + ", ");
       return;
    }
    // print root's data
    System.out.print(root.data +", ");
    // call for left-subTree
    preOder(root.left);
    // call for riight-subTree
    preOder(root.right);
  }
  // b. inOder(LDR)
  public static void inOder(Node root){// O(n),where n = no.of node
    if(root == null){// i.e. the leave node
        //System.out.print(-1 + ", ");
       return;
    }
    // call for left-subTree
      inOder(root.left);
    // print root's data
    System.out.print(root.data +", ");
    // call for riight-subTree
     inOder(root.right);
    }
  // c. postOder(LDR)
  public static void postOder(Node root){// O(n),where n = no.of node
    if(root == null){// i.e. the leave node
        //System.out.print(-1 + ", ");
       return;
    }
    // call for left-subTree
      postOder(root.left);
    // call for riight-subTree
      postOder(root.right);
     // print root's data
     System.out.print(root.data +", ");
    }
 // d. level-order traversal using iteration
 public static void levelOrder(Node root){
      if(root == null){
        return;
      }
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      q.add(null);
     while (!q.isEmpty()){
        // we extract value from queue one by one 
         Node currNode = q.remove();
        if(currNode == null){
            // print nextline
            System.out.println();
          if(q.isEmpty()){
            break;
          } else{// if queue has some data in it
            q.add(null);
          }
        } else{
            System.out.print(currNode.data + " ");
          if(currNode.left !=null){
            q.add(currNode.left);
          } 
          if(currNode.right !=null){
            q.add(currNode.right);
          }
        }
     }
   }
   public static int Height(Node root){//O(n)
      if(root == null){
        return 0; 
      }
      int lh = Height(root.left);
      int rh = Height(root.left);
     int height = Math.max(lh,rh) + 1;
      return height;
   }
   public static int count(Node root){//O(n)
     if(root == null){
      return 0;
     }
     int lcount = count(root.left);// no.of node in left-subTree are stored in leftcount->lcount
     int rcount = count(root.right);// no.of node in right-subTree are stored in rightcount->rcount
      return (lcount + rcount + 1);
   }
   public static int sumNode(Node root){// O(n)
        if(root == null) {// base-case
          return 0;
        }
          int lsum =  sumNode( root.left);
          int rsum =  sumNode( root.right);
      return (lsum + rsum + root.data);
   }
 }
    public static void main(String[] args) {
     int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
     BinaryTree tree = new BinaryTree();
       Node root =  tree.builtTree(nodes);
      System.out.println("Total sum of all nodes are in the binary tree  = "+tree.sumNode(root));

      //System.out.println("Total no. of nodes are in the binary tree  = "+tree.count(root));
     //  System.out.println("The height of the binary tree = "+tree.Height(root));
      //  System.out.println("Leveloder traversal's value are :- ");
      //  tree.levelOrder(root);
        // System.out.println("Postoder traversal's value are :- ");
        // tree.postOder(root);
    }
}