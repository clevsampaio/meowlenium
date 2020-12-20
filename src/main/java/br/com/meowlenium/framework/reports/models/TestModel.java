package br.com.meowlenium.framework.reports.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class TestModel {
    private String name;
    private LocalDateTime time;
    private String status;
    private List<Map<String, String>> timeInfo;
    private List<StepModel> stepModel;
}