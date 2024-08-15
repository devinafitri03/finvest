package apap.tk.finvest.service;

import java.util.List;
import java.util.Optional;

import apap.tk.finvest.model.KategoriModel;

public interface KategoriService {
    List<KategoriModel> getListKategori();

    Optional<KategoriModel> getKategoriByUuid(Integer uuid);

    KategoriModel addKategori(KategoriModel kategori);

    KategoriModel updateKategori(KategoriModel kategori);

    void deleteKategori(Integer uuid);
}
