package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
