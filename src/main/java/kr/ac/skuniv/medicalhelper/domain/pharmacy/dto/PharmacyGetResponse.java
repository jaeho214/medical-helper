package kr.ac.skuniv.medicalhelper.domain.pharmacy.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.entity.PharmacyComment;
import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class PharmacyGetResponse {
    private String name;
    private String tel;
    private String address;
    private String openDate;
    private String postNo;
    private String localName;
    private String xPos;
    private String yPos;
    private List<PharmacyComment> pharmacyComment = new ArrayList<>();

    public static PharmacyGetResponse entity2dto(Pharmacy pharmacy){
        return PharmacyGetResponse.builder()
                .name(pharmacy.getName())
                .localName(pharmacy.getLocalName())
                .openDate(pharmacy.getOpenDate())
                .address(pharmacy.getAddress())
                .postNo(pharmacy.getPostNo())
                .tel(pharmacy.getTel())
                .xPos(pharmacy.getXPos())
                .yPos(pharmacy.getYPos())
                .pharmacyComment(pharmacy.getPharmacyComment())
                .build();
    }


}
