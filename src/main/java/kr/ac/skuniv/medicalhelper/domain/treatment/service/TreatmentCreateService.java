package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentCreateService {
    private TreatmentRepository treatmentRepository;
    private MemberRepository memberRepository;

    public TreatmentCreateService(TreatmentRepository treatmentRepository, MemberRepository memberRepository) {
        this.treatmentRepository = treatmentRepository;
        this.memberRepository = memberRepository;
    }

    public void createTreatment(TreatmentCreateRequest treatmentCreateRequest, String userId){
        if(memberRepository.existsById(userId)) {
            Member member = memberRepository.findByUserId(userId);

            Optional.ofNullable(treatmentCreateRequest).orElseThrow(TreatmentRequestInvalidException::new);

            Treatment treatment = Treatment.of(treatmentCreateRequest);
            treatment.setMember(member);
            treatmentRepository.save(treatment);
            return;
        }
        throw new MemberNotFoundException();




    }
}
