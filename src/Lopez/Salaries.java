package Lopez;
public class Salaries {
    String id, name;
    double rh,rd,gross,net,Tgross,Tred,Tnet;
    int hw,Tem;
    public void info(String id1,String name1,double rh1,double rd1,double gross1,double net1,int hw1,double Tgross,double Tred,double Tnet,int Tem){
        this.id=id1;
        this.name=name1;
        this.rh=rh1;
        this.rd=rd1;
        this.gross=gross1;
        this.net=net1;
        this.hw=hw1;
    }
    public void view(){
        System.out.printf("\n|%-10s|%-10s|%-10.2f|%-10d|%-10.2f|%-10.2f|%-10.2f|", this.id, this.name, this.rh, this.hw, this.gross, this.rd, this.net);
    }
}
