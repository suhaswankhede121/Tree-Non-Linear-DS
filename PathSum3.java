public class PathSum3 {
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
        System.out.println(pathsum(root,7));
    }

    static int noofpaths(Node root,long targetsum){
        if(root==null) return 0;
        int count=0;
        if((long) root.val==targetsum) count++;
        return count+noofpaths(root.left, targetsum-(long)root.val)+noofpaths(root.right, targetsum-(long)root.val);

    }
    static int pathsum(Node root,long targetsum){
    if(root==null )return 0;
    int count=noofpaths(root, (long)targetsum);
    count+=pathsum(root.left, targetsum)+pathsum(root.right, targetsum);
    return count;
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