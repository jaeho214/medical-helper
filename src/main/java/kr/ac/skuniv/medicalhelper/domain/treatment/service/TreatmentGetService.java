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
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreatmentGetService {
    private TreatmentRepository treatmentRepository;
    private MemberRepository memberRepository;
    private DrugImageRepository drugImageRepository;
    private JwtService jwtService;

    public TreatmentGetService(TreatmentRepository treatmentRepository, MemberRepository memberRepository, DrugImageRepository drugImageRepository, JwtService jwtService) {
        this.treatmentRepository = treatmentRepository;
        this.memberRepository = memberRepository;
        this.drugImageRepository = drugImageRepository;
        this.jwtService = jwtService;
    }

    public List<TreatmentGetResponse> getAllTreatments(String token) {
        String userId = jwtService.findUserIdByJwt(token);

        Optional<Member> member = Optional.ofNullable(memberRepository.findByUserId(userId).orElseThrow(MemberNotFoundException::new));

        List<Treatment> treatments = treatmentRepository.findAllByMember(member.get());

        if (treatments.isEmpty())
            throw new TreatmentNotFoundException();

        return treatments.stream()
                .map(TreatmentGetResponse::entity2dto)
                .collect(Collectors.toList());

    }

    public TreatmentGetResponse getTreatment(Long tno, String token) {
        String userId = jwtService.findUserIdByJwt(token);

        if(memberRepository.existsById(userId)){
            Optional<Treatment> treatment = Optional.ofNullable(treatmentRepository.findById(tno).orElseThrow(TreatmentNotFoundException::new));

            checkMember(treatment.get(), userId);

            return TreatmentGetResponse.entity2dto(treatment.get());
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
