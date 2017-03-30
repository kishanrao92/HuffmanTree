
public class HuffmanNode implements Comparable<HuffmanNode>
{
	public HuffmanTree root;
	
	public HuffmanNode(HuffmanTree mData)
	{
		root = mData;
	}
	
	public Integer getFrequency()
	{
		return new Integer(root.frequency);
	}

	@Override
	public int compareTo(HuffmanNode other) 
	{
		return getFrequency().compareTo(other.getFrequency());
	}

}
