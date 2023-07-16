package serviceBussinceManager.BaseBackService;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Set<Branch> branches = new HashSet<>();
    @Column(name = "status")
    private boolean status;
    public Bank(String name) {
        this.name = name;
    }
}
