package com.tts.ecommerce.models;

import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "Username cannot be empty")
    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
    private String username;

    @Length(min = 5, message = "Your password must have at least 5 characters")
    private String password;

    @ElementCollection
    private HashMap<Product, Integer> cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(HashMap<Product, Integer> cart) {
        this.cart = cart;
    }

    public User(Long id,
            @NotEmpty(message = "Username cannot be empty") @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces") String username,
            @Length(min = 5, message = "Your password must have at least 5 characters") String password,
            HashMap<Product, Integer> cart) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }


    // public class UserDetailsService {
    //     // UserDetails requires these, they are technically getters (is-ers?) overridden by Lombok.
    //   // @Transient Makes it so these aren't persisted in the database, as they are hard coded.
    //   @Transient
    //   private boolean accountNonExpired = true;
    //   @Transient
    //   private boolean accountNonLocked = true;
    //   @Transient
    //   private boolean credentialsNonExpired = true;
    //   @Transient
    //   private boolean enabled = true;
    //   @Transient
    //   private Collection<GrantedAuthority> authorities = null;
    // }
    

}
