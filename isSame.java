public class isSame {
    public static void main(String[] args) {
       Node n1=new Node(1);
       Node a=new Node(2);
       Node b=new Node(3);
       n1.left=a;
       n1.right=b;
       Node n2=new Node(1);
       Node a1=new Node(2);
       Node b1=new Node(3);
       n2.left=a1;
       n2.right=b1;
        System.out.println(sameBT(n1, n2));
    }
    static boolean sameBT(Node n1,Node n2){
      if(n1==null && n2==null) return true;
      if(n1==null || n2==null) return false;
      if(n1.val != n2.val) return false;
      return (sameBT(n1.left, n2.left)&& sameBT(n1.right, n2.right));
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
