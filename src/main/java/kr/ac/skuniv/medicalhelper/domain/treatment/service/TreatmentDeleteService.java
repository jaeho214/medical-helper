package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentDeleteService {
    private TreatmentRepository treatmentRepository;

    public TreatmentDeleteService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public void deleteTreatment(Long tno, String userId){
        Optional<Treatment> deleteTreatment = treatmentRepository.findById(tno);
        deleteTreatment.orElseThrow(TreatmentNotFoundException::new);

        checkValidMember(deleteTreatment.get(), userId);

        treatmentRepository.delete(deleteTreatment.get());
    }

    private void checkValidMember(Treatment treatment, String deleteTreatmentUser) {
        if(treatment.getMember().getUserId().equals(deleteTreatmentUser))
            return;
        throw new UnauthorizedUserException();
    }
}
