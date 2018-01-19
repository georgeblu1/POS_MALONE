
package pom;
import java.util.*;
import java.io.*;

public class DailySales implements baseclass{
    String datecode;
    String itemcode;
    int quantity;
    String itemid;
    String itemname;
    String price;
    String suppliercode;
    int afterquantity;
    String itemtoedit;
    String itemqtoedit;
    String squantity;
    int minusquantity;
    String alterid;
    String altername;
    String alterprice;
    String altersupplier;
    
    public void add(){
        Scanner it = new Scanner(System.in);
        System.out.println("Please Enter DateCode:");
        String _date = it.next();
        System.out.println("Please Enter Item Code:");
        String _itemcode = it.next();
        System.out.println("Please Enter Item Sales Quantity:");
        int _quantity = it.nextInt();
        datecode = _date;
        itemcode = _itemcode;
        quantity = _quantity;
    }
    
    public void save(){}
    
    public void save(DailySales Sales){
        String _itemcode = itemcode;
        int _quantity = quantity;
        int loop1 = 0;
        int loop2 = 0;
        int loop3 = 1;
        int prints = 1;
        String squantity;
        
        //check for duplication of sales entry
        
        try{
            File SaleFile = new File("SalesEntry.txt");
            FileWriter fw = new FileWriter(SaleFile,true);
            Scanner fileread = new Scanner(SaleFile);
            while(fileread.hasNextLine()){
                String line = fileread.nextLine();
                String [] EmpArray = line.split(" ");
                for (String filecheck: EmpArray){
                    if(filecheck.equals(datecode)){
                        loop3=0;
                        break;
                    }
                }
                if (loop3==0){
                    break;
                }
                
            }
        }
        catch(IOException Ex){}
        if(loop3==0){
            System.out.println("--Date Code already exists--");
        }
        
        //verify the calculation can be done
        
        if(loop3==1){
            try
            {
                File ItemFile = new File("ItemEntry.txt");
                FileWriter fw = new FileWriter(ItemFile,true);
                Scanner fileread = new Scanner(ItemFile);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemArray = line.split(" ");
                    for (String filecheck: ItemArray){
                        if(filecheck.equals(_itemcode)){
                            squantity = ItemArray[4];
                            int scquantity = Integer.parseInt(squantity);
                            if (scquantity-_quantity<0){
                                System.out.println("--There's not enough item quantity to be deducted--");
                                loop2 = 1;
                                prints = 0;
                            }
                            else{
                                itemcode = ItemArray[0];
                                itemid = ItemArray[1];
                                itemname = ItemArray[2];
                                price = ItemArray[3];
                                afterquantity = scquantity-_quantity;
                                suppliercode = ItemArray[5];
                                loop1 = 1;
                                loop2 = 1;
                                prints = 0;
                            }
                        }
                    if (loop2==1){
                        break;
                    }
                    }
                if (loop2==1){
                    break;
                }
                }
            }
            catch(IOException Ex){}
            if (prints==1){
                System.out.println("--Item doesn't exists--");
            }
            
            if (loop1==1){
                try{
                File SaleFile = new File("SalesEntry.txt");
                FileWriter fw = new FileWriter(SaleFile,true);
                PrintWriter pw = new PrintWriter(fw);
                System.out.println("--Sales to be saved--");
                System.out.println(Sales.currentSales());
                pw.println(Sales.currentSales());
                pw.close();
                
                
                //deducting quantity of item from item entry
            
                
                FileInputStream fstream = new FileInputStream("ItemEntry.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(_itemcode)) {
                            String newLine = itemcode + " " + itemid + " " + itemname + " " + price+ " " + afterquantity + " " + suppliercode;
                            fileContent.append(newLine);
                            fileContent.append("\n");
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
                System.out.println("--Sales has been saved--");
                }
                catch(IOException Ex){}
            }
        }
        
    }
    
    public void delete(){
        Scanner del = new Scanner(System.in);
        System.out.println("Please Enter the Date Code to Delete:");
        String saletodelete = del.next();
        int loop1 = 0;
        int prints = 1;
        try {
            FileInputStream fstream = new FileInputStream("SalesEntry.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(saletodelete)) {
                        itemtoedit = tokens[1];
                        itemqtoedit = tokens[2];
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
            FileWriter fstreamWrite = new FileWriter("SalesEntry.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
        } catch (IOException Ex) {}
        if (prints==1){
            System.out.println("--No Sales is found--");
        }
        if (prints==0){
            try{
                File ItemFile = new File("ItemEntry.txt");
                FileWriter fw = new FileWriter(ItemFile,true);
                Scanner fileread = new Scanner(ItemFile);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemArray = line.split(" ");
                    for (String filecheck: ItemArray){
                        if(filecheck.equals(itemtoedit)){
                            squantity = ItemArray[4];
                            int scquantity = Integer.parseInt(squantity);
                            int scqtoedit = Integer.parseInt(itemqtoedit);
                            itemcode = ItemArray[0];
                            itemid = ItemArray[1];
                            itemname = ItemArray[2];
                            price = ItemArray[3];
                            afterquantity = scquantity+scqtoedit;
                            suppliercode = ItemArray[5];
                            loop1 = 1;
                            }
                        }
                    if (loop1==1){
                        break;
                    }
                if(loop1==1){
                    break;
                }
                }
                
                //returning item entry to their original quantity
                
                FileInputStream fstream = new FileInputStream("ItemEntry.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(itemtoedit)) {
                            String newLine = itemcode + " " + itemid + " " + itemname + " " + price+ " " + afterquantity + " " + suppliercode;
                            fileContent.append(newLine);
                            fileContent.append("\n");
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
                System.out.println("--Sales has been edited--");
                }
                catch(IOException Ex){}
        }
    }
    
    public void edit(){
        Scanner del = new Scanner(System.in);
        System.out.println("Please Enter the Date Code to Edit:");
        String datecodeedit = del.next();
        System.out.println("Please Enter new Item Code to Edit:");
        String itemcodeedit = del.next();
        System.out.println("Please Enter the Quantity to Edit");
        int quantityedit = del.nextInt();
        int loop1 = 0;
        int loop2 = 0;
        int prints = 1;
        int key = 0;
        
        try{
            File SaleFile = new File("ItemEntry.txt");
            FileWriter fw = new FileWriter(SaleFile,true);
            Scanner fileread = new Scanner(SaleFile);
            while(fileread.hasNextLine()){
                String line = fileread.nextLine();
                String [] EmpArray = line.split(" ");
                for (String filecheck: EmpArray){
                    if(filecheck.equals(itemcodeedit)){
                        key = 1;
                        break;
                    }
                }
            }
        }
        catch(IOException Ex){}
        if (key==0){
            System.out.println("--Item doesn't exists--");
        }
        if (key==1){
            try{
                File ItemFile = new File("ItemEntry.txt");
                FileWriter fw = new FileWriter(ItemFile,true);
                Scanner fileread = new Scanner(ItemFile);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemArray = line.split(" ");
                    for (String filecheck: ItemArray){
                        if(filecheck.equals(itemcodeedit)){
                            String squantity2 = ItemArray[4];
                            int scquantity3 = Integer.parseInt(squantity2);
                            if (scquantity3-quantityedit<0){
                                System.out.println("--There's not enough item quantity to be deducted--");
                                loop2 = 1;
                            }
                            else {
                                minusquantity = scquantity3-quantityedit;
                                key = 2;
                            }
                        }
                    if (loop2==1){
                        break;
                    }
                    }
                if (loop2==1){
                    break;
                }
                }
            }
            catch(IOException Ex){}
        }
        
        if (key==2){
            try {
                FileInputStream fstream = new FileInputStream("SalesEntry.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(datecodeedit)) {
                            itemtoedit = tokens[1];
                            itemqtoedit = tokens[2];
                            String newLine = datecodeedit + " " + itemcodeedit+ " "+quantityedit;
                            fileContent.append(newLine);
                            fileContent.append("\n");
                            prints = 0;
                        } else {
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }
                }
                FileWriter fstreamWrite = new FileWriter("SalesEntry.txt");
                BufferedWriter out = new BufferedWriter(fstreamWrite);
                out.write(fileContent.toString());
                out.close();
            } catch (IOException Ex) {}
            
        }
        
        if(prints==0){
            try{
                File ItemFile = new File("ItemEntry.txt");
                FileWriter fw = new FileWriter(ItemFile,true);
                Scanner fileread = new Scanner(ItemFile);
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemArray = line.split(" ");
                    for (String filecheck: ItemArray){
                        if(filecheck.equals(itemtoedit)){
                            squantity = ItemArray[4];
                            int scquantity = Integer.parseInt(squantity);
                            int scqtoedit = Integer.parseInt(itemqtoedit);
                            itemcode = ItemArray[0];
                            itemid = ItemArray[1];
                            itemname = ItemArray[2];
                            price = ItemArray[3];
                            afterquantity = scquantity+scqtoedit;
                            suppliercode = ItemArray[5];
                            }
                        }
                }
                
                while(fileread.hasNextLine()){
                    String line = fileread.nextLine();
                    String [] ItemArray = line.split(" ");
                    for (String filecheck2: ItemArray){
                        if(filecheck2.equals(itemcodeedit)){
                            alterid = ItemArray[1];
                            altername = ItemArray[2];
                            alterprice = ItemArray[3];
                            altersupplier = ItemArray[5];
                        }
                    }
                }
                
                //returning item entry to their original quantity
                
                FileInputStream fstream = new FileInputStream("ItemEntry.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(itemtoedit)) {
                            String newLine = itemtoedit + " " + itemid + " " + itemname + " " + price+ " " + afterquantity + " " + suppliercode;
                            fileContent.append(newLine);
                            fileContent.append("\n");
                        } else {
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }
                }
                
                //deducing item quantity from item entry
                
                while ((strLine = br.readLine()) != null) {
                    String tokens[] = strLine.split(" ");
                    if (tokens.length > 0) {
                        if (tokens[0].equals(itemcodeedit)) {
                            String newLine = itemcodeedit + " " + alterid + " " + altername + " " + alterprice+ " " + minusquantity + " " + altersupplier;
                            fileContent.append(newLine);
                            fileContent.append("\n");
                            prints = 0;
                        } 
                        else {
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }
                }
                
                FileWriter fstreamWrite = new FileWriter("ItemEntry.txt");
                BufferedWriter out = new BufferedWriter(fstreamWrite);
                out.write(fileContent.toString());
                out.close();
            
                if (prints==1){
                    System.out.println("--Item Wise Entry doesn't exists--");
                }
                else{
                    System.out.println("--Sales has been edited--");
                }
            }
            catch(IOException Ex){}
        }
    }
    
    public String currentSales(){
       return datecode+ " " + itemcode + " "+quantity;
    }
    
    public void display(){
        Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("SalesEntry.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
}
