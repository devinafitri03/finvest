package apap.tk.finvest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tk.finvest.model.KategoriModel;

@Repository
public interface KategoriDb extends JpaRepository<KategoriModel, Integer> {
    List<KategoriModel> findAll();
}
