import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value=value;
        }

        @Override
        public String toString() {
            return "Node="+value;
        }
    }
    private Node root;

    public void insert(int value){
        var node=new Node(value);
        if(root==null){
            root=node;
            return;
        }
        var current=root;
        while(true){
            if(value< current.value){
                if(current.leftChild==null){
                    current.leftChild=node;
                    break;
                }
                else{
                    current=current.leftChild;
                }
            }
            else{
                if(current.rightChild==null){
                    current.rightChild=node;
                    break;
                }
                else{
                    current=current.rightChild;
                }
            }
        }
    }

    public boolean find(int value){
        var current =root;
        while(current!=null){
            if(value< current.value){
                current=current.leftChild;
            }
            else if(value>current.value){
                current=current.rightChild;
            }
            else{
                return true;
            }

        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root){
        if(root==null){
            return;
        }
        else{
            System.out.println(root.value);
            traversePreOrder(root.leftChild);
            traversePreOrder(root.rightChild);
        }

    }
    private void traverseInOrder(Node root){
        if(root==null){
            return;
        }
        else{
            traverseInOrder(root.leftChild);
            System.out.println(root.value);
            traverseInOrder(root.rightChild);
        }

    }
    private void traversePostOrder(Node root){
        if(root==null){
            return;
        }
        else{
            traversePostOrder(root.leftChild);
            traversePostOrder(root.rightChild);
            System.out.println(root.value);
        }

    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root,int min, int max){
        if (root==null){
            return true;
        }
        if(root.value<min || root.value>max){
            return false;
        }

         return isBinarySearchTree(root.leftChild,min, root.value-1) && isBinarySearchTree(root.rightChild, root.value+1,max);
    }

    public int height(){
       return height(root);
    }

    private int height(Node root){

        if(root==null){
            return -1;
        }
        if(isLeaf(root)){
            return 0;
        }
        return 1+Math.max(height(root.leftChild),height(root.rightChild));
    }

    private boolean isLeaf(Node node){
        return node.leftChild==null & node.rightChild==null;
    }

    public int min(){
        return min(root);
    }

    private int min(Node root){
        if(isLeaf(root)){
            return root.value;
        }
        var left=min(root.leftChild);
        var right=min(root.rightChild);

        return Math.min(Math.min(left,right),root.value);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list=new ArrayList<Integer>();
        getNodesAtDistance(root,distance,list);
        return list;

    }

    private void getNodesAtDistance(Node node,int distance,ArrayList<Integer> list){
        if(node==null){
            return;
        }
        if(distance==0){
            list.add(node.value);
        }

        getNodesAtDistance(node.leftChild,distance-1,list);
        getNodesAtDistance(node.rightChild,distance-1,list);
    }

   public void traverseLevelOrder(){
        for(var i=0;i<=height();i++){
            for(var value:getNodesAtDistance(i)){
                System.out.println(value);
            }
        }
    }


}
