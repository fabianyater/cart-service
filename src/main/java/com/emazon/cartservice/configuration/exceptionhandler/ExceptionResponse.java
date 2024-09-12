package com.emazon.cartservice.configuration.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private final List<String> messages;
    private final String status;
    private final LocalDateTime timestamp;
}
