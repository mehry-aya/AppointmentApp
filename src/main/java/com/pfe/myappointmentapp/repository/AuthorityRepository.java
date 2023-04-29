package com.pfe.myappointmentapp.repository;

import com.pfe.myappointmentapp.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */

public interface AuthorityRepository extends JpaRepository<Authority, String> {}
