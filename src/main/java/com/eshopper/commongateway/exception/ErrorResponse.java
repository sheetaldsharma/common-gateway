package com.eshopper.commongateway.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
    private String moduleName;
    private String functionName;

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", functionName='" + functionName + '\'' +
                '}';
    }
}
