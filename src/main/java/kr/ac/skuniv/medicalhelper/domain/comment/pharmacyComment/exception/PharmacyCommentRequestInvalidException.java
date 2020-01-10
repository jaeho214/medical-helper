package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class PharmacyCommentRequestInvalidException extends BusinessLogicException {
    public PharmacyCommentRequestInvalidException() {
        super(ErrorCodeType.PHARMACY_COMMENT_REQUEST_INVALID);
    }
}
