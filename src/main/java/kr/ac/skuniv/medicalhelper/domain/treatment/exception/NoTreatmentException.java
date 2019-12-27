package kr.ac.skuniv.medicalhelper.domain.treatment.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class NoTreatmentException extends BusinessLogicException {
    public NoTreatmentException() {
        super(ErrorCodeType.NO_TREATMENT_IN_MEMBER);
    }
}
