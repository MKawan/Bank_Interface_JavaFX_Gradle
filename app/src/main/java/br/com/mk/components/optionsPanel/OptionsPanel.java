package br.com.mk.components.optionsPanel;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import br.com.mk.components.operations.CreditoOperations;
import br.com.mk.components.operations.PixOperations;
import br.com.mk.components.operations.ReceiveOperations;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class OptionsPanel extends HBox {
    public OptionsPanel(String[] options) {
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));

        for (String opt : options) {
            Button btn = new Button(opt);
            btn.setStyle("");

            // ação do botão
            btn.setOnAction(e -> {
                if (opt.equalsIgnoreCase("Pix")) {
                    abrirPixPanel();
                    
                } else if (opt.equalsIgnoreCase("Crédito")){
                	abrirCreditoPanel();
          
	            } else if (opt.equalsIgnoreCase("Receber")){
	            	abrirReceivePanel();
	            }
            });
            
            btn.getStyleClass().add("my-button");
            this.getChildren().add(btn);
        }
    }

    private void abrirPixPanel() {
        // cria uma nova janela com o painel Pix
        Stage pixStage = new Stage();
        PixOperations pixPanel = new PixOperations();
        Scene scene = new Scene(pixPanel, 300, 250);

        pixStage.setTitle("Enviar Pix");
        pixStage.setScene(scene);
        pixStage.show();
    }
    
    private void abrirCreditoPanel() {
        // cria uma nova janela com o painel Pix
        Stage pixStage = new Stage();
        CreditoOperations creditoPanel = new CreditoOperations();
        Scene scene = new Scene(creditoPanel, 300, 400);

        pixStage.setTitle("Crédito");
        pixStage.setScene(scene);
        pixStage.show();
    }
    
    private void abrirReceivePanel() {
        // cria uma nova janela com o painel Pix
        Stage pixStage = new Stage();
        ReceiveOperations creditoPanel = new ReceiveOperations();
        Scene scene = new Scene(creditoPanel, 300, 400);

        pixStage.setTitle("Receber");
        pixStage.setScene(scene);
        pixStage.show();
    }
}
