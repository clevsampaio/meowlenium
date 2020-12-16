package br.com.meow.framework.reports.models;

import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class ReportModel {
    private String fileName;
    private LocalDateTime suiteStartTime;
    private int tests;
    private int steps;
    private LocalDateTime start;
    private LocalDateTime end;
    private Duration timeTaken;
    private List<TestModel> testModel;
}