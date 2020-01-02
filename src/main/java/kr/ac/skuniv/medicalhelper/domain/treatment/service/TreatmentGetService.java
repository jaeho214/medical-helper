package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreatmentGetService {
    private TreatmentRepository treatmentRepository;
    private MemberRepository memberRepository;

    public TreatmentGetService(TreatmentRepository treatmentRepository, MemberRepository memberRepository) {
        this.treatmentRepository = treatmentRepository;
        this.memberRepository = memberRepository;
    }

    public List<TreatmentGetResponse> getTreatmentByMember(String userId) {
        if(memberRepository.existsById(userId)) {
            Member member = memberRepository.findByUserId(userId);

            List<Treatment> treatments = treatmentRepository.findAllByMember(member);

            if (treatments == null)
                throw new TreatmentNotFoundException();

            List<TreatmentGetResponse> treatmentGetResponseList = new ArrayList<>();

            for (Treatment treatment : treatments) {
                treatmentGetResponseList.add(TreatmentGetResponse.of(treatment));
            }

            return treatmentGetResponseList;
        }
        throw new MemberNotFoundException();
    }
}
