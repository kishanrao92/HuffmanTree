import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class PairingHeap<T extends Comparable<T>> implements Heap<T> 
{

	public T root;
	public ArrayList<PairingHeap<T>> children;
	
	public PairingHeap() 
	{
		root = null;
		children = new ArrayList<>();
	}
	
	public PairingHeap(T t)
	{
		root = t;
		children = new ArrayList<>();
	}
	
	@Override
	public void insert(T t) 
	{
		// TODO Auto-generated method stub
		if(root == null)
			root = t;
		else
		{
			//First create a new node.
			PairingHeap<T> newNode = new PairingHeap<T>(t);
			//See if the new node is bigger or smaller
			if(newNode.root.compareTo(root) > 0)
				//Add as a child
				children.add(newNode);
			else
			{
				//Make new node this root, and add old tree as only child.
				newNode.root = root;
				newNode.children = children;
				root = t;
				children = new ArrayList<>();
				children.add(newNode);
			}
		}
	}

	private PairingHeap<T> meld(PairingHeap<T> t1, PairingHeap<T> t2)
	{
		//System.out.println("Melding " + t1.root + " and " + t2.root);
		
		if(t1.root.compareTo(t2.root) < 0)	//t1 is smaller
		{
			t1.children.add(t2);
			return t1;
		}
		else
		{
			t2.children.add(t1);
			return t2;
		}
	}
	
	@Override
	public T remove() 
	{
		T min = root;
		//Radical stuff now :P
		if(children.isEmpty())
		{
			root = null;
			return min;
		}
		ArrayList<PairingHeap<T>> toMeld = children;
		while(toMeld.size() > 1)
		{
			ArrayList<PairingHeap<T>> meldPass = new ArrayList<>((int) Math.ceil(toMeld.size()/2));
			int cnt = (int) Math.ceil((float)toMeld.size()/2);
			if(toMeld.size()%2 == 1)
				cnt--;
			for(int i=0; i<cnt; i++)
			{
				meldPass.add(meld(toMeld.get(i*2), toMeld.get((2*i) + 1)));
			}
			if(toMeld.size()%2 == 1)
				meldPass.add(toMeld.get(toMeld.size()-1));
			
			toMeld = meldPass;
		}
		root = toMeld.get(0).root;
		children = toMeld.get(0).children;
		
		//System.out.println("New root: " + root);
		
		return min;
	}

	@Override
	public int size() 
	{
		if(root == null) return 0;
		
		int size = 1;	//For the root.
		if(children.size() == 0) return size;
		
		for(PairingHeap<T> child : children)
		{
			size += child.size();
		}
		return size;
	}

}
