interface Operacoes {
    void sacar(double valor, Usuario usuario);
    void depositar(double valor, Usuario usuario);
    void transferir(double valor, contaBancaria destino, Usuario usuario);
}
