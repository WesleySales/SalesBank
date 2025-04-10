package com.salesbanking.dto;

public record ClienteDTO(
        Long id, String nome, String CPF, String email, String senha
) {
}
