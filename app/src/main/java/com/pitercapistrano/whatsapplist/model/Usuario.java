package com.pitercapistrano.whatsapplist.model;

import android.provider.ContactsContract;

public class Usuario {

    /*como iremos utilizar fotos armazenadas dentro do programa e não de um banco de dados
    utilizaremos uma variável do tipo "int" ao invés de uma do tipo "String"*/

    private int foto;
    private String nome;
    private String mensagem;

    //Constructor para Usuario
    public Usuario(int foto, String nome, String mensagem) {
        this.foto = foto;
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
