package com.imloves.repository;

import com.imloves.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/20 9:47
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(nativeQuery = true, value = "SELECT r.role_name FROM customer_role cr LEFT JOIN role r ON cr.ROLE_ID = r.role_id LEFT JOIN customer c ON cr.CUSTOMER_ID = c.customer_id WHERE c.customer_id = ( SELECT customer_id FROM customer WHERE phone = :phone )")
    List<String> findRoleNamesByPhone(@Param("phone") String phone);
}
