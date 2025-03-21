public class minDistance {
  // minimum distance between nodes 
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

public static int minDistanceNodes(Node root,int n){
    if(root == null){
        return -1;
    }
    if(root.data == n){
        return 0;
     } 
     int dL = minDistanceNodes(root.left, n);
     int dR = minDistanceNodes(root.right, n);
     if(dL == -1 && dR == -1){
        return -1;
     } 
     else if(dL == -1){
        return dR+1;
     }else {
        return dL+1;
     }
}

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(4);
    root.right = new Node(6);
    root.left.left = new Node(3);
    root.left.right = new Node(2);
    root.right.left = new Node(7);
    root.right.right = new Node(9);
   int n1 = 7,n2 = 9;
    // Node ans = lca(root, n1, n2);// O(n) -> TC && SC
    Node ans = getLca(root, n1, n2);// O(n) -> TC && SC->O(1)
     int d1 = minDistanceNodes(ans, n1);
     int d2 = minDistanceNodes(ans, n2);
     System.out.println("The minimum distance b/w "+n1+" to "+n2 + " = "+(d1+d2));
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
