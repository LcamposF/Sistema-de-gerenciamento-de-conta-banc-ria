import java.util.Scanner;
public class Main {
    private static
    Scanner sc = new Scanner(System.in);
    private static contaCorrente contaCorrente;
    private static contaPoupanca contaPoupanca;

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n---------------------------------------------------------");
            System.out.println("\n--------------- Bem vindo a nossa Agência ---------------");
            System.out.println("\n---------------------------------------------------------");
            System.out.println("\n---------------Que operação deseja realizar? ------------");
            System.out.println("\n          1. Cadastrar Conta Corrente          ");
            System.out.println("\n          2. Cadastrar Conta Poupança");
            System.out.println("\n          3. Realizar Saque (Conta Corrente)");
            System.out.println("\n          4. Realizar Depósito (Conta Corrente)");
            System.out.println("\n          5. Realizar Saque (Conta Poupança)");
            System.out.println("\n          6. Realizar Depósito (Conta Poupança)");
            System.out.println("\n          7. Calcular Rendimento Mensal (Conta Poupança)");
            System.out.println("\n          8. Transferir da Conta Corrente para a Conta Poupança");
            System.out.println("\n          9. Mostrar Saldos");
            System.out.println("\n          10. Sair");
            System.out.print("\n Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarContaCorrente();
                    break;
                case 2:
                    cadastrarContaPoupanca();
                    break;
                case 3:
                    realizarSaque(contaCorrente);
                    break;
                case 4:
                    realizarDeposito(contaCorrente);
                    break;
                case 5:
                    realizarSaque(contaPoupanca);
                    break;
                case 6:
                    realizarDeposito(contaPoupanca);
                    break;
                case 7:
                    calcularRendimentoMensal();
                    break;
                case 8:
                    transferirEntreContas();
                    break;
                case 9:
                    mostrarSaldos();
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarContaCorrente() {
        sc.nextLine();
        System.out.print("Número da conta: ");
        String numeroContaCC = sc.nextLine();
        System.out.print("Titular da conta: ");
        String titularCC = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double saldoInicialCC = sc.nextDouble();
        System.out.print("Taxa de manutenção: ");
        double taxaManutencao = sc.nextDouble();
        contaCorrente = new contaCorrente(numeroContaCC, titularCC, saldoInicialCC, taxaManutencao);
        System.out.println("Conta Corrente cadastrada com sucesso.");
    }

    private static void cadastrarContaPoupanca() {
        sc.nextLine();
        System.out.print("Número da conta: ");
        String numeroContaCP = sc.nextLine();
        System.out.print("Titular da conta: ");
        String titularCP = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double saldoInicialCP = sc.nextDouble();
        System.out.print("Taxa de rendimento: ");
        double taxaRendimento = sc.nextDouble();
        contaPoupanca = new contaPoupanca(numeroContaCP, titularCP, saldoInicialCP, taxaRendimento);
        System.out.println("Conta Poupança cadastrada com sucesso.");
    }

    private static void realizarSaque(contaBancaria conta) {
        if (conta != null) {
            System.out.print("Digite o valor para sacar: ");
            double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não cadastrada.");
        }
    }

    private static void realizarDeposito(contaBancaria conta) {
        if (conta != null) {
            System.out.print("Digite o valor para depositar: ");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não cadastrada.");
        }
    }

    private static void calcularRendimentoMensal() {
        if (contaPoupanca != null) {
            contaPoupanca.calculoDeRendimentoMensal();
        } else {
            System.out.println("Conta Poupança não cadastrada.");
        }
    }

    private static void transferirEntreContas() {
        if (contaCorrente != null && contaPoupanca != null) {
            System.out.print("Digite o valor para transferir: ");
            double valorTransferencia = sc.nextDouble();
            contaCorrente.transferir(valorTransferencia, contaPoupanca);
        } else {
            System.out.println("Ambas as contas devem estar cadastradas para realizar a transferência.");
        }
    }

    private static void mostrarSaldos() {
        if (contaCorrente != null) {
            System.out.println("Saldo Conta Corrente " + contaCorrente.getNumeroDaConta() + ": " + contaCorrente.getSaldo());
        } else {
            System.out.println("Conta Corrente não cadastrada.");
        }
        if (contaPoupanca != null) {
            System.out.println("Saldo Conta Poupança " + contaPoupanca.getNumeroDaConta() + ": " + contaPoupanca.getSaldo());
        } else {
            System.out.println("Conta Poupança não cadastrada.");
        }
    }
}