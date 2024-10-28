package com.example.user_service.repository;

import com.example.user_service.model.UserEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEnt,Long> {
}
