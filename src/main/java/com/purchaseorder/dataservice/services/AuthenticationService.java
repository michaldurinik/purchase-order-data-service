package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.User;
import com.purchaseorder.dataservice.model.UserLogin;
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

    @Resource(name = "userList")
    private List<User> userList;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> allUsers() {
        return userList;
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<User> byName(@RequestBody UserLogin userLogin) {
        Optional<User> user = userList.stream()
                .filter(p -> p.getNnumber().equals(userLogin.getNnumber()))
                .findFirst();

        return user.map(ResponseEntity::ok)
                .orElse(notFound().build());
    }
}
