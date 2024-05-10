import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
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
        System.out.println(haspaths(root, 17));
    }

    static void helper(List<List<Integer>> ans,List<Integer> arr,Node root,int targetsum){
        if(root==null) return;
        if(root.left==null && root.right==null){
            arr.add(root.val);
            if(root.val==targetsum){
              List<Integer> a=new ArrayList<>();
            for(int i=0;i<a.size();i++){
                a.add(arr.get(i));
             }
               ans.add(a);
            }
            ans.remove(arr.size()-1);
            arr.remove(root.val);
            helper(ans, arr, root.left, targetsum-root.val);
            helper(ans, arr, root.right, targetsum-root.val);
        }
       
    }

    static List<List<Integer>> haspaths(Node root,int targetsum){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        helper(ans, arr, root, targetsum);
        return ans;
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