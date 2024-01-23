package tabuleiro;

import xadrez.Peca;

public interface IPeca {
	public boolean eliminarPeca(Peca alvo);
	public boolean possivelMovimento(Posicao posicao);
	public boolean haAlgumMovimentoPossivel();
}
