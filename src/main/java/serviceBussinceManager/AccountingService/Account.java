package serviceBussinceManager.AccountingService;


import lombok.*;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;
import serviceBussinceManager.TransactionManagmentService.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "Account_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "AccountNumber")
    private String Account_number;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @ManyToMany(mappedBy = "accounts")
    private Set<Customer> customers = new HashSet<>();
    @Column(name = "status")
    private boolean status=true;

    public Account(String account_number) {
        Account_number = account_number;
    }
}
