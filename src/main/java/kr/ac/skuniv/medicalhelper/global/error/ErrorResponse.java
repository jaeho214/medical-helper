package kr.ac.skuniv.medicalhelper.global.error;

import kr.ac.skuniv.medicalhelper.global.error.exception.ErrorCodeType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse {
    private String code;
    private String message;

    @Builder
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse of(ErrorCodeType errorCodeType){
        return ErrorResponse.builder()
                .code(errorCodeType.getCode())
                .message(errorCodeType.getMessage())
                .build();
    }
}
