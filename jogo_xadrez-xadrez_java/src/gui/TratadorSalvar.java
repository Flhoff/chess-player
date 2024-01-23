package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import pojo.PecaPojo;
import pojo.TabuleiroPojo;
import xadrez.PartidaXadrez;
import xadrez.Peca;

class TratadorSalvar implements EventHandler<Event>{
    @Override
    public void handle(Event evt) {
    	// Classe Básica em Java você pode salvar em XML ou JSON
    	// https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    	System.out.println("Salvar ");
    	Peca[][] pecasTabuleiro = PartidaXadrez.getInstance().getTabuleiro().getPecas();

    	TabuleiroPojo tabuleiroPojo = new TabuleiroPojo();
    	
    	for(int i=0; i<pecasTabuleiro[0].length; i++) {
    		for(int j=0; j<pecasTabuleiro.length; j++) {
    			
    			PecaPojo pecaPojo = new PecaPojo();
    			pecaPojo.setLinha(i);
    			pecaPojo.setColuna(j);
    			tabuleiroPojo.getListaPecas().add(pecaPojo);
    		}
    	}
    	
    	// você vai copiar de pecasTabuleiro para tabuleiroPojo
    	// você vai salvar tabuleiroPojo em formato json usando a classe GSon
    	
    	// você pode usar Gson para salvar este objeto tabuleiroPojo em formato json
    	
    }
}