package apap.tk.finvest.service;

import java.util.List;
import java.util.Optional;

import apap.tk.finvest.model.SubkategoriModel;

public interface SubkategoriService {
    List<SubkategoriModel> getListSubkategori();

    Optional<SubkategoriModel> getSubkategoriByUuid(Integer uuid);

    SubkategoriModel addSubkategori(SubkategoriModel subkategori);

    SubkategoriModel updateSubkategori(SubkategoriModel subkategori);

    void deleteSubkategori(Integer uuid);
}
