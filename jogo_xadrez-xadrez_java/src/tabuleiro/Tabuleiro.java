package tabuleiro;
import gui.XadrezException;
import xadrez.Peca;

public class Tabuleiro {
	private static Tabuleiro tabuleiro;
	private int linhas;
	private int colunas;
	private Peca[][] pecas; 


	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
//			throw new Exception("Erro ao criar tabuleiro: deve haver pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public boolean movimentoInvalido(boolean posicao) throws XadrezException {
		if(posicao==false) 
			throw new XadrezException("Movimento inválido");
		return posicao;
	}
	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
//			throw new Exception("Posição fora do tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
//			throw new Exception("Posição fora do tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		if (existePeca(posicao)) {
//			throw new TabuleiroException("Já existe uma peça na posição " + position);
		}
		peca.setPosicao(posicao);
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
//		peca.position = position;
	}
	
	public Peca removePeca(Posicao posicao) {
		if (!existePeca(posicao)) {
//			throw new TabuleiroException("Posição fora do tabuleiro ");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
//		aux.position = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}

	public boolean existePeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
//			throw new TabuleiroException("Posição fora do tabuleiro");
		}
		return peca(posicao) != null;
	}


	public static Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public static void setTabuleiro(Tabuleiro tabuleiro) {
		Tabuleiro.tabuleiro = tabuleiro;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Peca[][] getPecas() {
		return pecas;
	}

	public void setPecas(Peca[][] pecas) {
		this.pecas = pecas;
	}


}
