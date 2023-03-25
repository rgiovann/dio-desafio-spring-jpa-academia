package dio.desafio.spring.jpa.refatorado.enumerator;

 
public enum TipoTelefone {
	WHATS(0), CELULAR(1), FIXO(2),EMERGENCIA(2);

	private int codigo;

	private TipoTelefone(int code) {
		this.codigo = code;
	}

	public int getCode() {
		return this.codigo;
	}

	public static TipoTelefone valueOf(int codigo) {
		for( TipoTelefone value: TipoTelefone.values()) {
			if(value.getCode() == codigo)
				{
				return value;
				}
		}
		throw new IllegalArgumentException("Error! Invalid code for enum TipoTelefone.");
	}

}
