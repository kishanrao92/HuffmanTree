/**
 * Created by Kishan_Rao on 3/25/17.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//public class BinaryHeap<T extends Comparable<T>> implements Heap<T>{
public class BinaryHeap{

    public ArrayList<PQNode> heap;

    public BinaryHeap()
    {
        heap=new ArrayList<PQNode>();
    }

    public int leftChild(int position)
    {
        return (2*position + 1);
    }

    public int rightChild(int position)
    {
        return (2*position + 2);
    }

    public int parent(int position){
        return (position-1)/2;
    }

    public int size(){
        return heap.size();
    }

    public void builBinaryHeap( ArrayList<PQNode> contents) {

        heap = new ArrayList<PQNode>(contents);
        for(int i = (heap.size() / 2)-1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(PQNode node)
    {
        heap.add(node);
        int i=heap.size()-1;
        int p=parent(i);

        while(i>0 && heap.get(i).val<heap.get(p).val )
        {
            Collections.swap(heap,i,p);
            i=p;
            p=parent(i);

        }

    }

    public void heapify(int position)
    {
        int i=position;
        int left=leftChild(i);
        int right=rightChild(i);

        if(left<heap.size() && heap.get(left).val<=heap.get(i).val){
            i=left;
        }

        if(right<heap.size() && heap.get(right).val<heap.get(i).val){
            i=right;
        }
        if(i!=position)
        {
            Collections.swap(heap,i,position);
            heapify(i);
        }
    }

    public PQNode bremove()
    {
        PQNode res=null;


            if(heap.size()>0)
            {
                res=heap.get(0);
                heap.set(0,heap.get(heap.size()-1));
                heap.remove(heap.size()-1);
                heapify(0);
            }

        return res;

    }

    public PQNode treeUsingBinaryHeap(HashMap<String,Integer> map){
        //ArrayList<PQNode> ls=new ArrayList<PQNode>();

        PQNode left_child;
        PQNode right_child;
        PQNode result;


        //Heap<HuffmanNode> heap = new BinaryHeap<HuffmanNode>();

        for(String c: map.keySet())
        {
            if(c!=null)
                //heap.insert(new HuffmanNode( new HuffmanTree(c, map.get(c)) ));
                heap.add(new PQNode(Integer.parseInt(c),map.get(c)));
        }
        //Heap ready
        builBinaryHeap(heap);//BinaryHeap(ls);

        while(heap.size() > 1)
        {
            //HuffmanNode aNode = heap.remove();
            //left_child=remove();
            left_child = bremove();
            right_child =bremove();
            result = new PQNode(left_child.val + right_child.val);
            result.left = left_child;
            result.right = right_child;
            //heap.add(new (result));
            insert(result);
        }
        return heap.get(0);
    }

}