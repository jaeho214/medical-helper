package kr.ac.skuniv.medicalhelper.domain.treatment.dto;

import kr.ac.skuniv.medicalhelper.domain.drug.entity.Drug;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import kr.ac.skuniv.medicalhelper.domain.treatment.entity.Treatment;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatmentCreateRequest {
    private String title;
    private String solution;
    private String doctorName;
    private Long reservationId;
    private boolean breakfast;
    private boolean lunch;
    private boolean dinner;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime deadline;

    @Builder
    public TreatmentCreateRequest(String title, String solution, String doctorName, Long reservationId, boolean breakfast, boolean lunch, boolean dinner, LocalDateTime deadline) {
        this.title = title;
        this.solution = solution;
        this.doctorName = doctorName;
        this.reservationId = reservationId;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.deadline = deadline;
    }

    public Treatment toEntity(Drug drug, Member member, Reservation reservation){
        return Treatment.builder()
                .doctor(doctorName)
                .reservation(reservation)
                .solution(solution)
                .title(title)
                .drug(drug)
                .member(member)
                .build();
    }
}
