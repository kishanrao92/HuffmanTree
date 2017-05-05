import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kishan_Rao on 3/31/17.
 */
public class PQNode {
    PQNode left=null;
    PQNode right=null;
    int key;
    int val;

    //public void PQNode(){}

     PQNode(int key,int val){
        this.key=key;
        this.val=val;
    }

    PQNode(int val){
        this.val=val;
        this.key=-1;
    }



}
