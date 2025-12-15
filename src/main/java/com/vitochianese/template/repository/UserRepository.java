package com.vitochianese.template.repository;

import com.vitochianese.template.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
