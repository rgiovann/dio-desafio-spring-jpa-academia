package dio.desafio.spring.jpa.refatorado.enumerator;

 
public enum ObjetivoDoAluno {
	CONDICIONAMENTO(0), PERDA_PESO(1), HIPERTROFIA(2);

	private int codigo;

	private ObjetivoDoAluno(int code) {
		this.codigo = code;
	}

	public int getCode() {
		return this.codigo;
	}

	public static ObjetivoDoAluno valueOf(int codigo) {
		for( ObjetivoDoAluno value: ObjetivoDoAluno.values()) {
			if(value.getCode() == codigo)
				{
				return value;
				}
		}
		throw new IllegalArgumentException("Error! Invalid code for enum ObjetivoDoAluno.");
	}

}
