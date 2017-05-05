import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FourWayHeap
{
    private ArrayList<PQNode> heap;

    public FourWayHeap()
    {
        // TODO Auto-generated constructor stub
        heap = new ArrayList<>();
    }

    public void buildFourWayHeap(ArrayList<PQNode> contents)
    {
      
        heap=new ArrayList<PQNode>();
        heap.add(null);
        heap.add(null);
        heap.add(null);
        for(int i=0;i<contents.size();i++){
            heap.add(contents.get(i));
        }
        

        for(int i = ((heap.size()/4)-1)+3;i>=3;i--)
        {   //System.out.println("i is "+i);
            heapify(i);

        }
    }

    private int parent(int i)
    {
        return ( ((i-4) / 4)+3 );
    }

    


    private int firstChild(int i)
    {
        return (4 * (i-3)) + 4;
    }

    public int size()
    {
        return heap.size();
    }



    public void heapify(int i)
    {
        int j;
        int first = firstChild(i);
        int second = first + 1;
        int third = second + 1;
        int fourth = third + 1;


        //Check for all 4
        if(first < heap.size() && (heap.get(first).val<=heap.get(i).val))
            j = first;
        else
            j=i;

        if(second < heap.size() && (heap.get(second).val<heap.get(j).val))
            j = second;
        if(third < heap.size() && (heap.get(third).val<heap.get(j).val))
            j = third;
        if(fourth < heap.size() && (heap.get(fourth).val<heap.get(j).val))
            j = fourth;

        if(i != j)
        {
            
            Collections.swap(heap, i, j);
            heapify(j);
        }

    }

    public void insert(PQNode t)
    {
        heap.add(t);
        int i = heap.size() - 1;
        int p = parent(i);
        while(i > 0 && (heap.get(i).val<heap.get(p).val)) {
            
            Collections.swap(heap,i,p);
            i = p;
            p = parent(i);
        }
    }

    public PQNode remove()
    {

        PQNode res=null;



            res=heap.get(3);
            heap.set(3,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            heapify(3);


        return res;
    }

    @Override
    public String toString()
    {
        return heap.toString();
    }

    public PQNode treeUsingFourHeap(HashMap<String,Integer> map){

        ArrayList<PQNode> ls=new ArrayList<PQNode>();
        PQNode left_child;
        PQNode right_child;
        PQNode result;
		
		for(String c: map.keySet())
        {
            if(c!=null) {
                ls.add(new PQNode(Integer.parseInt(c), map.get(c)));
            }
        }
        
        //Heap ready
        buildFourWayHeap(ls);

        while(heap.size() != 4)
        {
            left_child = remove();
            right_child =remove();
            result = new PQNode(left_child.val + right_child.val);
            result.left = left_child;
            result.right = right_child;
            insert(result);
        }
        return heap.get(3);
    }
}
