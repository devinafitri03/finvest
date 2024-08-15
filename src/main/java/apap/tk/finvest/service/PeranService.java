package apap.tk.finvest.service;

import apap.tk.finvest.model.PeranModel;
import java.util.List;

public interface PeranService {
    List<PeranModel> findAll();
    void addPeran(PeranModel peran);
}
