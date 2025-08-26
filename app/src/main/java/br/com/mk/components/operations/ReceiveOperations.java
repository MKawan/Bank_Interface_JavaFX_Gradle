package br.com.mk.components.operations;

import br.com.mk.utils.QRCodeGenerator;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.zxing.WriterException;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ReceiveOperations extends VBox {

    private BigDecimal valor;
    private ImageView qrView; // manter referência para atualizar dinamicamente
    private String chave;

    public ReceiveOperations() {
    	
    	this.chave = "1548425626265";

    	Label qrNameLabel = new Label("QR CODE");
        TextField inputValorEnviarField = new TextField();
        Button enviarButton = new Button("Gerar QR Code");

        inputValorEnviarField.setPromptText("Valor a receber aqui...");

        qrView = new ImageView();
        qrView.setFitWidth(120);
        qrView.setFitHeight(120);

        enviarButton.setOnAction(e -> {
            try {
                // converte input para BigDecimal com 2 casas
                String valorInput = inputValorEnviarField.getText().trim().replace(",", ".");
                this.valor = new BigDecimal(valorInput)
                                .setScale(2, RoundingMode.HALF_UP);
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido! Digite um número válido.");
                return;
            }

            getValor();

            try {
                // gera o QR Code dinamicamente
                BufferedImage bufferedImage = QRCodeGenerator.generateQRCodeImage(
                        "PIX:" + chave + "?valor=" + valor, 250, 250
                );
                Image qrCodeFX = SwingFXUtils.toFXImage(bufferedImage, null);
                qrView.setImage(qrCodeFX); // atualiza a imagem do ImageView
            } catch (WriterException ex) {
                ex.printStackTrace();
            }
        });

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        VBox.setMargin(inputValorEnviarField, new Insets(0, 10, 0, 10));
        VBox.setMargin(enviarButton, new Insets(0, 10, 0, 10));
        this.getChildren().addAll(qrNameLabel, qrView, inputValorEnviarField, enviarButton);
    }

    public void getValor() {
        System.out.println("Valor do Pix: " + valor);
    }
}
