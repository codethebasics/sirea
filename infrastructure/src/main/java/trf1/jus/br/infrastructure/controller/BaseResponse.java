package trf1.jus.br.infrastructure.controller;

import lombok.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
@Builder
public class BaseResponse<T> {
    private int statusCode;
    private ResponseEntity<T> responseEntity;
    private String message;
    private LocalDateTime at;
}
