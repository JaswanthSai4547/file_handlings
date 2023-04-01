import java.util.ArrayList;

public class Bank {
    private String name;
    private int pn;
    private String address;
    private long ac_no;
    private String email;
    private double balance;
    private static ArrayList<Bank> bankobj = new ArrayList<>();
    public ArrayList<Transaction> transaction_list=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAc_no() {
        return ac_no;
    }

    public void setAc_no(long ac_no) {
        this.ac_no = ac_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static ArrayList<Bank> getBankobj() {
        return bankobj;
    }

    public static void setBankobj(ArrayList<Bank> bankobj) {
        Bank.bankobj = bankobj;
    }

    public ArrayList<Transaction> getTransaction_list() {
        return transaction_list;
    }

    public void setTransaction_list(ArrayList<Transaction> transaction_list) {
        this.transaction_list = transaction_list;
    }

    public Bank(String name, int pn, String address, long ac_no, String email) {
        this.name = name;
        this.pn = pn;
        this.address = address;
        this.ac_no = ac_no;
        this.email = email;
    }
}
