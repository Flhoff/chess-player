package gui;

import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pecas.Bispo;
import pecas.Cavalo;
import pecas.Peao;
import pecas.Rainha;
import pecas.Rei;
import pecas.Torre;
import tabuleiro.Cor;
import tabuleiro.Posicao;
import xadrez.PartidaXadrez;
import xadrez.Peca;

/** 
 * https://docs.oracle.com/javase/8/javase-clienttechnologies.htm
 */
public class Tela extends Application {
	public static Image peaoBranco = null;
	public static Image cavaloBranco = null;
	public static Image bispoBranco = null;
	public static Image torreBranco = null;
	public static Image reiBranco = null;
	public static Image rainhaBranco = null;
	public static Image peaoPreto = null;	
	public static Image cavaloPreto = null;
	public static Image bispoPreto = null;
	public static Image torrePreto = null;
	public static Image reiPreto = null;
	public static Image rainhaPreto = null;
	public static Image botaoSalvar = null;
	public static Image botaoCarregar = null;
	public static Image vazio = null;
	private static PartidaXadrez partidaXadrez;
	private int larguraTela=575;
	private int alturaTela=700;
	public static String posicaoOrigem;
	public static HashMap<String, Button> mapButton = null;
	TextArea textArea = null;
	
	/** 
	 * Método para inicializar um aplicativo java
	 */
	public static void main(String[] args) {
		launch(args);
	}
		
	@Override
	public void start(Stage stage) {
	        stage.setTitle("Jogo de Xadrez LTPII");
	        
	        VBox root = new VBox();
	        Scene scene = new Scene(root, larguraTela, alturaTela);
	        stage.setScene(scene);
	        stage.setWidth(larguraTela);
	        stage.setHeight(alturaTela);
	        exibirTabuleiro(root);
	        exibirTelasInformacoesJogadores(root);
	        stage.show();       
	}
	
	private void exibirTelasInformacoesJogadores(VBox root) {
        VBox vBox = new VBox();
        HBox hroot = new HBox();
        Image salvar = new Image("/salvar.png");
        ImageView save = new ImageView(salvar);
        save.setFitHeight(30);
        save.setPreserveRatio(true);
        
        Image Carregar = new Image("/Carregar.png");
        ImageView load = new ImageView(Carregar);
        load.setFitHeight(30);
        load.setPreserveRatio(true);
        
        Button botaoSalvar = new Button();
        Button botaoCarregar = new Button();
        botaoSalvar.addEventHandler(MouseEvent.MOUSE_CLICKED, new TratadorSalvar());
        botaoSalvar.setGraphic(save);
        
        botaoCarregar.addEventHandler(MouseEvent.MOUSE_CLICKED, new TratadorCarregar());
        botaoCarregar.setGraphic(load);
        textArea = new TextArea();
        textArea.setText("Jogador 1 - Proprietário das Peças Brancas \n"
        		+ "Jogador 2 - Proprietário das Peças Pretas"
        		+ ""
        		+ "\n"
        		+ "Jogador atual eh :\n");
        vBox.getChildren().add(textArea);
        vBox.getChildren().add(hroot);
        hroot.getChildren().add(botaoSalvar);
        hroot.getChildren().add(botaoCarregar);
        root.getChildren().add(vBox);


	}

	public Tela() {
		inicializar();
		
	}

	private void exibirTabuleiro(VBox root) {
		for (int linha = 0; linha < partidaXadrez.getTabuleiro().getLinhas(); linha++) {
	        HBox hroot = new HBox();
			for (int coluna = 0; coluna < partidaXadrez.getTabuleiro().getColunas(); coluna++) {
				Peca peca = partidaXadrez.getTabuleiro().getPecas()[linha][coluna];
				Posicao posicao = new Posicao(linha, coluna);
				adicionarButton(peca, posicao, hroot);
			}
			root.getChildren().add(hroot);
		}
	}
	
	void adicionarButton(Peca peca, Posicao posicao, HBox root) {
		Button button = new Button();
		String chaveIdentificarButton=posicao.getLinha()+","+posicao.getColuna();
		mapButton.put(chaveIdentificarButton, button);
        button.setId(chaveIdentificarButton);
	    button.setGraphic(getImageXadrez(peca));
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new TratadorEvento());
        root.getChildren().add(button);
	}

	
	
	
	public static ImageView getImageXadrez(Peca peca) {
		Image image = null;
		if(peca instanceof Peao && peca.getCor() == Cor.BRANCO) {
			image = peaoBranco;
		}
		if(peca instanceof Peao && peca.getCor() == Cor.PRETO) {
			image = peaoPreto;
		}
		if(peca instanceof Torre && peca.getCor() == Cor.PRETO) {
			image = torrePreto;
		}
		if(peca instanceof Torre && peca.getCor() == Cor.BRANCO) {
			image = torreBranco;
		}
		if(peca instanceof Bispo && peca.getCor() == Cor.PRETO) {
			image = bispoPreto;
		}
		if(peca instanceof Bispo && peca.getCor() == Cor.BRANCO) {
			image = bispoBranco;
		}
		if(peca instanceof Cavalo && peca.getCor() == Cor.PRETO) {
			image = cavaloPreto;
		}
		if(peca instanceof Cavalo && peca.getCor() == Cor.BRANCO) {
			image = cavaloBranco;
		}
		if(peca instanceof Rei && peca.getCor() == Cor.BRANCO) {
			image = reiBranco;
		}
		if(peca instanceof Rei && peca.getCor() == Cor.PRETO) {
			image = reiPreto;
		}
		if(peca instanceof Rainha && peca.getCor() == Cor.BRANCO) {
			image = rainhaBranco;
		}
		if(peca instanceof Rainha && peca.getCor() == Cor.PRETO) {
			image = rainhaPreto;
		}

		if(peca == null) {
			image = vazio;
		}

		ImageView imageView=new ImageView(image);

		return imageView;
	}
	
    void inicializar() {
    	mapButton = new HashMap<String, Button>();
    	partidaXadrez = PartidaXadrez.getInstance();
    
    	peaoBranco = new Image(getClass().getResourceAsStream("/peao_branco.png"), 50, 50, false, false);
    	cavaloBranco = new Image(getClass().getResourceAsStream("/cavalo_branco.png"), 50, 50, false, false);
    	bispoBranco = new Image(getClass().getResourceAsStream("/bispo_branco.png"), 50, 50, false, false);
    	torreBranco = new Image(getClass().getResourceAsStream("/torre_branco.png"), 50, 50, false, false);
    	reiBranco = new Image(getClass().getResourceAsStream("/rei_branco.png"), 50, 50, false, false);
    	rainhaBranco = new Image(getClass().getResourceAsStream("/rainha_branco.png"), 50, 50, false, false);
    	
    	peaoPreto = new Image(getClass().getResourceAsStream("/peao_preto.png"), 50, 50, false, false);
    	cavaloPreto = new Image(getClass().getResourceAsStream("/cavalo_preto.png"), 50, 50, false, false);
    	bispoPreto = new Image(getClass().getResourceAsStream("/bispo_preto.png"), 50, 50, false, false);
    	torrePreto = new Image(getClass().getResourceAsStream("/torre_preto.png"), 50, 50, false, false);
    	reiPreto = new Image(getClass().getResourceAsStream("/rei_preto.png"), 50, 50, false, false);
    	rainhaPreto = new Image(getClass().getResourceAsStream("/rainha_preto.png"), 50, 50, false, false);    	
    	
    	vazio = new Image(getClass().getResourceAsStream("/vazio.png"), 50, 50, false, false);
    	
    	botaoSalvar = new Image(getClass().getResourceAsStream("/salvar.png"), 50, 50, false, false);
    	botaoCarregar = new Image(getClass().getResourceAsStream("/Carregar.png"), 50, 50, false, false);
    }
}



