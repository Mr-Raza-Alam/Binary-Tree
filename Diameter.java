public class Diameter {
 // diameter of a tree ,using approach-1
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

 public static int Height(Node root){
     if(root == null)  {
        return 0; 
     }
     int lh = Height(root.left);
     int rh = Height(root.right);
    return (Math.max(lh,rh)+1);
 }

 public static int Diameter(Node root){//O(n^2)
     if(root == null){
        return 0;
     }
     int lh = Height(root.left);//O(n) ->each time
     int ldia = Diameter(root.left);//O(1) ->each time
     int rh = Height(root.right);//O(n) ->each time
     int rdia = Diameter(root.right); //O(1) ->each time

     int selfdia = (lh + rh + 1);
    return Math.max(selfdia,Math.max(ldia,rdia));
 }

  public static void main(String[] args) {
    /*    
              1
             / \
            2   3
           / \  / \
          4  5 6   7
     */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    // since diameter(root) is act as object of class Info 
    System.out.println("The height of the tree = "+diameter(root).ht);
    System.out.println("The diameter of the tree = "+diameter(root).dia);
    // System.out.println("The diameter of the tree = "+Diameter(root));
    //System.out.println("Height of the binary-tree = "+Height(root));
  }
    // 2nd approach of diameter of the tree
  static class Info{
      int dia;
      int ht;
      Info(int dia,int ht){
        this.dia = dia;
        this.ht = ht;
      }
  }
  
  public static Info diameter(Node root){//O(n)
        if(root == null){
            return new Info(0, 0);
        }
       Info Linfo = diameter(root.left);
       Info Rinfo = diameter(root.right);

       int Actdia = Math.max(Math.max(Linfo.dia,Rinfo.dia),Linfo.ht + Rinfo.ht + 1);// actual diameter of each node
       int Actht = Math.max(Linfo.ht,Rinfo.ht)+1; // actual height of each node
       return new Info(Actdia, Actht);// (actual diameter , height )of each node is being returned
  }

}
