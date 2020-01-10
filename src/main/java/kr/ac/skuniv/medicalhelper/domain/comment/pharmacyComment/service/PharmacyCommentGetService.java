package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.dto.PharmacyCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.exception.PharmacyCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.repository.PharmacyCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.exception.PharmacyNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PharmacyCommentGetService {
    private PharmacyCommentRepository pharmacyCommentRepository;
    private PharmacyRepository pharmacyRepository;

    public PharmacyCommentGetService(PharmacyCommentRepository pharmacyCommentRepository, PharmacyRepository pharmacyRepository) {
        this.pharmacyCommentRepository = pharmacyCommentRepository;
        this.pharmacyRepository = pharmacyRepository;
    }

    public List<PharmacyCommentGetResponse> getPharmacyComments(Long pharmacyId) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow(PharmacyCommentNotFoundException::new);

        List<PharmacyComment> comments = pharmacyCommentRepository.findByPharmacy(pharmacy);
        if(comments.isEmpty())
            throw new PharmacyCommentNotFoundException();

        return comments.stream()
                .map(PharmacyCommentGetResponse::entity2dto)
                .collect(Collectors.toList());
    }
}
