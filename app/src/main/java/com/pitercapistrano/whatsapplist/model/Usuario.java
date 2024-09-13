package com.pitercapistrano.whatsapplist.model;

// Classe que representa um usuário com foto, nome e mensagem
public class Usuario {

    // Variável para armazenar a foto do usuário, utilizando um identificador de recurso (int) em vez de uma String
    private int foto;
    // Variável para armazenar o nome do usuário
    private String nome;
    // Variável para armazenar a mensagem do usuário
    private String mensagem;

    // Construtor para inicializar um objeto Usuario com foto, nome e mensagem
    public Usuario(int foto, String nome, String mensagem) {
        this.foto = foto;  // Atribui o identificador da foto à variável foto
        this.nome = nome;  // Atribui o nome do usuário à variável nome
        this.mensagem = mensagem;  // Atribui a mensagem do usuário à variável mensagem
    }

    // Método para obter o identificador da foto do usuário
    public int getFoto() {
        return foto;  // Retorna o identificador da foto
    }

    // Método para definir o identificador da foto do usuário
    public void setFoto(int foto) {
        this.foto = foto;  // Atualiza o identificador da foto
    }

    // Método para obter o nome do usuário
    public String getNome() {
        return nome;  // Retorna o nome do usuário
    }

    // Método para definir o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;  // Atualiza o nome do usuário
    }

    // Método para obter a mensagem do usuário
    public String getMensagem() {
        return mensagem;  // Retorna a mensagem do usuário
    }

    // Método para definir a mensagem do usuário
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;  // Atualiza a mensagem do usuário
    }
}
