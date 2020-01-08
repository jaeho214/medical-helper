package kr.ac.skuniv.medicalhelper.global.jwt;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class SecretKeyConvertFailException extends BusinessLogicException {
    public SecretKeyConvertFailException() {
        super(ErrorCodeType.SECRET_KEY_CONVERT_FAIL);
    }
}
