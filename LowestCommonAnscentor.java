class Node{
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val=val;
    }

}

class LowestCommonAnscentor{
 
    static boolean contains(Node root,Node node){
        if(root==null) return false;
        if(root==node) return false;
        return (contains(root.left,node)||contains(root.right,node));
    }

    static Node LAC(Node root, Node p,Node q){
        if(p==root || q==root) return root;
        if(p==q) return p;
        boolean lp=contains(root.left, q);
        boolean rp=contains(root.right, p);
        if((lp && rp || !lp && !rp)) return root;
        if(lp && !rp) return LAC(root.left,p,q);
        if(!lp && rp) return LAC(root.right,p,q);
        return null;
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
        System.out.println(LAC(root,a,b));
    }
}



