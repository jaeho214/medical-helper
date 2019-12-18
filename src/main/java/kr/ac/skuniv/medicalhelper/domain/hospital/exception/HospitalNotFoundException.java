package kr.ac.skuniv.medicalhelper.domain.hospital.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class HospitalNotFoundException extends BusinessLogicException {
    public HospitalNotFoundException() {
        super(ErrorCodeType.HOSPITAL_NOT_FOUND);
    }
}
