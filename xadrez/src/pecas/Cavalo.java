package pecas;

import tabuleiro.Cor;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Peca;

/**
 * Contém as regras para movimentação da peça Cavalo em um jogo de xadrez. Considerando as cores brancas e pretas.
 * @author ricar
 *
 */
public class Cavalo extends Peca {

	/**
	 * Construtor da peça Cavalo
	 * @param tabuleiro
	 * @param cor
	 */
	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	private boolean podeMover(Posicao posicao) {
		Peca p = (Peca)getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
	}

	/**
	 * Irá retornar a matriz de booleanos para informar os possíveis movimentos do cavalo
	 * Este método deverá ser documentado
	 */
	@Override
	public boolean[][] possivelMovimento() {
		boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		// L indo para cima
		// Movimento 1 - faz um L <---> sobe uma linha e vai para esquerda duas casas
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 2);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		// Movimento 2 - faz um L <---> sobe uma linha e vai para direita duas casas
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// Movimento 3 - faz um L <---> sobe duas linhas e vai para esquerda uma casa
		p.setValores(posicao.getLinha() - 2, posicao.getColuna() - 1);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		// Movimento 4 - faz um L <---> sobe duas linhas e vai para direita uma casa
		p.setValores(posicao.getLinha() - 2, posicao.getColuna() + 1);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}


		// L indo para baixo
		// Movimento 5 - faz um L <---> desce uma linha e vai para esquerda duas casas
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 2);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		// Movimento 6 - faz um L <---> desce uma linha e vai para direita duas casas
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// Movimento 7 - faz um L <---> desce duas linhas e vai para esquerda uma casa
		p.setValores(posicao.getLinha() + 2, posicao.getColuna() - 1);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		// Movimento 8 - faz um L <---> desce duas linhas e vai para direita uma casa
		p.setValores(posicao.getLinha() + 2, posicao.getColuna() + 1);
		if(getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		return matrizMovimentosPossiveis;
	}
	
}
