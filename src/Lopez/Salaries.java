package Lopez;
public class Salaries {
    String id, name;
    double rh,rd,gross,net,Tgross,Tred,Tnet;
    int hw,Tem;
    public void info(String id1,String name1,double rh1,double rd1,double gross1,double net1,int hw1){
        this.id=id1;
        this.name=name1;
        this.rh=rh1;
        this.rd=rd1;
        this.gross=gross1;
        this.net=net1;
        this.hw=hw1;
        this.Tgross+=gross1;
        this.Tred+=rd1;
        this.Tnet+=net1;
    }
    public void view(){
        System.out.printf("\n|%-10s|%-10s|%-10.2f|%-10d|%-10.2f|%-10.2f|%-10.2f|", this.id, this.name, this.rh, this.hw, this.gross, this.rd, this.net);
    }
    public void edit(String newId, String newName, double newRh, int newHw, double newRd, double newGross, double newNet) {
        this.Tgross-=this.gross;
        this.Tnet-=this.net;
        this.Tred-=this.rd;
        this.id = newId;
        this.name = newName;
        this.rh = newRh;
        this.hw = newHw;
        this.rd = newRd;
        this.gross= newGross;
        this.net= newNet;
        this.Tgross+=newGross;
        this.Tred+=newRd;
        this.Tnet+=newNet;
    }
}
