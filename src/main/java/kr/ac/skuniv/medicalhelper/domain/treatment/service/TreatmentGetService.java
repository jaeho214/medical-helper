package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentGetService {
    private TreatmentRepository treatmentRepository;
    private MemberRepository memberRepository;

    public TreatmentGetService(TreatmentRepository treatmentRepository, MemberRepository memberRepository) {
        this.treatmentRepository = treatmentRepository;
        this.memberRepository = memberRepository;
    }

    public List<TreatmentGetResponse> getAllTreatments(String userId) {
        if(memberRepository.existsById(userId)) {
            Member member = memberRepository.findByUserId(userId);

            List<Treatment> treatments = treatmentRepository.findAllByMember(member);

            if (treatments == null)
                throw new TreatmentNotFoundException();

            List<TreatmentGetResponse> treatmentGetResponseList = new ArrayList<>();

            for (Treatment treatment : treatments) {
                treatmentGetResponseList.add(TreatmentGetResponse.entity2dto(treatment));
            }

            return treatmentGetResponseList;
        }
        throw new MemberNotFoundException();
    }

    public TreatmentGetResponse getTreatment(Long tno, String userId) {
        if(memberRepository.existsById(userId)){
            Optional<Treatment> treatment = treatmentRepository.findById(tno);
            treatment.orElseThrow(TreatmentNotFoundException::new);

            checkMember(treatment.get(), userId);

            TreatmentGetResponse treatmentGetResponse = TreatmentGetResponse.entity2dto(treatment.get());

            return treatmentGetResponse;
        }
        throw new MemberNotFoundException();
    }

    private void checkMember(Treatment treatment, String userId) {
        if(treatment.getMember().getUserId().equals(userId))
            return;
        throw new TreatmentNotFoundException();
    }
}
