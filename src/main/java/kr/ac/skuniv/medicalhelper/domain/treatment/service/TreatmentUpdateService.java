package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.DrugImageRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class TreatmentUpdateService {
    private TreatmentRepository treatmentRepository;
    private DrugImageRepository drugImageRepository;
    private TreatmentCreateService treatmentCreateService;
    private JwtService jwtService;

    public TreatmentUpdateService(TreatmentRepository treatmentRepository, DrugImageRepository drugImageRepository, TreatmentCreateService treatmentCreateService, JwtService jwtService) {
        this.treatmentRepository = treatmentRepository;
        this.drugImageRepository = drugImageRepository;
        this.treatmentCreateService = treatmentCreateService;
        this.jwtService = jwtService;
    }

    public void updateTreatment(MultipartFile imageFile, TreatmentUpdateRequest treatmentUpdateRequest, String token) throws IOException {
        String userId = jwtService.findUserIdByJwt(token);

        Optional.ofNullable(treatmentUpdateRequest).orElseThrow(TreatmentRequestInvalidException::new);

        if(!imageFile.isEmpty())
            updateImage(imageFile, treatmentUpdateRequest.getTno());

        Optional<Treatment> treatment = Optional.ofNullable(treatmentRepository.findById(treatmentUpdateRequest.getTno()).orElseThrow(TreatmentNotFoundException::new));

        checkValidMember(treatment.get(), userId);

        treatment.get().updateTreatment(treatmentUpdateRequest);

        treatmentRepository.save(treatment.get());
    }

    private void checkValidMember(Treatment treatment, String updateTreatmentUser) {
        if(treatment.getMember().getUserId().equals(updateTreatmentUser))
            return;
        throw new UnauthorizedUserException();
    }

    private void updateImage(MultipartFile imageFile, Long tno) throws IOException {
        Optional<Treatment> treatment = Optional.ofNullable(treatmentRepository.findById(tno).orElseThrow(TreatmentNotFoundException::new));

        DrugImage drugImage = drugImageRepository.findByTreatment(treatment.get());
        DrugImage updateDrugImage = treatmentCreateService.saveImage(imageFile, treatment.get());

        drugImage.updateDrugImage(updateDrugImage);
        drugImageRepository.save(drugImage);
    }
}
