package com.eshopper.commongateway.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class CommonGatewayServiceException extends Exception {
    private String errorMessage;
    private String moduleName;
    private String functionName;

    public CommonGatewayServiceException(String errorMessage, String moduleName, String functionName) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.moduleName = moduleName;
        this.functionName = functionName;
    }

    public CommonGatewayServiceException() {
        super();
    }
}
