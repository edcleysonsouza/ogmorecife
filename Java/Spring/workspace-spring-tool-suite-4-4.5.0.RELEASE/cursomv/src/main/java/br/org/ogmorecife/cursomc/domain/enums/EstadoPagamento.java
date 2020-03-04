package br.org.ogmorecife.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private Integer cod;
	private String descricao;
	
	
	private EstadoPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao; 
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if (cod.equals(null)) {
			return null;
		}
		
		for (EstadoPagamento ep : EstadoPagamento.values()) {						
			if (ep.getCod().equals(cod)) {
				return ep;
			}
		}
		
		throw new IllegalArgumentException("Código do enumerando inválido "+cod.toString());
		
	}

}
