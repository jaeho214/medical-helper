package kr.ac.skuniv.medicalhelper.domain.member.repository;

import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>{
    Member findByUserId(String userId);
}
