package br.com.meowlenium.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateDTO {
    private String name;
    private String job;
}