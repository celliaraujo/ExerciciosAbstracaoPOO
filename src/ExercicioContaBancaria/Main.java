package ExercicioContaBancaria;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Conta conta = new Conta(500);
        double valor;

        System.out.println(
                """
                =================================
                        SISTEMA BANCO GB
                ======== Seja Bem-Vindo! ========
                """);

        int option = 0;

        do {
            System.out.println(
            """                    
                    ==== ========= *** ========= ====
                    [1] Consultar Saldo
                    [2] Cheque Especial
                    [3] Depósito
                    [4] Saque
                    [5] Pagar Boleto
                    [6] Estou no Cheque?
                    [7] Exibir Extrato
                    [8] Encerrar Sessão                
                    ==== ========= *** ========= ====
                    """);
            System.out.print("Digite a operação: ");

            option = scan.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("""
                                    =================================
                                             Consultar Saldo
                                    =================================
                                    """);
                    System.out.printf("R$ %.2f \n", conta.getSaldo());

                }
                case 2 -> {
                    System.out.println("""
                                    =================================
                                        Consultar Cheque Especial
                                    =================================
                                    """);
                    System.out.printf("R$ %.2f \n", conta.getChequeEspecial());

                }
                case 3 -> {
                    System.out.println("""
                                    =================================
                                            Depositar na conta
                                    =================================
                                    """);
                    System.out.print("Digite o valor a ser depositado: ");
                    valor = scan.nextDouble();
                    conta.depositar(valor);

                }
                case 4 -> {
                    System.out.println("""
                                    =================================
                                                   Sacar
                                    =================================
                                    """);
                    System.out.print("Digite o valor a ser sacado: ");
                    valor = scan.nextDouble();
                    conta.sacar(valor);

                }
                case 5 -> {
                    System.out.println("""
                                    =================================
                                                Pagar Boleto
                                    =================================
                                    """);
                    System.out.print("Digite o valor do boleto: ");
                    valor = scan.nextDouble();
                    System.out.print("Digite a data de vencimento: ");
                    String dataStr = scan.next();
                    LocalDate vencimento = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    conta.pagarBoleto(valor, vencimento);

                }
                case 6 -> {
                    System.out.println("""
                                    =================================
                                       Entrei no Cheque Especial ?
                                    =================================
                                    """);
                    System.out.println(conta.estouNoCheque());

                }
                case 7 -> {
                    System.out.println("""
                                    =================================
                                             Exibir Extrato
                                    =================================
                                    """);
                    conta.exibirExtrato();

                }
                case 8 -> {
                    System.out.println("""
                                    =================================
                                          Encerrando a Aplicação...
                                    =================================
                                    """);
                }
                default -> System.out.println("Opção inválida...");
            }

        }while(option != 8);
    }
}
