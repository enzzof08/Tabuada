package br.senai.sp.jandira.tabuada.gui;

import br.senai.sp.jandira.tabuada.model.TabuadaUsuario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class TelaTabuada extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        // Definir o tamanho da tela
        //stage.setWidth(500);
        //stage.setHeight(500);
        stage.setTitle("Tabuada");
        stage.setResizable(false);

        // Criar o root - componente de leiaute principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: rgba(24,198,220,0.8)");

        // Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);




        // Criar o header da tela
        VBox header = new VBox();
        //header.setPrefHeight(100);
        header.setStyle("-fx-background-color: rgba(41,138,149,0.8)");

        // Colocar o conteúdo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setPadding(new Insets(8, 0, 0, 8));
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 30px;-fx-font-weight: bold;");

        Label labelSubtitulo = new Label("Crie a tabuada que a sua imaginação mandar. ");
        labelSubtitulo.setStyle("-fx-text-fill: white");
        labelSubtitulo.setPadding(new Insets(0, 0, 8, 8));


        //Colocar o label dentro do header
        header.getChildren().addAll(labelTitulo, labelSubtitulo);




        //Criar o grid de formulário
        GridPane gridFormulario = new GridPane();
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(16, 8, 16, 8));
        //gridFormulario.setPrefHeight(100);
        //gridFormulario.setStyle("-fx-background-color: #06f6a3");

        // Criar o conteúdo do gridFormulário
        Label labelMultiplicando = new Label("Multiplicando:");
        TextField textFieldMultiplicando = new TextField();

        Label labelMenorMultiplicador = new Label("Menor Multiplicador: ");
        TextField textFieldMenorMultiplicador = new TextField();

        Label labelMaiorMultiplicador = new Label("Maior Multiplicador: ");
        TextField textFieldMaiorMultiplicador = new TextField();

        //Colocar os componentes no grid
        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);

        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);

        gridFormulario.add(labelMaiorMultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultiplicador, 1, 2);





        //Criar a caixa dos botões
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(16,0,8,8));
        HBox boxBotoes = new HBox();
        boxBotoes.setPadding(new Insets(8));
        boxBotoes.setSpacing(10);
        paneButtons.getChildren().add(boxBotoes);

        // Fazer os botoes
        Button botao1 = new Button("Calcular");
        Button botao2 = new Button("Limpar");
        Button botao3 = new Button("Sair");

        //Adicionar os botoes á sua caixa
        boxBotoes.getChildren().addAll(botao1, botao2, botao3);






        // Criar a caixa de resultado
        VBox boxResultado = new VBox();
        boxResultado.setPrefHeight(300);
        //boxResultado.setStyle("-fx-background-color: #0c86ec");

        //Criar os componentes da boxResultado
        Label labelResultado = new Label("Resultado:");
        labelResultado.setPadding(new Insets(8));
        labelResultado.setStyle("-fx-text-fill: blue;-fx-font-size: 18");
        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(8));
        //listaTabuada.setPrefHeight(300);


        //Adicionar ao box
        boxResultado.getChildren().addAll(labelResultado, listaTabuada);





        // Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(paneButtons);
        root.getChildren().add(boxResultado);

        // Colocamos a cena no palco
        stage.setScene(scene);


        stage.show();


        //Calcular
        botao1.setOnAction(e -> {
            TabuadaUsuario tabuada = new TabuadaUsuario();


            tabuada.multiplicando =
                    Integer.parseInt(textFieldMultiplicando.getText());

            tabuada.multiplicadorInicial =
                    Integer.parseInt(textFieldMenorMultiplicador.getText());

            tabuada.multiplicadorFinal =
                    Integer.parseInt(textFieldMaiorMultiplicador.getText());

            String[] resultado = tabuada.CalcularTabuada();
            listaTabuada.getItems().addAll(resultado);

            // gravar os dados da tabuada em arquivo
            Path arquivo = Path.of("C:\\Users\\25203668\\DS1T\\tabuada\\dados_tabuada.csv");

            String dados = textFieldMultiplicando.getText() + ";" + textFieldMenorMultiplicador.getText() + ";" + textFieldMaiorMultiplicador.getText() + ";" + LocalDateTime.now() + "\n";

            try{
                Files.writeString(arquivo, dados, StandardOpenOption.APPEND);
            } catch (IOException erro) {
                System.out.println(erro.getMessage());

            }


        });




        //Limpar
        botao2.setOnAction(e -> {
            textFieldMultiplicando.clear();
            textFieldMenorMultiplicador.clear();
            textFieldMaiorMultiplicador.clear();
            listaTabuada.getItems().clear();
            textFieldMultiplicando.requestFocus();

        });



        //Sair
        botao3.setOnAction(e -> {

        });

    }
}
