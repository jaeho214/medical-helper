package kr.ac.skuniv.medicalhelper.domain.comment.pharmacyComment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class PharmacyCommentNotFoundException extends BusinessLogicException {
    public PharmacyCommentNotFoundException() {
        super(ErrorCodeType.PHARMACY_COMMENT_NOT_FOUND);
    }
}
