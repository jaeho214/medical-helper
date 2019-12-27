package kr.ac.skuniv.medicalhelper.domain.treatment.entity;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treatment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    private String name; // 진단명
    private String solution; // 받은 처방 기록
    private String doctor; // 의사명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_no")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
