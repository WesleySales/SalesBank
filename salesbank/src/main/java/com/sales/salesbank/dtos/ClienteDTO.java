package com.sales.salesbank.dtos;

public record ClienteDTO(
        Long id, String nome, String CPF, String email, String senha
) {
}