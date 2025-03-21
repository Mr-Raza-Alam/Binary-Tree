public class SortedArray {
 // task :- to build a balance BST from the given sorted array
 static class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
    }
 }
// create a  balance in any case of ele.order 
static Node createBST(int arr[],int si,int ei){// O(n)
    if(si>ei){
        return null;
    }
    int mid = (si+ei)/2;
    Node root = new Node(arr[mid]);
    root.left = createBST(arr, si, mid-1);
    root.right = createBST(arr, mid+1, ei);
    return root;
}
 

 static Node insert(Node root,int val){ // this will create a unbalance BST  without min height of tree
   if(root == null){
    root = new Node(val);
    return root;
   } else if(root.data > val){
    root.left = insert(root.left, val);
   } else{
    root.right = insert(root.right, val);
   }
    return root;
 }

 public static void main(String[] args) {
    // int mid = 0 + (arr.length -1 -0)/2;
    // // build left subtree with root Node
    // Node root = null;
    // for(int i = mid; i>=0; i--){
    //    root = insert(root, arr[i]);
    // }
    // // build right subtree without root node
    // for(int i = mid+1 ; i<arr.length; i++){
    //     root = insert(root, arr[i]);
    // }
    int arr[] = {3,5,6,8,10,11,12};
     Node root = createBST(arr, 0, arr.length -1);
    System.out.println("The values carry in preOrder traversal are :- ");
    preOrder(root);
    System.out.println("\nThe values carry in preOrder traversal are :- ");
    inOrder(root);  
}

 static void preOrder(Node root ){
    if(root == null){
        return ;
    }
    System.out.print(root.data +" ");
    preOrder(root.left);
    preOrder(root.right);
 }
 static void inOrder(Node root ){
    if(root == null){
        return ;
    }
    inOrder(root.left);
    System.out.print(root.data +" ");
    inOrder(root.right);
 }
}
