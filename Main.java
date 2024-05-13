import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo(a) ao Sistema de Gerenciamento de Contas Bancárias");

        System.out.println("Cadastrar Conta Corrente");
        System.out.print("Número da conta: ");
        String numeroContaCC = scanner.nextLine();
        System.out.print("Titular da conta: ");
        String titularCC = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldoInicialCC = scanner.nextDouble();
        System.out.print("Taxa de manutenção: ");
        double taxaManutencao = scanner.nextDouble();
        contaCorrente cc1 = new contaCorrente(numeroContaCC, titularCC, saldoInicialCC, taxaManutencao);

        System.out.println("Cadastrar Conta Poupança");
        scanner.nextLine();
        System.out.print("Número da conta: ");
        String numeroContaCP = scanner.nextLine();
        System.out.print("Titular da conta: ");
        String titularCP = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldoInicialCP = scanner.nextDouble();
        System.out.print("Taxa de rendimento: ");
        double taxaRendimento = scanner.nextDouble();
        contaPoupanca cp1 = new contaPoupanca(numeroContaCP, titularCP, saldoInicialCP, taxaRendimento);

        System.out.println("Operações Conta Corrente");
        System.out.print("Digite o valor para sacar: ");
        double valorSaqueCC = scanner.nextDouble();
        cc1.sacar(valorSaqueCC);
        System.out.print("Digite o valor para depositar: ");
        double valorDepositoCC = scanner.nextDouble();
        cc1.depositar(valorDepositoCC);

        System.out.println("Operações Conta Poupança");
        System.out.print("Digite o valor para sacar: ");
        double valorSaqueCP = scanner.nextDouble();
        cp1.sacar(valorSaqueCP);
        System.out.print("Digite o valor para depositar: ");
        double valorDepositoCP = scanner.nextDouble();
        cp1.depositar(valorDepositoCP);

        System.out.println("Cálculo de rendimento Conta Poupança");
        cp1.calculoDeRendimentoMensal();

        System.out.println("Transferência");
        System.out.print("Digite o valor para transferir : ");
        double valorTransferencia = scanner.nextDouble();
        cc1.transferir(valorTransferencia, cp1);

        System.out.println("Saldo final da Conta Corrente " + cc1.getNumeroDaConta() + ": " + cc1.getSaldo());
        System.out.println("Saldo final da Conta Poupança " + cp1.getNumeroDaConta() + ": " + cp1.getSaldo());


    }
}
