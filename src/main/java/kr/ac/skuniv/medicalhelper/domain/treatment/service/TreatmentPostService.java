package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentPostRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentPostService {
    private TreatmentRepository treatmentRepository;
    private MemberRepository memberRepository;

    public TreatmentPostService(TreatmentRepository treatmentRepository, MemberRepository memberRepository) {
        this.treatmentRepository = treatmentRepository;
        this.memberRepository = memberRepository;
    }

    public void postTreatment(TreatmentPostRequest treatmentPostRequest, String userId){
        Member member = memberRepository.findByUserId(userId);

        if(member == null)
            throw new MemberNotFoundException();

        Optional<TreatmentPostRequest> updateRequest = Optional.ofNullable(treatmentPostRequest);
        updateRequest.orElseThrow(TreatmentRequestInvalidException::new);

        Treatment treatment = Treatment.of(treatmentPostRequest);
        treatment.setMember(member);

        treatmentRepository.save(treatment);
    }
}
