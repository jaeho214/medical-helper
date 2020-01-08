package kr.ac.skuniv.medicalhelper.domain.hospital.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.dto.HospitalGetResponse;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.exception.HospitalNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HospitalGetService {

    private final HospitalRepository hospitalRepository;
    private final int LIMIT = 10;

    public List<HospitalGetResponse> getHospitalByName(String name) {
        List<Hospital> hospitals = hospitalRepository.findByNameContaining(name);

        if(hospitals == null)
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public HospitalGetResponse getHospitalDetail(Long hospital_no){
        Optional<Hospital> hospital =  hospitalRepository.findById(hospital_no);
        hospital.orElseThrow(() -> new HospitalNotFoundException());
        return HospitalGetResponse.entity2dto(hospital.get());
    }

    public List<HospitalGetResponse> getHospitalByGps(String xPos, String yPos, int pageNum) {
        List<Hospital> hospitals = hospitalRepository.findByXPosAndYPos(xPos,yPos, --pageNum * LIMIT);

        if(hospitals.isEmpty())
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<HospitalGetResponse> getHospitalByHospitalCode(String xPos, String yPos, String hospitalCode, int pageNum) {
        List<Hospital> hospitals = hospitalRepository.findByHospitalCode(xPos,yPos, hospitalCode, --pageNum * LIMIT);

        if(hospitals.isEmpty())
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<HospitalGetResponse> getHospitalByCityCode(String cityCode, int pageNum) {
        Pageable pageable = (Pageable) PageRequest.of(--pageNum * LIMIT, 10);
        Page<Hospital> hospitals = hospitalRepository.findByCityCodeName(cityCode, pageable);

        if(hospitals.isEmpty())
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<HospitalGetResponse> getHospitalByCityCodeAndHospitalCode(String cityCode, String hospitalCode, int pageNum) {
        Pageable pageable = (Pageable) PageRequest.of(--pageNum * LIMIT, 10);
        Page<Hospital> hospitals = hospitalRepository.findByCityCodeNameAndNameContaining(cityCode, hospitalCode, pageable);

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }


//    //Entity 인스턴스를 Dto 로 바꿔서 response해주기 위해 변환하는 메소드
//    private List<HospitalGetResponse> entity2dto(List<Hospital> hospitals){
//        List<HospitalGetResponse> hospitalGetResponses = new ArrayList<>();
//        hospitals.forEach(hospital -> hospitalGetResponses.add(
//                HospitalGetResponse.of(hospital)
//        ));
//
//        return hospitalGetResponses;
//    }

}
