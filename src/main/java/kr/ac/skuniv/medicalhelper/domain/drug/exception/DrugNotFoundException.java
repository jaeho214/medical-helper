package kr.ac.skuniv.medicalhelper.domain.drug.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class DrugNotFoundException extends BusinessLogicException {
    public DrugNotFoundException() {
        super(ErrorCodeType.DRUG_NOT_FOUND);
    }
}
