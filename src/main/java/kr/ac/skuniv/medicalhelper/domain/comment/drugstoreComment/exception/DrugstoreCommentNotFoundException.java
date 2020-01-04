package kr.ac.skuniv.medicalhelper.domain.comment.drugstoreComment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class DrugstoreCommentNotFoundException extends BusinessLogicException {
    public DrugstoreCommentNotFoundException() {
        super(ErrorCodeType.DRUGSTORE_COMMENT_NOT_FOUND);
    }
}
