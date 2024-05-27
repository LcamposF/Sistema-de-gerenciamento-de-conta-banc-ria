class contaCorrente extends contaBancaria {
    private static final double taxa_de_manutencao = 0.50;
    private double taxaDeManutencao;

    public contaCorrente(String numeroDaConta, String titular, double saldo) {
        super(numeroDaConta, titular, saldo);
        this.taxaDeManutencao = taxa_de_manutencao;
    }

    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }

    public void setTaxaDeManutencao(double taxaDeManutencao) {
        this.taxaDeManutencao = taxaDeManutencao;
    }

    @Override
    public void sacar(double valor, Usuario usuario) {
        double valorComTaxa = valor + taxaDeManutencao;
        if (this.verificarSaldo(valorComTaxa)) {
            if (verificarAutorizacao(usuario)) {
                this.saldo -= valorComTaxa;
                logTransacao("Saque", valor, usuario);

            } else {
                System.out.println("Usuário não autorizado");
            }
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor, Usuario usuario) {
        this.saldo += valor;
        if (verificarAutorizacao(usuario)) {
            logTransacao("Depósito", valor, usuario);
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta " + this.getNumeroDaConta());
        } else {
            this.saldo -= valor; // Desfaz a operação de depósito
            System.out.println("Usuário não autorizado");
        }
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
