// Marcela Pasqua de Almeida 22051660

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
		// Questão 2
		boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);

		// norte - movimenta para cima - movimenta varias casas
		p.setValores(posicao.getLinha()-1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna());
		}
		
		// norte - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sul - movimenta para baixo
		p.setValores(posicao.getLinha()+1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()+1, p.getColuna());
		}
		
		// sul - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// leste -  movimenta para direita
		p.setValores(posicao.getLinha(), posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha(), p.getColuna()+1);
		}
		
		// leste - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// oeste -  movimenta para esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha(), p.getColuna()-1);
		}
		
		// oeste - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		// noroeste - diagonal superior esquerda - movimenta varias casas
		p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna()-1);
		}
		
		// noroeste - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// nordeste - diagonal superior direita
		p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()-1, p.getColuna()+1);
		}
		
		// nordeste - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudeste - diagonal inferior direita
		p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()+1, p.getColuna()+1);
		}
		
		// sudeste - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudoeste - diagonal inferior esquerda
		p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha()+1, p.getColuna()-1);
		}
		
		// sudoeste - Rainha esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		return matrizMovimentosPossiveis;	
	}

}
