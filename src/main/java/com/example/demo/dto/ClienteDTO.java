package com.example.demo.dto;

public class ClienteDTO {
    private String endereco;

    public ClienteDTO(String endereco) {
        this.endereco =endereco;


    }

    public String getEndereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }
}