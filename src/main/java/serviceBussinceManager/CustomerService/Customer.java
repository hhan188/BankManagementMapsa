package serviceBussinceManager.CustomerService;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import serviceBussinceManager.AccountingService.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Customer {
    @Id
    @Column(name = "Customer_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CustomerNumber")
    private String customerNumber;
    @Column(name = "status")
    private boolean status = true;
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "Account_Costumer",
            joinColumns = @JoinColumn(name = "Customer_Id"),
            inverseJoinColumns = @JoinColumn(name = "Account_Id")
    )
    private Set<Account> accounts = new HashSet<>();

    public Customer(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
