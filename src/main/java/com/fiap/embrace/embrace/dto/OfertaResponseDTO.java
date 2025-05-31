package com.fiap.embrace.embrace.dto;

public class OfertaResponseDTO {
    private Long anuncioId;
    private int totalOfertado;
    private int restante;
    private String mensagem;

    public OfertaResponseDTO() {}

    public OfertaResponseDTO(Long anuncioId, int totalOfertado, int restante, String mensagem) {
        this.anuncioId = anuncioId;
        this.totalOfertado = totalOfertado;
        this.restante = restante;
        this.mensagem = mensagem;
    }

    public Long getAnuncioId() {
        return anuncioId;
    }

    public void setAnuncioId(Long anuncioId) {
        this.anuncioId = anuncioId;
    }

    public int getTotalOfertado() {
        return totalOfertado;
    }

    public void setTotalOfertado(int totalOfertado) {
        this.totalOfertado = totalOfertado;
    }

    public int getRestante() {
        return restante;
    }

    public void setRestante(int restante) {
        this.restante = restante;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
