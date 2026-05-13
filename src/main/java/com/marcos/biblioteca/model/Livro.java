package com.marcos.biblioteca.model;

public class Livro {
    final private String titulo;
    final private String autor;
    final private String categoria;
    private StatusLeitura status;

    public Livro(String titulo, String autor, String categoria, StatusLeitura status) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public StatusLeitura getStatus() {
        return status;
    }

    public void setStatus(StatusLeitura status) {
        this.status = status;
    }
}
