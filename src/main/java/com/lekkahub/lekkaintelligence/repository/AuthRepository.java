package com.lekkahub.lekkaintelligence.repository;

import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthCredentials, Long> {
    AuthCredentials findByService(String service);
}

