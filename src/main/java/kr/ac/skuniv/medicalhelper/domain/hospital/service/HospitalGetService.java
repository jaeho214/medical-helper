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

    public List<HospitalGetResponse> getHospitalByName(String xPos, String yPos, String name, int pageNo) {
        List<Hospital> hospitals = hospitalRepository.findByNameContaining(xPos, yPos, name, --pageNo * LIMIT);

        if(hospitals == null)
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public HospitalGetResponse getHospitalDetail(Long id){
        Hospital hospital =  hospitalRepository.findById(id).orElseThrow(HospitalNotFoundException::new);
        return HospitalGetResponse.entity2dto(hospital);
    }

    public List<HospitalGetResponse> getHospitalAround(String xPos, String yPos, int pageNo) {
        List<Hospital> hospitals = hospitalRepository.findByXPosAndYPos(xPos,yPos, --pageNo * LIMIT);

        if(hospitals.isEmpty())
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<HospitalGetResponse> getHospitalByHospitalCode(String xPos, String yPos, String hospitalCode, int pageNo) {
        List<Hospital> hospitals = hospitalRepository.findByHospitalCode(xPos,yPos, hospitalCode, --pageNo * LIMIT);

        if(hospitals.isEmpty())
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<HospitalGetResponse> getHospitalByCityCode(String cityCode, int pageNo) {
        Pageable pageable = (Pageable) PageRequest.of(--pageNo * LIMIT, 10);
        Page<Hospital> hospitals = hospitalRepository.findByCityCodeName(cityCode, pageable);

        if(hospitals.isEmpty())
            throw new HospitalNotFoundException();

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }

    public List<HospitalGetResponse> getHospitalByCityCodeAndHospitalCode(String cityCode, String hospitalCode, int pageNo) {
        Pageable pageable = (Pageable) PageRequest.of(--pageNo * LIMIT, 10);
        Page<Hospital> hospitals = hospitalRepository.findByCityCodeNameAndNameContaining(cityCode, hospitalCode, pageable);

        return hospitals.stream()
                .map(HospitalGetResponse::entity2dto)
                .collect(Collectors.toList());
    }


}
