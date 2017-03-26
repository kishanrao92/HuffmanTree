import java.util.ArrayList;
import java.util.Collection;

public class FourWayHeap<T extends Comparable<T>>
{
	private ArrayList<T> heap;
	
	public FourWayHeap() 
	{
		// TODO Auto-generated constructor stub
		heap = new ArrayList<>();
	}
	
	protected FourWayHeap(int sign, Collection<T> contents) 
	{
		heap = new ArrayList<T>(contents);
		for(int i = 1 + heap.size() / 2; i >= 0; i--) 
		{
			heapify(i);
		}
	}
	
	private final int parent(int i)
	{
		return (int) Math.ceil( (i-1) / 4 );
	}
	
	//Return null in List if children are absent.
	private final ArrayList<T> children(int i)
	{
		ArrayList<T> child = new ArrayList<T>(4);
		try
		{
			child.add(heap.get( (4 * (i-1)) + 2 ));
			child.add(heap.get( (4 * (i-1)) + 3 ));
			child.add(heap.get( (4 * (i-1)) + 4 ));
			child.add(heap.get( (4 * (i-1)) + 5 ));
		}
		catch (Exception e) 
		{
			//child = null;
		}
		
		return child;
	}
	
	private final int firstChild(int i)
	{
		return (4 * (i)) + 2;
	}

	public int size() 
	{
		return heap.size();
	}
	

	private void swap(int i, int j) 
	{
		T temp = heap.get(j);
		heap.set(j, heap.get(i));
		heap.set(i, temp);
	}

	private void heapify(int i)
	{
		int j=1;
		int first = firstChild(i);
		int second = first + 1;
		int third = second + 1;
		int fourth = third + 1;
		
		//Check for all 4
		if(first < heap.size() && (heap.get(first).compareTo(heap.get(i)) < 1))
			j = first;
		if(second < heap.size() && (heap.get(second).compareTo(heap.get(i)) < 1))
			j = second;
		if(third < heap.size() && (heap.get(third).compareTo(heap.get(i)) < 1))
			j = third;
		if(fourth < heap.size() && (heap.get(fourth).compareTo(heap.get(i)) < 1))
			j = fourth;
		
		if(i != j)
		{
			swap(i,j);
			heapify(j);
		}
		
	}
	
	public void insert(T t)
	{
		heap.add(t);
		int i = heap.size() - 1;
		int p = parent(i);
		while(i > 0 && (heap.get(i).compareTo(heap.get(p)) < 0)) {
			swap(i, p);
			i = p;
			p = parent(i);
		}
	}
	
	public T remove()
	{
		T ans = null;
		if(heap.size() > 0)
		{
			ans = heap.remove(0);
			if(heap.size() > 1) 
			{
				heap.add(0, heap.remove(heap.size() -1));
				heapify(0);
			}
		}
		return ans;
	}
	
	@Override
	public String toString() 
	{
		return heap.toString();
	}
}
