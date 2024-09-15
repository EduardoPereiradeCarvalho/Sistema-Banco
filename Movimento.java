public class Movimento {
    private int tipo;
    private String dataMovimentacao;
    private String horaMovimentacao;
    private double valor;

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public String getDataMovimentacao() {
        return dataMovimentacao;
    }
    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
    public String getHoraMovimentacao() {
        return horaMovimentacao;
    }
    public void setHoraMovimentacao(String horaMovimentacao) {
        this.horaMovimentacao = horaMovimentacao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        String tipoMovimento = tipo == 1 ? "Depósito" : tipo == 2 ? "Saque" : "Transferência";
        return tipoMovimento + " de R$ " + valor + " em " + dataMovimentacao + " às " + horaMovimentacao;
    }
}
