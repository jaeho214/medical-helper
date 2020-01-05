package kr.ac.skuniv.medicalhelper.domain.drugstore.dto;

import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class DrugstoreGetResponse {
    private String name;
    private String tel;
    private String address;
    private String openDate;
    private String postNo;
    private String localName;
    private List<DrugstoreComment> drugstoreComment = new ArrayList<>();


}
