package br.com.mk.components.operations;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.mk.dto.PixHistory;

public class PixOperations extends VBox {

	private String name;
    private String chave;
    private BigDecimal valor;

    // Tabela de histórico
    private TableView<PixHistory> tabelaHistorico;

    public PixOperations() {

        VBox pixPanel = new VBox();

        TextField inputNomeField = new TextField();
        TextField inputChaveEnviarField = new TextField();
        TextField inputValorEnviarField = new TextField();
        Button enviarButton = new Button("Enviar");

        inputNomeField.setPromptText("Nome do destinatário...");
        inputChaveEnviarField.setPromptText("Chave Pix aqui...");
        inputValorEnviarField.setPromptText("Valor do envio aqui...");

        // Criando a tabela
        tabelaHistorico = new TableView<>();
        tabelaHistorico.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS); 

        TableColumn<PixHistory, String> colName = new TableColumn<>("Nome");
        colName.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<PixHistory, BigDecimal> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        
        TableColumn<PixHistory, String> colChave = new TableColumn<>("Chave");
        colChave.setCellValueFactory(new PropertyValueFactory<>("chave"));

        TableColumn<PixHistory, String> colHorario = new TableColumn<>("Horário");
        colHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));

        // ação do botão
        enviarButton.setOnAction(e -> {
            this.chave = inputChaveEnviarField.getText();
            this.name = inputNomeField.getText();
            try {
                String valorInput = inputValorEnviarField.getText().trim().replace(",", ".");
                this.valor = new BigDecimal(valorInput)
                                .setScale(2, RoundingMode.HALF_UP);
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido! Digite um número válido.");
                return;
            }

            getChave();
            getValor();

            // adiciona na tabela
            String horario = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            PixHistory registro = new PixHistory(name, valor, chave, horario);
            tabelaHistorico.getItems().add(registro);

            // limpa campos
            inputNomeField.clear();
            inputChaveEnviarField.clear();
            inputValorEnviarField.clear();
        });

        
        tabelaHistorico.getColumns().addAll(
            java.util.Arrays.asList(colName, colValor, colChave, colHorario)
        );
        tabelaHistorico.setPrefHeight(200);


        pixPanel.setSpacing(10);
        pixPanel.getChildren().addAll(inputNomeField, inputChaveEnviarField, inputValorEnviarField, enviarButton);

        VBox.setMargin(pixPanel, new Insets(10, 10, 0, 10));
        VBox.setMargin(tabelaHistorico, new Insets(10, 10, 10, 10));

        this.getChildren().addAll(pixPanel, tabelaHistorico);
    }

    public void getName() {
    	System.out.println("Valor do Pix: " + valor);
    }

    public void getChave() {
        System.out.println("Chave Pix do destinatário: " + chave);
    }

    public void getValor() {
        System.out.println("Valor do Pix: " + valor);
    }
    
}
