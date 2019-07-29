package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
}
