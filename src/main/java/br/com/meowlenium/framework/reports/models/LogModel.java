package br.com.meowlenium.framework.reports.models;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class LogModel {
    private String status;
    private LocalTime timeStamp;
    private String details;
    private String base64img;
}