package serviceBussinceManager.BaseBackService;

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
public class Branch
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Branch_Id")
    private Integer id;
    @Column(name = "Branch_Code")
    private String branchCode;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();
    @Column(name = "status")
    private boolean status;
    public Branch(String branchCode) {
        this.branchCode = branchCode;
    }
}
