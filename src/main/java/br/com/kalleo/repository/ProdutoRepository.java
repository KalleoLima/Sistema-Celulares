package br.com.kalleo.repository;

import br.com.kalleo.domain.product.Produto;

import java.util.HashSet;
import java.util.Set;

public class ProdutoRepository implements Comparable {

    Set<Produto> produtos = new HashSet<>();

    public void addProdutoo(Produto produto){
        produtos.add(produto);
    }




    public Set <Produto> produtos(){

        return produtos;
    }




    public  double buscandoPorNome(String nome){
        String name ;
        double precoTotal = 0d;

        for (Produto S : produtos){
            if (S.getNameProduto().equalsIgnoreCase(nome)){
                precoTotal += S.getPreco();
                return precoTotal;
            }
        }


        return precoTotal;

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "ProdutoRepository{" +
                "produtos=" + produtos +
                '}';

    }
}
