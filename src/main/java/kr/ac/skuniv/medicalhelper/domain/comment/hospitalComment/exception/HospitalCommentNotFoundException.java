package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class HospitalCommentNotFoundException extends BusinessLogicException {
    public HospitalCommentNotFoundException() {
        super(ErrorCodeType.HOSPITAL_COMMENT_NOT_FOUND);
    }
}
