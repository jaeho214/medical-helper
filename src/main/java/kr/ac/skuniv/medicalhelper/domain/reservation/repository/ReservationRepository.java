package kr.ac.skuniv.medicalhelper.domain.reservation.repository;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.reservation.entity.Reservation;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r join fetch r.hospital where r.member = :member")
    List<Reservation> findAllByMember(Member member);

    Optional<Reservation> findByHospitalAndReserveDateAndReserveTime(Hospital hospital, LocalDate reserveDate, String reserveTime);
    List<Reservation> findByHospitalAndReserveDate(Hospital hospital, LocalDate reserveDate);
    @Query("select r from Reservation r join fetch r.member join fetch r.hospital where r.id=:id")
    Optional<Reservation> findById(Long id);
}
