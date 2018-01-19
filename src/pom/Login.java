package pom;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Login {
    private String password;
    private String userid;
    private String usertype;
    private int key;
    
    public Login(String _userid, String _password, String _usertype){
        userid = _userid;
        password = _password;
        usertype = _usertype;
    }
    
    public void authentication(){
        String employeesearch = userid;
        String employeepassword = password;
        String employeetype = usertype;
        
        //match for employee login 
        
        try {
            File file2read = new File("EmployeeLogin.txt");
            Scanner ev = new Scanner(file2read);
            int loop1 = 0;
            while (ev.hasNextLine()){
                int i = 0;
                String line = ev.nextLine();
                String [] EmployeeL = line.split(" ");
                if (EmployeeL[i].equals(employeesearch)){
                    i++;
                    if (EmployeeL[i].equals(employeepassword)){
                        i++;
                        if (EmployeeL[i].equals(employeetype)){
                            loop1 = 1;
                        }
                    }
                }
                
            }
            if (loop1==1){
                key = 1;
                System.out.println("--Login Successful--");
            }
            else {
                System.out.println("--Incorrect Login Information--");
            }
        }
        catch (IOException Ex){}
    }
   
    public int callKey(int cKey){
        return cKey = key;
    }
    
    public String callType(String cType){
        return cType = usertype;
    }
}
