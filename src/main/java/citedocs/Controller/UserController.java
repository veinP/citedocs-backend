package citedocs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import citedocs.Entity.UserEntity;
import citedocs.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userv;

    //C
    @PostMapping("/postUser")
    public UserEntity postUser(@RequestBody UserEntity user) {
        return userv.postUser(user);
    }

    //R
    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userv.getAllUsers();
    }

    //U
    @PutMapping("/updateUser")
    public UserEntity updateUser(@RequestParam int uid, @RequestBody UserEntity newUserDetails) {
        return userv.updateUser(uid, newUserDetails);
    }

    //D
    @DeleteMapping("/deletePayment/{uid}")
    public String deleteUser(@PathVariable int uid) {
        return userv.deleteUser(uid);
    }
}
