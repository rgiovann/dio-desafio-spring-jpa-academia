package dio.desafio.spring.jpa.refatorado.enumerator;

public enum EstadoDoBrasil {
	AC, AL, AP,AM,BA,CE,DF,ES,GO,MA,
	MT,MS,MG,PA,PB,PR,PE,PI,RJ,RN,
	RS,RO,RR,SC,SP,SE,TO;
	
//	private int codigo;
//
//	private EstadoDoBrasil(int code) {
//		this.codigo = code;
//	}
//
//	public int getCode() {
//		return this.codigo;
//	}
//
//	public static EstadoDoBrasil valueOf(int codigo) {
//		for( EstadoDoBrasil value: EstadoDoBrasil.values()) {
//			if(value.getCode() == codigo)
//				{
//				return value;
//				}
//		}
//		throw new IllegalArgumentException("Erro! Código estado brasileiro inválido.");
//	}

}
