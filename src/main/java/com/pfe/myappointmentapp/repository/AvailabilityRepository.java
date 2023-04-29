package com.pfe.myappointmentapp.repository;

import com.pfe.myappointmentapp.domain.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {}
