package dio.desafio.spring.jpa.refatorado.enumerator;

 
public enum SituacaoDaMatricula {
	ADIMPLENTE(0), INADIMPLENTE(1), EXPIRADO(2);

 	private int codigo;
 
 	private SituacaoDaMatricula(int code) {
 		this.codigo = code;
 	}
 
 public int getCode() {
 	return this.codigo;
 }
 
 	public static SituacaoDaMatricula valueOf(int codigo) {
 	for( SituacaoDaMatricula value: SituacaoDaMatricula.values()) {
 		if(value.getCode() == codigo)
 				{
 				return value;
 			}
 	}
 		throw new IllegalArgumentException("Error! Invalid code for enum SituacaoDaMatricula.");
 	}

}
