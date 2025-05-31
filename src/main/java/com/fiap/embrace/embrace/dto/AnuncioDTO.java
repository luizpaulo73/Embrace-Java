package com.fiap.embrace.embrace.dto;

import com.fiap.embrace.embrace.entities.TipoEvento;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AnuncioDTO {
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
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

    @NotBlank(message = "O tipo de recurso é obrigatório")
    @Size(max = 100, message = "O tipo de recurso deve ter no máximo 100 caracteres")
    private String tipoRecurso;

    @NotNull(message = "A data de término é obrigatória")
    @Future(message = "A data de término deve ser uma data futura")
    private LocalDateTime dataFim;

    private boolean ativo;
    private int totalOfertado;

    @NotNull(message = "O ID do autor é obrigatório")
    private Long autorId;

    public AnuncioDTO() {}

    public AnuncioDTO(
            Long id,
            String titulo,
            String descricao,
            String cep,
            String logradouro,
            String bairro,
            String cidadeEstado,
            TipoEvento tipoEvento,
            String tipoRecurso,
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            boolean ativo,
            int totalOfertado,
            Long autorId
    ) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidadeEstado = cidadeEstado;
        this.tipoEvento = tipoEvento;
        this.tipoRecurso = tipoRecurso;
        this.dataFim = dataFim;
        this.ativo = ativo;
        this.totalOfertado = totalOfertado;
        this.autorId = autorId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
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

    public int getTotalOfertado() {
        return totalOfertado;
    }

    public void setTotalOfertado(int totalOfertado) {
        this.totalOfertado = totalOfertado;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
