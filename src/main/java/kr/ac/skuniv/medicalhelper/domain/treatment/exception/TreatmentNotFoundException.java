package kr.ac.skuniv.medicalhelper.domain.treatment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class TreatmentNotFoundException extends BusinessLogicException {
    public TreatmentNotFoundException() {
        super(ErrorCodeType.TREATMENT_NOT_FOUND);
    }
}
