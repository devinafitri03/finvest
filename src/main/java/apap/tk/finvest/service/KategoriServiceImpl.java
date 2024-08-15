package apap.tk.finvest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tk.finvest.model.KategoriModel;
import apap.tk.finvest.repository.KategoriDb;

@Service
public class KategoriServiceImpl implements KategoriService {

    @Autowired
    private KategoriDb kategoriDb;

    @Override
    public List<KategoriModel> getListKategori() {
        return kategoriDb.findAll();
    }

    @Override
    public Optional<KategoriModel> getKategoriByUuid(Integer uuid) {
        return kategoriDb.findById(uuid);
    }

    @Override
    public KategoriModel addKategori(KategoriModel kategori) {
        return kategoriDb.save(kategori);
    }

    @Override
    public KategoriModel updateKategori(KategoriModel kategori) {
        return kategoriDb.save(kategori);
    }

    @Override
    public void deleteKategori(Integer uuid) {
        kategoriDb.deleteById(uuid);
    }
}
