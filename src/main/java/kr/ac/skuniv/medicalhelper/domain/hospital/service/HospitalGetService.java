package kr.ac.skuniv.medicalhelper.domain.hospital.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.dto.HospitalGetResponse;
import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.exception.HospitalNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalGetService {

    private final HospitalRepository hospitalRepository;
    private final int LIMTT = 10;

    public List<HospitalGetResponse> getHospitalByName(String name) {
        List<Hospital> hospitals = hospitalRepository.findByNameContaining(name);

        if(hospitals == null)
            throw new HospitalNotFoundException();

        return entity2dto(hospitals);
    }

    public HospitalGetResponse getHospitalDetail(Long hospital_no){
        Hospital hospital =  hospitalRepository.findById(hospital_no).orElseThrow(() -> new HospitalNotFoundException());
        return HospitalGetResponse.of(hospital);
    }

    public List<HospitalGetResponse> getHospitalByGps(String xPos, String yPos, int pageNum) {
        List<Hospital> hospitals = hospitalRepository.findByXPosAndYPos(xPos,yPos, --pageNum * LIMTT);

        if(hospitals == null)
            throw new HospitalNotFoundException();

        return entity2dto(hospitals);
    }

    public List<HospitalGetResponse> getHospitalByHospitalCode(String xPos, String yPos, String hospitalCode, int pageNum) {
        List<Hospital> hospitals = hospitalRepository.findByHospitalCode(xPos,yPos, hospitalCode, --pageNum * LIMTT);

        if(hospitals == null)
            throw new HospitalNotFoundException();

        return entity2dto(hospitals);
    }


    //Entity 인스턴스를 Dto 로 바꿔서 response해주기 위해 변환하는 메소드
    private List<HospitalGetResponse> entity2dto(List<Hospital> hospitals){
        List<HospitalGetResponse> hospitalGetResponses = new ArrayList<>();
        hospitals.forEach(hospital -> hospitalGetResponses.add(
                HospitalGetResponse.of(hospital)
        ));

        return hospitalGetResponses;
    }

    public List<HospitalGetResponse> getHospitalByCityCode(String cityCode, int pageNum) {
        Pageable pageable = (Pageable) PageRequest.of(--pageNum * LIMTT, 10);
        Page<Hospital> hospitals = hospitalRepository.findByCityCode(cityCode, pageable);

        List<HospitalGetResponse> hospitalGetResponses = new ArrayList<>();
        hospitals.forEach(hospital -> hospitalGetResponses.add(
                HospitalGetResponse.of(hospital)
        ));

        return hospitalGetResponses;
    }

    public List<HospitalGetResponse> getHospitalByCityCodeAndHospitalCode(String cityCode, String hospitalCode, int pageNum) {
        Pageable pageable = (Pageable) PageRequest.of(--pageNum * LIMTT, 10);
        Page<Hospital> hospitals = hospitalRepository.findByCityCodeAndNameContaining(cityCode,hospitalCode, pageable);

        List<HospitalGetResponse> hospitalGetResponses = new ArrayList<>();
        hospitals.forEach(hospital -> hospitalGetResponses.add(
                HospitalGetResponse.of(hospital)
        ));

        return hospitalGetResponses;
    }
}
