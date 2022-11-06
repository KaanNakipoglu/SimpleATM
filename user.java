public class user {
    private String name;
    private String surName;
    private int password;
    private int cardNumber;
    private float moneyInAccount;
    private int customerId;
    private boolean customerDeclined;

    public boolean isCustomerDeclined() {
        return customerDeclined;
    }

    public void setCustomerDeclined(boolean customerDeclined) {
        this.customerDeclined = customerDeclined;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(float moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    public user(String name, String surName, int password, int cardNumber, float moneyInAccount,int customerId, boolean customerDeclined) {
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.cardNumber = cardNumber;
        this.moneyInAccount = moneyInAccount;
        this.customerId= customerId;
        this.customerDeclined = customerDeclined;
    }


}
