package ExercicioContaBancaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private double saldo;
    private double chequeEspecial;
    private List<String> extrato;

    public Conta(double valor){
        this.chequeEspecial = valor <= 500 ? 50 : valor * 0.5;
        this.saldo = valor;
        this.extrato = new ArrayList<>();
    }

    public double getSaldo(){
        return saldo;
    }

    public double getChequeEspecial(){
        if(saldo < 0) return saldo + chequeEspecial;
        return chequeEspecial;
    }

    public void depositar(double valor){
        if(valor > 0) {
            double jurosAtual = calcularJurosChequeEspecial();
            if(saldo + valor >= jurosAtual){
                cobrarJuros();
            }
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f efetuado com sucesso. \n", valor);
            extrato.add(String.format("Depósito: R$ %.2f \n", valor));
        }else{
            System.out.println("Depósito não realizado.");
        }
    }

    public String estouNoCheque(){
        if(saldo < 0) return String.format("Sim, você está usando R$ %.2f \n do seu cheque especial.\n", saldo * -1);
        else return "Não está usando o cheque especial.";
    }

    public void pagarBoleto(double valor, LocalDate vencimento){
        LocalDate hoje = LocalDate.now();
        //System.out.printf("Hoje: %s --- Vencimento: %s\n", hoje, vencimento);
        if(vencimento.compareTo(hoje) < 0) {
            System.out.println("Não foi possível realizar o pagamento. Prazo vencido.");
        }else{
            if (valor <= saldo + chequeEspecial) {
                saldo -= valor;
                System.out.printf("Boleto de R$ %s pago com sucesso. \n", valor);
                extrato.add(String.format("Pagamento boleto: - R$ %.2f \n", valor));

            } else {
                System.out.println("Saldo insuficiente.");
            }

        }
    }

        public void sacar(double valor){
        if(valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.printf("Saque de R$ %s efetuado com sucesso. \n", valor);
            extrato.add(String.format("Saque: - R$ %.2f \n", valor));

        }else{
            System.out.println("Saldo insuficiente.");
        }

    }

    private double calcularLimiteUsado(){
        if(saldo < 0) return saldo * -1;
        else return 0;
    }


    private double calcularJurosChequeEspecial(){
        return calcularLimiteUsado() * 0.2;
    }

    private void cobrarJuros(){
        double jurosCobrado = calcularJurosChequeEspecial();
        saldo -= jurosCobrado;
        if(jurosCobrado > 0) {
            System.out.printf("R$ %.2f debitado: juros do Cheque Especial.\n", jurosCobrado);
            extrato.add(String.format("Juros cheque especial: \n - R$ %.2f \n", jurosCobrado));
        }

    }

    public void exibirExtrato(){
        for(String operacao : extrato){
            System.out.println(operacao);
        }
        System.out.printf("Saldo disponível: R$ %.2f \n", saldo);
    }
}
