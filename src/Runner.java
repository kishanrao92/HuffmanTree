import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Runner 
{
	public static void main(String args[]) throws IOException
	{
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		BufferedReader br=new BufferedReader(new FileReader("sample_input_small.txt"));
		String line=null;
		while((line=br.readLine())!=null)
		{
			if(map.containsKey(line)){
				map.put(line,map.get(line)+1);
			}
			else{
				map.put(line,1);
			}
		}
		br.close();
		
		//Build the tree now
		
		HuffmanTree left_child;
        HuffmanTree right_child;
        HuffmanTree result;
        
        Heap<HuffmanNode> heap = new PairingHeap<HuffmanNode>();
        
        for(String c: map.keySet())
        {
            if(c!=null)
                heap.insert(new HuffmanNode( new HuffmanTree(c, map.get(c)) ));
        }
        //Heap ready yaay!

        while(heap.size() > 1)
        {
        	//HuffmanNode aNode = heap.remove();
        	left_child = heap.remove().root;
        	right_child = heap.remove().root;
        	result = new HuffmanTree("--", left_child.frequency + right_child.frequency);
        	result.left = left_child;
        	result.right = right_child;
        	heap.insert(new HuffmanNode(result));
        }
        
        HuffmanTree theTree = heap.remove().root;
		theTree.bermudezPrint();
		HuffmanTreeEncoder.encode(theTree);
	}
}
