
package pom;
import java.util.*;
import java.io.*;

public class PurchaseRequisition {
    String prcode;
    String date;
    String itemcode;
    int quantity;
    String suppliercode;
    
    public void add(){
        Scanner it = new Scanner(System.in);
        System.out.println("Please Enter a PR Code:");
        String _prcode = it.next();
        System.out.println("Please Enter the Date:");
        String _date = it.next();
        System.out.println("Please Enter the Item Code:");
        String _itemcode = it.next();
        System.out.println("Please Enter Item Quantity:");
        int _quantity = it.nextInt();
        prcode = _prcode;
        date = _date;
        itemcode = _itemcode;
        quantity = _quantity;
    }
    
    public void save(PurchaseRequisition PR){
        int loop1 = 0;
        int prints = 2;
        
        //verify for existing item
        
        try{
            File RefFile = new File("ItemEntry.txt");
            FileWriter rfw = new FileWriter(RefFile,true);
            Scanner rfileread = new Scanner(RefFile);
            while(rfileread.hasNextLine()){
                String rline = rfileread.nextLine();
                String [] RefArray = rline.split(" ");
                for (String rfilecheck: RefArray){
                    if(rfilecheck.equals(itemcode)){
                        suppliercode = RefArray[0];
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
        
        //check for duplication of purchase requisition
        
        if (prints==1){
            try{
                File RefFile = new File("PurchaseRequisition.txt");
                FileWriter fw = new FileWriter(RefFile,true);
                Scanner rfileread = new Scanner(RefFile);
                while(rfileread.hasNextLine()){
                    String rline = rfileread.nextLine();
                    String [] RefArray = rline.split(" ");
                    for (String rfilecheck: RefArray){
                        if(rfilecheck.equals(prcode)){
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
            System.out.println("--Item doesn't exist--");
        }
        if (prints==0){
            System.out.println("--Purchase Requisition Code already exist--");
        }
        if(prints==1){
            try{
                    File PRFile = new File("PurchaseRequisition.txt");
                    FileWriter fw = new FileWriter(PRFile,true);
                    PrintWriter pw = new PrintWriter(fw);
                    System.out.println("--Purchase Requisition to be saved--");
                    System.out.println(PR.current());
                    pw.println(PR.current());
                    System.out.println("--Purchase Requisition has been saved--");
                    pw.close();
            }
            catch(IOException Ex){}
        }
    }
    
    public void delete(){
        int prints = 1;
        try {
            Scanner del = new Scanner(System.in);
            System.out.println("Please Enter the Purchase Requisition Code to Delete:");
            String itemtodelete = del.next();
            FileInputStream fstream = new FileInputStream("PurchaseRequisition.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(itemtodelete)) {
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
            FileWriter fstreamWrite = new FileWriter("PurchaseRequisition.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            System.out.println("--Purchase Requisition has been deleted--");
        } catch (IOException Ex) {}
        if(prints==1){
            System.out.println("--Purchase Requisition doesn't exists--");
        }
    }
    
    public void edit(){
        int key = 0;
        Scanner ei = new Scanner(System.in);
        System.out.print("Please Enter Purchase Requisition Code to Edit:");
        String Item1 = ei.next();
        System.out.print("Please Enter New Date:");
        String Item2 = ei.next();
        System.out.print("Please Enter New Item Code:");
        String Item3 = ei.next();
        System.out.print("Please Enter New Item Quantity:");
        int Item4 = ei.nextInt();
        
        //verify for existing item
        
        try{
            File RefFile = new File("ItemEntry.txt");
            FileWriter rfw = new FileWriter(RefFile,true);
            Scanner rfileread = new Scanner(RefFile);
            while(rfileread.hasNextLine()){
                String rline = rfileread.nextLine();
                String [] RefArray = rline.split(" ");
                for (String rfilecheck: RefArray){
                    if(rfilecheck.equals(Item3)){
                        key = 1;
                        break;
                    }
                }
            }
        }
        catch(IOException Ex){}
        
        if(key==0){
            System.out.println("--Item doesn't exists--");
        }
        
        //verify for purchase requisition to be deleted
        
        if (key==1){
            try{
                File RefFile = new File("PurchaseRequisition.txt");
                FileWriter rfw = new FileWriter(RefFile,true);
                Scanner rfileread = new Scanner(RefFile);
                while(rfileread.hasNextLine()){
                    String rline = rfileread.nextLine();
                    String [] RefArray = rline.split(" ");
                    for (String rfilecheck: RefArray){
                        if(rfilecheck.equals(Item1)){
                            key = 2;
                            break;
                        }
                    }
                }
            }
            catch(IOException Ex){}
        }
        
        if(key==1){
            System.out.println("--Purchase Requisition doesn't exists--");
        }
        
        if(key==2){
            try{
                FileInputStream fstream = new FileInputStream("PurchaseRequisition.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(Item1)) {
                            String newLine = Item1 + " " + Item2 + " " + Item3 + " " + Item4;
                            fileContent.append(newLine);
                            fileContent.append("\n");
                        } else {
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }
                }
                FileWriter fstreamWrite = new FileWriter("PurchaseRequisition.txt");
                BufferedWriter out = new BufferedWriter(fstreamWrite);
                out.write(fileContent.toString());
                out.close();
                System.out.println("--Purchae Requisition has been edited--");
            }
            catch (IOException Ee) {}
        }
    }
    
    public String current(){
        return prcode + " "+date + " "+itemcode + " "+quantity + " "+suppliercode;
    }
    
    public void display(){
        Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("PurchaseRequisition.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
}
