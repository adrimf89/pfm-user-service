package com.adri.pfm.pfm_user_service.exception.handler;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
