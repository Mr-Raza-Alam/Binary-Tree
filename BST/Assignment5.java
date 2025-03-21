public class Assignment5 {
// task :- to find max sum of BST avialble in a binary tree;

static class Node{
    int val;
    Node left,right;
    Node(int data){
        this.val = data; 
    }
 }
 static int i = -1;
 static Node insert(int values[]){
     i++;
    if(values[i] == -1) return null;
    Node newNode = new Node(values[i]);
     newNode.left = insert(values);
     newNode.right = insert(values);
    return newNode;
 }

 static class Info{
    Boolean isBST;
    int sum;
    int min;
    int max;
    Info(Boolean isBST,int sum,int min,int max){
        this.isBST = isBST;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
 }
    static int maxSum;
    static Info getMaxSum(Node root){
       if(root == null){
         return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE,0);
       }
     else if(root.left == null && root.right == null){// in case of leaf node
        maxSum = Math.max(maxSum, root.val);
        return new Info(true,root.val,root.val, root.val);
     }
     Info leftInfo = getMaxSum(root.left);
     Info rightInfo = getMaxSum(root.right);
      Info bst = new Info(null, 0,0,0);
     // check the validity of BST 
     if(leftInfo.isBST && rightInfo.isBST && root.val>=leftInfo.max && root.val <= rightInfo.min){
         // update the isBST, min,max ,and sum''s values
         bst.isBST = true;
         bst.min = Math.min(root.val,Math.min(leftInfo.min,rightInfo.min));
        bst.max = Math.max(root.val,Math.max(leftInfo.max,rightInfo.max));
        bst.sum = root.val+leftInfo.sum+rightInfo.sum;
        maxSum = Math.max(maxSum,root.val + leftInfo.sum + rightInfo.sum);
        return bst;
     }
     bst.isBST = false;
     bst.sum = root.val+leftInfo.sum+rightInfo.sum;
     
     return bst ;
    } 

    public static void main(String[] args) {
        int values[] = {7,2,1,-1,-1,7,-1,-1,6,4,2,-1,-1,-1,3,-1,-1};
        Node root = insert(values);
        getMaxSum(root);
        System.out.println("The max sum of nodes of BST in binary tree = "+maxSum);
    }
}
