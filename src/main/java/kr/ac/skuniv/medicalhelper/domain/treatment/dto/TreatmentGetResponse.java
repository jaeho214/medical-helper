package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentGetResponse {
    private Long tno;
    private String title;
    private String solution;
    private String doctorName;
    private Reservation reservation;

    @Builder
    public TreatmentGetResponse(Long tno, String title, String solution, String doctorName, Reservation reservation) {
        this.tno = tno;
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.reservation = reservation;
    }

    public static TreatmentGetResponse entity2dto(Treatment treatment){
        return TreatmentGetResponse.builder()
                .tno(treatment.getTno())
                .title(treatment.getTitle())
                .solution(treatment.getSolution())
                .doctorName(treatment.getDoctor())
                .reservation(treatment.getReservation())
                .build();
    }

}
