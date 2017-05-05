/**
 * Created by Kishan_Rao on 4/4/17.
 */

import java.io.*;
import java.util.HashMap;

public class decoder
{
    public static String codeTablePath=null;
    public static String encodedBinPath=null;
  
    public static PQNode decodeTree(String path) throws FileNotFoundException,IOException {
        PQNode root=new PQNode(-1);
        PQNode current=null;
        BufferedReader br=new BufferedReader(new FileReader(path));
        String line;
        current=root;
        while((line=br.readLine())!=null){

            String[] temp=line.split(" ");
            char[] code=temp[1].toCharArray();

            for(int i=0;i<=code.length-1;i++){
                if(code[i]=='0'){
                    if(current.left==null) {
                        current.left = new PQNode(-1);
                        current = current.left;
                    }
                    else{
                        current=current.left;
                    }

                }
                if(code[i]=='1'){
                    if(current.right==null) {
                        current.right = new PQNode(-1);
                        current = current.right;
                    }
                    else{
                        current=current.right;
                    }
                }

            }
            current.key=Integer.parseInt(temp[0]);


            current=root;

        }

        return root;

    }

    public static void writeToDecodedFile(PQNode root,String path) throws FileNotFoundException,IOException{
        PQNode current=root;

        BufferedWriter fw = new BufferedWriter(new FileWriter("decoded.txt"));

        File file = new File(path);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));

        dis.readFully(fileData);
        dis.close();
        int temp=0;
             for(int i=0;i<fileData.length-1;i++){
            temp=fileData[i];

            for(int location=7;location>=0;location--){
                if(((temp&(1<<location))>>location)==1){
                    current=current.right;

                }
                else if(((temp &(1<<location))>>location)==0){
                    current=current.left;
                }

                if(current.left==null && current.right==null){
                    fw.append(current.key+"\n");
                    current=root;


                }
            }


        }
        fw.close();





    }


    public static boolean isLeaf(PQNode node){
        if(node.left==null && node.right==null)
            return true;

        return false;
    }


    public static void main(String[] args) throws IOException
    {

  
        encodedBinPath=args[0];
        codeTablePath=args[1];
        PQNode node=decoder.decodeTree(codeTablePath);
        decoder.writeToDecodedFile(node,encodedBinPath);
        
    }


}
