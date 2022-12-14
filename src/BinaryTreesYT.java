import java.util.*;

public class BinaryTreesYT {
    static class Node{
        int val ;
        Node left ;
        Node right ;

        Node(int val){
            this.val = val ;
            this.left = null ;
            this.right = null ;
        }
    }

static class BinaryTree {
        static int idx = -1 ;
        public static Node buildTree (int nodes[]){
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
            Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes) ;
        newNode.right = buildTree(nodes);

        return newNode ;

        }
}
//---------------------------------------------------------------------------------------

//preorder traversal
public static void preorder(Node root){
        if(root == null)
            return ;
    System.out.println(root.val);
    preorder(root.left);
    preorder(root.right);
}
//---------------------------------------------------------------------------------------

//Inorder traversal
    public static void inorder (Node root){
        if (root == null)
            return ;

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
//-----------------------------------------------------------------------------------------

// postorder traversal
    public static void postorder(Node root){
        if (root == null)
            return ;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

//---------------------------------------------------------------------------------------
  //level order traversal (breadth-first-search BFS)

    public static void levelOrder(Node root)
    {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            System.out.print(curr.val+" ");
        }
    }

//---------------------------------------------------------------------------------------

 //Size/count of Binary tree
    public static int getSize(Node root)
    {
        if(root == null) return 0;

        int leftSize = getSize(root.left);
        int rightSize = getSize(root.right);
        return leftSize + rightSize + 1;
    }

//---------------------------------------------------------------------------------------

    //Sum of Binary tree
    public static int sumBT(Node root)
    {
        if(root == null) return 0;

        int leftSum = sumBT(root.left);
        int rightSum = sumBT(root.right);

        return leftSum + rightSum + root.val;
    }
//---------------------------------------------------------------------------------------

    //Maximum node(number)  in the tree
    public static int findMax(Node root)
    {
        if(root == null) return Integer.MIN_VALUE;

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

//---------------------------------------------------------------------------------------

    //Minimum node(number) in the tree
    public static int findMin(Node root)
    {
        if(root == null) return Integer.MAX_VALUE;

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }
//---------------------------------------------------------------------------------------------

    //Height of the binary tree
    static int nodeCount = 0;
   public static int height(Node root)
    {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        nodeCount = Math.max(nodeCount,lh+ rh+ 1);
        return Math.max(lh, rh) + 1;
    }
//---------------------------------------------------------------------------------------------
  // Diameter of binary tree with O(n^2) TC
    public static int diameter(Node root) {

    nodeCount = Integer.MIN_VALUE;
    height(root);
    return nodeCount;

}
//---------------------------------------------------------------------------------------------
    // Diameter of binary tree with O(n) TC (optimal)

    static class TreeInfo{
       int ht ;
       int diam ;

       TreeInfo(int ht , int diam){
           this.ht = ht ;
           this.diam = diam ;
       }
    }
    public static TreeInfo diameter2(Node root){

       if(root == null){
           return new TreeInfo(0,0);
       }
       TreeInfo left = diameter2((root.left));
       TreeInfo right = diameter2((root.right));

       int myHeight = Math.max(left.ht , right.ht)+1;

       int diam1 = left.diam;
       int diam2 = right.diam;
       int diam3 = left.ht + right.ht + 1 ;

       int mydiam = Math.max(Math.max(diam1,diam2),diam3) ;

       TreeInfo myInfo = new TreeInfo(myHeight,mydiam);
       return myInfo ;
    }
//---------------------------------------------------------------------------------------------
    //sum of leaf nodes
    public static int sumOfLeafNodes (Node root){
       if(root == null)
           return 0 ;
       if(root.left==null || root.right==null)
           return root.val ;

       int s1 = sumOfLeafNodes(root.left);
       int s2 = sumOfLeafNodes(root.right) ;
       return (s1+s2) ;

    }
//---------------------------------------------------------------------------------------------

    public static void main(String[] args) {
    int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1} ;
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
       // System.out.println(root.val);

        // preorder(root);
        // inorder(root);
        // postorder(root);
       // levelOrder(root);  // BFS side by side

       // System.out.println(getSize(root));    Answer = 6
        // System.out.println(sumBT(root));     Answer = 21
       // System.out.println(findMax(root));    Answer = 6
       // System.out.println(findMin(root));    Answer = 1
       // System.out.println(height(root));       Answer = 3
       // System.out.println(diameter(root));     Answer = 5 ( TC : O(n^2) )
      //  System.out.println(diameter2(root).diam);  Answer = 5 ( TC : O(n) )
      //  System.out.println(sumOfLeafNodes(root));   Answer = 12   
    }
}
//Kadanes alo
class Main {
    public static int maximumSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i <= n - 1; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
