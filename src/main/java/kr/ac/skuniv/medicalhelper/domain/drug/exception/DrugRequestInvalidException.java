package kr.ac.skuniv.medicalhelper.domain.drug.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class DrugRequestInvalidException extends BusinessLogicException {
    public DrugRequestInvalidException() {
        super(ErrorCodeType.DRUG_REQUEST_INVALID);
    }
}
