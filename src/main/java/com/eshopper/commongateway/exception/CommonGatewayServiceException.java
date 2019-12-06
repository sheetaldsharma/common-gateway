package com.eshopper.commongateway.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class CommonGatewayServiceException extends Exception {
    private String errorMessage;

    public CommonGatewayServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public CommonGatewayServiceException() {
        super();
    }
}
