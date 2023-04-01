import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private String tran_id;
    private LocalDate date;
    private LocalTime time;
    private Double balance;

    public Transaction(String tran_id, LocalDate date, LocalTime time, Double balance) {
        this.tran_id = tran_id;
        this.date = date;
        this.time = time;
        this.balance = balance;
    }
}
