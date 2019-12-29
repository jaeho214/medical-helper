package kr.ac.skuniv.medicalhelper.domain.treatment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class TreatmentRequestInvalidException extends BusinessLogicException {
    public TreatmentRequestInvalidException() {
        super(ErrorCodeType.TREATMENT_REQUEST_INVALID);
    }
}
