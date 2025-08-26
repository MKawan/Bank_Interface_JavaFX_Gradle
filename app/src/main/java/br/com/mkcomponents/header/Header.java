package br.com.mkcomponents.header;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import br.com.mk.components.buttonSettings.ButtonSettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class Header extends HBox {
    public Header() {
    	
    	this.setAlignment(Pos.BASELINE_CENTER);
        this.setPadding(new Insets(5));
        
        
        Image iconImage = new Image(getClass().getResource("/imagens/icon2.png").toExternalForm());
        ImageView iconView = new ImageView(iconImage);
        iconView.setFitWidth(120);
        iconView.setFitHeight(40);
     // Se quiser efeito "cover"
        iconView.setPreserveRatio(false); // força ocupar toda área, sem manter proporção
        iconView.setScaleX(3);
        iconView.setScaleY(6);
        
        Image gearImage = new Image(getClass().getResource("/imagens/settings3.png").toExternalForm());
        ButtonSettings settingsBtn = new ButtonSettings(gearImage);
        
        // Regiões de espaçamento
        Region leftSpacer = new Region();
        Region rightSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        // Ordem dos elementos → [espaço esquerdo][icone][espaço direito][botão]
        this.getChildren().addAll(leftSpacer, iconView, rightSpacer, settingsBtn);
        this.setAlignment(Pos.CENTER); // garante alinhamento vertical
    }
    
}
