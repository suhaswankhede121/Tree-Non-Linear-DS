class ConstructInorderPreorder{
    public static void main(String[] args) {
        int []pre={1,2,4,5,3,6};
        int []ino={2,4,5,1,3,6};
        Node root=buidTree(pre, ino);
        display(root);
    }

    static Node helper(int []preorder,int prelo,int prehi,int[]inorder,int inlo,int inhi){
        if(prelo>inhi) return null;
        Node root=new Node(preorder[prelo]);
        int i=inlo;
        while(inorder[i] != preorder[prelo]) {
          i++;
        }
        int leftsize=i-inlo;
        root.left=helper(preorder, prelo+1, prelo+leftsize, inorder, inlo,i-1);
        root.right=helper(preorder, prelo+leftsize+1, prehi, inorder, i+1, inhi);
        return root;
    }

    static Node buidTree(int[]preorder,int []inorder){
        int n=preorder.length;
        return helper(preorder, 0, n-1, inorder, 0, n-1);
    }

    static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+"...>");
        if(root.left!=null) System.out.print(root.left.val+" ");
        if(root.right !=null) System.out.print(root.right.val+" ");
        System.out.println();
        display(root.left);
        display(root.right);
    }
}

class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val=val;
    }
}