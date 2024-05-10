public class BalanaceBT {
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
        Node f=new Node(7);
        e.right=f;
        System.out.println(isBalance(root));
    }

    static int height(Node root){
        if( root==null || (root.left==null && root.right==null)){
            return 0;
        }
       return 1+Math.max(height(root.left), height(root.right));
    }

    static boolean isBalance(Node root){
        if(root==null) return true;
        int lh=height(root.left);
        if(root.left !=null) lh++;
        int rh=height(root.right);
        if(root.right !=null) rh++;
        int diff=lh-rh;
        if(diff<0) diff=-diff;
        if(diff>1) return false;
        return (isBalance(root.left) && isBalance(root.right));

    }
}
class Node{
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val=val;
    }

}