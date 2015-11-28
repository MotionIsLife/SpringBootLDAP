package fr.julien.springbootldap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by julien on 28/11/15.
 */
@RestController
public class RestServices {

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/logged")
    public Principal user(Principal user) {
        return user;
    }

}