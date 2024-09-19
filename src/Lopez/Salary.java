package Lopez;
import java.util.Scanner;
public class Salary {
    void salary(){
        Scanner s=new Scanner(System.in);
        int Tem=0;
        int noem=0;
        int salimit=0;
        Salaries[] sal=new Salaries[salimit];
        double[] Tgross = new double[salimit];
        double[] Tred = new double[salimit];
        double[] Tnet=new double[salimit];
        String[] id = new String[salimit];
        String[] name = new String[salimit];
        double[] rh = new double[salimit];
        int [] hw = new int[salimit];
        double[] rd = new double[salimit];
        double[] gross = new double[salimit];
        double[] net = new double[salimit];
        int choice, choice2;
        
        System.out.println("+-----------------------------------------------");
        System.out.println("|\tWelcome To Salary App");
        System.out.println("+-----------------------------------------------");
        do{
        System.out.print("|\t1. Add"
                + "\n|\t2. view"
                + "\n|\t3. Edit"
                + "\n|\t4. Delete"
                + "\n|\t5. Exit"
                + "\n|Enter Choice: ");
        choice = s.nextInt();
        System.out.println("+-----------------------------------------------");
        while(choice == 2 || choice == 3 || choice == 4){
            if(Tem==0){
                System.out.println("|Cant view, no file found!");
                System.out.print("|Enter Choice Again: ");
                choice=s.nextInt();
            }
        }
        
        switch(choice){
            case 1:
                System.out.print("|\tSelect:"
                        + "\n|\t1. Add Limit of Employee"
                        + "\n|\t2. Add Employee"
                        + "\n|\t3. Back"
                        + "\n|Enter Choice: ");
                choice2 = s.nextInt();
                while(choice2 == 2){
                    if(salimit == 0){
                        System.out.println("|\tEnter Limit of Employee First!");
                        System.out.print("|\tEnter Choice Again: ");
                        choice2 = s.nextInt();
                    }else{
                        break;
                    }
                }
                switch(choice2){
                    case 1:
                        System.out.print("|\tEnter Limit of Employee: ");
                        salimit=s.nextInt();
                    break;
                    case 2:
                        System.out.print("|\tEnter no. of Employee: ");
                        noem=s.nextInt();
                            while(salimit<noem){
                                System.out.println("|\tMax no. of Employee ["+salimit+"] only!");
                                System.out.print("|\tEnter Again: ");
                                noem=s.nextInt();
                            }
                                System.out.println("+----------------------------------------------------------------------------+");
                                for(int x=0; x<=noem; x++){
                                    System.out.println("| Enter Details of Employee "+(x+1));
                                    System.out.print("|\tID: ");
                                    id[x]=s.next();
                                    System.out.print("|\tName: ");
                                    name[x]=s.next();
                                    System.out.print("|\tRate (Hourly): ");
                                    rh[x]=s.nextDouble();
                                    System.out.print("|\tHours Worked: ");
                                    hw[x]=s.nextInt();
                                    System.out.print("|\tReduction: ");
                                    rd[x]=s.nextDouble();
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    gross[x]=rh[x]*hw[x];
                                    net[x]=gross[x]-rd[x];
                                    Tgross[x]+=gross[x];
                                    Tred[x]+=rd[x];
                                    Tnet[x]+=net[x];
                                    Tem+=1;

                                    sal[x] = new Salaries();
                                    sal[x].info(id[x], name[x], rh[x], rd[x], gross[x], net[x], hw[x], Tgross[x], Tred[x], Tnet[x], Tem);
                                }
                    break;
                    default:                        
                    break;
                }
            break;
            case 2:
                System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|", "ID", "Name", "Rate", "Hours", "Gross", "Reduction", "NetPay");
                for(int x=0; x<noem; x++){
                    sal[x].view();
                }
                for(int x=0; x<noem; x++){
                    System.out.println("\n+----------------------------------------------------------------------------+");
                    System.out.println("|\tTotal Salary Request: "+Tgross[x]);
                    System.out.println("|\tTotal Employee Reduction: "+Tred[x]);
                    System.out.println("|\tTotal Net Pay: "+Tnet[x]);
                    System.out.println("|\tNo. of Employee: "+Tem);
                    System.out.println("+----------------------------------------------------------------------------+");
                }
            break;
        }
        }while(choice!=5);
    }
}
