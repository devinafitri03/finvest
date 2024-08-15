package apap.tk.finvest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="subkategori")
public class SubkategoriModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @NotNull
    private String nama;

    @OneToMany(mappedBy="subkategori", fetch=FetchType.LAZY)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<CompanyModel> companySubkategori;

}
