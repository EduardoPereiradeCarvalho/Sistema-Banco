import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

enum Situacao {
    ATIVO, INATIVO;
}

public class Conta {
    private long numero;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private Situacao situacao;
    private String senha;
    private double saldo;
    private List<Movimento> movimentacoes;

    public Conta() {
        movimentacoes = new ArrayList<>();
        this.dataAbertura = LocalDateTime.now();
        this.situacao = Situacao.ATIVO;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private void adicionarMovimento(Movimento movimento) {
        movimentacoes.add(movimento);
    }

    private boolean isAtiva() {
        return situacao == Situacao.ATIVO;
    }

    private String obterDataHoraAtual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    public void sacar(double valor) {
        if (!isAtiva()) {
            throw new IllegalStateException("Conta desativada!");
        }
        if (valor <= 0 || valor > saldo) {
            throw new IllegalArgumentException("Valor inválido ou saldo insuficiente!");
        }

        saldo -= valor;
        Movimento movimento = new Movimento(2, valor, obterDataHoraAtual());
        adicionarMovimento(movimento);
        System.out.println("Saque realizado: R$ " + valor);
    }

    public void depositar(double valor) {
        if (!isAtiva()) {
            throw new IllegalStateException("Conta desativada!");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido!");
        }

        saldo += valor;
        Movimento movimento = new Movimento(1, valor, obterDataHoraAtual());
        adicionarMovimento(movimento);
        System.out.println("Depósito realizado: R$ " + valor);
    }

    public void transferir(Conta contaDestino, double valor) {
        if (!isAtiva()) {
            throw new IllegalStateException("Conta desativada!");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta destino não pode ser nula.");
        }
        if (valor <= 0 || valor > saldo) {
            throw new IllegalArgumentException("Valor inválido ou saldo insuficiente!");
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
        Movimento movimento = new Movimento(3, valor, obterDataHoraAtual());
        adicionarMovimento(movimento);
        System.out.println("Transferência realizada: R$ " + valor);
    }

    public String obterExtrato() {
        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato da Conta\n");
        extrato.append("Número da Conta: ").append(numero).append("\n");
        extrato.append("Data de Abertura: ").append(dataAbertura.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))).append("\n");

        if (dataEncerramento != null) {
            extrato.append("Data de Encerramento: ").append(dataEncerramento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))).append("\n");
        }

        extrato.append("Saldo Atual: R$ ").append(saldo).append("\n");
        extrato.append("Movimentações:\n");

        for (Movimento movimento : movimentacoes) {
            extrato.append(movimento.toString()).append("\n");
        }

        return extrato.toString();
    }

    public List<Movimento> listarMovimentacoes() {
        return new ArrayList<>(movimentacoes);
    }
}

class Movimento {
    private int tipo;
    private double valor;
    private String dataHora;

    public Movimento(int tipo, double valor, String dataHora) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public int getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        String tipoMovimento;
        switch (tipo) {
            case 1:
                tipoMovimento = "Depósito";
                break;
            case 2:
                tipoMovimento = "Saque";
                break;
            case 3:
                tipoMovimento = "Transferência";
                break;
            default:
                tipoMovimento = "Desconhecido";
                break;
        }
        return String.format("%s de R$ %.2f em %s", tipoMovimento, valor, dataHora);
    }
}
