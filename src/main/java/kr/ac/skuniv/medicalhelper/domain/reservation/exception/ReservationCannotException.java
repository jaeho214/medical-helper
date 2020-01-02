package kr.ac.skuniv.medicalhelper.domain.reservation.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class ReservationCannotException extends BusinessLogicException {
    public ReservationCannotException() {
        super(ErrorCodeType.RESERVATION_CANNOT);
    }
}
