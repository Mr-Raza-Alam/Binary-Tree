import java.util.ArrayList;
public class Merge2BSTs {
 // task :- merge 2 different BST and formed a new balance BST

 static class Node{
    int data;
    Node left;
    Node right;
    Node(int val){   
        this.data = val;
    }
 }

  static Node create_balance_BST(ArrayList<Integer>list, int st, int end){
    if(st > end){
        return null;
    }
     int mid = (st + end)/2 ;
    //int mid = (st + end)/2 +1;
    Node root = new Node(list.get(mid));
    root.left =  create_balance_BST(list, st, mid -1);
    root.right = create_balance_BST(list, mid+1, end);
    return root;
  } 

 public static void main(String[] args) {//O(n+m)
   // build a BST1
   Node root1 = new Node(8);
   root1.left = new Node(4);
   root1.left.left = new Node(3);
   root1.left.left.right = new Node(6);
   root1.left.left.left = new Node(2);
   root1.right = new Node(11);
   root1.right.left = new Node(9);
   root1.right.left.right = new Node(10);
   root1.right.right = new Node(14);
   root1.right.right.right = new Node(16);

   // build a BST2
   Node root2 = new Node(7);
   root2.left = new Node(1);
   root2.left.right = new Node(5);
   root2.right = new Node(17);
   root2.right.left = new Node(13);
   root2.right.left.left = new Node(12);
   root2.right.right = new Node(18);
   root2.right.right.right = new Node(19);

// store Inorder sequence of BST1 in list1 
   ArrayList<Integer> list1 = new ArrayList<>();
    Inorder(root1,list1);
// store Inorder sequence of BST2 in list2 
   ArrayList<Integer> list2 = new ArrayList<>();
   Inorder(root2,list2);
// merging of list1 and list2 in list
   ArrayList<Integer> list = new ArrayList<>();
   int idx1 = 0,idx2 = 0;
   while (idx1 <list1.size() && idx2 < list2.size()){
      if(list1.get(0) <= list2.get(0)){
        list.add(list1.remove(0));
        //idx1++; 
      } else{
        list.add(list2.remove(0));
      //  idx2++;
      }
   }
   while (idx1< list1.size()){
    list.add(list1.remove(0));
    //idx1++;
   }
   while (idx2<list2.size()){
    list.add(list2.remove(0));
    //idx2++;
   }
   // now we have sorted arraylist element in list 
   // its time to create a balance BST using this Sorted arraylist i.e list
   Node node = create_balance_BST(list,0,list.size() -1);
   System.out.println("The inOrder traversal's values of new formed BST are :- ");
   inOrder(node);
   System.out.println("\nThe value in resultant BST after merging 2 BSTs are :- ");
    preOrder(node);

 }   

 static void Inorder(Node root,ArrayList<Integer> l){
    if(root == null){
        return;
    }
    Inorder(root.left, l);
    l.add(root.data);
    Inorder(root.right, l);
 }
 
 static void preOrder(Node root){
    if(root == null){
        return;
    }
    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);
 }
 static void inOrder(Node root){
    if(root == null){
        return;
    }
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);
 }
}
