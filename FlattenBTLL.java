public class FlattenBTLL {
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
        flatten(root);
        display(root);
    }

    static void display(Node root){
        if(root==null)  return;
  
        System.out.print(root.val+ " ....>");
        if(root.left!=null) System.out.print(root.left.val+" ,");
         if(root.right!=null)System.out.println(root.right.val+" ");
         System.out.println();
        display(root.left);
        display(root.right);
      }   
    static void flatten(Node root){
     Node curr=root;
     Node pre=null;
    while(curr !=null){
    if(curr.left!=null)
        pre= curr.left;
      while(pre.right !=null){
        pre=pre.right;
      }
      pre.right=curr.right;
      curr.right=curr.left;
      curr.left=null;
    }
    curr=curr.right;
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