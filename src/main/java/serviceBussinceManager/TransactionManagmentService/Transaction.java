package serviceBussinceManager.TransactionManagmentService;

import lombok.Data;
import serviceBussinceManager.AccountingService.Account;


import javax.persistence.*;

@Entity
@Data
public class Transaction {
    @Id
    @Column(name = "Transaction_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction(TransactionType transactionType) {
        this.transactionType = transactionType;
    }


}
