package br.com.mk.components.buttonSettings;

import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ButtonSettings extends Button{

    public ButtonSettings(Image gearImage) {
        
        ImageView gearIcon = new ImageView(gearImage);
        gearIcon.setFitWidth(20);
        gearIcon.setFitHeight(20);
        
        this.setGraphic(gearIcon);
     // Ajuste o tamanho do botão para caber o ícone
        this.setPrefSize(30, 30); 
        this.setStyle("-fx-background-color: transparent;");
    }
}

