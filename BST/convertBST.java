import java.util.ArrayList;

public class convertBST {
// task :- Convert BST to Balance BST
static class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
      this.data = val;
    }
}
static Node insert(Node root,int val){//O(n)
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
// create balance BST 
static Node create_BST(ArrayList<Integer> list,int si,int ei){//O(n)
    if(si>ei){
        return null;
    }

    int mid = (si + ei)/2;
    Node root = new Node(list.get(mid));
    root.left = create_BST(list, si, mid-1);
    root.right = create_BST(list, mid +1, ei);
    return root;
}

static void preOrder(Node root){
    if(root == null){
        return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}

public static void main(String[] args) {
    int arr[] = {8,6,10,5,3,11,12};
    Node root = null;
    for(int i : arr){
        root = insert(root, i);
    }
    System.out.println("The values carry in preOrder traversal are :- ");
    preOrder(root);
    // store inorder sequence of above build-in BST in ArrayList
    ArrayList<Integer> list = new ArrayList<>();
    inOrder(root,list);
  System.out.println("\nThe value in list are :- ");
  for(int i= 0; i<list.size(); i++){
    System.out.print(list.get(i)+" ");
  }
  Node node = create_BST(list, 0, list.size() -1);
  System.out.println("\nThe values carry in preOrder traversal are :- ");
  preOrder(node);
}

static void inOrder(Node root,ArrayList<Integer> list){//O(n)
   if(root == null){
    return;
   }
   inOrder(root.left,list);
   list.add(root.data);
   inOrder(root.right,list);
 }   
}
