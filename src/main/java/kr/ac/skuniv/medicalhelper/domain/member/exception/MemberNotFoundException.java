package kr.ac.skuniv.medicalhelper.domain.member.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class MemberNotFoundException extends BusinessLogicException {
    public MemberNotFoundException() {
        super(ErrorCodeType.MEMBER_NOT_FOUND);
    }
}
