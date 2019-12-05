package com.eshopper.commongateway.exception;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import net.minidev.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.toList;

@ControllerAdvice
public class CommonGatewayControllerException {

    @ExceptionHandler(CustomerServiceException.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleCustomerServiceException(CustomerServiceException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorMessage("There is some internal error. Please check.");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<ErrorResponse> handleFeignClientException(FeignException ex) {
        System.out.println("===========> handleFeignException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(FeignException.BadRequest.class)
//    public Map<String, Object> handleFeignStatusException(FeignException e, HttpServletResponse response) throws IOException {
//        response.setStatus(e.status());
//        return new JSONObject(e.contentUTF8()).toMap();
//    }
}

