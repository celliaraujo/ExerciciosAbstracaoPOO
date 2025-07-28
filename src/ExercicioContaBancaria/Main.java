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

        System.out.println(" ============================================");
        System.out.println(" |      BEM-VINDO AO SISTEMA BANCO GB       |");
        System.out.println(" ==========É G de good. É B de bank==========");

        int option = 0;

        do {
            System.out.println("    1 - Consultar saldo");
            System.out.println("    2 - Consultar limite do cheque especial");
            System.out.println("    3 - Depositar");
            System.out.println("    4 - Sacar");
            System.out.println("    5 - Pagar boleto");
            System.out.println("    6 - Verificar se está no cheque especial");
            System.out.println("    7 - Sair");

            System.out.println(" --------------------------------------------");
            System.out.print("  Qual operação deseja realizar ? ");

            option = scan.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Consultar saldo: ");
                    System.out.printf("   R$ %.2f \n", conta.getSaldo());
                    System.out.println(" --------------------------------------------");
                }
                case 2 -> {
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Consultar cheque especial: ");
                    System.out.printf("   R$ %.2f \n", conta.getChequeEspecial());
                    System.out.println(" --------------------------------------------");
                }
                case 3 -> {
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Depositar na conta: ");
                    System.out.print("   Digite o valor a ser depositado: ");
                    valor = scan.nextDouble();
                    conta.depositar(valor);
                    System.out.println(" --------------------------------------------");
                }
                case 4 -> {
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Sacar da conta: ");
                    System.out.print("   Digite o valor a ser sacado: ");
                    valor = scan.nextDouble();
                    conta.sacar(valor);
                    System.out.println(" --------------------------------------------");
                }
                case 5 -> {
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Pagar boleto: ");
                    System.out.print("   Digite o valor do boleto: ");
                    valor = scan.nextDouble();
                    System.out.print("   Digite a data de vencimento: ");
                    String dataStr = scan.next();
                    LocalDate vencimento = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    conta.pagarBoleto(valor, vencimento);
                    System.out.println(" --------------------------------------------");
                }
                default -> System.out.println("Opção inválida...");
            }

        }while(option != 7);
    }
}
