package kr.ac.skuniv.medicalhelper.domain.member.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class UnauthorizedUserException extends BusinessLogicException {
    public UnauthorizedUserException() {
        super(ErrorCodeType.USER_UNAUTHORIZED);
    }
}
