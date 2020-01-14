package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentDeleteService {
    private TreatmentRepository treatmentRepository;
    private JwtService jwtService;

    public TreatmentDeleteService(TreatmentRepository treatmentRepository, JwtService jwtService) {
        this.treatmentRepository = treatmentRepository;
        this.jwtService = jwtService;
    }

    public void deleteTreatment(Long id, String token){
        String email = jwtService.findEmailByJwt(token);

        Treatment treatment = treatmentRepository.findById(id).orElseThrow(TreatmentNotFoundException::new);

        checkValidMember(treatment, email);
        treatmentRepository.delete(treatment);
    }

    private void checkValidMember(Treatment treatment, String email) {
        if(treatment.getMember().getEmail().equals(email))
            return;
        throw new UnauthorizedUserException();
    }
}
