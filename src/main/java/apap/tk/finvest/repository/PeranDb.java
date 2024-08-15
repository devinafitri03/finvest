package apap.tk.finvest.repository;

import apap.tk.finvest.model.PeranModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeranDb extends JpaRepository<PeranModel, Long> {
    List<PeranModel> findAll();
}
