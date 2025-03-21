public class AVLTree {
// AVL-Tree -> Self-Balancing BST 

static class Node{
    int data,height;
    Node left,right;
    Node(int val){
       this.data = val;
       height = 1;  
    }
}
 
public static Node root;

static int balanceFactor(Node root){
   if(root == null){
    return 0;
   }
   return (height(root.left) - height(root.right));
}

static Node leftRotation(Node x){
    Node y = x.right;
    Node T2 = y.left;
    // Perform rotation
    y.left = x;
    x.right = T2;
    // Update heights
    x.height = Math. max(height(x.left),height(x.right))+1; 
    y.height = Math. max(height(y.left),height(y.right))+1;
    // return new Node as y after left rotation
    return y;
} 
static Node rightRotation(Node y){
    Node x = y.left;
    Node T2 = x.right;
    // Perform rotation
    x.right = y;
    y.left = T2;
    // Update heights
    y.height = Math. max(height(y.left),height(y.right))+1;
    x.height = Math. max(height(x.left),height(x.right))+1; 
    // return new Node as x after right rotation
    return x;
} 

static Node insert(Node root,int key){
  if(root == null){
    return new Node(key);
  }
  else if(root.data > key){
     root.left = insert(root.left, key);
  } else if( root.data < key){
    root.right = insert(root.right, key);
  } 
else{
  return root;
  }
  // Update root height
  root.height = 1 + Math.max(height(root.left) , height(root.right));
 // Get root's balance factor of each node while inserting it
 int bf = balanceFactor(root);

 // left-left Case i.e right rotation only i.e.. bf > 1(always) but root.left.data < key
 if(bf >1 && key < root.left.data){// unbalace bf > 1
   return rightRotation(root);
 }
 // right-right Case i.e left rotation only i.e.. bf < -1(always) but root.right.data > key
 if(bf < -1 && key > root.right.data){
   return leftRotation(root);
 }
// left-right Case i.e 1st- leftRotation and then 2nd -rightRotation only i.e.. bf > 1(always) but root.right.data > key
  if(bf >1 && key > root.left.data){
   root.left = leftRotation(root.left);
    return rightRotation(root);
 }
 // right-left Case i.e 1st- rightRotation and then 2nd -lefttRotation only i.e.. bf < -1(always) but root.right.data < key
 if(bf < -1 && key < root.right.data){
   root.right = rightRotation(root.right);
   return leftRotation(root);
 }

 return root; // if AVL tree is already balance . otherwise above cases will be execute
}

static int height(Node root){
  if(root == null){
    return 0;
  }
  return root.height;
}

public static void main(String[] args) {
    int values[] = {40,20,10,25,30,22,50};
    // build a AVL-Tree
    for(int i : values){
        root = insert(root, i);
    }
    System.out.println("The preOder traversal's value of AVL-Tree are :- ");
    preOrder(root);
    System.out.println("\nThe inOder traversal's value of AVL-Tree are :- ");
    inOrder(root);
}

static void preOrder(Node root){
    if(root == null){
        return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
 }
 static void inOrder(Node root){
    if(root == null){
        return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
}
}
