package pecas;

import tabuleiro.Cor;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;
import xadrez.Peca;

public class Rainha extends Peca {

	public Rainha(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] possivelMovimento() {
		// Quest�o 2
		boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		

		// noroeste - diagonal superior esquerda - movimenta v�rias casas
		
		p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna()-1);
		}
		
		// noroeste -  est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// nordeste - diagonal superior direita
		p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna()+1);
		}
		
		// nordeste -  est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudeste - diagonal inferior direita
		p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()+1, p.getColuna()+1);
		}
		
		// sudeste - est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudoeste - diagonal inferior esquerda
		p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()+1, p.getColuna()-1);
		}
		
		// sudoeste -est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		

		// norte - movimenta para cima - movimenta v�rias casas
		p.setValores(posicao.getLinha()-1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna());
		}
		
		// norte - est� capturando uma pe�a advers�ria
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
		
		// leste - movimenta para direita
		p.setValores(posicao.getLinha(), posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha(), p.getColuna()+1);
		}
		
		// leste -est� capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// oeste -movimenta para esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha(), p.getColuna()-1);
		}
		
		// oeste -capturando uma pe�a advers�ria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		return matrizMovimentosPossiveis;	
	}

}
