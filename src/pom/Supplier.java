
package pom;
import java.util.*;
import java.io.*;

public class Supplier implements baseclass {
    String suppliercode;
    String supplierid;
    String suppliername;
    String itemsupplied;
    String supplieraddress;
    int contactnumber;
    String alterid;
    String alteritem;
    
    public void add(){
        Set<String> Items = new HashSet<String>();
        Scanner sc = new Scanner(System.in);
        int loop1 = 1;
        int loop2 = 1;
        System.out.println("Please Enter Supplier Code:");
        String _suppliercode = sc.next();
        System.out.println("Please Enter Supplier ID:");
        String _supplierid = sc.next();
        System.out.println("Please Enter Supplier Name:");
        String _suppliername = sc.next();
        System.out.println("Please Enter Supplier Address:");
        String _supplieraddress = sc.next();
        System.out.println("Please Enter Suppllier Contact Number");
        int _contactnumber = sc.nextInt();
        
        //loop for registering items to one supplier
        //check for duplicated item
        
        while (loop1==1){
            int key = 0;
            try{
                System.out.println("Please Enter Supplied Items ID:");
                String _itemsupplied = sc.next();
                File ItemSup = new File("ItemEntry.txt");
                FileWriter fw = new FileWriter(ItemSup,true);
                Scanner fileread = new Scanner(ItemSup);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemsArray = line.split(" ");
                    for (String filecheck: ItemsArray){
                        if(filecheck.equals(_itemsupplied)){
                            System.out.println("--Item ID Already Exists--");
                            loop2 = 0;
                            key = 1;
                            break;
                        }
                    }
                }
                if (key==0){
                    Items.add(_itemsupplied);
                }
            }
            catch(IOException EX){}
            
            
            
            System.out.println("More Supplied Item?\n1.Yes\n2.No");
            loop1 = sc.nextInt();
            
        }
        
        suppliercode = _suppliercode;
        supplierid = _supplierid;
        suppliername = _suppliername;
        supplieraddress = _supplieraddress;
        contactnumber = _contactnumber;
        System.out.println("Save?\n1.Yes\n1.No\nPlease Enter with Number:");
        int input = sc.nextInt();
        
        //check for duplicated supplier
        
        if (input==1){
            try
            {
                int loop4 = 1;
                int loop5 = 0;
                File SupFile = new File("Supplier.txt");
                FileWriter fw = new FileWriter(SupFile,true);
                Scanner fileread = new Scanner(SupFile);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] SupArray = line.split(" ");
                    for (String filecheck: SupArray){
                        if(filecheck.equals(suppliercode)){
                            System.out.println("--Supplier Already Exists--");
                            loop4 = 0;
                            loop5 = 1;
                            break;
                        }
                    }
                    if (loop5==1){
                        break;
                    }

                }
                if (loop4==1){
                    PrintWriter pw = new PrintWriter(fw);
                    System.out.println("--Supplier to be saved--");
                    System.out.println(suppliercode+" "+supplierid+ " " + suppliername +" "+supplieraddress+" "+contactnumber);
                    pw.println(suppliercode+" "+supplierid+ " "+ suppliername +" "+supplieraddress+" "+contactnumber);
                    pw.close();
                    
                    File SupItem = new File("SupplierItem.txt");
                    FileWriter sfw = new FileWriter(SupItem,true);
                    BufferedWriter out = new BufferedWriter(sfw);
                    Iterator it = Items.iterator(); 
                    while(it.hasNext()) {
                        out.write(suppliercode + " " +(String)it.next());
                        out.newLine();
                    }
                    out.close();
                    
                    System.out.println("--Supplier has been saved--");
                    
                }
            }
            catch(IOException Ex){}
            }
    }
    
    public void save(){}
    
    public void delete(){
        int prints = 1;
        try {
            Scanner del = new Scanner(System.in);
            System.out.println("Please Enter the Supplier Code to Delete:");
            String suppliertodelete = del.next();
            
            //delete supplier
            
            FileInputStream fstream = new FileInputStream("Supplier.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(suppliertodelete)) {
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
            FileWriter fstreamWrite = new FileWriter("Supplier.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            
            //delete supplied item 
            
            FileInputStream sfstream = new FileInputStream("SupplierItem.txt");
            BufferedReader sbr = new BufferedReader(new InputStreamReader(sfstream));
            String sstrLine;
            StringBuilder sfileContent = new StringBuilder();
            while ((sstrLine = sbr.readLine()) != null) {
                String stokens[] = sstrLine.split(" ");
                if (stokens.length > 0) {
                    if (stokens[0].equals(suppliertodelete)) {
                        String snewLine = "";
                        sfileContent.append(snewLine);
                        sfileContent.append("\n");
                    } else {
                        sfileContent.append(sstrLine);
                        sfileContent.append("\n");
                    }
                }
            }
            FileWriter sfstreamWrite = new FileWriter("SupplierItem.txt");
            BufferedWriter sout = new BufferedWriter(sfstreamWrite);
            sout.write(sfileContent.toString());
            sout.close();
            
            System.out.println("--Supplier has been deleted--");
        } catch (IOException Ex) {
        }
        if (prints==1){
            System.out.println("--Supplier doesn't exists--");
        }
    }
    
    public void edit(){
        int prints = 1;
        Scanner ei = new Scanner(System.in);
        System.out.print("Please Enter Supplier Code:");
        String Item1 = ei.next();
        System.out.print("Please Enter New SupplierID:");
        String Item2 = ei.next();
        System.out.print("Please Enter New Supplier Name:");
        String Item3 = ei.next();
        System.out.print("Please Enter New Supplier Addressr:");
        double Item4 = ei.nextDouble();
        System.out.print("Please Enter New Suppleir Contact Number:");
        int Item5 = ei.nextInt();
        
        //changing supplier details
        
        try {
            FileInputStream fstream = new FileInputStream("Supplier.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(Item1)) {
                        alterid = tokens[1];
                        String newLine = Item1 + " " + Item2 + " " + Item3 + " " + Item4+ " " + Item5;
                        fileContent.append(newLine);
                        fileContent.append("\n");
                        prints = 0;
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("Supplier.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            System.out.println("--Supplier Details has been edited--");
        }
        catch (IOException Ee) {}
        
        //matching supplier to their supplied item and change to the supplier id
        
        try{
            FileInputStream fstream = new FileInputStream("SupplierItem.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(alterid)) {
                        alteritem = tokens[1];
                        String newLine = Item1 + " " + alteritem;
                        fileContent.append(newLine);
                        fileContent.append("\n");
                        prints = 0;
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("Supplier.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
        }
        catch(IOException Ex){}
        
        if (prints==1){
            System.out.println("--Supplier doesn't exists--");
        }
    }
    
    public void display(){
        Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("Supplier.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
    
    public void displaySupItem(){
            Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("SupplierItem.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
}
