package com.emazon.cartservice.configuration.exceptionhandler;

import com.emazon.cartservice.domain.exception.CategoriesLimitExceedException;
import com.emazon.cartservice.domain.exception.InsufficientStockException;
import com.emazon.cartservice.domain.exception.NextSupplyDateException;
import com.emazon.cartservice.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ExceptionResponse(List.of(HttpStatus.FORBIDDEN.toString()), ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ExceptionResponse> handleInsufficientStockException(InsufficientStockException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(List.of(ex.getMessage() + ex.getNextSupplyDate()), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(CategoriesLimitExceedException.class)
    public ResponseEntity<ExceptionResponse> handleCategoriesLimitExceedException(CategoriesLimitExceedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(List.of(ex.getMessage()), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NextSupplyDateException.class)
    public ResponseEntity<ExceptionResponse> handleNextSupplyDateException(NextSupplyDateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(List.of(ex.getMessage()), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
}
