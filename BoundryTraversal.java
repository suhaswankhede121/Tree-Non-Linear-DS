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

public class BoundryTraversal {
    public static void main(String[] args) {
        String [] arr={"1","2","3","4","5","","6","7","","8","","9","10",
                        "","11","12","","13","","14","15","16","","17","","","18","","19","","","","20",
                          "21","22","23","","24","25","26","27","","","28","",""};
        Node root=cbfs(arr);
        displayBoundry(root);
    }

    static Node cbfs(String[] arr) {
        if (arr == null || arr.length == 0 || arr[0].equals("")) {
            return null;
        }
    
        int x = Integer.parseInt(arr[0]);
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
    
        int n = arr.length;
        int i = 1; // Start from index 1, as index 0 is already processed for the root
    
        while (i < n) {
            Node temp = q.poll(); // Use poll() instead of remove() to handle empty queues
            if (!arr[i].equals("")) {
                int l = Integer.parseInt(arr[i]);
                Node left = new Node(l);
                temp.left = left;
                q.add(left);
            }
            i++; // Increment i after processing the left child
    
            if (i < n && !arr[i].equals("")) {
                int r = Integer.parseInt(arr[i]);
                Node right = new Node(r);
                temp.right = right;
                q.add(right);
            }
            i++; // Increment i after processing the right child
        }
    
        return root;
    }
    
static void displayBoundry(Node root){
    LeftBoundry(root);
    System.out.println();
    RightBoundry(root);
    System.out.println();
    BottomBoundry(root);
}
static void LeftBoundry(Node root){
    if(root==null) return;
    if(root.left==null && root.right==null) return;
    System.out.print(root.val+" ");
    if(root.left !=null) LeftBoundry(root.left);
    else LeftBoundry(root.right);
}
static void RightBoundry(Node root){
    if(root==null) return;
    if(root.left==null && root.right==null) return;
    if(root.right !=null) RightBoundry(root.right);
    else RightBoundry(root.left);
     System.out.print(root.val+" ");
    
}
static void BottomBoundry(Node root){
    if(root==null) return;
    if(root.left ==null && root.right==null){
        System.out.print(root.val+" ");
        return;
    }
    BottomBoundry(root.left);
    BottomBoundry(root.right);
}
}
