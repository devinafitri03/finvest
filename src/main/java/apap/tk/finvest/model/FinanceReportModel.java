package apap.tk.finvest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finance_report")
public class FinanceReportModel {
    @Id
    @NotNull
    @Column(name = "proyek", nullable = false)
    private Integer proyek;

    @NotNull
    @Column(name = "periode_fiskal", nullable = false)
    private Integer periode_fiskal;

    @NotNull
    @Column(name = "tahun_fiskal", nullable = false)
    private Integer tahun_fiskal;

    @NotNull
    @Column(name = "total_revenue", nullable = false)
    private Integer total_revenue;

    @NotNull
    @Column(name = "operating_expense", nullable = false)
    private Integer operating_expense;

    @NotNull
    @Column(name = "tax", nullable = false)
    private Float tax;

    @NotNull
    @Column(name = "net_profit", nullable = false)
    private Integer net_profit;

    @NotNull
    @Column(name = "jumlah_investor", nullable = false)
    private Integer jumlah_investor;
}
