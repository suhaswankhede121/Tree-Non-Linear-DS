import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
    }
 }

// to craete a constructBFS 
class ConstructBFs{
static Node cbfs(String []arr){
 int x=Integer.parseInt(arr[0]);
 Node root = new Node(x);
 Queue<Node> q=new LinkedList<>();
 q.add(root);
 int n=arr.length;
 int i=1;
 while(i<n-1){
    Node temp=q.remove();
    Node left=new Node(0);
    Node right=new Node(0);
    if(arr[i].equals("")){
    left=null;  // because we checked for null value soi need to provide here null value
    }else{
    int l=Integer.parseInt(arr[i]);
    left.val=l;
    q.add(left);
    }
    if(arr[i+1].equals("")){
    right=null;  // because we checked for null value soi need to provide here null value
    }else{
          int r=Integer.parseInt(arr[i+1]);
    right.val=r;
    q.add(right);
    }
temp.left=left;
temp.right=right;
 }
 return root;
}


    static int height(Node root){
        if(root==null) return 0;
        if(root.left !=null && root.right !=null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }


    static void  nthlevel(Node root,int n){
      if(root==null) return;
     if(n==1){
        System.out.println(root.val+" "); return;
     }
       nthlevel(root.left, n-1);
       nthlevel(root.right, n-1);
       
    }



public static void main(String[] args) {
    String []arr={"1","2","3","","","5","","8","9","10","","72"};
   Node root=cbfs(arr);
    int level=height(root)+1;
    for(int i=1;i<=level;i++){
     nthlevel(root, i);
    }
}

}

