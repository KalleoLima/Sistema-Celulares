package br.com.kalleo.cli;

import br.com.kalleo.domain.user.Cliente;
import br.com.kalleo.service.CarrinhoService;
import br.com.kalleo.service.FreteService;
import br.com.kalleo.service.PedidoService;


import java.util.Scanner;

public class logicaServiceCli {


    Scanner input =  new Scanner(System.in);

    FreteService frete  ;
    PedidoService  PedidoService; // aqui aparentemente nao tem valor também
    CarrinhoService carrinhoService;
    Cliente nome;

    private logicaServiceCli cli;


    public void setCli(logicaServiceCli cli) {
        this.cli = cli;
    }

    //métodos
    public void freteParaLogicaService(FreteService frete) {
        this.frete = frete;
    }

    public void pago(){

        System.out.println("pagamento confirmado!");
        enderecoCliente();

    }
    public void enderecoCliente(){
        System.out.println("digite sua localização para entrega do produto:1 ");
        String localizacao = input.nextLine();
        frete.setLocal(localizacao);
        pedidoCompleto();

    }



  public void pedidoCompleto(){
        double precototalComfrete = carrinhoService.getValorPagamento() + 3;
        System.out.println("localização de entrega: " + frete.getLocal());
        System.out.println("nome do cliente: " + nome.getName());
        System.out.println("preço do produto com frete: " + precototalComfrete );


  }






    public void fazerCompra(){

if ( carrinhoService.getProdutosDocarrinho().size() > 0){
        System.out.println("por segurança queremos fazer a confirmação. \n digite 'fazer compra' " );
        String decisao = input.nextLine();
        if (decisao.equalsIgnoreCase("fazer compra")){
            System.out.println("processando pagamento");
            double total = carrinhoService.calculandoValor();
        System.out.println( "valor total dos produto: " + total);
pago();}
        } else  {System.out.println("o carrinho está vazio!" );return;}
    }

public void removerProduto(){
        System.out.println("digite o nome do produto que você quer remover: ");
    String decisao = input.nextLine();
  if (decisao.equalsIgnoreCase("remover")){
        System.out.println("digite o produto que voce quer remover do carrinho");
        String nameObjeto = input.nextLine();
        carrinhoService.RemoverCarrinho(nameObjeto);};
}





    // set/get abaixos!
    public PedidoService getPedidoService() {
        return PedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
        PedidoService = pedidoService;
    }

    public CarrinhoService getCarrinhoService() {
        return carrinhoService;
    }

    public void setCarrinhoService(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }


    public Cliente getNome() {
        return nome;
    }

    public void setNome(Cliente nome) {
        this.nome = nome;
    }

    public FreteService getFrete() {
        return frete;
    }

    public void setFrete(FreteService frete) {
        this.frete = frete;
    }








}
