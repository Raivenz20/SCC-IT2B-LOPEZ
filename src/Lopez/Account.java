package Lopez;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Account {
    public void Input(){
        Scanner sc=new Scanner(System.in);
        int noa = validatenoa(sc);
        String[] ID=new String[noa];
        String[] FNAME=new String[noa];
        String[] LNAME=new String[noa];
        String[] EMAIL=new String[noa];
        String[] UNAME=new String[noa];
        String[] PASSWORD=new String[noa];
        Accounts[] acc2 = new Accounts[noa];
        
        for(int x=0; x<noa; x++){
            System.out.println("\n-----------------------------------------------------------------");
            System.out.print("ID: ");
            while(true){
                String newid=sc.next();
                if(validateID(ID, newid, noa)){
                    ID[x]=newid;
                    break;
                }else{
                    System.out.print("Try Again: ");
                }
            }
            System.out.print("First Name: ");
            while(true){
                String newfname=sc.next();
                if(validateFName(FNAME, newfname, noa)){
                    FNAME[x]=newfname;
                    break;
                }else{
                    System.out.print("Try Again: ");
                }
            }
            System.out.print("Last Name: ");
            LNAME[x]=sc.next();
            System.out.print("Email: ");
            while(true){
                String newemail=sc.next();
                if(validateEmail(EMAIL, newemail, noa)){
                    EMAIL[x]=newemail;
                    break;
                }else{
                    System.out.print("Try Again: ");
                }
            }
            System.out.print("User Name: ");
            while(true){
                String newuname=sc.next();
                if(validateUName(UNAME, newuname, noa)){
                    UNAME[x]=newuname;
                    break;
                }else{
                    System.out.print("Try Again: ");
                }
            }
            System.out.print("Password: ");
            while(true){
                String newpass=sc.next();
                if(validatePass(PASSWORD, newpass, noa)){
                    PASSWORD[x]=newpass;
                    break;
                }else{
                    System.out.print("Try Again: ");
                }
            }
            acc2[x]=new Accounts();
            acc2[x].add(ID[x], FNAME[x], LNAME[x], EMAIL[x], UNAME[x], PASSWORD[x], noa);
        }
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |"
                ,"Acc no.","ID","First Name","Last Name","Email","User Name","Password");
        
        for(int x=0; x<noa; x++){
            acc2[x].view();
        }
    }
    public static int validatenoa(Scanner sc){
        int noa = 0;
        while(true){
            System.out.print("Enter no. of Accounts: ");
            try{
                noa = sc.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("Invalid Character!");
                sc.next();
            }
        }
        return noa;
    }
    public static boolean validateID(String[] ID, String newid, int noa){
        for(int x=0;x<noa;x++){
            if(newid.equals(ID[x])){
                return false;
            }
        }
        return true;
    }
    public static boolean validateFName(String[] FNAME, String newfname, int noa){
        for(int x=0;x<noa;x++){
            if(newfname.equals(FNAME[x])){
                return false;
            }
        }
        return true;
    }
    public static boolean validateEmail(String[] EMAIL, String newemail, int noa){
        for(int x=0;x<noa;x++){
            if(newemail.equals(EMAIL[x])){
                return false;
            }
        }
        return true;
    }
    public static boolean validateUName(String[] UNAME, String newuname, int noa){
        for(int x=0;x<noa;x++){
            if(newuname.equals(UNAME[x])){
                return false;
            }
        }
        return true;
    }
    public static boolean validatePass(String[] PASSWORD, String newpass, int noa){
        for(int x=0; x<noa; x++){
            if(newpass.equals(PASSWORD[x])){
                return false;
            }
            if(newpass.length()<8){
                return false;
            }
            boolean hasUpperCase = false;
            for(int i=0; i<newpass.length();i++){
                if(Character.isUpperCase(newpass.charAt(i))){
                    hasUpperCase=true;
                    break;
                }
            }
            if(!hasUpperCase){
                return false;
            }
            boolean hasLowerCase = false;
            for(int i=0; i<newpass.length();i++){
                if(Character.isLowerCase(newpass.charAt(i))){
                    hasLowerCase = true;
                    break;
                }
            }
            if(!hasLowerCase){
                return false;
            }
            boolean hasNumber = false;
            for(int i=0; i<newpass.length(); i++){
                if(Character.isDigit(newpass.charAt(i))){
                    hasNumber = true;
                    break;
                }
            }
            if(!hasNumber){
                return false;
            }
            String[] Common={"admin","1234","mike"};
            for(String notCommon : Common){
                if(newpass.contains(notCommon)){
                    return false;
                }
            }
            String SpecialChar = "!@#$%^&*()_-+=<,>.?/:;{[}]|";
            boolean hasSpecialCharacter = false;
            for (int i = 0; i < newpass.length(); i++) {
                if (SpecialChar.indexOf(newpass.charAt(i)) >= 0) {
                    hasSpecialCharacter = true;
                    break;
                }
            }
            if(!hasSpecialCharacter){
                return false;
            }
        }
        return true;
    }
}
