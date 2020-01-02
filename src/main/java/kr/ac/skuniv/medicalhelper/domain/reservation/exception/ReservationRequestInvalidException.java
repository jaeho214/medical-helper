package kr.ac.skuniv.medicalhelper.domain.reservation.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class ReservationRequestInvalidException extends BusinessLogicException {
    public ReservationRequestInvalidException() {
        super(ErrorCodeType.RESERVATION_REQUEST_INVALID);
    }
}
