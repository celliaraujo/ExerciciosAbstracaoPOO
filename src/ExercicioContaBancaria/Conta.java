package ExercicioContaBancaria;

public class Conta {
    double saldo;
    double chequeEspecial;

    public Conta(double valor){
        this.chequeEspecial = valor <= 500 ? 50 : valor * 0.5;
        this.saldo = valor;
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
        }else{
            System.out.println("Depósito não realizado.");
        }


    }

        public void sacar(double valor){
        if(valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.printf("Saque de R$ %s efetuado com sucesso. \n", valor);

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
        System.out.printf("R$ %.2f debitado: juros do Cheque Especial.\n", jurosCobrado);

    }
}
