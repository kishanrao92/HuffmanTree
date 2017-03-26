
public class Runner 
{
	public static void main(String args[])
	{
		FourWayHeap<Integer> heapOne = new FourWayHeap<Integer>();
		heapOne.insert(12);
		heapOne.insert(2);
		heapOne.insert(52);
		heapOne.insert(42);
		heapOne.insert(22);
		heapOne.insert(9);
		
		while(heapOne.size() > 0)
		{
			System.out.println(heapOne.remove());
		}
	}
}
