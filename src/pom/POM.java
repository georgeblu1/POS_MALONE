
package pom;
import java.util.Scanner;

public class POM {
    
    public static void main(String[] args) {
        System.out.println("--Welcome to Order Management System--");
        Scanner sc = new Scanner(System.in);
        int key=0;
        
        System.out.println("Please Enter UserID:");
        String userid = sc.next();
        System.out.println("Please Enter Password:");
        String password = sc.next();
        System.out.println("---User Type---\n1.Sales Manager\n2.Purchase manager\n3.Administrator\nPlease Verify User Type with Number:");
        String usertype = sc.next();
        
        Login check = new Login(userid, password, usertype);
        check.authentication();
        int ckey = check.callKey(key);
        
        if (ckey==1){
            String cType = check.callType(usertype);
            int CType = Integer.parseInt(cType);
            if (CType==1){
                int selection = 0;
                System.out.println("--Welcome Sales Manager--");
                while (selection!=9){
                    selection = 0;
                    System.out.println("--Operation--\n1.Item Entry\n2.List of Item Entry\n3.Supplier Entry\n4.List of Supplier Entry\n5.Daily Item-wise Sales Entry\n6.Create Purchase Requisition\n7.List of Purchase Requisition\n8.List of Purchase Order\n9.Exit\nPlease Confirm Operation with Number:");
                    selection = sc.nextInt();
                    ItemEntry ItemE = new ItemEntry();
                    Employee Emp = new Employee();
                    Supplier Sup = new Supplier();
                    DailySales Sale = new DailySales();
                    PurchaseRequisition PR = new PurchaseRequisition();
                    PurchaseOrder PO = new PurchaseOrder();
                    while (selection==1){
                        int operation = 0;
                        System.out.println("--Item Entry Operation--\n1.Add Item Entry\n2.Save Item Entry\n3.Delete Item Entry\n4.Edit Item Entry\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            ItemE.add();
                        }
                        else if (operation==2){
                            ItemE.save(ItemE);
                        }
                        else if(operation==3){
                            System.out.println("--Item Entry List--");
                            ItemE.displayItem();
                            ItemE.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Item Entry List--");
                            ItemE.displayItem();
                            ItemE.edit();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if (selection==2){
                        System.out.println("--Item Entry List--");
                        ItemE.displayItem();
                    }
                    while(selection==3){ 
                        int operation = 0;
                        System.out.println("--Supplier Operationn--\n1.Add Supplier\n2.Delete Supplier\n3.Edit Supplier\n4.Display Item Supplied\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            Sup.add();
                        }
                        else if(operation==2){
                            System.out.println("--Supplier List--");
                            Sup.display();
                            Sup.delete();
                        }
                        else if(operation==3){
                            System.out.println("--Supplier List--");
                            Sup.display();
                            Sup.edit();
                        }
                        else if(operation==4){
                            System.out.println("--Supplied Item List--");
                            Sup.displaySupItem();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if(selection==4){
                        System.out.println("--Supplier Details--");
                        Sup.display();
                    }
                    while(selection==5){
                        System.out.println("--Daily Item-wise Operation--\n1.Add ItemWise\n2.Save ItemWise\n3.Delete ItemWise\n4.Edit ItemWise\n5.Display ItemWise\n6.Back\nPlease Confirm Operation with Number:");
                        int operation = 0;
                        operation = sc.nextInt();
                        if (operation==1){
                            System.out.println("--Item Entry--");
                            ItemE.displayItem();
                            Sale.add();
                        }
                        else if(operation==2){
                            Sale.save(Sale);
                        }
                        else if(operation==3){
                            System.out.println("--Item Wise Entry--");
                            Sale.display();
                            Sale.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Item Wise Entry--");
                            Sale.display();
                            Sale.edit();
                        }
                        else if(operation==5){
                            System.out.println("--Item Wise Entry--");
                            Sale.display();
                        }
                        else if (operation==6){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    while(selection==6){
                        int operation = 0;
                        System.out.println("--Purchase Requisition Operation--\n1.Add Purchase Requisition\n2.Save Purchase Requisition\n3.Delete Purchaser Requisition\n4.Edit Purchase Requisition\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            PR.add();
                        }
                        else if(operation==2){
                            PR.save(PR);
                        }
                        else if(operation==3){
                            System.out.println("--Purchase Requisition List--");
                            PR.display();
                            PR.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Purchase Requisition List--");
                            PR.display();
                            PR.edit();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if(selection==7){
                        System.out.println("--Purchase Requisition List--");
                        PR.display();
                    }
                    if(selection==8){
                        System.out.println("--Purchase Order List--");
                        PO.display();
                    }
                    if (selection==9){
                        break;
                    }
                }
                System.out.println("--Exit System--");
                System.exit(0);
            }
            if (CType==2){
                int selection = 0;
                System.out.println("--Welcome Purchase Manager--");
                while (selection!=6){
                    selection = 0;
                    System.out.println("--Operation--\n1.List of Item Entry\n2.List of Supplier Entry\n3.List of Purchase Requisition\n4.Generate Purchase Orders\n5.List of Purchase Order\n6.Exit\nPlease Confirm Operation with Number:");
                    selection = sc.nextInt();
                    ItemEntry ItemE = new ItemEntry();
                    Employee Emp = new Employee();
                    Supplier Sup = new Supplier();
                    DailySales Sale = new DailySales();
                    PurchaseRequisition PR = new PurchaseRequisition();
                    PurchaseOrder PO = new PurchaseOrder();
                    if (selection==1){
                        System.out.println("--Item Entry List--");
                        ItemE.displayItem();
                    }
                    else if(selection==2){ 
                        System.out.println("--Supplier Details--");
                        Sup.display();
                    }
                    else if(selection==3){
                        System.out.println("--Purchase Requisition List--");
                        PR.display();
                    }
                    while(selection==4){
                        int operation = 0;
                        System.out.println("--Purchase Order Operation--\n1.Add Purchase Order\n2.Save Purchase Order\n3.Delete Purchase Order\n4.Edit Purchase Order\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            System.out.println("--Purchase Requisition List--");
                            PR.display();
                            PO.add();
                        }
                        else if(operation==2){
                            PO.save(PO);
                        }
                        else if(operation==3){
                            System.out.println("--Purchase Order List--");
                            PO.display();
                            PO.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Purchase Order List--");
                            PO.display();
                            PO.edit();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if(selection==5){
                        System.out.println("--Purchase Order List--");
                        PO.display();
                    }
                    if (selection==6){
                        break;
                    }
                }
                System.out.println("--Exit System--");
                System.exit(0);
            }

            if (CType==3){
                int selection = 0;
                System.out.println("--Welcome Administrator--");
                while (selection!=11){
                    selection = 0;
                    System.out.println("--Operation--\n1.Item Entry\n2.List of Item Entry\n3.Supplier Entry\n4.List of Supplier Entry\n5.Daily Item-wise Sales Entry\n6.Create Purchase Requisition\n7.List of Purchase Requisition\n8.Generate Purchase Orders\n9.List of Purchase Order\n10.Register user\n11.Exit\nPlease Confirm Operation with Number:");
                    selection = sc.nextInt();
                    ItemEntry ItemE = new ItemEntry();
                    Employee Emp = new Employee();
                    Supplier Sup = new Supplier();
                    DailySales Sale = new DailySales();
                    PurchaseRequisition PR = new PurchaseRequisition();
                    PurchaseOrder PO = new PurchaseOrder();
                    while (selection==1){
                        int operation = 0;
                        System.out.println("--Item Entry Operation--\n1.Add Item Entry\n2.Save Item Entry\n3.Delete Item Entry\n4.Edit Item Entry\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            ItemE.add();
                        }
                        else if (operation==2){
                            ItemE.save(ItemE);
                        }
                        else if(operation==3){
                            System.out.println("--Item Entry List--");
                            ItemE.displayItem();
                            ItemE.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Item Entry List--");
                            ItemE.displayItem();
                            ItemE.edit();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if (selection==2){
                        System.out.println("--Item Entry List--");
                        ItemE.displayItem();
                    }
                    while(selection==3){ 
                        int operation = 0;
                        System.out.println("--Supplier Operationn--\n1.Add Supplier\n2.Delete Supplier\n3.Edit Supplier\n4.Display Item Supplied\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            Sup.add();
                        }
                        else if(operation==2){
                            System.out.println("--Supplier List--");
                            Sup.display();
                            Sup.delete();
                        }
                        else if(operation==3){
                            System.out.println("--Supplier List--");
                            Sup.display();
                            Sup.edit();
                        }
                        else if(operation==4){
                            System.out.println("--Supplied Item List--");
                            Sup.displaySupItem();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if(selection==4){
                        System.out.println("--Supplier Details--");
                        Sup.display();
                    }
                    while(selection==5){
                        System.out.println("--Daily Item-wise Operation--\n1.Add ItemWise\n2.Save ItemWise\n3.Delete ItemWise\n4.Edit ItemWise\n5.Display ItemWise\n6.Back\nPlease Confirm Operation with Number:");
                        int operation = 0;
                        operation = sc.nextInt();
                        if (operation==1){
                            System.out.println("--Item Entry--");
                            ItemE.displayItem();
                            Sale.add();
                        }
                        else if(operation==2){
                            Sale.save(Sale);
                        }
                        else if(operation==3){
                            System.out.println("--Item Wise Entry--");
                            Sale.display();
                            Sale.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Item Wise Entry--");
                            Sale.display();
                            Sale.edit();
                        }
                        else if(operation==5){
                            System.out.println("--Item Wise Entry--");
                            Sale.display();
                        }
                        else if (operation==6){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    while(selection==6){
                        int operation = 0;
                        System.out.println("--Purchase Requisition Operation--\n1.Add Purchase Requisition\n2.Save Purchase Requisition\n3.Delete Purchaser Requisition\n4.Edit Purchase Requisition\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            PR.add();
                        }
                        else if(operation==2){
                            PR.save(PR);
                        }
                        else if(operation==3){
                            System.out.println("--Purchase Requisition List--");
                            PR.display();
                            PR.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Purchase Requisition List--");
                            PR.display();
                            PR.edit();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if(selection==7){
                        System.out.println("--Purchase Requisition List--");
                        PR.display();
                    }
                    while(selection==8){
                        int operation = 0;
                        System.out.println("--Purchase Order Operation--\n1.Add Purchase Order\n2.Save Purchase Order\n3.Delete Purchase Order\n4.Edit Purchase Order\n5.Back\nPlease Confirm Operation with Number:");
                        operation = sc.nextInt();
                        if (operation==1){
                            System.out.println("--Purchase Requisition List--");
                            PR.display();
                            PO.add();
                        }
                        else if(operation==2){
                            PO.save(PO);
                        }
                        else if(operation==3){
                            System.out.println("--Purchase Order List--");
                            PO.display();
                            PO.delete();
                        }
                        else if(operation==4){
                            System.out.println("--Purchase Order List--");
                            PO.display();
                            PO.edit();
                        }
                        else if(operation==5){
                            break;
                        }
                        else{
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if(selection==9){
                        System.out.println("--Purchase Order List--");
                        PO.display();
                    }
                    while (selection==10){                        
                        int operation = 0;
                        System.out.println("---Registration---\n1.Add Employee\n2.Save Employee\n3.Edit Employee\n4.Delete Employee\n5.Display Employee\n6.Back");
                        operation = sc.nextInt();
                        if (operation==1){
                            Emp.add();
                        }
                        else if (operation==2){
                            Emp.save(Emp);
                        }
                        else if (operation==3){
                            System.out.println("--Employee List--");
                            Emp.display();
                            Emp.edit();
                        }
                        else if (operation ==4){
                            System.out.println("--Employee List--");
                            Emp.display();
                            Emp.delete();
                        }
                        else if (operation==5){    
                            System.out.println("--Employee List--");
                            Emp.display();
                        }
                        else if (operation==6){
                            break;
                        }
                        else {
                            System.out.println("--Invalid Number--");
                        }
                    }
                    if (selection==11){
                        break;
                    }
                }
                System.out.println("--Exit System--");
                System.exit(0);
            }
        }
    }
    
}
