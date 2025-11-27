package citedocs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citedocs.Entity.UserEntity;
import citedocs.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository urepo;

    public UserService(UserRepository urepo){
        this.urepo = urepo;
    }
    
    //C
    public UserEntity postUser(UserEntity user) {
        return urepo.save(user);
    }

    //R
    public List<UserEntity> getAllUsers() {
        return urepo.findAll();
    }

    //U
    @SuppressWarnings("finally")
    public UserEntity updateUser(int uid, UserEntity newUserDetails) {
        UserEntity user = new UserEntity();

        try{
            //search
            user = urepo.findById(uid).get();

            //update
            user.setName(newUserDetails.getName());
            user.setEmail(newUserDetails.getEmail());
            user.setPassword(newUserDetails.getPassword());
            user.setRole(newUserDetails.getRole());
            user.setSid(newUserDetails.getSid());
            user.setAid(newUserDetails.getAid());
        }catch(NoSuchElementException e) {
            throw new NoSuchElementException("User " + uid + " does not exist!");
        }finally {
            return urepo.save(user);
        }
    }
    //D
    public String deleteUser(int uid) {
        String msg = "";

        if(urepo.findById(uid)!=null){
            urepo.deleteById(uid);
            msg = "User " + uid + " is successfully deleted!";
        } else {
            msg = "User " + uid + " does not exist!";
        }
        return msg;
    }
}
