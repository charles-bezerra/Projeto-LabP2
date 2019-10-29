package projetoLP2.classes;

public class Pesquisa {
	private String descricao, campoDeInteresse, cod;
	private boolean estado;
	private String motivo;
	
	
	public Pesquisa(String descricao, String campoDeInteresse, String cod) {
		this.descricao = descricao;
		this.campoDeInteresse = campoDeInteresse;
		this.cod = cod;
		estado = true;
		motivo = "";
	}
	
	
	private String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	private String getCampoDeInteresse() {
		return campoDeInteresse;
	}
	
	public void setCampoDeInteresse(String campoDeInteresse) {
		this.campoDeInteresse = campoDeInteresse;
	}
	
	private String getCod() {
		return cod;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void ativaPesquisa() {
		estado = true;
	}
	
	public void encerraPesquisa(String motivo) {
		this.motivo = motivo;
		estado = false;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", getCod(),getDescricao(),getCampoDeInteresse());
	}
	
	
}
