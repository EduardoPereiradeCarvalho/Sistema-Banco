public class Main {
    public static void main(String[] args) {
        try {
            Endereco enderecoFisica = new Endereco("Rua A", "11111-111", "Bairro A", 101, "Cidade A");
            Endereco enderecoJuridica = new Endereco("Rua B", "22222-222", "Bairro B", 202, "Cidade B");

            PessoaFisica pessoaFisica = new PessoaFisica("Eduardo Pereira", 3000, Situacao.ATIVO, enderecoFisica, "123.456.789-10", "MG-12.345.678");
            Conta contaFisica = new Conta();
            contaFisica.setSituacao(Situacao.ATIVO);
            pessoaFisica.setConta(contaFisica);

            PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa ABC", 100000, Situacao.ATIVO, enderecoJuridica, "12.345.678/0001-99");
            Conta contaJuridica = new Conta();
            contaJuridica.setSituacao(Situacao.ATIVO);
            pessoaJuridica.setConta(contaJuridica);

            contaFisica.depositar(500);
            contaFisica.depositar(500);
            contaFisica.sacar(200);
            contaFisica.sacar(200);

            contaJuridica.depositar(1000);
            contaJuridica.depositar(1000);
            contaJuridica.transferir(contaFisica, 500);
            contaJuridica.transferir(contaFisica, 500);

            System.out.println("Extrato da Conta Física:");
            System.out.println(contaFisica.obterExtrato());

            System.out.println("Extrato da Conta Jurídica:");
            System.out.println(contaJuridica.obterExtrato());

            contaFisica.sacar(1000);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
