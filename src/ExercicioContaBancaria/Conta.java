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
            System.out.printf("Depósito de R$ %.2f efetuado com sucesso. \n", valor);
        }else{
            System.out.println("Depósito não realizado.");
        }

    }

    private void reporChequeEspecial(double valor){
        chequeEspecial += valor;
        saldo -= valor;
        System.out.printf("Reposição de Cheque especial: R$ %.2f \n", valor);
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
        return limiteChequeEspecial - chequeEspecial;
    }


    private double calcularJurosChequeEspecial(){
        return calcularLimiteUsado() * 0.2;
    }

    private void cobrarJuros(){
        saldo -= calcularJurosChequeEspecial();

    }
}
