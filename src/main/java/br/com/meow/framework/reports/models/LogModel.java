package br.com.meow.framework.reports.models;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class LogModel {
    private String status;
    private LocalTime timeStamp;
    private String details;
    private String base64img;
}