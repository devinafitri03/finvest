package apap.tk.finvest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "investasi")
public class InvestasiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_investor", referencedColumnName = "uuid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private InvestorModel idInvestor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_perusahaan", referencedColumnName = "uuid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompanyModel idPerusahaan;

    @NotNull
    @Column(name = "jumlah_investasi", nullable = false)
    private Integer jumlahInvestasi;

    @NotNull
    @Column(name = "periode_fiskal", nullable = false)
    private Integer periodeFiskal;

    @NotNull
    @Column(name = "tahun_fiskal", nullable = false)
    private Integer tahunFiskal;


}

