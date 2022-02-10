// Maria Eduarda Krutzsch e Victor do Amaral

public class Dados {
	
	private String nome;
	private boolean permissaoLeitura;
	private boolean permissaoGravacao;
	private Pasta pasta;

    public Dados(String nome) {
        this.nome = nome;
    }

    public Pasta getPasta() {
		return pasta;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPermissaoLeitura() {
        return permissaoLeitura;
    }

    public void setPermissaoLeitura(boolean permissaoLeitura) {
        this.permissaoLeitura = permissaoLeitura;
    }

    public boolean isPermissaoGravacao() {
        return permissaoGravacao;
    }

    public void setPermissaoGravacao(boolean permissaoGravacao) {
        this.permissaoGravacao = permissaoGravacao;
    }

    public long getTamanho()
    {
    	return this.nome.length();
    }

    public void setPasta(Pasta pasta) {
    	this.pasta = pasta;
    }
}
