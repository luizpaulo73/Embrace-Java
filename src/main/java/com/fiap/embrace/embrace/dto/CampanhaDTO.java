package com.fiap.embrace.embrace.dto;

import com.fiap.embrace.embrace.entities.TipoEvento;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CampanhaDTO {
    private Long id;

    @NotBlank(message = "O nome da campanha é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição da campanha é obrigatória")
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String descricao;


    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(
            regexp = "\\d{5}-\\d{3}",
            message = "O CEP deve estar no formato 99999-999"
    )
    private String cep;

    @NotBlank(message = "O logradouro é obrigatório")
    @Size(max = 200, message = "O logradouro deve ter no máximo 200 caracteres")
    private String logradouro;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres")
    private String bairro;

    @NotBlank(message = "A cidade/estado é obrigatória")
    @Size(max = 100, message = "A cidade/estado deve ter no máximo 100 caracteres")
    private String cidadeEstado;

    @NotNull(message = "O tipo de evento é obrigatório")
    private TipoEvento tipoEvento;

    @Min(value = 1, message = "A meta de doações deve ser no mínimo 1")
    private int metaDoacoes;

    private int doacoesRecebidas;

    private LocalDateTime dataInicio;

    @NotNull(message = "A data de término da campanha é obrigatória")
    @Future(message = "A data de término deve ser uma data futura")
    private LocalDateTime dataFim;

    private boolean ativo;

    @NotNull(message = "O ID do criador é obrigatório")
    private Long criadorId;

    public CampanhaDTO() {}

    public CampanhaDTO(
            Long id,
            String nome,
            String descricao,
            String cep,
            String logradouro,
            String bairro,
            String cidadeEstado,
            TipoEvento tipoEvento,
            int metaDoacoes,
            int doacoesRecebidas,
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            boolean ativo,
            Long criadorId
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidadeEstado = cidadeEstado;
        this.tipoEvento = tipoEvento;
        this.metaDoacoes = metaDoacoes;
        this.doacoesRecebidas = doacoesRecebidas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativo = ativo;
        this.criadorId = criadorId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidadeEstado() {
        return cidadeEstado;
    }

    public void setCidadeEstado(String cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMetaDoacoes() {
        return metaDoacoes;
    }

    public void setMetaDoacoes(int metaDoacoes) {
        this.metaDoacoes = metaDoacoes;
    }

    public int getDoacoesRecebidas() {
        return doacoesRecebidas;
    }

    public void setDoacoesRecebidas(int doacoesRecebidas) {
        this.doacoesRecebidas = doacoesRecebidas;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(Long criadorId) {
        this.criadorId = criadorId;
    }
}
