package kr.ac.skuniv.medicalhelper.domain.pharmacy.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class PharmacyNotFoundException extends BusinessLogicException {
    public PharmacyNotFoundException() {
        super(ErrorCodeType.PHARMACY_NOT_FOUND);
    }
}
