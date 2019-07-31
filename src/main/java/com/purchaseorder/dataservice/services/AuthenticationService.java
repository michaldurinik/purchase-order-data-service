package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.User;
import com.purchaseorder.dataservice.model.LoginUser;
import com.purchaseorder.dataservice.passwordStorage.StoredPasswords;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static com.purchaseorder.dataservice.services.SecretGenerator.generateSecret;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationService {


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
    public ResponseEntity<User> byName(@RequestBody LoginUser loginUser, StoredPasswords storedPasswords) {

        Optional<User> currentUser = findUser(loginUser.getNnumber());

        if (storedPasswords.isValid(loginUser.getNnumber(), loginUser.getPassword())) {
            currentUser.get().authenticate();
            currentUser.get().setSecret(generateSecret());

            return currentUser.map(ResponseEntity::ok)
                    .orElse(notFound().build());
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
