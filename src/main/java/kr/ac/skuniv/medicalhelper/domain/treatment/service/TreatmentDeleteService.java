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

    public void deleteTreatment(Long tno, String token){
        String userId = jwtService.findUserIdByJwt(token);

        Optional<Treatment> deleteTreatment = Optional.ofNullable(treatmentRepository.findById(tno).orElseThrow(TreatmentNotFoundException::new));

        checkValidMember(deleteTreatment.get(), userId);

        treatmentRepository.delete(deleteTreatment.get());
    }

    private void checkValidMember(Treatment treatment, String deleteTreatmentUser) {
        if(treatment.getMember().getUserId().equals(deleteTreatmentUser))
            return;
        throw new UnauthorizedUserException();
    }
}
