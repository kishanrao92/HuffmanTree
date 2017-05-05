import java.util.ArrayList;
import java.util.HashMap;


public class PairingHeap
{

    public PHNode root;
    public ArrayList<PHNode> children;

    public PairingHeap()
    {
        root = null;
        children = new ArrayList<>();
    }


    public boolean isEmpty(){
        return root==null;
    }

    public void makeEmpty(){
        root=null;
    }


    public PHNode insert(int x)
    {
        PHNode temp = new PHNode( x );
        if (root == null)
            root = temp;
        else
            root = pairCompare(root, temp);
        return temp;
    }




    public PHNode pairCompare(PHNode one,PHNode two){
        if(two==null){
            return one;
        }

        if(two.val<one.val){
            two.prev=one.prev;
            one.prev=two;
            one.rightSibling=two.leftChild;
            if(one.rightSibling!=null){
                one.rightSibling.prev=one;

            }
            two.leftChild=one;
            return two;
        }

        else{
            two.prev=one;
            one.rightSibling=two.rightSibling;
            if(one.rightSibling!=null){
                one.rightSibling.prev=one;
            }
            two.rightSibling=one.leftChild;
            if(two.rightSibling!=null){
                two.rightSibling.prev=two;
            }
            one.leftChild=two;
            return one;
        }

    }



    private PHNode pairCombine(PHNode nextSibling)
    {
        if( nextSibling.rightSibling == null )
            return nextSibling;
        /* Store the subtrees in an array */
        int siblingCount = 0;
        for ( ; nextSibling != null; siblingCount++)
        {
            children.add(siblingCount,nextSibling);
            /* break links */
            nextSibling.prev.rightSibling = null;
            nextSibling = nextSibling.rightSibling;
        }
        children.set(siblingCount,null);
        /* Combine subtrees two at a time, going left to right */
        int i = 0;
        for ( ; i + 1 < siblingCount; i += 2)
            children.set(i,pairCompare(children.get(i),children.get(i+1)));
        int j = i - 2;
        /* j has the result of last compareAndLink */
        /* If an odd number of trees, get the last one */
        if (j == siblingCount - 3)
            children.set(j,pairCompare(children.get(j),children.get(j+1)));

        /* Now go right to left, merging last tree with */
        /* next to last. The result becomes the new last */
        for ( ; j >= 2; j -= 2)
            children.set(j-2,pairCompare(children.get(j-2),children.get(j)));
        return children.get(0);
    }


    public int remove( )
    {
        if (isEmpty( ) )
            return -1;
        int x = root.val;
        if (root.leftChild == null)
            root = null;
        else
            root = pairCombine( root.leftChild );
        return x;
    }

    public void treeUsingPairingHeap(HashMap<String,Integer> map){

        PHNode left_child=null;
        PHNode right_child=null;
        PHNode result=null;
        boolean check=true;


        for(String c: map.keySet())
        {
            if(c!=null)


                if(check){
                    root=new PHNode(map.get(c));
                    check=false;

                }
                else{
                    PHNode node=new PHNode(map.get(c));
                    insert(node.val);

                }
        }

        while(children.size() > 1)
        {
            left_child.val = remove();
            right_child.val = remove();
            result=new PHNode(left_child.val+right_child.val);
            insert(result.val);
            
        }
       
    }




 



}
