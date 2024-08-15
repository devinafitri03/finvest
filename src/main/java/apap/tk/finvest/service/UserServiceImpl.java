package apap.tk.finvest.service;

import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.ProjectModel;
import apap.tk.finvest.model.UserModel;
import apap.tk.finvest.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser(){
        return userDb.findAll();
    }


    @Override
    public Optional<UserModel> getUserByUuid(Integer uuid) {
        return userDb.findByUuid(uuid);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        userDb.save(user);
        return user;
    }

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public UserModel getUserByUsername(String username){return userDb.findByUsername(username);}

    @Override
    public UserModel getUserByIdUser(Integer uuid) {
        Optional<UserModel> user = userDb.findByUuid(uuid);
        if (user.isPresent()) {
            return user.get();
        } else
            return null;
    }
}

