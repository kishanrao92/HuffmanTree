import java.io.*;
import java.util.BitSet;
import java.util.HashMap;

import java.util.*;

/**
 * Created by Kishan_Rao on 4/4/17.
 */



    public class encoder {
        public static StringBuilder sb=new StringBuilder();
        public static String  inputFile=null;
        
        static void encode(PQNode root) throws IOException {
            //Get code in HashMap
            HashMap<Integer, String> codes = encodeRecursive(root, "", new HashMap<Integer, String>());

            //Write codes to file
            FileWriter fw = new FileWriter("code_table.txt");
            for (Integer s : codes.keySet()) {
                fw.append(s + " " + codes.get(s) + "\n");
            }
            fw.close();


            BufferedReader br=new BufferedReader(new FileReader(inputFile));

            String line=null;
            while((line=br.readLine())!=null)
            {
                sb.append(codes.get(Integer.parseInt(line)));
            }
            br.close();

            BitSet bs=new BitSet(sb.toString().length());
            char[] codeByte=sb.toString().toCharArray();
            int count=bs.size()-1;
            for(int i=0;i<codeByte.length;i++){
                if('1' == codeByte[i]){
                    bs.set(count);
                }
                count--;


            }

            byte[] result=bs.toByteArray();
            reverseByteArray(result);
        
             //Generate binary file

            FileOutputStream os=new FileOutputStream("encoded.bin");
            os.write(result);
            os.close();
         }

        private static HashMap<Integer, String> encodeRecursive(PQNode node, String code, HashMap<Integer, String> encoding) {
          
            if (node.left == null && node.right == null) {
        
                encoding.put(node.key, code);
            }
            else {
                if (node.left != null) {
                    encodeRecursive(node.left, code + "0", encoding);
                }
                if (node.right != null) {
                    encodeRecursive(node.right, code + "1", encoding);
                }
            }
            return encoding;
        }

        public static void reverseByteArray(byte[] arr){
            int i=0;
            int j=arr.length-1;
            while(i<j){
                byte temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }

        }

        public static void main(String[] args) throws IOException
        {

            FourWayHeap fh=new FourWayHeap();

            HashMap<String,Integer> map=new HashMap<String,Integer>();
            inputFile =args[0];
            BufferedReader br=new BufferedReader(new FileReader(args[0]));
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

            encoder.encode(fh.treeUsingFourHeap(map));

            }



    }


