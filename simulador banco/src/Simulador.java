import java.util.Scanner;

public class Simulador {
    public static void main(String[] args) {
        String nome = "Clark Kent";
        String tipoConta = "Corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.println("***********************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("\n***********************");

        String menu = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor 
                4 - Sair

                """;

        Scanner leitura = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            System.out.print("Escolha: ");
            if (leitura.hasNextInt()) {
                opcao = leitura.nextInt();
            } else {
                System.out.println("Por favor, digite um número válido.");
                leitura.next(); // limpa entrada inválida
                continue;
            }

            if (opcao == 1){
                System.out.printf("O saldo atualizado é R$ %.2f%n", saldo);
            } else if (opcao == 2) {
                System.out.print("Qual o valor que deseja transferir? R$ ");
                double valor = leitura.nextDouble();
                if (valor > saldo) {
                    System.out.println("Não há saldo suficiente para realizar a transferência.");
                } else {
                    saldo -= valor;
                    System.out.printf("Transferência realizada. Novo saldo: R$ %.2f%n", saldo);
                }
            } else if (opcao == 3) {
                System.out.print("Valor recebido: R$ ");
                double valor = leitura.nextDouble();
                saldo += valor;
                System.out.printf("Saldo atualizado: R$ %.2f%n", saldo);
            } else if (opcao != 4) {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Obrigado por usar nosso sistema. Até logo!");
        leitura.close();
    }
}
