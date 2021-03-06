package br.com.meowlenium.framework.reports.models;

import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class StepModel {
    private String name;
    private LocalDateTime time;
    private String duration;
    private String status;
    private List<LogModel> logModel;
}