package com.pfe.myappointmentapp.repository;

import com.pfe.myappointmentapp.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {}
