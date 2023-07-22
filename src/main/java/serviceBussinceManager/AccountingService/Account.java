package serviceBussinceManager.AccountingService;


import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

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
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="myEntityCache")
public class Account {
    @Id
    @Column(name = "Account_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "AccountNumber")
    private String AccountNumber;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @ManyToMany(mappedBy = "accounts")
    private Set<Customer> customers = new HashSet<>();
    @Column(name = "status")
    private boolean status=true;
    @Column(name="balance")
    private long balance;

    public Account(String account_number) {
        AccountNumber = account_number;
    }
}
