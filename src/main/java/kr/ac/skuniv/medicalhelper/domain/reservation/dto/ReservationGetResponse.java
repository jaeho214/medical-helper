package kr.ac.skuniv.medicalhelper.domain.reservation.dto;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@ToString
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationGetResponse {
    private LocalDate reserveDate;
    private String symptom;
    private Hospital hospital;

    @Builder
    public ReservationGetResponse(LocalDate reserveDate, String symptom, Hospital hospital) {
        this.reserveDate = reserveDate;
        this.symptom = symptom;
        this.hospital = hospital;
    }

    public static ReservationGetResponse of(Reservation reservation){
        return ReservationGetResponse.builder()
                .reserveDate(reservation.getReserveDate())
                .symptom(reservation.getSymptom())
                .hospital(reservation.getHospital())
                .build();
    }
}
