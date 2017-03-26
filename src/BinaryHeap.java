import java.util.ArrayList;
import java.util.Collection;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T>
{

  private ArrayList<T> theHeap;

	private final int sign;

	protected final int left(int i) { return (i << 1) + 1; }
	protected final int right(int i) { return (i << 1) + 2; }
	protected final int parent(int i) { return ((i - 1) >> 1); }

	private void heapify(int i) 
	{
		int j = i;
		int l = left(i);
		int r = right(i);
		if(l < theHeap.size() && (sign == theHeap.get(l).compareTo(theHeap.get(j))))
			j = l;
		if(r < theHeap.size() && (sign == theHeap.get(r).compareTo(theHeap.get(j))))
			j = r;
		if(j != i) {
			swap(i, j);
			heapify(j);
		}
	}

	protected BinaryHeap(int sign)
	{
		this.sign = sign;
		theHeap = new ArrayList<T>();
	}

	protected BinaryHeap(int sign, Collection<T> contents) 
	{
		this.sign = sign;
		theHeap = new ArrayList<T>(contents);
		for(int i = 1 + theHeap.size() / 2; i >= 0; i--) 
		{
			heapify(i);
		}
	}

	public int size() 
	{
		return theHeap.size();
	}

	private void swap(int i, int j) 
	{
		T temp = theHeap.get(j);
		theHeap.set(j, theHeap.get(i));
		theHeap.set(i, temp);
	}

	public void insert(T t) 
	{
		theHeap.add(t);
		int i = theHeap.size() - 1;
		int p = parent(i);
		while(i > 0 && (sign == theHeap.get(i).compareTo(theHeap.get(p)))) {
			swap(i, p);
			i = p;
			p = parent(i);
		}
	}

	public T remove() 
	{
		T result = null;
		if(theHeap.size() > 0) {
			result = theHeap.remove(0);
			if(theHeap.size() > 1) {
				theHeap.add(0, theHeap.remove(theHeap.size() -1));
				heapify(0);
			}
		}
		return result;
	}

	@Override
	public String toString() 
	{
		return theHeap.toString();
	}
}