import java.util.LinkedList;
import java.util.Queue;

public class HuffmanTree 
{
	
	public String key;
	public int frequency;
	
	public HuffmanTree left;
	public HuffmanTree right;
	
	public HuffmanTree(String mKey, int mFrequency)
	{
		key = mKey;
		frequency = mFrequency;
	}

	public boolean isLeaf()
	{
		return (left==null && right == null);
	}
	
	//helper
	public void bermudezPrint()
	{
		Queue<HuffmanTree> q = new LinkedList<HuffmanTree>();
		q.add(this);

		while(!q.isEmpty()){
			HuffmanTree temp = q.poll();
			System.out.println(temp.key + "\t" + temp.frequency);

			if(temp.left!=null){
				q.add(temp.left);
			}
			
			if(temp.right!=null){
				q.add(temp.right);
			}
		}

	}
}
