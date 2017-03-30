import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanTreeEncoder {
	// Generates code_table.txt and encoded.bin
	static void encode(HuffmanTree root) throws IOException 
	{
		//Get code in HashMap
		HashMap<String, String> codes = encodeRecursive(root, "", new HashMap<String, String>());
		
		//Write codes to file
		FileWriter fw = new FileWriter("code_table.txt", true);
		for(String s : codes.keySet())
		{
			fw.append(s + " " + codes.get(s) + "\n");
		}
		fw.close();
		
		//Generate binary
		
		
		//Write binary to file
	}

	private static HashMap<String, String> encodeRecursive(HuffmanTree node, String code, HashMap<String, String> encoding) 
	{
		//Actually a DFS traversal
		if (node.isLeaf())
			encoding.put(node.key, code);
		else {
			if (node.left != null)
				encodeRecursive(node.left, code + "0", encoding);
			if (node.right != null)
				encodeRecursive(node.right, code + "1", encoding);
		}
		return encoding;
	}
}
