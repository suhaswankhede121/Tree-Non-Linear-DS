

class Node{
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val=val;
    }

}


public class DiameterBT {
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    

    static int diameter(Node root){
        if( root==null || (root.left==null && root.right==null)){
            return 0;
        }
        int leftNode=diameter(root.left);
        int rightNode=diameter(root.right);
        int mid=height(root.left)+height(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null) mid++;
        int maxDiameter=Math.max(leftNode, Math.max(rightNode, mid));
        return maxDiameter;
    }

    static void display(Node root) {
        if (root == null) return;
        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }
    public static void main(String[] args) {
        Node root=new Node(10);
        Node a=new Node(1);
        Node b=new Node(2);
        root.left=a;
        root.right=b;
        Node c=new Node(3);
        Node d=new Node(4);
        a.left=c;
        a.right=d;
        Node e=new Node(5);
        b.right=e;

        display(root);
     // System.out.println(diameter(root));
    }
}
