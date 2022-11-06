import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class atm {
    private String name;
    private bank bank;
    private float moneyInMachine;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public bank getBank() {
        return bank;
    }

    public void setBank(bank bank) {
        this.bank = bank;
    }

    public float getMoneyInMachine() {
        return moneyInMachine;
    }

    public void setMoneyInMachine(float moneyInMachine) {
        this.moneyInMachine = moneyInMachine;
    }

    public atm(String name, bank bank, float moneyInMachine) {
        this.name = name;
        this.bank = bank;
        this.moneyInMachine = moneyInMachine;
    }
    public void check(user a){
        int tempPass;
        int failedPassCounter=3;
        boolean showOperation = false;
        int selection;

        Scanner myObj = new Scanner(System.in);
        if(a.isCustomerDeclined()){
            System.out.println("Your account has blocked please contact with Customer Services");

        }
        else{
            System.out.println("Hello, " + a.getName() + " " + a.getSurName());
            while(failedPassCounter != 0){
                System.out.println("Please enter your password: ");
                tempPass = myObj.nextInt();
                if (tempPass == a.getPassword() ) {
                    System.out.println("Password Correct! Please choose your operation.");
                    showOperation = true;
                    failedPassCounter =0;

                }
                else{
                    System.out.println("You have entered your password wrong! You have " + (failedPassCounter-1) + " tries left.");
                    failedPassCounter--;

                }

            }
            while (showOperation){
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Transfer Money");
                System.out.println("4. Exit");
                selection = myObj.nextInt();
                switch (selection){
                    case 1:
                        depositMoney(a);
                        break;
                    case 2:
                        withdrawMoney(a);
                        break;
                    case 3:
                        transferMoney(a);
                        break;
                    case 4:
                        showOperation= false;
                        break;
                }
            }
        }

    }
    public void depositMoney(user a){
        Scanner myObj = new Scanner(System.in);
        float ammountGiven;
        System.out.println("Please Enter the amount you are going the deposit"); //Mimicking the money insertion in real life
        System.out.println("Current Balance: " + a.getMoneyInAccount());
        ammountGiven = myObj.nextFloat();
        a.setMoneyInAccount(a.getMoneyInAccount()+ ammountGiven);
        setMoneyInMachine(getMoneyInMachine() + ammountGiven);
        System.out.println("Money has deposited!");
        System.out.println("Current Balance: " + a.getMoneyInAccount());
    }

    public void withdrawMoney(user a){
        Scanner myObj = new Scanner(System.in);
        float withdrawAmount;
        boolean z=true;
        while (z){
            System.out.println("Please Enter the amount you are going to withdraw: ");
            System.out.println("Current Balance: " + a.getMoneyInAccount());
            withdrawAmount = myObj.nextFloat();
            if(withdrawAmount > a.getMoneyInAccount() || withdrawAmount > getMoneyInMachine()){
                System.out.println("Amount is not possible");
                z=false;
            }
            else{
                a.setMoneyInAccount(a.getMoneyInAccount()-withdrawAmount);
                setMoneyInMachine(getMoneyInMachine()-withdrawAmount);
                System.out.println("Money is given! ");
                z=false;
            }
        }
        System.out.println("Current Balance: " + a.getMoneyInAccount());}

        public void transferMoney(user a){
            boolean z=true;
            boolean isUserValid = false;
            ArrayList<user> users= new ArrayList<>();
            users = getBank().getUsers();
        user SelectedUser=null;
        Scanner myobj = new Scanner(System.in);
                System.out.println("Please enter the money amount you are going to transfer");
                System.out.println("Current Balance: " + a.getMoneyInAccount());
                float amount = myobj.nextFloat();
                if(amount > a.getMoneyInAccount()){
                    System.out.println("Amount is not possible");
                    z=false;
                }
                else{
                    System.out.println("Please enter the ID of the account you are going to transfer money: ");
                    int cusID = myobj.nextInt();

                    for(int i=0;i<users.size();i++){
                        if(users.get(i).getCustomerId()==cusID){
                            SelectedUser =users.get(i);
                            isUserValid = true;
                        }

                        }
                    if (isUserValid){
                        System.out.println("Please Verify the user.Yes/No");
                        System.out.println(SelectedUser.getName() + " " + SelectedUser.getSurName());
                        String answer = myobj.next();
                        if(answer.equals("Yes")){
                            a.setMoneyInAccount(a.getMoneyInAccount()-amount);
                            SelectedUser.setMoneyInAccount(SelectedUser.getMoneyInAccount()+amount);
                            System.out.println("Transfer is Successful");
                            System.out.println("Current Balance: " + a.getMoneyInAccount());

                        }
                        else{
                            System.out.println("Please be sure that ID you are typing is correct");
                        }

                    }
                    else {
                        System.out.println("There's no such a user");
                    }

                }

            }













   }






