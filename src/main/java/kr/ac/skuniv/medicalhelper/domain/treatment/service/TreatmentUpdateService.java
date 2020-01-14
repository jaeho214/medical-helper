package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentUpdateRequest;
import kr.ac.skuniv.medicalhelper.domain.drugImage.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.drugImage.repository.DrugImageRepository;
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

    public void updateTreatment(TreatmentUpdateRequest treatmentUpdateRequest, MultipartFile imageFile, String token) throws IOException {
        String email = jwtService.findEmailByJwt(token);

        Optional.ofNullable(treatmentUpdateRequest).orElseThrow(TreatmentRequestInvalidException::new);

        if(imageFile != null)
            updateImage(imageFile, treatmentUpdateRequest.getId());

        Treatment treatment = treatmentRepository.findById(treatmentUpdateRequest.getId()).orElseThrow(TreatmentNotFoundException::new);

        checkValidMember(treatment, email);

        treatment.updateTreatment(treatmentUpdateRequest);

        treatmentRepository.save(treatment);
    }

    private void checkValidMember(Treatment treatment, String updateTreatmentUser) {
        if(treatment.getMember().getEmail().equals(updateTreatmentUser))
            return;
        throw new UnauthorizedUserException();
    }

    private void updateImage(MultipartFile imageFile, Long id) throws IOException {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(TreatmentNotFoundException::new);

        DrugImage drugImage = drugImageRepository.findByTreatment(treatment);
        DrugImage updateDrugImage = treatmentCreateService.saveImage(imageFile, treatment);

        drugImage.updateDrugImage(updateDrugImage);
        drugImageRepository.save(drugImage);
    }
}
