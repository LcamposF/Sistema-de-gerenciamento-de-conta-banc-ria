class contaPoupanca extends contaBancaria{
    private double taxaDeRendimento;

    public contaPoupanca (String numeroDaConta, String titular, double saldo, double taxaDeRendimento){
        super(numeroDaConta, titular, saldo);
        this.taxaDeRendimento = taxaDeRendimento;
    }

    @Override
    public void sacar (double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso da conta " + this.getNumeroDaConta());
        } else {
            System.out.println("Saldo insuficiente " + this.getNumeroDaConta());
        }
    }

    @Override
    public void depositar (double valor) {
        this.saldo += valor;
        System.out.println("Depósito de " + valor + "realizado com sucesso na conta" + this.getNumeroDaConta());
    }

    public void calculoDeRendimentoMensal(){
        double rendimento = this.saldo * taxaDeRendimento;
        this.saldo += rendimento;
        System.out.println("Rendimento mensal de " + rendimento + "aplicado na conta" + this.getNumeroDaConta());
        }
    }

