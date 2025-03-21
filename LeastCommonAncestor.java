import java.util.ArrayList;
public class LeastCommonAncestor {
    // task :- to find least(first) common Anscestor

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
  
   public static boolean getPath(Node root,ArrayList<Node> p1,int n){
         if(root == null){
            return false;
         } 
         p1.add(root);
       if(root.data == n){
        return true;
       }
       boolean foundAtleft = getPath(root.left, p1, n);
       boolean foundAtright = getPath(root.right, p1, n);
       if(foundAtleft || foundAtright){
        return true;
       } 
      p1.remove(p1.size() -1);
        return false ;
   } 
   public static Node lca(Node root , int n1,int n2){// TC = O(n) && SC = SC = o(n)
    ArrayList<Node> path1 = new ArrayList<>();// SC = o(n)
    ArrayList<Node> path2 = new ArrayList<>(); // SC = o(n)
    getPath(root, path1, n1);//O(n)
    getPath(root, path2, n2);//O(n)
    int i =0;
  for(; i<path1.size() && i< path2.size() ; i++){//O(path1.size())
      if(path1.get(i)!=path2.get(i)) break;
  }
  Node lca = path1.get(i-1);
      return lca;
}

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(1);
       int n1 =8,n2 = 1;
        // Node ans = lca(root, n1, n2);// O(n) -> TC && SC
        Node ans = getLca(root, n1, n2);// O(n) -> TC && SC->O(1)
    System.out.println("The least common ancestor = "+ans.data);
    }  
    // 2nds approach with TC -> o(n) & SC -> O(1)
    public static Node getLca(Node root,int n1,int n2 ){
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
         Node leftLCA = getLca(root.left, n1, n2);
         Node rightLCA = getLca(root.right, n1, n2);
// righttLca gives valid lca from left subtree  then return leftlca
          if(rightLCA == null){
            return leftLCA;
          }
// lefttLca gives valid lca from right subtree  then return righttlca
          if(leftLCA == null){
            return rightLCA;
          }
        return root;
    }
}
