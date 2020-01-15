package kr.ac.skuniv.medicalhelper.domain.drugImage.entity;

import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrugImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugImageNo;

    @NotNull
    private String imageName;

    @NotNull
    private String imageType;

    @NotNull
    private String imagePath;

    @NotNull
    private Long imageSize;

    @NotNull
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_no")
    private Treatment treatment;

    @Builder
    public DrugImage(@NotNull String imageName,
                     @NotNull String imageType,
                     @NotNull String imagePath,
                     @NotNull Long imageSize,
                     @NotNull String imageUrl,
                     Treatment treatment) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imagePath = imagePath;
        this.imageSize = imageSize;
        this.imageUrl = imageUrl;
        this.treatment = treatment;
    }

    public void updateDrugImage(DrugImage drugImage){
        this.imageName = drugImage.imageName;
        this.imageType = drugImage.imageType;
        this.imagePath = drugImage.imagePath;
        this.imageSize = drugImage.imageSize;
        this.imageUrl = drugImage.imageUrl;
    }
}
