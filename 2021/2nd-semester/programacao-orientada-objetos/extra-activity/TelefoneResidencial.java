// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral

import java.time.LocalDate;
public class TelefoneResidencial {
    private String nomeUsuario;
    private String enderecoInstalacao;
    private LocalDate dataInstalacao;
    private String numero;
    private boolean conexaoInternet;
    private double valorAPagar = 15.00;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEnderecoInstalacao() {
        return enderecoInstalacao;
    }

    public void setEnderecoInstalacao(String enderecoInstalacao) {
        this.enderecoInstalacao = enderecoInstalacao;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getNumero() {

        return numero;
    }

    public void setNumero(String numero) {
        numero.replace("(", "");
        numero.replace(")", "");
        numero.replace(" ", "");
        numero.replace("-", "");

        this.numero = numero;
    }

    public boolean isConexaoInternet() {
        return conexaoInternet;
    }

    public void setConexaoInternetTrue() {
        this.conexaoInternet = true;
    }

    public void setConexaoInternetFalse() {
        this.conexaoInternet = false;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }
}