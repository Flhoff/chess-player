package xadrez;

import tabuleiro.Cor;
import tabuleiro.IPeca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class Peca implements IPeca {
	protected Posicao posicao; 
	private Cor cor;
	private Tabuleiro tabuleiro;
	private int contagemMovimento; 
	
	public Peca(Tabuleiro tabuleiro, Cor cor) {
		this.tabuleiro=tabuleiro;
		this.cor=cor;
	}

	public abstract boolean[][] possivelMovimento();
	
	public boolean possivelMovimento(Posicao posicao) {
		return possivelMovimento()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean haAlgumMovimentoPossivel() {
		boolean[][] mat = possivelMovimento();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getContagemMovimento() {
		return contagemMovimento;
	}

	public void setContagemMovimento(int contagemMovimento) {
		this.contagemMovimento = contagemMovimento;
	}

	public void aumentaContagemMovimento() {
		contagemMovimento++;
	}

	public void diminuiContagemMovimento() {
		contagemMovimento--;
	}

	public Posicao getPosicaoXadrez() {
		return Posicao.dePosicao(posicao);
	}
	
	protected boolean ehPecaOponente(Posicao posicao) {
		Peca p = (Peca)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}

	@Override
	public boolean eliminarPeca(Peca pecaAlvo) {
		if(this.equals(pecaAlvo))
			return false;
		
		return true;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
