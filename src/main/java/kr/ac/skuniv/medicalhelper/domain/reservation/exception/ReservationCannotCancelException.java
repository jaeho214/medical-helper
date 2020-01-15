package kr.ac.skuniv.medicalhelper.domain.reservation.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class ReservationCannotCancelException extends BusinessLogicException {
    public ReservationCannotCancelException() {
        super(ErrorCodeType.RESERVATION_CANNOT_CANCEL);
    }
}
