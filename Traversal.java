import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val=val;
    }

}

public class Traversal {

    //Stack - DFS
    static void preorder(Node root){
        if(root==null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
     static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
         System.out.println(root.val);
    }



   //BFS - Queue Traversal
   static void bfs(Node root){
    Queue<Node> q=new LinkedList<>();
    if(root!=null) q.add(root);
    while(q.size()>0){
        Node temp=q.peek();
        if(temp.left !=null) q.add(temp.left);
        if(temp.right !=null) q.add(temp.right);
        System.out.println(" "+temp.val);
        q.remove();
    }
    
   }

   //DFS - Stack Traversal InOrder VIMP
   static List<Integer> inorderTraversal(Node root){
    List<Integer> arr=new ArrayList<>();
    Stack<Node> s=new Stack<>();
    if(root==null) return arr;
    s.push(root);
    while(s.size()>0){
       Node temp=s.peek();
       if(temp.left !=null){
        s.push(temp.left);
        temp.left=null;
       }else{
        s.pop();
        arr.add(temp.val);
        if(temp.right !=null){
            s.push(temp.right);
        }
       }
    }
    return arr;
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
        //postorder(root);

        //bfs(root);
       // List<Integer> arr=new ArrayList<>();
        System.out.println(inorderTraversal(root));

    }
}
