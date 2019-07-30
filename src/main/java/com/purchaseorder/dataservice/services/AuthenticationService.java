package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.User;
import com.purchaseorder.dataservice.model.UserLogin;
import com.purchaseorder.dataservice.passwordStorage.UserPasswords;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationService {

    SecretGenerator secretGenerator;

    private Optional<User> findUser(String nnumber) {
       return userList.stream()
                .filter(p -> p.getNnumber().equals(nnumber))
                .findFirst();
    }

    @Resource(name = "userList")
    private List<User> userList;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> allUsers() {
        return userList;
    }

    @RequestMapping(
            method = RequestMethod.POST
    )

    public ResponseEntity<User> byName(@RequestBody UserLogin userLogin,
                                       UserPasswords userPasswords) {

        Optional<User> currentUser = findUser(userLogin.getNnumber());

        if (userPasswords.isValid(userLogin.getNnumber(), userLogin.getPassword())) {
            currentUser.get().authenticate();
            currentUser.get().setSecret("something");

            return currentUser.map(ResponseEntity::ok)
                    .orElse(notFound().build());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
