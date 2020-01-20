package kr.ac.skuniv.medicalhelper.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCodeType {

    //Common
    UNKNOWN(400, "COMMON_001", "UNKNOWN"),
    USER_UNAUTHORIZED(400, "COMMON_002", "이 기능을 사용할 수 없는 사용자입니다."),

    //Member
    USER_ID_DUPLICATION(400, "M001", "중복된 ID 입니다."),
    MEMBER_NOT_FOUND(400,"M002", "해당 사용자를 찾을 수 없습니다."),
    PASSWORD_INVALID(400,"M003", "비밀번호가 올바르지 않습니다"),


    //hospital
    HOSPITAL_NOT_FOUND(400, "H001", "해당 병원을 찾을 수 없습니다."),

    //hospitalComment
    HOSPITAL_COMMENT_NOT_FOUND(400, "HC001", "병원에 대한 평가를 찾을 수 없습니다."),
    HOSPITAL_COMMENT_REQUEST_INVALID(400, "HC002", "병원에 대한 평가 입력 데이터가 올바르지 않습니다."),

    //pharmacy
    PHARMACY_NOT_FOUND(400,"P001", "해당 약국을 찾을 수 없습니다."),

    //pharmacyComment
    PHARMACY_COMMENT_NOT_FOUND(400, "PC001", "약국에 대한 평가를 찾을 수 없습니다."),
    PHARMACY_COMMENT_REQUEST_INVALID(400, "PC002", "약국에 대한 평가 입력 데이터가 올바르지 않습니다."),

    //treatment
    TREATMENT_NOT_FOUND(400, "T001", "처방 기록이 없습니다."),
    TREATMENT_REQUEST_INVALID(400, "T002", "처방 입력 데이터가 올바르지 않습니다."),

    //reservation
    RESERVATION_NOT_FOUND(400,"R001", "예약 기록을 찾을 수 없습니다."),
    RESERVATION_CANNOT(400, "R002", "이 시간/날짜에 예약을 할 수 없습니다."),
    RESERVATION_REQUEST_INVALID(400,"R001", "예약 입력 데이터가 올바르지 않습니다"),
    RESERVATION_CANNOT_CANCEL(400, "R004", "예약을 취소할 수 없습니다."),

    //drug
    DRUG_REQUEST_INVALID(400, "D001", "약에 대한 입력 데이터가 올바르지 않습니다."),
    DRUG_NOT_FOUND(400, "D002", "약 정보를 찾을 수 없습니다."),

    //jwt
    SECRET_KEY_CONVERT_FAIL(400, "JWT001", "Secret Key 변환 실패"),

    //fcm
    FIREBASE_INITIALIZED_FAIL(400, "FCM001", "Firebase initialized fail");

    private int status;
    private String code;
    private String message;

    ErrorCodeType(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
