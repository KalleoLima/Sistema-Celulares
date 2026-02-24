package br.com.kalleo.domain.product;

import br.com.kalleo.repository.ProdutoRepository;

import java.util.UUID;

public class Produto {
    private String id = UUID.randomUUID().toString();
    private String nameProduto;
    private Categorias.categorias categoria;
    private double preco;
    private boolean disponibilidade;
    private int estoque;




    public void  produto(String nameProduto, Categorias.categorias categoria, double preco, boolean disponibilidade, int estoque) {

        if (this.estoque < 0 && preco < 0){
            this.disponibilidade = false;
            return;
        }

        this.id = id;
        this.nameProduto = nameProduto;
        this.categoria = categoria;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.estoque = estoque;


    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduto() {
        return nameProduto;
    }

    public void setNameProduto(String nameProduto) {
        this.nameProduto = nameProduto;
    }

    public Categorias.categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias.categorias categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }



    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nameProduto='" + nameProduto + '\'' +
                ", categoria=" + categoria +
                ", preco=" + preco +
                ", disponibilidade=" + disponibilidade +
                ", estoque=" + estoque +
                '}';
    }
}
