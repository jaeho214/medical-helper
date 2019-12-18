package kr.ac.skuniv.medicalhelper.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCodeType {

    //Member
    USER_ID_DUPLICATION(400, "M001", "중복된 ID입니다."),
    MEMBER_NOT_FOUND(400,"M002", "해당 사용자를 찾을 수 없습니다."),
    PASSWORD_INVALID(400,"M003", "비밀번호가 올바르지 않습니다"),

    //hospital
    HOSPITAL_NOT_FOUND(400, "H001", "해당 병원을 찾을 수 없습니다.");

    private int status;
    private String code;
    private String message;

    ErrorCodeType(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
