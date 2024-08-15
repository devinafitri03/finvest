package apap.tk.finvest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tk.finvest.model.SubkategoriModel;

@Repository
public interface SubkategoriDb extends JpaRepository<SubkategoriModel, Integer> {
    List<SubkategoriModel> findAll();
}

