package apap.tk.finvest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @NotNull
    private String nama;

    @NotNull
    private String tahun_berdiri;

    private Integer perusahaan_induk;

    private Integer saldo_perusahaan;

    @Column(name = "status_perusahaan", nullable = false)
    @NotNull
    private String statusPerusahaan;

    @OneToMany(mappedBy = "uuid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<InvestasiModel> investasiList;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<ProjectModel> projects;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_kategori", referencedColumnName = "uuid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public KategoriModel kategori;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_subkategori", referencedColumnName = "uuid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public SubkategoriModel subkategori;

    public String getSubkategoriBisnisDisplay() {
        return subkategori == null ? "UTAMA" : subkategori.toString();
    }

    public Long getEstimatedProfitOfUnfinishedProject() {
        Long estimatedProfit = 0L;
        for (ProjectModel project : projects) {
            if (!project.getIsFinished()) {
                estimatedProfit += project.getEstimatedProfit();
            }
        }
        return estimatedProfit;
    }
}
