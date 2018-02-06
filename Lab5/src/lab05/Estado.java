package lab05;

public enum Estado {
	
	FINALIZADO_OCORREU("Finalizado (ocorreu)"), 
	FINALIZADO_NAO_OCORREU("Finalizado (n ocorreu)"),
	NAO_FINALIZADO("Nao finalizado");
	
	private String estado;
	
	Estado(String estado) {
		this.estado = estado;
	}
	
	public final String getEstado() {
		return this.estado;
	}
	
}
