package com.imloves.service;

import com.imloves.model.Customer;
import com.imloves.repository.CustomerRepository;
import com.imloves.repository.RoleRepository;
import javafx.beans.property.SimpleListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/20 9:35
 */
@Component
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByPhone(phone);
        List<String> roleNames = roleRepository.findRoleNamesByPhone(phone);
        List<GrantedAuthority> authorities = new ArrayList<>();
        roleNames.forEach(name -> authorities.add(new SimpleGrantedAuthority(name)));
        User securityUser = new User(customer.getNickName(), customer.getPassword(), authorities);
        return securityUser;
    }
}
