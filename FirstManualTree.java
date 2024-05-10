

//1.. Create a node

class Node{
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val=val;
    }

}

class FirstManualTree{

    // Display Level wise
     static void display(Node root){
      if(root==null)  return;

      System.out.print(root.val+ " ....>");
      if(root.left!=null) System.out.print(root.left.val+" ,");
       if(root.right!=null)System.out.println(root.right.val+" ");
       System.out.println();
      display(root.left);
      display(root.right);
    }   

    static int size(Node root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }

    static int sum(Node root){
         if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }

    static int height(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
    static int max(Node root){
        if(root==null) return Integer.MIN_VALUE;
        int a=root.val;
        int b=max(root.left);
        int c=max(root.right);
        return Math.max(a, Math.max(b, c));

    }

    static int mini(Node root){
        if(root==null) return Integer.MAX_VALUE;
        int a=root.val;
        int b=mini(root.left);
        int c=mini(root.right);
        return Math.min(a, Math.min(b, c));
    }

    static int product(Node root){
        if(root==null) return 1;
        return root.val*product(root.left)*product(root.right);
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
        //display(root);
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
        System.out.println(mini(root));
        System.out.println(product(root));

    }
}