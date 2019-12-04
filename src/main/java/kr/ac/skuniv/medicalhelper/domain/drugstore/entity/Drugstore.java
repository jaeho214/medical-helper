package kr.ac.skuniv.medicalhelper.domain.drugstore.entity;

import kr.ac.skuniv.medicalhelper.domain.evaluation.drugstore.entity.DrugstoreComment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Drugstore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugstoreNo;

    private String location;
    private String time;

    @OneToMany
    @JoinColumn(name = "dcNo")
    private List<DrugstoreComment> drugstoreComment = new ArrayList<>();

    public Drugstore(String location, String time, List<DrugstoreComment> drugstoreComment) {
        this.location = location;
        this.time = time;
        this.drugstoreComment = drugstoreComment;
    }
}
