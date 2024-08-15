package apap.tk.finvest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @NotNull
    private String nama;

    @ManyToOne
    @JoinColumn(name = "id_kategori", referencedColumnName = "uuid")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private KategoriModel kategori;

    @ManyToOne
    @JoinColumn(name = "id_subkategori", referencedColumnName = "uuid")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private SubkategoriModel subkategori;

    @Column(name = "tanggal_mulai", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalSelesai;

    @ManyToOne
    @JoinColumn(name = "id_company", referencedColumnName = "uuid")
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompanyModel company;

    @Column(name = "estimated_profit", nullable = false)
    @NotNull
    private Integer estimatedProfit;

    @Column(name = "deskripsi", nullable = false)
    @NotNull
    private String deskripsi;

    @Column(name = "is_finished", nullable = false)
    @NotNull
    private Boolean isFinished;
}

