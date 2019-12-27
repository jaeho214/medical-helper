package kr.ac.skuniv.medicalhelper.domain.member.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class UserDuplicationException extends BusinessLogicException {

    public UserDuplicationException() {
        super(ErrorCodeType.USER_ID_DUPLICATION);
    }
}
