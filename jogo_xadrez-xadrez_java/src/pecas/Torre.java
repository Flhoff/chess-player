package pecas;

import tabuleiro.Cor;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Peca;

public class Torre extends Peca {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] possivelMovimento() {
		boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		// norte - movimenta para cima - movimenta v�rias casas
		p.setValores(posicao.getLinha()-1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna());
		}
		
		// norte - Torre est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sul - movimenta para baixo
		p.setValores(posicao.getLinha()+1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()+1, p.getColuna());
		}
		
		// sul - Torre est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// leste - Torre movimenta para direita
		p.setValores(posicao.getLinha(), posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha(), p.getColuna()+1);
		}
		
		// leste - Torre est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// oeste - Torre movimenta para esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha(), p.getColuna()-1);
		}
		
		// oeste - Torre est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		return matrizMovimentosPossiveis;
	}

}
