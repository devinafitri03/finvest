package apap.tk.finvest.service;

import apap.tk.finvest.model.ProjectModel;
import apap.tk.finvest.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel addUser(UserModel user);

    public String encrypt(String password);

    List<UserModel> getListUser();

    Optional<UserModel> getUserByUuid(Integer uuid);

    UserModel updateUser(UserModel user);

    void deleteUser(UserModel user);

    UserModel getUserByUsername(String username);

    UserModel getUserByIdUser(Integer uuid);

}
