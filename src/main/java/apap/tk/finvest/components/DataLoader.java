package apap.tk.finvest.components;

import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.KategoriModel;
import apap.tk.finvest.model.PeranModel;
import apap.tk.finvest.model.SubkategoriModel;
import apap.tk.finvest.model.UserModel;
import apap.tk.finvest.repository.KategoriDb;
import apap.tk.finvest.repository.PeranDb;
import apap.tk.finvest.repository.SubkategoriDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {
    private PeranDb peranDb;
    private KategoriDb kategoriDb;
    private SubkategoriDb subkategoriDb;


    @Autowired
    public DataLoader (PeranDb peranDb, KategoriDb kategoriDb, SubkategoriDb subkategoriDb){
        this.peranDb = peranDb;
        this.kategoriDb = kategoriDb;
        this.subkategoriDb = subkategoriDb;
    }

    public void run(ApplicationArguments args) {
        peranDb.save(new PeranModel(1, "Direksi", new ArrayList<UserModel>()));
        peranDb.save(new PeranModel(2, "Keuangan", new ArrayList<UserModel>()));
        peranDb.save(new PeranModel(3, "Admin", new ArrayList<UserModel>()));
        peranDb.save(new PeranModel(4, "Legal", new ArrayList<UserModel>()));
        peranDb.save(new PeranModel(5, "Investor", new ArrayList<UserModel>()));

        kategoriDb.save(new KategoriModel(1, "Keuangan", new ArrayList<CompanyModel>()));
        kategoriDb.save(new KategoriModel(2, "Sumber Daya Manusia", new ArrayList<CompanyModel>()));
        kategoriDb.save(new KategoriModel(3, "Pemasaran", new ArrayList<CompanyModel>()));
        kategoriDb.save(new KategoriModel(4, "Teknologi Informasi", new ArrayList<CompanyModel>()));
        kategoriDb.save(new KategoriModel(5, "Operasional", new ArrayList<CompanyModel>()));
        kategoriDb.save(new KategoriModel(6, "Kesehatan", new ArrayList<CompanyModel>()));

        subkategoriDb.save(new SubkategoriModel(1, "Akuntansi", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(2, "Audit Internal", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(3, "Rekruitment", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(4, "Hubungan Masyarakat", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(5, "Manajemen Data", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(6, "K3", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(7, "Pengendalian Risiko", new ArrayList<CompanyModel>()));
        subkategoriDb.save(new SubkategoriModel(8, "Pengembangan Perangkat Lunak", new ArrayList<CompanyModel>()));
    }

}
