package com.eshopper.commongateway.exception;


import feign.FeignException;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
public class CustomerControllerException {

    @ExceptionHandler(CustomerServiceException.class)
    public ResponseEntity<ErrorResponse> handleCustomerServiceException(Exception ex) {
        System.out.println("===========> handleGenericException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<ErrorResponse> handleFeignClientException(Exception ex) {
        System.out.println("===========> handleFeignException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        System.out.println("===========> handleGenericException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("There is some internal error. Please check.");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
    }
}
