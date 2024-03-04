package com.example.LooseCouplingDemo.repository;

import com.example.LooseCouplingDemo.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {
    List<Messages> findAllByTypeIgnoreCase(String messageType);
}
