package com.example.demo_base.repository;

import com.example.demo_base.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
