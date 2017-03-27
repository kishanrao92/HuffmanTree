
public class Runner 
{
	public static void main(String args[])
	{
		Heap<Integer> heapOne = new PairingHeap<Integer>();
		heapOne.insert(12);
		//System.out.println("12\t" + heapOne.size());
		heapOne.insert(2);
		//System.out.println("2\t" + heapOne.size());
		heapOne.insert(52);
		//System.out.println("52\t" + heapOne.size());
		heapOne.insert(42);
		//System.out.println("42\t" + heapOne.size());
		heapOne.insert(22);
		//System.out.println("22\t" + heapOne.size());
		heapOne.insert(9);
		//System.out.println("9\t" + heapOne.size());
		
		while(heapOne.size() > 0)
		{
			System.out.println(heapOne.remove());
		}
	}
}
