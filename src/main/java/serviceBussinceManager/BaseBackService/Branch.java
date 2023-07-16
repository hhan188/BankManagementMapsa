package serviceBussinceManager.BaseBackService;

import lombok.Data;
import lombok.NoArgsConstructor;
import serviceBussinceManager.AccountingService.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Branch
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Branch_Id")
    private Integer id;
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