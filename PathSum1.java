public class PathSum1 {
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
        System.out.println(hasPath(root, 7));
    }

    static boolean hasPath(Node root, int targetsum){
        if(root==null) return false;
        if(root !=null && root.left ==null && root.right==null){
            if(root.val==targetsum){
                return true;
            }
        }
        return hasPath(root.left, targetsum-root.val) || hasPath(root.right, targetsum-root.val);
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

