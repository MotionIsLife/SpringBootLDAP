package fr.julien.springbootldap;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

/**
 * Created by julien on 28/11/15.
 */
@RestController
public class RestServices {

    @RequestMapping("/")
    public String index(Principal user) {
        return "Welcome " + user.getName() + "!";
    }

    @RequestMapping("/logged")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/roles")
    public Collection<? extends GrantedAuthority> roles(Principal principal) {
        UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
        Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
        return authorities;
    }

    @Secured("ROLE_DEVELOPERS")
    @RequestMapping("/hello")
    public String hello() {
        return "Hello is granted! ;)";
    }

}