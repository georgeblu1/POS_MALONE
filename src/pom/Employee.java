
package pom;
import java.io.*;
import java.util.Scanner;

public class Employee implements baseclass {
    String usercode;
    String userid;
    String username;
    String password;
    int contactnumber;
    String address;
    int usertype;
    String rusertype;
    String tempuser;
    
    public void add(){
        Scanner it = new Scanner(System.in);
        System.out.println("Please Enter User Code:");
        String _usercode = it.next();
        System.out.println("Please Enter User ID:");
        String _userid = it.next();
        System.out.println("Please Enter User Name:");
        String _username = it.next();
        System.out.println("Please Enter User Password:");
        String _password = it.next();
        System.out.println("Please Enter User Contact Number:");
        int _contactnumber = it.nextInt();
        System.out.println("Please Enter User Address:");
        String _address = it.next();
        System.out.println("----User Type----\n1.Sales Manager\n2.Purchase Manager\n3.Administrator");
        System.out.println("Please Enter User Type with number:");
        int _usertype = it.nextInt();
        usercode = _usercode;
        userid = _userid;
        username = _username;
        password = _password;
        contactnumber = _contactnumber;
        address = _address;
        usertype = _usertype;
    }
    
    public void save (){};
    
    public void save(Employee EmployeeE){
        String userC = usercode;
        
        //login file is used for authentication
        
        try
        {
            int loop1 = 1;
            int loop2 = 0;
            File EmpFile = new File("EmployeeDetails.txt");
            FileWriter fw = new FileWriter(EmpFile,true);
            File EmpLFile = new File("EmployeeLogin.txt");
            FileWriter Efw = new FileWriter(EmpLFile,true);
            Scanner fileread = new Scanner(EmpFile);
            while(fileread.hasNextLine()){
                String line = fileread.nextLine();
                String [] EmpArray = line.split(" ");
                for (String filecheck: EmpArray){
                    if(filecheck.equals(userC)){
                        System.out.println("--User Already Exists--");
                        loop1 = 0;
                        loop2 = 1;
                        break;
                    }
                }
                if (loop2==1){
                    break;
                }
                
            }
            if (loop1==1){
                PrintWriter pw = new PrintWriter(fw);
                System.out.println("--User to be saved--");
                System.out.println(EmployeeE.currentEmp());
                pw.println(EmployeeE.currentEmp());
                pw.close();
                
                PrintWriter Epw = new PrintWriter(Efw);
                Epw.println(EmployeeE.currentEmpL());
                Epw.close();
                System.out.println("--User has been saved--");
            }
        }
        catch(IOException Ex){}
    }
    
    public void delete(){
        int prints = 1;
        try {
            Scanner del = new Scanner(System.in);
            System.out.println("Please Enter the User Code to Delete:");
            String usertodelete = del.next();
            
            FileInputStream fstream = new FileInputStream("EmployeeDetails.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(usertodelete)) {
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
            FileWriter fstreamWrite = new FileWriter("EmployeeDetails.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            
            File RefFile = new File("EmployeeDetails.txt");
            FileWriter fw = new FileWriter(RefFile,true);
            Scanner fileread = new Scanner(RefFile);
            while(fileread.hasNextLine()){
                String line = fileread.nextLine();
                String [] RefArray = line.split(" ");
                for (String filecheck: RefArray){
                    if(filecheck.equals(usertodelete)){
                        tempuser = RefArray[1];
                    }
                }
            }
            
            FileInputStream Efstream = new FileInputStream("EmployeeLogin.txt");
            BufferedReader Ebr = new BufferedReader(new InputStreamReader(Efstream));
            String strELine;
            StringBuilder EfileContent = new StringBuilder();
            while ((strELine = Ebr.readLine()) != null) {
                String Etokens[] = strELine.split(" ");
                if (Etokens.length > 0) {
                    if (Etokens[0].equals(tempuser)) {
                        String newELine = "";
                        EfileContent.append(newELine);
                        EfileContent.append("\n");
                    } else {
                        EfileContent.append(strELine);
                        EfileContent.append("\n");
                    }
                }
            }
            FileWriter EfstreamWrite = new FileWriter("EmployeeLogin.txt");
            BufferedWriter Eout = new BufferedWriter(EfstreamWrite);
            Eout.write(EfileContent.toString());
            Eout.close();
            
            System.out.println("--User has been deleted--");
        } catch (IOException Ex) {
        }
        if (prints==1){
            System.out.println("--User doesn't exists--");
        }
    }
    
    public void edit(){
        int prints = 1;
        try {
            Scanner ei = new Scanner(System.in);
            System.out.print("Please Enter User Code to Edit:");
            String User1 = ei.next();
            System.out.print("Please Enter New UserID:");
            String User2 = ei.next();
            System.out.print("Please Enter New Username:");
            String User3 = ei.next();
            System.out.print("Please Enter New User Password:");
            String User4 = ei.next();
            System.out.print("Please Enter New User Contact number:");
            int User5 = ei.nextInt();
            System.out.print("Please Enter New User Address:");
            String User6 = ei.next();
            System.out.println("----User Type----\n1.Sales Manager\n2.Purchase Manager\n3.Administrator");
            System.out.print("Please Enter New User Type accoding to Number:");
            int User7 = ei.nextInt();
            String User8=" ";
            switch (User7) {
                case 1:
                    User8 = "Sales Manager";
                    break;
                case 2:
                    User8 = "Purchase Manager";
                    break;
                case 3: 
                    User8 = "Administrator";
                    break;
                default:
                    break;
            }
            FileInputStream fstream = new FileInputStream("EmployeeDetails.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(User1)) {
                        String newLine = User1 + " " + User2 + " " + User3 + " " + User4+ " " + User5 + " " + User6+" "+User7+"."+User8;
                        fileContent.append(newLine);
                        fileContent.append("\n");
                        prints = 0;
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            
            FileWriter fstreamWrite = new FileWriter("EmployeeDetails.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            
            FileInputStream Efstream = new FileInputStream("EmployeeLogin.txt");
            BufferedReader Ebr = new BufferedReader(new InputStreamReader(Efstream));
            String EstrLine;
            StringBuilder efileContent = new StringBuilder();
            while ((EstrLine = Ebr.readLine()) != null) {
                String Etokens[] = EstrLine.split(" ");
                if (Etokens.length > 0) {
                    if (Etokens[0].equals(User1)) {
                        String EnewLine =  User2 + " " + User4+ " " + User7;
                        efileContent.append(EnewLine);
                        efileContent.append("\n");
                    } else {
                        efileContent.append(EstrLine);
                        efileContent.append("\n");
                    }
                }
            }
            FileWriter EfstreamWrite = new FileWriter("EmployeeLogin.txt");
            BufferedWriter Eout = new BufferedWriter(EfstreamWrite);
            Eout.write(efileContent.toString());
            Eout.close();
            System.out.println("--User has been edited--");
        }
        catch (IOException Ex) {}
        if (prints==1){
            System.out.println("--User doesn't exists--");
        }
    }
    
    public String currentEmp(){
        switch (usertype) {
            case 1:
                rusertype = "Sales Manager";
                break;
            case 2:
                rusertype = "Purchase Manager";
                break;
            case 3:
                rusertype = "Administrator";
                break;
            default:
                break;
        }
        return usercode+" "+userid+" "+username+" "+password+" "+contactnumber+ " "+address+" "+usertype+"."+rusertype;
    }
    
    public String currentEmpL(){
        return userid+" "+password+" "+usertype;
    }
    
    public void display(){
        Scanner Sc = new Scanner(System.in);
            try{
                File file2Read = new File("EmployeeDetails.txt");
                Sc = new Scanner(file2Read);
                    while (Sc.hasNextLine()){
                        String Line = Sc.nextLine();
                        System.out.println(Line);
                    }
            }
            catch(IOException Ex){}
    }
}


