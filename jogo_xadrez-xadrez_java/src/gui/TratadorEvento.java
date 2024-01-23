package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import tabuleiro.Posicao;
import xadrez.PartidaXadrez;
import xadrez.Peca;

class TratadorEvento implements EventHandler<Event>{
    @Override
    public void handle(Event evt) {
    	String identificadorDestino = ((Control)evt.getSource()).getId();
    	String[] ids =identificadorDestino.split(",");
    	int linhaDestino=Integer.valueOf(ids[0]);
    	int colunaDestino=Integer.valueOf(ids[1]);

    	if(Tela.posicaoOrigem==null)
    		Tela.posicaoOrigem=identificadorDestino;

    	if(Tela.posicaoOrigem!=null && !Tela.posicaoOrigem.equals(identificadorDestino)) {
        	String[] idOrigem=Tela.posicaoOrigem.split(",");
        	int linhaOrigem=Integer.valueOf(idOrigem[0]);
        	int colunaOrigem=Integer.valueOf(idOrigem[1]);
        	Posicao posicaoDestino = new Posicao(linhaDestino, colunaDestino);
        	Peca pecaOrigem = PartidaXadrez.getInstance().getTabuleiro().getPecas()[linhaOrigem][colunaOrigem];
        	if(pecaOrigem!=null) {
        		// Obtém a lista de movimentos válidos para peça
        		boolean[][] possiveisMovimentosOrigem = pecaOrigem.possivelMovimento();
        		System.out.println(Tela.posicaoOrigem + " " + identificadorDestino);

        		// Verifica se para onde deseja movimentar é true
				try {
					if(PartidaXadrez.getInstance().getTabuleiro().movimentoInvalido(possiveisMovimentosOrigem[linhaDestino][colunaDestino])) {
						PartidaXadrez.getInstance().getTabuleiro().removePeca(pecaOrigem.getPosicao());
						PartidaXadrez.getInstance().getTabuleiro().colocarPeca(pecaOrigem, posicaoDestino);
						ImageView imagemVazia=new ImageView(Tela.vazio);
						Tela.mapButton.get(Tela.posicaoOrigem).setGraphic(imagemVazia);
						Tela.mapButton.get(identificadorDestino).setGraphic(Tela.getImageXadrez(pecaOrigem));
						Tela.posicaoOrigem=null;
					}
				} catch (XadrezException xe) {
					xe.printStackTrace();
				} 
				
				Tela.posicaoOrigem=null;
        	}
    	}
		System.out.println(Tela.posicaoOrigem + ",			" + identificadorDestino);

    }
}