package ExercicioContaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Conta conta = new Conta(500);

        System.out.println(" ============================================");
        System.out.println(" |      BEM-VINDO AO SISTEMA BANCO GB       |");
        System.out.println(" ============================================");

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

            switch(option){
                case 1:
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Consultar saldo: ");
                    System.out.printf("   R$ %.2f \n", conta.getSaldo());
                    System.out.println(" --------------------------------------------");
                    break;
                case 2:
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Consultar cheque especial: ");
                    System.out.printf("   R$ %.2f \n", conta.getChequeEspecial());
                    System.out.println(" --------------------------------------------");
                    break;
                case 3:
                    System.out.println(" --------------------------------------------");
                    System.out.println("   Depositar na conta: ");
                    System.out.printf("   R$ %.2f \n", conta.getChequeEspecial());
                    System.out.println(" --------------------------------------------");
                    break;
                default:
                    System.out.println("Opção inválida...");
            }

        }while(option != 7);
    }
}
