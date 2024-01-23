package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import pojo.PecaPojo;
import pojo.TabuleiroPojo;
import xadrez.PartidaXadrez;
import xadrez.Peca;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


class TratadorSalvar implements EventHandler<Event> {

 

  @Override
  public void handle(final Event evt) {
    final Peca[][] pecasTabuleiro = PartidaXadrez.getInstance().getTabuleiro().getPecas();
    System.out.println("salvar");

    
  }
}