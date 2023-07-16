package serviceBussinceManager.TransactionManagmentService;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import serviceBussinceManager.AccountingService.Account;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
