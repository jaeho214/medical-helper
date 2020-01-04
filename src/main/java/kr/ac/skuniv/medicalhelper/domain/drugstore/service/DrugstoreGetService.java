package kr.ac.skuniv.medicalhelper.domain.drugstore.service;

import kr.ac.skuniv.medicalhelper.domain.drugstore.dto.DrugStoreRequest;
import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.drugstore.repository.DrugstoreRepository;
import kr.ac.skuniv.medicalhelper.global.api.ApiConnection;
import kr.ac.skuniv.medicalhelper.global.api.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugstoreGetService {

    @Autowired
    private DrugstoreRepository drugstoreRepository;

    public List<Drugstore> getDrugstoreByName(String name) {
        //drugstoreRepository.find
        return null;
    }
}
