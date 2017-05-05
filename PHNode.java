/**
 * Created by Kishan_Rao on 4/3/17.
 */
public class PHNode {
    PHNode leftChild;
    PHNode rightSibling;
    PHNode prev;
    int val;

   public PHNode(){}

    public PHNode(int val){
       this.val=val;
       leftChild=null;
       rightSibling=null;
       prev=null;
   }
}
