
public class Obra {
	private String titulo;
	private String autor;
	private Parecer[] pareceres = new Parecer[3];
	private int indexParecer = 0;
	
	
	public boolean adicionarParecer(Parecer parecer) {
		if (this.indexParecer > 2) {
			return false;
		}
		
		this.pareceres[this.indexParecer] = parecer;
		
		this.indexParecer++;
		
		return true;
	}
	
	// getters e setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String exibir() {
		String str = "Obra:"+ this.getTitulo() + 
		"\nAutor:"+ this.getAutor() +
		"\nPareceres:"+ this.indexParecer;
		
		for (int i = 0; i < this.indexParecer; i++) {
			str+= "\nParecerista: " + this.pareceres[i].getParecerista() +
				  "\nem :" + this.pareceres[i].getData() +
				  "\nafirmou '" + this.pareceres[i].getConteudo()+"'";
		}
		
		return str;
	}
	
}
