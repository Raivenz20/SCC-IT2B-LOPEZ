package Lopez;
import java.util.Scanner;
public class Salary {
    void salary(){
        Scanner s=new Scanner(System.in);
        
        double Tgross=0,Tred=0,Tnet=0;
        int Tem=0,noem,tagain;
        
        System.out.print("Enter Limit of Employee: ");
        int salimit=s.nextInt();
        Salaries[] sal=new Salaries[salimit];
        do{
            System.out.print("Enter no. of Employee: ");
            while(true){
                noem=s.nextInt();
                if(salimit<noem){
                    System.out.println("Max no. of Employee ["+salimit+"] only!");
                    System.out.print("Enter Again: ");
                }else{
                    break;
                }
            }
            System.out.println("+----------------------------------------------------------------------------+");
            for(int x=0; x<noem; x++){
                System.out.println("| Enter Details of Employee "+(x+1));
                System.out.print("|\tID: ");
                String id=s.next();
                System.out.print("|\tName: ");
                String name=s.next();
                System.out.print("|\tRate (Hourly): ");
                double rh=s.nextDouble();
                System.out.print("|\tHours Worked: ");
                int hw=s.nextInt();
                System.out.print("|\tReduction: ");
                double rd=s.nextDouble();
                System.out.println("+----------------------------------------------------------------------------+");
                double gross=rh*hw;
                double net=gross-rd;
                Tgross+=gross;
                Tred+=rd;
                Tnet+=net;
                Tem+=1;

                sal[x] = new Salaries();
                sal[x].info(id, name, rh, rd, gross, net, hw, Tgross, Tred, Tnet, Tem);
            }
            System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|", "ID", "Name", "Rate", "Hours", "Gross", "Reduction", "NetPay");
            for(int x=0; x<noem; x++){
                sal[x].view();
            }
            System.out.println("\n+----------------------------------------------------------------------------+");
            System.out.println("|\tTotal Salary Request: "+Tgross);
            System.out.println("|\tTotal Employee Reduction: "+Tred);
            System.out.println("|\tTotal Net Pay: "+Tnet);
            System.out.println("|\tNo. of Employee: "+Tem);
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.print("Try Again? (1/0): ");
            tagain=s.nextInt();
        }while(tagain!=0);
        System.out.println("EXITED! Thanks for using the System!");
    }
}
