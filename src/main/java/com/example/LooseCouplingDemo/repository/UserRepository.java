package com.example.LooseCouplingDemo.repository;

import com.example.LooseCouplingDemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
