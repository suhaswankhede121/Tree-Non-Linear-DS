import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val=val;
    }
}

class RightSideViewTraversal{

    static void PreOrder(Node root,List<Integer> ans,int level){
        if(root==null) return;
        ans.set(level-1, root.val);
        PreOrder(root.left,ans,level+1);
        PreOrder(root.right, ans, level+1);

    }

    static int height(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    static List<Integer> rightsideview(Node root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        int level=height(root)+1;
        for(int i=0;i<level;i++){
            ans.add(10);
        }
        PreOrder(root,ans,1);
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> ans=new ArrayList<>();
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
        ans=rightsideview(root);
        System.out.println(ans);
    }
}