package com.brihaspathee.jwt.domain.repository;

import com.brihaspathee.jwt.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:19 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findRoleByRoleName(String roleName);
}
