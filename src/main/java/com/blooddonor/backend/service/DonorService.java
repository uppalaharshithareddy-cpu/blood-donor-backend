package com.blooddonor.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blooddonor.backend.entity.Donor;
import com.blooddonor.backend.repository.DonorRepository;

@Service
public class DonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id).orElse(null);
    }

    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public Donor updateDonor(Long id, Donor donor) {
        Donor existingDonor = donorRepository.findById(id).orElse(null);

        if (existingDonor != null) {
    existingDonor.setName(donor.getName());
    existingDonor.setAge(donor.getAge());
    existingDonor.setGender(donor.getGender());
    existingDonor.setBloodGroup(donor.getBloodGroup());
    existingDonor.setPhone(donor.getPhone());
    existingDonor.setEmail(donor.getEmail());
    existingDonor.setCity(donor.getCity());
    existingDonor.setAvailable(donor.isAvailable());

    return donorRepository.save(existingDonor);
}

        return null;
    }

    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}
