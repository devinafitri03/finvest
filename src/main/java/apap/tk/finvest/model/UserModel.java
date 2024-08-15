package apap.tk.finvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class UserModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull 
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull 
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "is_main_ceo", nullable = false)
    private Integer isMainCeo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_role", referencedColumnName = "UUID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public PeranModel peran;

    @ManyToOne(fetch=FetchType.EAGER, optional = true)
    @JoinColumn(name="investor_id", referencedColumnName = "uuid", nullable = true)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private InvestorModel investor;

    @ManyToOne
    @JoinColumn(name = "id_company", referencedColumnName = "uuid")
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompanyModel company;
}
