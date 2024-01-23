package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import pecas.Peao;
import pecas.Torre;
import pojo.TabuleiroPojo;
import tabuleiro.Cor;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;
import xadrez.Peca;

class TratadorCarregar implements EventHandler<Event>{
    @Override
    public void handle(Event evt) {
    	System.out.println("Carregar ");
    	
    	Peca pecaOrigem = PartidaXadrez.getInstance().getTabuleiro().getPecas()[linhaOrigem][colunaOrigem];
    	
    	for(int i=0;i<8;i++) {
    		for(int j=0;i<8;j++) {
    			Peca pecaOrigem=null;
    			PartidaXadrez.getInstance().getTabuleiro().getPecas()[i][j]=pecaOrigem;
    			ImageView imagemVazia=new ImageView(Tela.vazio);
    			Tela.mapButton.get(Tela.posicaoOrigem).setGraphic(imagemVazia);
    		}
    	}
    	
    	Tabuleiro tabuleiro = new Tabuleiro(8, 8);
    	Peca pecaOrigem = null;
    	String tipoPeca[] = {"BRANCO","TORRE","0","0"};
    	for(int i=0;i<8;i++) {
    		for(int j=0;i<8;j++) {
    			if(tipoPeca[1].equals("Peao")) {
    				pecaOrigem=new Peao(PartidaXadrez.getInstance().getTabuleiro(), Cor.valueOf(tipoPeca[0]), PartidaXadrez.getInstance());
    				pecaOrigem.setPosicao(new Posicao(Integer.parseInt(tipoPeca[2]), Integer.parseInt(tipoPeca[3])));
    			}
    			
    			PartidaXadrez.getInstance().getTabuleiro().getPecas()[i][j]=pecaOrigem;
    			ImageView imagemVazia=new ImageView(Tela.vazio);
    		}
    	}
    }
}