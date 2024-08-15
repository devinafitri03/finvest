package apap.tk.finvest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "investor")
public class InvestorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_investor", nullable = false)
    private String namaInvestor;

    @OneToMany(mappedBy = "uuid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InvestasiModel> investasiList;

    @OneToMany(mappedBy = "investor")
    List<UserModel> userList;

}
