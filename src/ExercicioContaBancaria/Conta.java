package ExercicioContaBancaria;

public class Conta {
    double saldo;
    double chequeEspecial;
    double limiteChequeEspecial;
    boolean usouLimiteCheque;

    public Conta(double valor){
        this.limiteChequeEspecial = valor <= 500 ? 50 : valor * 0.5;
        this.chequeEspecial = this.limiteChequeEspecial;
        this.saldo = valor;
    }

    public double getSaldo(){
        return saldo;
    }

    public double getChequeEspecial(){
        return chequeEspecial;
    }

    public void depositar(double valor){
        if(valor > 0) {
            saldo += valor;
        }

    }

    public void debitar(double valor){
        if(valor < saldo) {
            saldo -= valor;
            System.out.printf("Saque: R$ %s \n", valor);

        }else if (valor < saldo + chequeEspecial){
            chequeEspecial -= valor - saldo;
            double valorAtualizado  = valor - saldo;
            saldo -= valorAtualizado;

            usouLimiteCheque = true;

        }else{
            System.out.println("Saldo insuficiente.");
        }

    }


    private double calcularJurosChequeEspecial(){
        double juros = 0;
        if(usouLimiteCheque){
            double valorChequeUsado = limiteChequeEspecial - chequeEspecial;
            juros = valorChequeUsado * 0.2;

        }
        return juros;
    }

    private void cobrarJuros(){
        if()
    }
}
