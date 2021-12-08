package com.example.demo.repository;

import com.example.demo.model.user.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification,Long>{
    Certification findByUserId(String userId);

    boolean existsByUserId (String userId);
}
