package br.com.kalleo.cli;

import br.com.kalleo.domain.user.Cliente;
import br.com.kalleo.service.CarrinhoService;
import br.com.kalleo.service.FreteService;
import br.com.kalleo.service.PedidoService;


import java.io.*;
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
        System.out.println("preço do produto com frete: " + precototalComfrete);
        System.out.println("nome do produto: " + carrinhoService.getProdutosDocarrinho());

      try {
          salvandoPedidos();
      } catch (IOException e) {
          throw new RuntimeException(e.getCause());
      }
  }






    public void fazerCompra(){

if ( carrinhoService.getProdutosDocarrinho().size() > 0){
        System.out.println("por segurança queremos fazer a confirmação. \ndigite 'fazer compra' " );
        String decisao = input.nextLine();
        if (decisao.equalsIgnoreCase("fazer compra")){
            System.out.println("processando pagamento");
            
            // Reduz estoque e calcula valor
            carrinhoService.fazerCompraDoCarrinho();
            double total = carrinhoService.getValorPagamento();
            
        System.out.println( "valor total dos produto: " + total);
pago();}
        } else  {System.out.println("o carrinho está vazio!" );return;}
    }

public void removerProduto(){
        System.out.println("se voce realmente quer remover produto, digite 'remover' ");
    String decisao = input.nextLine();
  if (decisao.equalsIgnoreCase("remover")){
        System.out.println("digite o produto que voce quer remover do carrinho");
        String nameObjeto = input.nextLine();
        carrinhoService.removerCarrinho(nameObjeto);};
}

// salvar em arquivos
    public void salvandoPedidos() throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        File f = new File("StatusPedidos");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName(),true));
        double precototalComfrete = carrinhoService.getValorPagamento() + 3;
        String papel = "";
        for (String carrin : carrinhoService.getProdutosDocarrinho()){
            System.out.println(carrin);
         papel = carrin;
        }
        bw.newLine();
        bw.write("nome do Cliente: " + nome.getName());
        bw.newLine();

        bw.write("preço total do produto: $" + precototalComfrete);
        bw.newLine();

        bw.write("localização: "+frete.getLocal());
        bw.newLine();



bw.write("nome do produto: " + papel);

            System.out.printf("aquivo %s foi aberto, check ele assim que terminar execução ",f.getName() );
            bw.flush();
            bw.close();



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
