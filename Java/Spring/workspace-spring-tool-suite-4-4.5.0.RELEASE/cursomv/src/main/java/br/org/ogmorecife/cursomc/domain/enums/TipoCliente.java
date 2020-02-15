package br.org.ogmorecife.cursomc.domain.enums;

public enum TipoCliente {
	
	//it is similar an instances of the Cliente type object 
	PESSOAFISICA (1,"Pessoa Física"),
	PESSOAJURIDICA (2,  "Pessoa Jurídica");	
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}		
	
	public int getCod() {
		return cod;
	}
	

	public String getDescricao() {
		return descricao;
	}
	

	public static TipoCliente toEnum(Integer cod) {
		
		if (cod.equals(null) ) {
			return null;
		}			
		
		for (TipoCliente tc : TipoCliente.values()) {			
			if ( cod.equals(tc.getCod()) ) {
				return tc;
			}
		} 
		
		throw new IllegalArgumentException("Código do enumerando inválido "+cod.toString()); 
	}

}
