import java.util.*;
public class Topview {
    // top view of a tree
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
      public static int count(Node root){
        if(root == null){
            return 0;
        } 
        int lcount = count(root.left);
        int rcount = count(root.right);
        return lcount + rcount +1;
      }
        static class Info{
            int hd;
            Node node;
            Info(int hd,Node node){
                this.hd = hd;
                this.node = node;
            }
        }

      public static void topView(Node root){
         // apply level order traversal
         Queue<Info> q = new LinkedList<>();
         HashMap<Integer,Node> map = new HashMap<>();
         int min = 0,max = 0;// for getting most least HD and for getting most greatest HD    
         // here in queue , we store pair value : 1st hd of each node and its corresponding node
         q.add(new Info(0, root));
         q.add(null);
         while (!q.isEmpty()){
             Info curr = q.remove();
             if(curr == null){
                 if(q.isEmpty()){// b/c we have traversed all the node that's why now need to stop the process
                    break;
                 } else{
                    q.add(null);
                 }
            } else{
            // check whether the similar HD of node exit or not
            // if not exit then add new HD of node else leave it 
            if(!map.containsKey(curr.hd)){// containKey(key)--> return true if key exit otherwise retun false;
               
                map.put(curr.hd,curr.node);
            }
           if(curr.node.left !=null){
            // add HD of left node and node itself to the queue q 
             q.add(new Info(curr.hd-1, curr.node.left));
              min = Math.min(min,curr.hd-1);
              // here to update the max value make it sensless work. b/c we need min - max range for print the top view node
           }
           if(curr.node.right !=null){
            // add HD of right node and node itself to the queue q 
            q.add(new Info(curr.hd+1, curr.node.right));
            max = Math.max(max,curr.hd+1);
            // here to update the min value make it sensless work . b/c we need min - max range for print the top view node
            }
          }
        }
         // its time to print top-view node 
         for(int i = min; i<= max; i++){
            System.out.print(map.get(i).data+" ");
         }
      }

      public static void main(String[] args) {
    
          Node root = new Node(5);
          root.left = new Node(9);
          root.right = new Node(7);
          root.left.left = new Node(4);
          root.left.right = new Node(8);
          root.right.left = new Node(5);
          root.right.right = new Node(6);
          System.out.println("The top view nodes are :- ");
          topView(root);
        // int bal = count(root);
        // if((bal-1)%2 == 0){// done by me for balance tree
        //  System.out.println("The given is Balance tree\nFrom top view the nodes are :- ");
        //  // print only left node's data of left-subtree
        //  printLeftNode(root.left);
        //  // print root node's data
        //  System.out.print(root.data + " ");
        // // print only right node's data of left-subtree
        //  printrightNode(root.right);
        // } else System.out.println("The given is Unbalance tree "); 
    
     } 

    public static void printLeftNode(Node root){// O(n)
       if(root == null){
        return ;
       }
       printLeftNode(root.left);
       System.out.print(root.data + " ");
    }
    public static void printrightNode(Node root){//O(n)
        if(root == null){
            return ;
           }
        System.out.print(root.data + " ");
           printLeftNode(root.right);
    }
}
