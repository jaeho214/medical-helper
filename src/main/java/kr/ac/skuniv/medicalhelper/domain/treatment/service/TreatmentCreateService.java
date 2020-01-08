package kr.ac.skuniv.medicalhelper.domain.treatment.service;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.dto.TreatmentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.DrugImage;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import kr.ac.skuniv.medicalhelper.domain.treatment.exception.TreatmentRequestInvalidException;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.DrugImageRepository;
import kr.ac.skuniv.medicalhelper.domain.treatment.repository.TreatmentRepository;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class TreatmentCreateService {

    private static final String IMAGE_PATH = "resources.image-locations";

    private TreatmentRepository treatmentRepository;
    private DrugImageRepository drugImageRepository;
    private MemberRepository memberRepository;
    private JwtService jwtService;
    private Environment environment;

    public TreatmentCreateService(TreatmentRepository treatmentRepository, DrugImageRepository drugImageRepository, MemberRepository memberRepository, JwtService jwtService, Environment environment) {
        this.treatmentRepository = treatmentRepository;
        this.drugImageRepository = drugImageRepository;
        this.memberRepository = memberRepository;
        this.jwtService = jwtService;
        this.environment = environment;
    }

    public void createTreatment(TreatmentCreateRequest treatmentCreateRequest, MultipartFile imageFile, String token) throws IOException {
        String userId = jwtService.findUserIdByJwt(token);

        Optional<Member> member = Optional.ofNullable(memberRepository.findByUserId(userId).orElseThrow(MemberNotFoundException::new));

        Optional.ofNullable(treatmentCreateRequest).orElseThrow(TreatmentRequestInvalidException::new);

        Treatment treatment = Treatment.builder()
                .doctor(treatmentCreateRequest.getDoctorName())
                .reservation(treatmentCreateRequest.getReservation())
                .solution(treatmentCreateRequest.getSolution())
                .title(treatmentCreateRequest.getTitle())
                .drug(treatmentCreateRequest.getDrug())
                .member(member.get())
                .build();

        treatmentRepository.save(treatment);

        if (!imageFile.isEmpty()) {
            DrugImage drugImage = saveImage(imageFile, treatment);
            drugImageRepository.save(drugImage);
        }
        return;

    }

    public DrugImage saveImage(MultipartFile imageFile, Treatment treatment) throws IOException {

        UUID uid = UUID.randomUUID();
        String fileName = uid + "_" + imageFile.getOriginalFilename();
        String savePath = makePath(environment.getProperty(IMAGE_PATH));
        File destinationFile = new File(environment.getProperty(IMAGE_PATH) + savePath, fileName);

        imageFile.transferTo(destinationFile);

        String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/medicalHelper/drug/image/" + treatment.getTno())
                .toUriString();

        return DrugImage.builder()
                .imageName(imageFile.getOriginalFilename())
                .imageSize(imageFile.getSize())
                .imageType(imageFile.getContentType())
                .imageUrl(imageUrl)
                .imagePath(environment.getProperty(IMAGE_PATH) + savePath + File.separator + fileName)
                .treatment(treatment)
                .build();
    }

    private String makePath(String uploadPath) {

        Calendar calendar = Calendar.getInstance();

        String yearPath = File.separator + calendar.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH)+1);
        String datePath = monthPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DATE));

        makeDir(uploadPath, yearPath, monthPath, datePath);

        return datePath;
    }

    private void makeDir(String uploadPath, String... paths) {
        if(new File(uploadPath + paths[paths.length - 1]).exists()) {
            return;
        }

        for( String path : paths){
            File dirPath = new File(uploadPath + path);

            if(!dirPath.exists()){
                dirPath.mkdir();
            }
        }
    }
}
