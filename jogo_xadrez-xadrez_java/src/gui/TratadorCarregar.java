package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import pojo.TabuleiroPojo;
import tabuleiro.Posicao;
import xadrez.PartidaXadrez;
import xadrez.Peca;

class TratadorCarregar implements EventHandler<Event>{
    @Override
    public void handle(Event evt) {
    	System.out.println("Carregar ");
    	// Classe Básica em Java você pode salvar em XML ou JSON
    	// https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    	
    	TabuleiroPojo tabuleiroPojo = new TabuleiroPojo();

    	// você pode usar Gson para recuperar um objeto tabuleiroPojo a partir de um arquivo formato json
    }
}