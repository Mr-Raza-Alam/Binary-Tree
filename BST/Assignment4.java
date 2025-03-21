import java.util.ArrayList;
import java.util.Scanner;
public class Assignment4 {
// task :- to find list of pair of nodes whose sum = given target value k in BST
static class Node{
    int data;
    Node left,right;
    Node(int val){
        this.data =val;
    }
}
static Node insert(Node root,int val){
 if(root == null) return new Node(val);
 else if(root.data>val) root.left = insert(root.left, val);
 else root.right = insert(root.right, val);
 return root;
}    

static void inorder(Node root,ArrayList<Integer> list){
 if(root == null) return;
 // call for left-subtree
 inorder(root.left, list);
 // work on data
 list.add(root.data);
 // call for right-subtree
 inorder(root.right, list);
}

static void preOrder(Node root){
    if(root == null) return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}

public static void main(String[] args) {
 Node root = null;
 int values[] = {5,8,3,1,7,4,6,9};
 // build a BST
 for(int i: values){
    root = insert(root, i);
 }
 ArrayList<Integer> list = new ArrayList<>();// SC = O(n)
 Scanner sc = new Scanner(System.in);
 inorder(root, list);
 System.out.println("The values in BST through PreOrder traversal are :- ");
 preOrder(root); //O(n)
 System.out.print("\nEnter the target value = ");
 int k = sc.nextInt();
 System.out.print("\nThe pair of 2-nodes of BST,whose sum = "+k+" are :-\n (");
 getSumOF2Nodes(list,k);//O(n)

}

static void getSumOF2Nodes(ArrayList<Integer> list,int k){
  // using 2-pointer approach
  int st = 0,end = list.size()-1;
  while (st < end){
    int sum = list.get(st) + list.get(end);
    if(sum == k){
      System.out.print(list.get(st)+","+list.get(end)+"), (");
      st++;
      end--;
    } else if(sum < k) {
        list.remove(st);
         end -=1;
    }
    else{
      list.remove(end);
        end -=1;
    } 
     //st++;
    // end--;
  }

}
}
