package kr.ac.skuniv.medicalhelper.domain.drug.service;

import kr.ac.skuniv.medicalhelper.domain.drug.dto.DrugUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.drug.exception.DrugNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drug.exception.DrugRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.drug.repository.DrugRepository;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrugUpdateService {
    private DrugRepository drugRepository;
    private TreatmentRepository treatmentRepository;
    private JwtService jwtService;

    public DrugUpdateService(DrugRepository drugRepository, TreatmentRepository treatmentRepository, JwtService jwtService) {
        this.drugRepository = drugRepository;
        this.treatmentRepository = treatmentRepository;
        this.jwtService = jwtService;
    }

    public void updateDrug(DrugUpdateRequest drugUpdateRequest, String token){
        String email = jwtService.findEmailByJwt(token);

        Optional.ofNullable(drugUpdateRequest).orElseThrow(DrugRequestInvalidException::new);

        Drug drug = drugRepository.findById(drugUpdateRequest.getId()).orElseThrow(DrugNotFoundException::new);

        Treatment treatment = treatmentRepository.findByDrug(drug).orElseThrow(TreatmentNotFoundException::new);

        checkMember(treatment, email);
        drug.updateDrug(drugUpdateRequest);

        drugRepository.save(drug);
    }

    private void checkMember(Treatment treatment, String email) {
        if(treatment.getMember().getEmail().equals(email))
            return;
        throw new UnauthorizedUserException();
    }
}
