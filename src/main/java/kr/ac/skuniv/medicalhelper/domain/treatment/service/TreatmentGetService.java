package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.DrugImageRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentGetService {
    private TreatmentRepository treatmentRepository;
    private MemberRepository memberRepository;
    private DrugImageRepository drugImageRepository;

    public TreatmentGetService(TreatmentRepository treatmentRepository, MemberRepository memberRepository, DrugImageRepository drugImageRepository) {
        this.treatmentRepository = treatmentRepository;
        this.memberRepository = memberRepository;
        this.drugImageRepository = drugImageRepository;
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

    public byte[] getImageResource(Long tno) {
        Optional<Treatment> treatment = treatmentRepository.findById(tno);
        treatment.orElseThrow(TreatmentNotFoundException::new);

        DrugImage drugImage = drugImageRepository.findByTreatment(treatment.get());

        byte[] result = null;
        try{
            File file = new File(drugImage.getImagePath());

            InputStream in = new FileInputStream(file);
            result = IOUtils.toByteArray(in);

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
