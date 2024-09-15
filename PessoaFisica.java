public class PessoaFisica extends Pessoa {
    private String cpf;
    private String rg;
    private Conta conta; 

    public PessoaFisica(String nome, double renda, Situacao situacao, Endereco enderecoFisica, String cpf, String rg) {
        super(nome, renda, situacao);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nCPF: %s\nRG: %s", cpf, rg);
    }

    
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }
}
