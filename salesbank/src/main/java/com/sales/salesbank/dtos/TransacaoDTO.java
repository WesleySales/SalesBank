package com.sales.salesbank.dtos;

import io.micrometer.common.lang.Nullable;

public record TransacaoDTO(
        Long idTransacao,
        Double valor,
        String tipo,
        @Nullable Long idContaDestino
) {
}