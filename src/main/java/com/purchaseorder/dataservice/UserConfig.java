package com.purchaseorder.dataservice;

import com.purchaseorder.dataservice.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.purchaseorder.dataservice.model.User.userType.*;

@Configuration
public class UserConfig {

    @Bean(name = "userList")
    public List<User> function() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("n3333333", "Joe King", "joe.king9087@gmail.com", false, Normal));
        userList.add(new User("n2222222", "David Duffy", "david.duffy45129@gmail.com", false, Approver));
        userList.add(new User("n1111111", "karen", "Karen O\'Brien", false, Finance));
        return userList;
    }
}
