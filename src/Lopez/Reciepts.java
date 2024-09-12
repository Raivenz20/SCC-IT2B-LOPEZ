package Lopez;
import java.util.Scanner;
public class Reciepts {
    void reciept(){
        Scanner s = new Scanner(System.in);
        System.out.print("Customer Name: ");
        String name = s.nextLine();
        System.out.print("Product Name: ");
        String item = s.nextLine();
        System.out.print("Quantity: ");
        int quan = s.nextInt();
        System.out.print("Price: ");
        int price = s.nextInt();
        System.out.print("Cash: ");
        int cash = s.nextInt();
        System.out.println("\n----------------------------------------------");
        System.out.println("RECEIPT");
        System.out.println("----------------------------------------------");
        System.out.println("Name: "+name);
        System.out.println("Item: "+item);
        System.out.println("Quantity: "+quan);
        System.out.println("----------------------------------------------");
        System.out.println("Total Due: "+(price*quan));
        System.out.println("Cash: "+cash);
        System.out.println("----------------------------------------------");
        System.out.println("Change: "+(cash-(price*quan)));
    }
}
