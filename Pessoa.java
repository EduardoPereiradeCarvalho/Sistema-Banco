public abstract class Pessoa {
    private String nome;
    private double renda;
    private Situacao situacao;

    public Pessoa(String nome, double renda, Situacao situacao) {
        this.nome = nome;
        this.renda = renda;
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nRenda: %.2f\nSituação: %s", nome, renda, situacao);
    }
}
