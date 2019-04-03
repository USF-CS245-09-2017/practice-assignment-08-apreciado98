public class BST<String>{
    private class BSTNode{
        private Comparable data;
        private BSTNode left;
        private BSTNode right;

        BSTNode(Comparable newdata){
            data=newdata;
        }
    }
    private BSTNode root;

    public boolean find(Comparable value){
        return find(root, value);
    }

    private boolean find(BSTNode node, Comparable value){
        if(node==null){ //base case if node not in tree
            return false;
        }
        else if(value.compareTo(node.data)==0){ //are equal
            return true;
        }
        else if(value.compareTo(node.data)>0){ //value greater than data
            return find(node.right, value); //recursive call of find from right
        }
        else{
            return find(node.left, value); //recursive call of find from left
        }
    }

    public void insert(Comparable value){
        root=insert(root, value);
    }

    private BSTNode insert(BSTNode node, Comparable value){
        if(node==null){ //base case
            BSTNode n=new BSTNode(value); //create new node
            return n;
        }
        else if(value.compareTo(node.data)>0){ //value greater than data
            node.right=insert(node.right, value); //go right
            return node;
        }
        else{
            node.left=insert(node.left, value); //go left
            return node;
        }
    }

    public void print(){
        print(root);
    }

    private void print(BSTNode node){
        if(node!=null){ //this is the base case
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    public void delete(Comparable value){
        root=delete(root, value);
    }

    private BSTNode delete(BSTNode node, Comparable value){
        if(node==null){ //if empty
            return null;
        }
        else if(node.data.compareTo(value)==0){ //are equal
            if(node.left==null){ //if no left element
                return node.right;
            }
            else if(node.right==null){ //if no right element
                return node.left;
            }
            else{
                if(node.right.left==null){ //no left of right element
                    node.data=node.right.data;
                    node.right=node.right.right;
                    return node;
                }
                else{
                    node.data=removeSmallest(node.right);
                    return node;
                }//else
            }//else
        }//if
        else if(node.data.compareTo(value)<0){ //data less than value
            node.left=delete(node.left, value);
            return node;
        }
        else{
            node.right=delete(node.right, value);
            return node;
        }
    }

    Comparable removeSmallest(BSTNode node){
        if(node.left.left==null){
            Comparable smallest=node.left.data;
            node.left=node.left.right;
            return smallest;
        }
        else{
            node.data=removeSmallest(node.right);
            return removeSmallest(node.left);
        }

    }
}