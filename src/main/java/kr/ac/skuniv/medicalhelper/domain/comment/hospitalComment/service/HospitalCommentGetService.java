package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.service;

import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.dto.HospitalCommentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.entity.HospitalComment;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception.HospitalCommentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.repository.HospitalCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.exception.HospitalNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalCommentGetService {
    private HospitalRepository hospitalRepository;
    private HospitalCommentRepository hospitalCommentRepository;

    public HospitalCommentGetService(HospitalRepository hospitalRepository, HospitalCommentRepository hospitalCommentRepository) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalCommentRepository = hospitalCommentRepository;
    }

    public List<HospitalCommentGetResponse> getHospitalComments(Long hospitalNo) {
        Optional<Hospital> hospital = hospitalRepository.findById(hospitalNo);
        hospital.orElseThrow(HospitalNotFoundException::new);

        List<HospitalComment> comments = hospitalCommentRepository.findByHospital(hospital.get());

        if(comments.isEmpty())
            throw new HospitalCommentNotFoundException();

        return comments.stream()
                .map(HospitalCommentGetResponse::entity2dto)
                .collect(Collectors.toList());
    }
}
