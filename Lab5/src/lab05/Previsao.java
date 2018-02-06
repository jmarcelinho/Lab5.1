package lab05;

public enum Previsao {
	VAI_ACONTECER("VAI ACONTECER"), NAO_VAI_ACONTECER("N VAI ACONTECER");
	
	private String previsao;
	
	Previsao(String previsao) {
		this.previsao = previsao;
	}
	
	public final  String getPrevisao() {
		return this.previsao;
	}
}
