// Marcela Pasqua de Almeida 22051660

package pecas;

import tabuleiro.Cor;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;
import xadrez.Peca;

public class Rei extends Peca {
	PartidaXadrez partidaXadrez;
	public Rei(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partidaXadrez) {
		super(tabuleiro, cor);
		this.partidaXadrez = partidaXadrez;
	}

	private boolean podeMover(Posicao posicao) {
		Peca p = (Peca)getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
	}
	
	private boolean testRookCastling(Posicao posicao) {
		Peca p = (Peca)getTabuleiro().peca(posicao);
		return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContagemMovimento() == 0;
	}
	
	@Override
	public boolean[][] possivelMovimento() { 
		// Questão 1
		boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);

		// norte - movimenta para cima - movimenta varias casas
		p.setValores(posicao.getLinha()-1, posicao.getColuna());
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// norte - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sul - movimenta para baixo
		p.setValores(posicao.getLinha()+1, posicao.getColuna());
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sul - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// leste -  movimenta para direita
		p.setValores(posicao.getLinha(), posicao.getColuna()+1);
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// leste - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// oeste -  movimenta para esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna()-1);
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// oeste - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}

		// noroeste - diagonal superior esquerda - movimenta varias casas
		p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// noroeste - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// nordeste - diagonal superior direita
		p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// nordeste - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudeste - diagonal inferior direita
		p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudeste - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudoeste - diagonal inferior esquerda
		p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		// sudoeste - Rei esta capturando uma peca adversaria
		if(getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
			matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
		}
		
		return matrizMovimentosPossiveis;
	}
}
