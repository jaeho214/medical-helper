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

    //treatment
    TREATMENT_NOT_FOUND(400, "T001", "처방 기록이 없습니다."),
    TREATMENT_REQUEST_INVALID(400, "T002", "입력 데이터가 올바르지 않습니다.");

    private int status;
    private String code;
    private String message;

    ErrorCodeType(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
