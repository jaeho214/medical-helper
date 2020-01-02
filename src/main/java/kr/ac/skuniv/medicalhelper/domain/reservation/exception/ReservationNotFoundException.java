package kr.ac.skuniv.medicalhelper.domain.reservation.exception;

import kr.ac.skuniv.medicalhelper.global.error.exception.BusinessLogicException;
import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;

public class ReservationNotFoundException extends BusinessLogicException {
    public ReservationNotFoundException() {
        super(ErrorCodeType.RESERVATION_NOT_FOUND);
    }
}
