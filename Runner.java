import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Runner
{
    /*public static void main(String[] args) throws IOException
    {

        BinaryHeap bh=new BinaryHeap();
        PairingHeap ph=new PairingHeap();
        FourWayHeap fh=new FourWayHeap();

        HashMap<String,Integer> map=new HashMap<String,Integer>();
        BufferedReader br=new BufferedReader(new FileReader("/Users/Kishan_Rao/Downloads/sample_input_large.txt"));
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
        //long start_time = System.currentTimeMillis();

        //for(int i =0;i<10;i++) {
            //bh.treeUsingBinaryHeap(map);
            //fh.treeUsingFourHeap(map);
            //ph.treeUsingPairingHeap(map);
        //}
       // System.out.println(((System.currentTimeMillis()-start_time)/10)+" = time to make 10 huffman trees using 4way heap heap ");

        HuffmanTreeEncoder.encode(fh.treeUsingFourHeap(map));
        PQNode node=HuffmanTreeDecoder.decodeTree("/Users/Kishan_Rao/Downloads/code_table.txt");
        HuffmanTreeDecoder.writeToDecodedFile(node,"/Users/Kishan_Rao/Downloads/Encoded.bin");

        //}


        //Build the tree now


        //HuffmanTree theTree = heap.remove().root;
        //theTree.bermudezPrint();

       /* long start_time = System.currentTimeMillis();
        for(int i =0;i<10;i++)
            bh.treeUsingBinaryHeap(map);
        System.out.println(((System.currentTimeMillis()-start_time)/10)+" = time to make 10 huffman trees using binary heap ");

        start_time = System.currentTimeMillis();
       stem.out.println((((System.currentTimeMillis()-start_time)/10))+" = time to make 1 huffman trees using 4-way heap");


        //HuffmanTreeEncoder.encode(bh.treeUsingBinaryHeap(map));

       //PQNode res= HuffmanTreeDecoder.decodeTree("/Users/Kishan_Rao/Downloads/code_table.txt");

       //System.out.println(res.left.left.right.key+" ****");
       // System.out.println("_________________");
       //prettyPrint(res);


        //start_time = System.currentTimeMillis();
        //for(int i =0;i<5;i++)	{
            //System.out.println(i);
            //fh.treeUsingFourHeap(map);


        //}
        //System.out.println((((System.currentTimeMillis()-start_time))/10)+" = time to make 100 huffman trees using 4-way heap");

        //System.out.println((((System.currentTimeMillis()-start_time))/10)+" = time to make 100 huffman trees using pairing heap");
    }

    public static void prettyPrint(PQNode node)
    {
        Queue<PQNode> q = new LinkedList<PQNode>();
        q.add(node);

        while(!q.isEmpty()){
            PQNode temp = q.poll();
            System.out.println(temp.key + "\t" + temp.val);

            if(temp.left!=null){
                q.add(temp.left);
            }

            if(temp.right!=null){
                q.add(temp.right);
            }
        }

    }*/
}
