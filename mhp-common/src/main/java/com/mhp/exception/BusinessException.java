// mhp-common: com.mhp.exception.BusinessException
package com.mhp.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}