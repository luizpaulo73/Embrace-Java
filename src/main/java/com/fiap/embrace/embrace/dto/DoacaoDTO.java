package com.fiap.embrace.embrace.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DoacaoDTO {
    @NotNull
    private Long campanhaId;

    @NotNull
    private Long voluntarioId;

    @Min(1)
    private int quantidade;

    public DoacaoDTO() {}

    public DoacaoDTO(Long campanhaId, Long voluntarioId, int quantidade) {
        this.campanhaId = campanhaId;
        this.voluntarioId = voluntarioId;
        this.quantidade = quantidade;
    }

    public Long getCampanhaId() {
        return campanhaId;
    }

    public void setCampanhaId(Long campanhaId) {
        this.campanhaId = campanhaId;
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
