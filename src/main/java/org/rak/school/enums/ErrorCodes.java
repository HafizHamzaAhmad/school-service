package org.rak.school.enums;


import lombok.Getter;

@Getter
public enum ErrorCodes {

    ERROR_UNABLE_TO_CREATE("100-001", "Unable to create"),
    ERROR_NOT_FOUND("100-002", "No %s found"),
    ERROR_ALREADY_EXISTS("100-003", "%s already exists"),
    ERROR_UNSUPPORTED("100-900", "Un Supported operation"),
    ERROR_UNABLE_TO_PROCESS("100-900", "Unable to process"),
    ;

    private String code;
    private String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
