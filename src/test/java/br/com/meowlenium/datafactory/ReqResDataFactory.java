package br.com.meowlenium.datafactory;

import br.com.meowlenium.dto.CreateDTO;

public class ReqResDataFactory {
    public static CreateDTO create() {
        return CreateDTO.builder().
                name("morpheus").
                job("leader").
                build();
    }
}