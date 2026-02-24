package br.com.kalleo.repository;

import br.com.kalleo.domain.product.Produto;

import java.util.Formattable;
import java.util.HashSet;
import java.util.Set;

public class ProdutoRepository implements Comparable {

    Set<Produto> produtos = new HashSet<>();
Produto daClassProduto;
    public void addProdutoo(Produto produto){
        produtos.add(produto);
    }


    public void reduzirRepository(String name){
        
        for (Produto x : produtos){
    if (x.getNameProduto().equalsIgnoreCase(name)){
int reducao = daClassProduto.getEstoque() - 1;
    daClassProduto.setEstoque(reducao);
    }
        }
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

    public Set <Produto> produtos(){

        return produtos;
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

    public boolean reduzirEstoque(String nomeProduto, int quantidade) {
        for (Produto x : produtos) {
            if (x.getNameProduto().equalsIgnoreCase(nomeProduto)) {
                
                // Verifica se tem estoque suficiente
                if (x.getEstoque() >= quantidade) {
                    int novoEstoque = x.getEstoque() - quantidade;
                    x.setEstoque(novoEstoque);
                    System.out.println("✓ Estoque reduzido: " + x.getNameProduto() + 
                                       " (restam " + x.getEstoque() + " unidade(s))");
                    return true;  // Sucesso - produto encontrado e estoque reduzido
                } else {
                    System.out.println("✗ Estoque insuficiente! " + x.getNameProduto() + 
                                       " tem apenas " + x.getEstoque() + " unidade(s)");
                    return false;  // Falhou - sem estoque suficiente
                }
            }
        }
        // Se chegou aqui, produto não foi encontrado
        System.out.println("✗ Produto não encontrado: " + nomeProduto);
        return false;
    }

    @Override
    public String toString() {
        return "ProdutoRepository{" +
                "produtos=" + produtos +
                '}';

    }
}
