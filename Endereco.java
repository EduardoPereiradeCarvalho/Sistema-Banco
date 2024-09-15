public class Endereco {
    private String rua;
    private String cep;
    private String bairro;
    private int numero;
    private String cidade;

    public Endereco(String rua, String cep, String bairro, int numero, String cidade) {
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString(){
        return String.format("Rua: %s, CEP: %s, Bairro: %s, Número: %d, Cidade: %s",
                rua, cep, bairro, numero, cidade);
    }
}
