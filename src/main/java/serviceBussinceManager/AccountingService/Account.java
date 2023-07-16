package serviceBussinceManager.AccountingService;


import lombok.Data;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;
import serviceBussinceManager.TransactionManagmentService.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Account {
    @Id
    @Column(name = "Account_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer Account_number;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @ManyToMany(mappedBy = "accounts")
    private Set<Customer> customers = new HashSet<>();
    @Column(name = "status")
    private boolean status;

    public Account(Integer account_number) {
        Account_number = account_number;
    }
}