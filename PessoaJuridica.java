public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private Conta conta;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public PessoaJuridica(String nome, double renda, Situacao situacao, Endereco enderecoJuridica, String cnpj) {
        super(nome, renda, situacao);  
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return String.format("%s, CNPJ: %s",
            super.toString(), cnpj);
    }
}
