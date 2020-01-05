package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.service;

import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import kr.ac.skuniv.medicalhelper.domain.drugstore.exception.DrugstoreNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.drugstore.repository.DrugstoreRepository;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.dto.DrugstoreCommentCreateRequest;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.entity.DrugstoreComment;
import kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.repository.DrugstoreCommentRepository;
import kr.ac.skuniv.medicalhelper.domain.member.entity.Member;
import kr.ac.skuniv.medicalhelper.domain.member.exception.MemberNotFoundException;
import kr.ac.skuniv.medicalhelper.domain.member.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrugstoreCommentCreateService {

    private DrugstoreRepository drugstoreRepository;
    private DrugstoreCommentRepository drugstoreCommentRepository;
    private MemberRepository memberRepository;

    public DrugstoreCommentCreateService(DrugstoreRepository drugstoreRepository, DrugstoreCommentRepository drugstoreCommentRepository, MemberRepository memberRepository) {
        this.drugstoreRepository = drugstoreRepository;
        this.drugstoreCommentRepository = drugstoreCommentRepository;
        this.memberRepository = memberRepository;
    }

    public ResponseEntity createDrugstoreComment(DrugstoreCommentCreateRequest drugstoreCommentCreateRequest, String userId) {
        if(drugstoreRepository.existsById(drugstoreCommentCreateRequest.getDrugstoreNo())){
            Optional<Drugstore> drugstore = drugstoreRepository.findById(drugstoreCommentCreateRequest.getDrugstoreNo());
            drugstore.orElseThrow(DrugstoreNotFoundException::new);

            if(!memberRepository.existsById(userId))
                throw new MemberNotFoundException();

            Member member = memberRepository.findByUserId(userId);

            //입력한 약국에 대한 별점을 entity로 바꿔서
            DrugstoreComment drugstoreComment =
                    DrugstoreComment.builder()
                    .comment(drugstoreCommentCreateRequest.getComment())
                    .score(drugstoreCommentCreateRequest.getScore())
                    .drugstore(drugstore.get())
                    .member(member)
                    .build();

            drugstoreCommentRepository.save(drugstoreComment);

            return ResponseEntity.ok(drugstoreComment);
        }
        throw new DrugstoreNotFoundException();
    }
}
