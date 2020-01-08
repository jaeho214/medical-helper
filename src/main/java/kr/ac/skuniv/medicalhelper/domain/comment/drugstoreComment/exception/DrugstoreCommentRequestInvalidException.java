package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class DrugstoreCommentRequestInvalidException extends BusinessLogicException {
    public DrugstoreCommentRequestInvalidException() {
        super(ErrorCodeType.DRUGSTORE_COMMENT_REQUEST_INVALID);
    }
}
