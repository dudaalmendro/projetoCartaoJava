// Nome do arquivo: projeto_1_java_banco.java

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class projetoCartao {
    
    static List<Compra> Duda = new ArrayList<>();
    static List<Compra> Marlene = new ArrayList<>();
    static List<Compra> Jessica = new ArrayList<>();
    
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        System.out.println("██████╗  █████╗ ███╗   ██╗ ██████╗  ██████╗ ");
        System.out.println("██╔══██╗██╔══██╗████╗  ██║██╔════╝ ██╔═══██╗");
        System.out.println("██████╔╝███████║██╔██╗ ██║██║      ██║   ██║");
        System.out.println("██╔══██ ██╔══██║██║╚██╗██║██║      ██║   ██║");
        System.out.println("███████ ██║  ██║██║ ╚████║╚██████╗ ╚██████╔╝");
        System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ");

        main();
        
    }

    //adicionar uma classe nova para cada compra
    static class Compra {
        double valor;
        String categoria;
        String data;

        Compra(double valor, String categoria, String data) {
            this.valor = valor;
            this.categoria = categoria;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Valor: " + valor + ", Categoria: " + categoria + ", Data: " + data;
        }
        
    }
    
    //funcao para a opcao numero 1(cadastrar um novo valor)
    static void numero_1(){
        Scanner scanner = new Scanner(System.in);

        String numero_1;
        System.out.println("Você escolheu cadastrar uma nova ccompra.");
        System.out.println("Digite o nome da pessoa que realizou a compra: ");
        System.out.println("Escreva o nome com a primeira letra maiúscula e sem espaço");
        //ler o nomer da pessoa que ira adiciocar o valor na lista 
        String nome_lista = scanner.nextLine();

        //ler a quantidade que quer adicionar na lista 
        System.out.println("Digite o valor: ");
        double valor_lista = scanner.nextDouble();
        scanner.nextLine(); 
        //ler a categoria
        System.out.println("Digite a categoria da compra: ");
        String categoria_lista = scanner.nextLine();
        //ler a data 
        System.out.println("Digite a data da compra: ");
        String data_lista = scanner.nextLine();

        //objeto com a compra nova
        Compra novaCompra = new Compra(valor_lista, categoria_lista, data_lista);

        // ler o if para adicionar na lista certa 
        if (nome_lista.equals("Duda")) {
            Duda.add(novaCompra);
        } else if (nome_lista.equals("Marlene")) {
            Marlene.add(novaCompra);
        } else if (nome_lista.equals("Jessica")) {
            Jessica.add(novaCompra);
        } else {
            System.out.println("Nome não encontrado.");
        }
        System.out.println("------------------------------------------------------------------");
        menu_principal();

    }
  
    //funcao para consultar o valor total da fatura: 
   static void numero_2(){
     double total_2= 0;
     double total_1 = 0;
     double total_3 = 0;
     double total;
     // fazendo a soma da primeira lista "duda"
     for (Compra compra : Duda){
         total_1 += compra.valor;
     }   

     //fazendo a soma da segunda lista "marlene"
     for (Compra compra: Marlene){
        total_2 += compra.valor;
     }

     // fazendo a soma da terceira litsa "Jessica"
     for (Compra compra : Jessica){
        total_3 += compra.valor;
     }
     total = total_1 + total_2 + total_3;

     // printando o valor total da fatura: 
     System.out.println("O valor total da fatura é igual a: " + total);

     System.out.println("------------------------------------------------------------------");

     menu_principal();

   }

   // funcao para ver a fatura por nomes:
   static void numero_3(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o nome da conta que quer saber: ");
    String nome_conta = scanner.nextLine();

    //checar se é o nome para sair a lista:
    if (nome_conta.equalsIgnoreCase("Duda")){
    //acessando cada lista e printando os produtos:
        for(Compra compra : Duda){
            System.out.print("Valor: " + compra.valor + " | ");
            System.out.print("Categoria: " + compra.categoria + " | ");
            System.out.println("Data: " + compra.data + " | ");
        }
    //checar se é o nome para sair a lista:
     } else if (nome_conta.equalsIgnoreCase("Marlene")){
        //acessando cada lista e printando os produtos:
        for(Compra compra : Marlene){
            System.out.print("Valor: " + compra.valor + " | ");
            System.out.print("Categoria: " + compra.categoria + " | ");
            System.out.println("Data: " + compra.data + " | ");
        }
         //checar se é o nome para sair a lista
     } else if (nome_conta.equalsIgnoreCase("Jessica")){
        //acessando cada lista e printando os produtos:
        for(Compra compra : Jessica){
            System.out.print("Valor: " + compra.valor + " | ");
            System.out.print("Categoria: " + compra.categoria + " | ");
            System.out.println("Data: " + compra.data + " | ");
     }
    }
    System.out.println("------------------------------------------------------------------");
    menu_principal();
   }
   
   // funcao para sair do aplicativo:
   static void numero_4(){
    System.out.println("Você escolheu sair do aplicativo.");
   }
   
   //funcao para opcoes no inicio do aplicativo 
    static void opcoes(){
        Scanner scanner = new Scanner(System.in);
        // colocando asopcoes na tela
        System.out.println("Escolha uma opção para seguir no aplicativo: ");
        System.out.println("1. Cadastrar uma nova compra");
        System.out.println("2. Consultar valor total da fatura");
        System.out.println("3. Ver fatura por nomes");
        System.out.println("4. Fchar aplicativo");

        int opcao_cliente = scanner.nextInt(); 

        // ligando as opcoes com as funcoes:
            if (opcao_cliente == 1){
                numero_1();
            } else if (opcao_cliente == 2){
                numero_2();
            } else if (opcao_cliente == 3){
                numero_3();
            } else{
                numero_4();
            }
        System.out.println("------------------------------------------------------------------");
 
    }
    
    //looping ate que a pessoa clique para sair:
    static void menu_principal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se quiser voltar ao menus principal digite qualquer tecla: ");
        String voltar = scanner.nextLine(); 
        opcoes();
    }
   
    static void main(){
        opcoes();
    }
}
