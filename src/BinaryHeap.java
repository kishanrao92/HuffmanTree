/**
 * Created by Kishan_Rao on 3/25/17.
 */


import java.util.ArrayList;
import java.util.Collections;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T>{

    public ArrayList<T> heap;

    public BinaryHeap()
    {
        heap=new ArrayList<T>();
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

    public void insert(T node)
    {
        heap.add(node);
        int i=heap.size()-1;
        int p=parent(i);

        while(i>0 && heap.get(i).compareTo(heap.get(p))<0 )
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

        if(left<heap.size() && heap.get(left).compareTo(heap.get(i))<1){
            i=left;
        }

        if(right<heap.size() && heap.get(right).compareTo(heap.get(i))<1){
            i=right;
        }
        if(i!=position)
        {
            Collections.swap(heap,i,position);
            heapify(i);
        }
    }

    public T remove()
    {
        T res=null;
        if(heap.size()>0)
        {
            res=heap.remove(0);
            if(heap.size()>1)
            {
                heap.add(0,heap.remove(heap.size()-1));
                heapify(0);
            }
        }
        return res;

    }

}