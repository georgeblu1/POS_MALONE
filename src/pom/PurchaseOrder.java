
package pom;
import java.util.*;
import java.io.*;

public class PurchaseOrder extends PurchaseRequisition {
    String pocode;
    String prcode;
    String status;
    
    public void add(){
        Scanner it = new Scanner(System.in);
        System.out.println("Please Enter Purchase Order Code:");
        String _pocode = it.next();
        System.out.println("Please Enter Purchase Requisition Code:");
        String _prcode = it.next();
        System.out.println("Please Enter Permission Status (Yes/No):");
        String _status = it.next();
        pocode = _pocode;
        prcode = _prcode;
        status = _status;
    }
    
    public void save(PurchaseOrder PO){
        int loop1 = 0;
        int prints = 2;
        
        //verify for existing purchase requisition
        
        try{
            File RefFile = new File("PurchaseRequisition.txt");
            FileWriter fw = new FileWriter(RefFile,true);
            Scanner rfileread = new Scanner(RefFile);
            while(rfileread.hasNextLine()){
                String rline = rfileread.nextLine();
                String [] RefArray = rline.split(" ");
                for (String rfilecheck: RefArray){
                    if(rfilecheck.equals(prcode)){
                        loop1 = 1;
                        prints = 1;
                        break;
                    }
                }
                if(loop1==1){
                    break;
                }
            }
        }
        catch(IOException Ex){}
        
        //check for duplication of purchase order
        
        if (prints==1){
            try{
                File RefFile = new File("PurchaseOrder.txt");
                FileWriter fw = new FileWriter(RefFile,true);
                Scanner rfileread = new Scanner(RefFile);
                while(rfileread.hasNextLine()){
                    String rline = rfileread.nextLine();
                    String [] RefArray = rline.split(" ");
                    for (String rfilecheck: RefArray){
                        if(rfilecheck.equals(pocode)){
                            loop1 = 0;
                            prints = 0;
                            break;
                        }
                    }
                    if(loop1==0){
                        break;
                    }
                if (loop1==0){
                    break;
                }
                }
            }
            catch(IOException Ex){}
        }
        if (prints==2){
            System.out.println("--Purchase Requisition Code doesn't exists--");
        }
        if (prints==0){
            System.out.println("--Purchase Order Code already exists--");
        }
        if(prints==1){
            try{
                    File PRFile = new File("PurchaseOrder.txt");
                    FileWriter fw = new FileWriter(PRFile,true);
                    PrintWriter pw = new PrintWriter(fw);
                    System.out.println("--Purchase Order to be saved--");
                    System.out.println(PO.current());
                    pw.println(PO.current());
                    System.out.println("--Purchase Order has been saved--");
                    pw.close();
            }
            catch(IOException Ex){}
        }
    }
    
    public void delete(){
        int prints = 1;
        try {
            Scanner del = new Scanner(System.in);
            System.out.println("Please Enter the Purchase Order Code to Delete:");
            String potodelete = del.next();
            FileInputStream fstream = new FileInputStream("PurchaseOrder.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(potodelete)) {
                        String newLine = "";
                        fileContent.append(newLine);
                        fileContent.append("\n");
                        prints = 0;
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("PurchaseOrder.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            System.out.println("--Purchase Order has been deleted--");
        } catch (IOException Ex) {}
        if(prints==1){
            System.out.println("--Purchase Order doesn't exists--");
        }
    }
    
    public void edit(){
        int prints = 0;
        int loop1 = 0;
        try {
            Scanner ei = new Scanner(System.in);
            System.out.print("Please Enter Purchase Order Code to Edit:");
            String Item1 = ei.next();
            System.out.print("Please Enter New Purchase Requisition Code:");
            String Item2 = ei.next();
            System.out.print("Please Enter New Status:");
            String Item3 = ei.next();
            
            //verify for existing purchase requisition
            
            File RefFile = new File("PurchaseRequisition.txt");
            FileWriter fw = new FileWriter(RefFile,true);
            Scanner rfileread = new Scanner(RefFile);
            while(rfileread.hasNextLine()){
                String rline = rfileread.nextLine();
                String [] RefArray = rline.split(" ");
                for (String rfilecheck: RefArray){
                    if(rfilecheck.equals(Item2)){
                        loop1 = 1;
                        prints = 1;
                        break;
                    }
                }
                if(loop1==1){
                    break;
                }
            if(loop1 ==1){
                break;
            }
            }
            if(prints==1){
                FileInputStream fstream = new FileInputStream("PurchaseOrder.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(Item1)) {
                            String newLine = Item1 + " " + Item2 + " " + Item3;
                            fileContent.append(newLine);
                            fileContent.append("\n");
                            prints = 2;
                        } else {
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }
                }
                FileWriter fstreamWrite = new FileWriter("PurchaseOrder.txt");
                BufferedWriter out = new BufferedWriter(fstreamWrite);
                out.write(fileContent.toString());
                out.close();
                System.out.println("--Purchase Order has been edited--");
            }
        }
        catch (IOException Ee) {}
        if (prints==0){
            System.out.println("--Purchase Requisition doesn't exists--");
        }
        if (prints==1){
            System.out.println("--Purchase Order doesn't exists--");
        }
    }
    
    public String current(){
        return pocode + " " + prcode + " " + status;
    }
    
    public void display(){
        Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("PurchaseOrder.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
}
