package com.blooddonor.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blooddonor.backend.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}

