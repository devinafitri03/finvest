package apap.tk.finvest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tk.finvest.model.SubkategoriModel;
import apap.tk.finvest.repository.SubkategoriDb;

@Service
public class SubkategoriServiceImpl implements SubkategoriService {

    @Autowired
    private SubkategoriDb subkategoriDb;

    @Override
    public List<SubkategoriModel> getListSubkategori() {
        return subkategoriDb.findAll();
    }

    @Override
    public Optional<SubkategoriModel> getSubkategoriByUuid(Integer uuid) {
        return subkategoriDb.findById(uuid);
    }

    @Override
    public SubkategoriModel addSubkategori(SubkategoriModel subkategori) {
        return subkategoriDb.save(subkategori);
    }

    @Override
    public SubkategoriModel updateSubkategori(SubkategoriModel subkategori) {
        return subkategoriDb.save(subkategori);
    }

    @Override
    public void deleteSubkategori(Integer uuid) {
        subkategoriDb.deleteById(uuid);
    }

}
