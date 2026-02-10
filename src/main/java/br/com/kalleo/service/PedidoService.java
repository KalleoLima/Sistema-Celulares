package br.com.kalleo.service;


import br.com.kalleo.domain.user.Cliente;

public class PedidoService {
double valor;
String localizacao;
String  nome;
CarrinhoService carrinho;


    public CarrinhoService getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoService carrinho) {
        this.carrinho = carrinho;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
