package kr.ac.skuniv.medicalhelper.domain.comment.hospitalComment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class HospitalCommentRequestInvalidException extends BusinessLogicException {
    public HospitalCommentRequestInvalidException() {
        super(ErrorCodeType.HOSPITAL_COMMENT_REQUEST_INVALID);
    }
}
