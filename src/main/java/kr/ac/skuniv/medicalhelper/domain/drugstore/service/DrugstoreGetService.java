package kr.ac.skuniv.medicalhelper.domain.drugstore.service;

import kr.ac.skuniv.medicalhelper.domain.drugstore.dto.DrugstoreGetResponse;
import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.drugstore.exception.DrugstoreNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drugstore.repository.DrugstoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrugstoreGetService {

    @Autowired
    private DrugstoreRepository drugstoreRepository;

    public List<DrugstoreGetResponse> getDrugstoreByName(String name, String xPos, String yPos, int pageNo) {

        List<Drugstore> drugstores = drugstoreRepository.findByName(name, xPos, yPos, pageNo);
        
        if(drugstores.isEmpty())
            throw new DrugstoreNotFoundException();

        return entity2dto(drugstores);
    }

    public List<DrugstoreGetResponse> getDrugstoreByDistance(String xPos, String yPos, int pageNo){
        List<Drugstore> drugstores = drugstoreRepository.findOrderByDistance(xPos, yPos, pageNo);

        if(drugstores.isEmpty())
            throw new DrugstoreNotFoundException();

        return entity2dto(drugstores);
    }

    public DrugstoreGetResponse getDrugstore(Long drugstoreNo) {

        Optional<Drugstore> drugstore = drugstoreRepository.findById(drugstoreNo);
        drugstore.orElseThrow(DrugstoreNotFoundException::new);

        DrugstoreGetResponse drugstoreGetResponse =
                DrugstoreGetResponse.builder()
                        .address(drugstore.get().getAddress())
                        .localName(drugstore.get().getLocalName())
                        .name(drugstore.get().getName())
                        .openDate(drugstore.get().getOpenDate())
                        .postNo(drugstore.get().getPostNo())
                        .tel(drugstore.get().getTel())
                        .drugstoreComment(drugstore.get().getDrugstoreComment())
                        .build();

        return drugstoreGetResponse;
    }

    private List<DrugstoreGetResponse> entity2dto(List<Drugstore> drugstores) {
        List<DrugstoreGetResponse> drugstoreGetResponseList = new ArrayList<>();

        for (Drugstore drugstore : drugstores) {
            drugstoreGetResponseList.add(
                    DrugstoreGetResponse.builder()
                            .name(drugstore.getName())
                            .localName(drugstore.getLocalName())
                            .openDate(drugstore.getOpenDate())
                            .address(drugstore.getAddress())
                            .postNo(drugstore.getPostNo())
                            .tel(drugstore.getTel())
                            .drugstoreComment(drugstore.getDrugstoreComment())
                            .build()
            );
        }
        return drugstoreGetResponseList;
    }
}
