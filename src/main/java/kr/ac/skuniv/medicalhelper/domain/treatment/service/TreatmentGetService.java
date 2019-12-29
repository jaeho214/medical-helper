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
        Member member = memberRepository.findByUserId(userId);

        if(member == null)
            throw new MemberNotFoundException();

        List<Treatment> treatments = treatmentRepository.findAllByMember(member);

        if(treatments == null)
            throw new TreatmentNotFoundException();

        List<TreatmentGetResponse> treatmentGetResponseList = new ArrayList<>();

        for (Treatment treatment : treatments) {
            treatmentGetResponseList.add(entity2dto(treatment));
        }

        return treatmentGetResponseList;
    }

    private TreatmentGetResponse entity2dto(Treatment treatment){
        return TreatmentGetResponse.builder()
                .tno(treatment.getTno())
                .title(treatment.getTitle())
                .solution(treatment.getSolution())
                .doctorName(treatment.getDoctor())
                .hospital(treatment.getHospital())
                .treatedDate(treatment.getTreatedDate())
                .build();
    }
}
