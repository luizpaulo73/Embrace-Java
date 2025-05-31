package com.fiap.embrace.embrace.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OfertaDTO {

    @NotNull(message = "O ID do anúncio é obrigatório")
    private Long anuncioId;

    @NotNull(message = "O ID do voluntário é obrigatório")
    private Long voluntarioId;

    @Min(value = 1, message = "A quantidade deve ser no mínimo 1")
    private int quantidade;

    public OfertaDTO() {}

    public OfertaDTO(Long anuncioId, Long voluntarioId, int quantidade) {
        this.anuncioId = anuncioId;
        this.voluntarioId = voluntarioId;
        this.quantidade = quantidade;
    }


    public Long getAnuncioId() {
        return anuncioId;
    }

    public void setAnuncioId(Long anuncioId) {
        this.anuncioId = anuncioId;
    }

    public Long getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Long voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
