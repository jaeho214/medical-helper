package kr.ac.skuniv.medicalhelper.domain.member.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class InvalidPasswordException extends BusinessLogicException {
    public InvalidPasswordException() {
        super(ErrorCodeType.PASSWORD_INVALID);
    }
}
