class contaPoupanca extends contaBancaria {
    private static final double taxa_de_rendimento = 0.003;
    private double taxaDeRendimento;

    public contaPoupanca(String numeroDaConta, String titular, double saldo) {
        super(numeroDaConta, titular, saldo);
        this.taxaDeRendimento = taxa_de_rendimento;
    }

    @Override
    public void sacar(double valor, Usuario usuario) {
        if (verificarAutorizacao(usuario)) {
            if (this.verificarSaldo(valor)) {
                this.saldo -= valor;
                logTransacao("Saque", valor, usuario);
                System.out.println("Saque de " + valor + " realizado com sucesso da conta " + this.getNumeroDaConta());
            } else {
                System.out.println("Saldo insuficiente " + this.getNumeroDaConta());
            }
        } else {
            System.out.println("Usuário não autorizado");
        }
    }

    @Override
    public void depositar(double valor, Usuario usuario) {
        if (verificarAutorizacao(usuario)) {
            this.saldo += valor;
            logTransacao("Depósito", valor, usuario);
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta " + this.getNumeroDaConta());
        } else {
            System.out.println("Usuário não autorizado");
        }
    }

    public void calculoDeRendimentoMensal() {
        double rendimento = this.saldo * taxaDeRendimento;
        this.saldo += rendimento;
        System.out.println("Rendimento mensal de " + rendimento + " aplicado na conta " + this.getNumeroDaConta());
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

