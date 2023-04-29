package com.pfe.myappointmentapp.repository;

import com.pfe.myappointmentapp.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {}
