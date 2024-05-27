abstract class contaBancaria implements Operacoes {
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

    protected void logTransacao(String tipo, double valor, Usuario usuario) {

    }

    protected boolean verificarAutorizacao(Usuario usuario) {
        return usuario != null && usuario.isAutorizado();
    }

    protected boolean verificarSaldo(double valor) {
        return this.saldo >= valor;
    }

    @Override
    public void transferir(double valor, contaBancaria destino, Usuario usuario) {
        if (verificarAutorizacao(usuario)) {
            if (this.verificarSaldo(valor)) {
                this.sacar(valor, usuario);
                destino.depositar(valor, usuario);
                logTransacao("Transferência", valor, usuario);
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Usuário não autorizado");
        }
    }
}
