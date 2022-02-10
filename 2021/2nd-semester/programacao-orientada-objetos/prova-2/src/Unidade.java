// Maria Eduarda Krutzsch e Victor do Amaral

public class Unidade {
	
    private String descricao;
    private float capacidade;
    private Pasta pasta;
    

    public Unidade(String descricao, float capacidade) {

        this.descricao = descricao;
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }

    public void addDados(Dados dado, Pasta pasta) {
    	for (Dados d: this.pasta.getDados()) {
    		if (d.getNome().equals(pasta.getNome())) {
    			pasta.addDados(d);
    		}
    	}
    }

    public Pasta getPasta(String nomePasta) {   	
    	for (Dados d: this.pasta.getDados()) {
    		if (d.getNome().equals(nomePasta)) {
    			return (Pasta)d;
    		}	
    	}
    	return null;
    }
    
    public float getEspacoLivre()
    {
    	float espacoLivre = 0;
    	for (Dados d: this.pasta.getDados()) {
    		espacoLivre += d.getTamanho();
    	}
    	return capacidade - espacoLivre;
    }
}