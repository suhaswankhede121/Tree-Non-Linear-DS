import java.util.ArrayList;
import java.util.List;



class Node{
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val=val;
    }

}

public class BinaryTreePath {

    static void helper(Node root,List<String> ans,String s){
        if(root==null) return;
        if(root.left==null && root.right==null){
            s+=root.val;
            ans.add(s);
            return;
        }
        helper(root.left, ans, s+root.val+"..>");
        helper(root.right, ans, s+root.val+"..>");
    }
    static List<String> paths(Node root){
        List<String> ans=new ArrayList<>();
        helper(root, ans, "");
        return ans;
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
        System.out.println(paths(root));
    }
}
