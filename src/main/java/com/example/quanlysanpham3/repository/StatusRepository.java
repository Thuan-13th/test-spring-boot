package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    Optional<Status> findByStatusName(String statusName);
}
