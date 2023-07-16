package serviceBussinceManager.CustomerService;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import serviceBussinceManager.AccountingService.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer
{
    @Id
    @Column(name = "Customer_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerNumber;
    @Column(name = "status")
    private boolean status;
    @ManyToMany(cascade = {
CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "Account_Costumer",
            joinColumns = @JoinColumn(name = "Customer_Id"),
            inverseJoinColumns = @JoinColumn(name = "Account_Id")
    )
    private Set<Account> accounts =new HashSet<>();

    public Customer(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}
