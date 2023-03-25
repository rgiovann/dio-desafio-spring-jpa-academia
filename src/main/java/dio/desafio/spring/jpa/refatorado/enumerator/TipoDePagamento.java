package dio.desafio.spring.jpa.refatorado.enumerator;

public enum TipoDePagamento {
	AVISTA_PIX(0), CREDITO_PARCELADO(1), CREDITO_A_VISTA(2),A_VISTA_BOLETO(3);
 	private int codigo;
 	 
 	private TipoDePagamento(int code) {
 		this.codigo = code;
 	}
 
 public int getCode() {
 	return this.codigo;
 }
 
 	public static TipoDePagamento valueOf(int codigo) {
 	for( TipoDePagamento value: TipoDePagamento.values()) {
 		if(value.getCode() == codigo)
 				{
 				return value;
 			}
 	}
 		throw new IllegalArgumentException("Error! Invalid code for enum TipoDePagamento.");
 	}


}
