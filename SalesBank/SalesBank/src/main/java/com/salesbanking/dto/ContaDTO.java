package com.salesbanking.dto;

import com.salesbanking.entities.Cliente;

public record ContaDTO(
        String agencia, String numeroDaConta, double saldo, Cliente titular
) {
}
