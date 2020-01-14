package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentGetResponse;
import kr.ac.skuniv.medicalhelper.domain.drugImage.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drugImage.repository.DrugImageRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    //TODO: 필요없을거 같단 생각이 드네요
    public List<TreatmentGetResponse> getAllTreatments(String token) {
        String email = jwtService.findEmailByJwt(token);

        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        List<Treatment> treatments = treatmentRepository.findAllByMember(member);

        if (treatments.isEmpty())
            throw new TreatmentNotFoundException();

        return treatments.stream()
                .map(TreatmentGetResponse::entity2dto)
                .collect(Collectors.toList());

    }

    public TreatmentGetResponse getTreatment(Long id, String token) {
        String email = jwtService.findEmailByJwt(token);

        if(memberRepository.existsByEmail(email)){
            Treatment treatment = treatmentRepository.findById(id).orElseThrow(TreatmentNotFoundException::new);

            checkMember(treatment, email);

            return TreatmentGetResponse.entity2dto(treatment);
        }
        throw new MemberNotFoundException();
    }

    private void checkMember(Treatment treatment, String userId) {
        if(treatment.getMember().getEmail().equals(userId))
            return;
        throw new TreatmentNotFoundException();
    }

    public byte[] getImageResource(Long id) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(TreatmentNotFoundException::new);

        DrugImage drugImage = drugImageRepository.findByTreatment(treatment);

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
