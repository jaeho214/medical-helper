package kr.ac.skuniv.medicalhelper.domain.member.repository;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String>{
    Optional<Member> findByUserId(String userId);
}
