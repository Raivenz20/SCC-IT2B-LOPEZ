package Lopez;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Salary {
    public void salary(){
        Scanner input=new Scanner(System.in);
        
        boolean Tagain=true;
        int choice,choice2;
        int ArrLim=0, v234=0, Employee;
        double Tgross=0, Tred=0, Tnet=0;
        
        Salaries[] s2 =null;
        
        
        System.out.println("+-----------------------------------------------------------");
        System.out.println("|\tWelcome To Salary App");
        System.out.println("+-----------------------------------------------------------");
        do{
            while(true){
                choice=ValidateChoice(input);
                if(choice<1 || choice>5){
                    System.out.println("\t!!!Invalid Choice!!!\nTry Again!");
                }else if(v234==0 && choice==2 ||v234==0 && choice==3 || v234==0 && choice==4){
                    System.out.println("\t!!!No File to view!!!\nTry Again!");
                }else{
                    System.out.println("+-----------------------------------------------------------");
                    break;
                }
                System.out.println("+-----------------------------------------------------------");
            }
            
            
            switch(choice){
                case 1:
                    while(true){
                        choice2=ValidateChoice2(input);
                        if(choice2<1 || choice2>3){
                            System.out.println("\t!!!Invalid Input!!!\nTry Again:");
                        }else if(ArrLim==0 && choice2==2){
                            System.out.println("Must Enter a Limit to Employee First!\nTry Again:");
                        }else{
                            System.out.println("+-----------------------------------------------------------");
                            break;   
                        }
                        System.out.println("+-----------------------------------------------------------");
                    }
                    switch(choice2){
                        case 1:
                            while(true){
                                ArrLim=ValidateArrLim(input);
                                if(ArrLim<1){
                                    System.out.println("\t!!!Invalid Input!!!\nTry Again:");
                                }else{
                                    s2=new Salaries[ArrLim];
                                    System.out.println("+-----------------------------------------------------------");
                                    break;
                                }
                                System.out.println("+-----------------------------------------------------------");
                            }
                        break;
                        case 2:
                            while(true){
                                Employee=ValidateEmployee(input);
                                if(Employee<1){
                                    System.out.println("\t!!!Invalid Input!!!\nTry Again:");
                                }else if(Employee>ArrLim){
                                    System.out.println("\t!!!Limit is "+ArrLim+"!!!\nEdit Your Limit/Try Again!");
                                }else{
                                    System.out.println("+-----------------------------------------------------------");
                                    break;
                                }
                                System.out.println("+-----------------------------------------------------------");
                            }
                            for(int x=0; x<Employee; x++){
                                String id;
                                boolean duplicatedID;
                                while(true){
                                    duplicatedID=false;
                                    System.out.print("|\tID: ");
                                    id = input.next();
                                    for(int i=0; i<v234; i++){
                                        if(s2[i].id.equals(id)){
                                            System.out.println("\t!!!ID *"+id+"* Already Exist!!!\nTry Again: ");
                                            duplicatedID=true;
                                            break;
                                        }
                                    }
                                    if(!duplicatedID){
                                        break;
                                    }
                                }
                                System.out.print("|\tName: ");
                                String name = input.next();
                                System.out.print("|\tRate (Hourly): ");
                                double rh = input.nextDouble();
                                System.out.print("|\tHours Worked: ");
                                int hw= input.nextInt();
                                System.out.print("|\tReduction: ");
                                double rd= input.nextDouble();
                                System.out.println("+-----------------------------------------------------------");
                                double gross = rh*hw;
                                double net = gross-rd;
                                Tgross += gross;
                                Tred += rd;
                                Tnet += net;
                                s2[x]=new Salaries();
                                s2[x].info(id, name, rh, rd, gross, net, hw);
                                s2[x].info2(Tgross, Tred, Tnet);
                                v234+=1;
                            }
                        break;
                    }
                break;
                
                case 2:
                    System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|", "ID", "Name", "Rate", "Hours", "Gross", "Reduction", "NetPay");
                    for(int x=0; x<v234; x++){
                        s2[x].view();
                    }
                    System.out.println("");
                break;
                
                case 3:
                    System.out.print("Enter Employee ID to Edit: ");
                    String EditID=input.next();
                    boolean getID= false;
                    for(int x=0; x<v234; x++){
                        if(s2[x].id.equals(EditID)){
                            getID=true;
                            System.out.print("|\tNew ID: ");
                            String newId = input.next();
                            System.out.print("|\tNew Name: ");
                            String newName = input.next();
                            System.out.print("|\tNew Rate (Hourly): ");
                            double newRh = input.nextDouble();
                            System.out.print("|\tNew Hours Worked: ");
                            int newHw = input.nextInt();
                            System.out.print("|\tNew Reduction: ");
                            double newRd = input.nextDouble();
                            double newGross = newRh * newHw;
                            double newNet = newGross - newRd;
                            
                            s2[x].edit(newId, newName, newRh, newHw, newRd, newGross, newNet);
                            System.out.println("Employee Information Updated!");
                            break;
                        }
                    }
                    if(!getID){
                        System.out.println("Employee With ID "+EditID+" not Found!");
                    }
                    System.out.println("+-----------------------------------------------------------");
                break;
                
                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    String DeleteID = input.next();
                    boolean getDelete = false;
                    for (int x = 0; x < v234; x++) {
                        if (s2[x].id.equals(DeleteID)) {
                            getDelete = true;
                            for (int i = x; i < v234 - 1; i++) {
                                s2[i] = s2[i + 1];
                            }
                            s2[v234 - 1] = null;
                            v234--;
                            System.out.println("Employee with ID " +DeleteID+ " has been deleted.");
                            break;
                        }
                    }
                    if (!getDelete) {
                        System.out.println("Employee with ID " +DeleteID+ " not found.");
                    }
                    System.out.println("+-----------------------------------------------------------");
                break;
                
                default:
                    Tagain=false;
                break;
                
            }
        }while(Tagain);
        System.out.println("Thank You For Using This APP!");
        
    }
    public static int ValidateChoice(Scanner input){
        int choice;
        while(true){
            System.out.print("\t***Start Page***"
                    + "\n\t1. Add"
                    + "\n\t2. View"
                    + "\n\t3. Edit"
                    + "\n\t4. Delete"
                    + "\n\t5. Exit"
                    + "\nEnter Choice: ");
            try{
                choice = input.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("\t!!!Invalid Character!!!\nTry Again:");
                input.next();
                System.out.println("+-----------------------------------------------------------");
            }
        }
        return choice;
    }
    public static int ValidateChoice2(Scanner input){
        int choice2;
        while(true){
            System.out.print("Select Option:"
                    + "\n\t1. Add/Edit Limit To Employee"
                    + "\n\t2. Add Employee"
                    + "\n\t3. Back"
                    + "\nEnter Choice: ");
            try{
                choice2=input.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("\t!!!Invalid Character!!!\nTry Again:");
                input.next();
                System.out.println("+-----------------------------------------------------------");
            }
            
        }
        return choice2;
    }
    public static int ValidateArrLim(Scanner input){
        int ArrLim;
        while(true){
            System.out.print("Enter Employee Limit: ");
            try{
                ArrLim=input.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("\t!!!Invalid Character!!!\nTry Again:");
                input.next();
                System.out.println("+-----------------------------------------------------------");
            }
        }
        return ArrLim;
    }
    public static int ValidateEmployee(Scanner input){
        int Employee;
        while(true){
            System.out.print("Enter Number of Employee: ");
            try{
                Employee=input.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("\t!!!Invalid Character!!!\nTry Again:");
                input.next();
                System.out.println("+-----------------------------------------------------------");
            }
        }
        return Employee;
    }
}
