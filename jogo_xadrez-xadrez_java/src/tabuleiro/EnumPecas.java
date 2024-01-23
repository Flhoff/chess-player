package tabuleiro;

public enum EnumPecas {
 	PEAO_BRANCO('p'), 
	PEAO_PRETO('P'), 
	BISPO_BRANCO('b'), 
	BISPO_PRETO('B'), 
	CAVALO_BRANCO('c'), 
	CAVALO_PRETO('C'),
	TORRE_BRANCO('t'), 
	TORRE_PRETO('T'), 
	REI_BRANCO('k'), 
	REI_PRETO('K'), 
	RAINHA_BRANCO('q'), 
	RAINHA_PRETO('Q'),
	ESPACO_VAZIO(' ');

	private final char peca;

	EnumPecas(char peca) {
		this.peca=peca;
	}
	
	public char getPeca(){
        return peca;
    }
}
