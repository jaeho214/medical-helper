package kr.ac.skuniv.medicalhelper.domain.pharmacy.service;

import kr.ac.skuniv.medicalhelper.domain.pharmacy.dto.PharmacyGetResponse;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.exception.PharmacyNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PharmacyGetService {

    private PharmacyRepository pharmacyRepository;

    public PharmacyGetService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public List<PharmacyGetResponse> getPharmacyByName(String name, String xPos, String yPos, int pageNo) {

        List<Pharmacy> pharmacies = pharmacyRepository.findByName(name, xPos, yPos, pageNo);
        
        if(pharmacies.isEmpty())
            throw new PharmacyNotFoundException();

        return pharmacies.stream()
                .map(PharmacyGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<PharmacyGetResponse> getPharmacyByDistance(String xPos, String yPos, int pageNo){
        List<Pharmacy> pharmacies = pharmacyRepository.findOrderByDistance(xPos, yPos, pageNo);

        if(pharmacies.isEmpty())
            throw new PharmacyNotFoundException();

        return pharmacies.stream()
                .map(PharmacyGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public PharmacyGetResponse getPharmacy(Long id) {
        Pharmacy pharmacy = pharmacyRepository.findById(id).orElseThrow(PharmacyNotFoundException::new);
        return PharmacyGetResponse.entity2dto(pharmacy);
    }

}
