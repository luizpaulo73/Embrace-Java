package com.fiap.embrace.embrace.dto;

public class DoacaoResponseDTO {
    private Long campanhaId;
    private int totalDoado;
    private int restante;
    private String mensagem;

    public DoacaoResponseDTO() {}

    public DoacaoResponseDTO(Long campanhaId, int totalDoado, int restante, String mensagem) {
        this.campanhaId = campanhaId;
        this.totalDoado = totalDoado;
        this.restante = restante;
        this.mensagem = mensagem;
    }

    public Long getCampanhaId() { return campanhaId; }
    public void setCampanhaId(Long campanhaId) { this.campanhaId = campanhaId; }

    public int getTotalDoado() { return totalDoado; }
    public void setTotalDoado(int totalDoado) { this.totalDoado = totalDoado; }

    public int getRestante() { return restante; }
    public void setRestante(int restante) { this.restante = restante; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}
