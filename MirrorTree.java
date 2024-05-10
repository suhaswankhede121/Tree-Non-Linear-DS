public class MirrorTree {
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
        Node temp=invertTree(root);
        display(temp);
    }
    static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+"-->");
        if(root.left !=null) System.out.print(root.left.val+" ");
        if(root.right!=null) System.out.print(root.right.val+" ");
        System.out.println();
        display(root.left);
        display(root.right);
    }
  static  Node invertTree(Node root){
        if(root==null) return root;
        Node l=root.left;
        Node r=root.right;
        root.left=invertTree(r);
        root.right=invertTree(l);
        return root;
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