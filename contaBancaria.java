abstract class contaBancaria implements operacoes{
    private String numeroDaConta;
    private String titular;
    protected double saldo;

    public contaBancaria(String numeroDaConta, String titular, double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void transferir(double valor, contaBancaria destino) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso para " + destino.getNumeroDaConta());
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}