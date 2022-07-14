package com.example.apiwithtesting.entity.exception;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class EntityErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
