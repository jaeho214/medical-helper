package kr.ac.skuniv.medicalhelper.domain.drugstore.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class DrugstoreNotFoundException extends BusinessLogicException {
    public DrugstoreNotFoundException() {
        super(ErrorCodeType.DRUGSTORE_NOT_FOUND);
    }
}
