class contaCorrente  extends contaBancaria {
    @Override
    public void depositar(double valor) {

    }

    private double taxaDeManutencao;

    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }

    public void setTaxaDeManutencao(double taxaDeManutencao) {
        this.taxaDeManutencao = taxaDeManutencao;
    }

    public contaCorrente (String numeroDaConta, String titular, double saldo, double taxaDeManutencao){
        super(numeroDaConta, titular, saldo);
        this.taxaDeManutencao = taxaDeManutencao;
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + taxaDeManutencao;
        if( this.saldo >= valorComTaxa){
            this.saldo -= valorComTaxa;
            System.out.println("Saque de " + valor + " realizado com sucesso da conta " + this.getNumeroDaConta() );
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
