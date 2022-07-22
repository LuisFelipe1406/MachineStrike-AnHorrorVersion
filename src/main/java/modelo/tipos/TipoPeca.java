package modelo.tipos;

public abstract class TipoPeca {

	private String nome;
	
	public TipoPeca(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
        return this.nome;
	}
	
	public String toString() {
		return this.getNome();
	}
	
}
