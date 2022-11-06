import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<user> AbankUsers = new ArrayList<>();
        user Kaan = new user("Kaan","Nakipoglu",1234,1111,700,1111,false);
        user Ahmet = new user("Ahmet","Veli",4321,2222,1000,2222,true);
        AbankUsers.add(Kaan);
        AbankUsers.add(Ahmet);
        bank Abank = new bank("Abank",AbankUsers);
        atm BostanliAbankATM = new atm("BostanliAbankATM",Abank,1000);

        BostanliAbankATM.check(Kaan);
        //For Testing
        System.out.println(Kaan.getMoneyInAccount());
        BostanliAbankATM.setMoneyInMachine(100);
        System.out.println(BostanliAbankATM.getMoneyInMachine());

        System.out.println(Ahmet.getMoneyInAccount());






    }
}
