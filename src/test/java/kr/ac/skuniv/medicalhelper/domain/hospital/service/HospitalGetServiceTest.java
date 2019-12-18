package kr.ac.skuniv.medicalhelper.domain.hospital.service;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.hospital.repository.HospitalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class HospitalGetServiceTest {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Test
    public void 반경계산하기(){
        String xPos = "127.09854004628151";
        String yPos = "37.6132113197367";

        List<Hospital> byXPosAndYPos = hospitalRepository.findByXPosAndYPos(xPos, yPos,1);
        System.out.println(byXPosAndYPos.get(0));

    }

}