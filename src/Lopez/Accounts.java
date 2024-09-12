package Lopez;

public class Accounts {
    String ID, FNAME, LNAME, EMAIL, UNAME, PASSWORD;
    int noa;
    public void add(String id, String fname, String lname, String email, String uname, String pass, int noas){
        this.ID=id;
        this.FNAME=fname;
        this.LNAME=lname;
        this.EMAIL=email;
        this.UNAME=uname;
        this.PASSWORD=pass;
        this.noa=noas;
    }
    public void view(){
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |"
                ,this.noa,this.ID,this.FNAME,this.LNAME,this.EMAIL,this.UNAME,this.PASSWORD);
    }
}
