
package pom;
import java.util.Scanner;
import java.io.*;

public class ItemEntry implements baseclass {
    String itemcode;
    String itemid;
    String itemname;
    double price;
    int quantity;
    String suppliercode;
    
    public void add(){
        Scanner it = new Scanner(System.in);
        System.out.println("Please Enter Item Code:");
        String _itemcode = it.next();
        System.out.println("Please Enter Item ID:");
        String _itemid = it.next();
        System.out.println("Please Enter Item Name:");
        String _itemname = it.next();
        System.out.println("Please Enter Item Price:");
        double _price = it.nextDouble();
        System.out.println("Please Enter Item Quantity:");
        int _quantity = it.nextInt();
        itemcode = _itemcode;
        itemid = _itemid;
        itemname = _itemname;
        price = _price;
        quantity = _quantity;
    }
    
    public void save(){};
    
    public void save(ItemEntry ItemE){
        String Itemcode = itemcode;
        String Itemid = itemid;
        int loop1 = 0;
        int loop2 = 0;
        int prints = 1;
        
        //verify for existing supplied item
        
        try{
        File RefFile = new File("SupplierItem.txt");
            FileWriter rfw = new FileWriter(RefFile,true);
            Scanner rfileread = new Scanner(RefFile);
            while(rfileread.hasNextLine()){
                String rline = rfileread.nextLine();
                String [] RefArray = rline.split(" ");
                for (String rfilecheck: RefArray){
                    if(rfilecheck.equals(Itemid)){
                        suppliercode = RefArray[0];
                        loop1 = 1;
                        loop2 = 1;
                        prints = 0;
                        break;
                    }
                }
                if(loop2==1){
                    break;
                }
            }
        }
        catch(IOException Ex){}
        if (prints==1){
            System.out.println("--There's no supplier for this item--");
        }
        
        //check for duplicated item
        
        if (loop1==1){
            try
            {
                int loop3 = 1;
                int loop4 = 0;
                File ItemFile = new File("ItemEntry.txt");
                FileWriter fw = new FileWriter(ItemFile,true);
                Scanner fileread = new Scanner(ItemFile);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemArray = line.split(" ");
                    for (String filecheck: ItemArray){
                        if(filecheck.equals(Itemcode)){
                            System.out.println("--Item Code Already Exists--");
                            loop3 = 0;
                            loop4 = 1;
                            break;
                        }
                    }
                    if (loop4==1){
                        break;
                    }

                }
                if (loop3==1){
                    PrintWriter pw = new PrintWriter(fw);
                    System.out.println("--Item to be saved--");
                    System.out.println(ItemE.currentItem());
                    pw.println(ItemE.currentItem());
                    System.out.println("--Item has been saved--");
                    pw.close();
                }
            }
            catch(IOException Ex){}
        }
    }
    
    public void delete(){
        int prints = 1;
        try {
            Scanner del = new Scanner(System.in);
            System.out.println("Please Enter the Item Code to Delete:");
            String itemtodelete = del.next();
            FileInputStream fstream = new FileInputStream("ItemEntry.txt");
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
            FileWriter fstreamWrite = new FileWriter("ItemEntry.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            System.out.println("--Item has been deleted--");
        } catch (IOException Ex) {}
        if(prints==1){
            System.out.println("--Item doesn't exists--");
        }
    }
    
    public void edit(){
        int key = 0;
        int loop1 = 0;
        int prints = 1;
        try {
            Scanner ei = new Scanner(System.in);
            System.out.print("Please Enter Item Code to Edit:");
            String Item1 = ei.next();
            System.out.print("Please Enter New ItemID:");
            String Item2 = ei.next();
            System.out.print("Please Enter New Item Name:");
            String Item3 = ei.next();
            System.out.print("Please Enter New Item Price:");
            double Item4 = ei.nextDouble();
            System.out.print("Please Enter New Item Quantity:");
            int Item5 = ei.nextInt();
            
            //verify for existing item
            
            File RefFile = new File("SupplierItem.txt");
            FileWriter rfw = new FileWriter(RefFile,true);
            Scanner rfileread = new Scanner(RefFile);
            while(rfileread.hasNextLine()){
                String rline = rfileread.nextLine();
                String [] RefArray = rline.split(" ");
                for (String rfilecheck: RefArray){
                    if(rfilecheck.equals(Item2)){
                        suppliercode = RefArray[0];
                        loop1 = 1;
                        key = 1;
                        break;
                    }
                }
                if(loop1==1){
                    break;
                }
            }
            if(key==1){
                FileInputStream fstream = new FileInputStream("ItemEntry.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(Item1)) {
                            String newLine = Item1 + " " + Item2 + " " + Item3 + " " + Item4+ " " + Item5 + " " + suppliercode;
                            fileContent.append(newLine);
                            fileContent.append("\n");
                            prints = 0;
                        } else {
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }
                }

                FileWriter fstreamWrite = new FileWriter("ItemEntry.txt");
                BufferedWriter out = new BufferedWriter(fstreamWrite);
                out.write(fileContent.toString());
                out.close();
                System.out.println("--Item has been edited--");
                if (prints==1){
                System.out.println("--Item doesn't exists--");
                }
            }
        }
        catch (IOException Ex) {}
        if (key==0){
            System.out.println("--There's no supplier for the Item--");
        }
    }
    
    public String currentItem(){
       return itemcode+" "+itemid+" "+itemname+" "+price+" "+quantity+ " "+suppliercode;
    }
    
    public void displayItem(){
        Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("ItemEntry.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
}
