package br.com.mk.components.mainPanel;

import br.com.mk.components.avatarPane.AvatarPane;
import br.com.mk.components.userInfoPane.UserInfoPane;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class MainPanel extends BorderPane {

    public MainPanel() {
    	
        // -------------------------
        // Gradiente diagonal
        // -------------------------
    	
    	LinearGradient gradient = new LinearGradient(
    	        0, 0, 1, 1,               // 45deg: diagonal superior esquerdo → inferior direito
    	        true,                      // coordenadas proporcionais
    	        CycleMethod.NO_CYCLE,
    	        new Stop(0.0, Color.rgb(85, 135, 196)),
    	        new Stop(0.25, Color.rgb(85, 106, 177)),
    	        new Stop(0.5, Color.rgb(86, 84, 159)),
    	        new Stop(0.75, Color.rgb(86, 84, 159)),  // corresponde ao último stop do CSS
    	        new Stop(1.0, Color.rgb(85, 106, 177))
    	);
    	
        this.setBackground(new Background(
                new BackgroundFill(gradient, new CornerRadii(20), Insets.EMPTY)
        ));

        // -------------------------
        // Sombra apenas direita e bottom
        // -------------------------
        DropShadow shadow = new DropShadow();
        shadow.setRadius(10);
        shadow.setOffsetX(5);    // direita
        shadow.setOffsetY(5);    // abaixo
        shadow.setSpread(0.2);   // aumenta área da sombra
        shadow.setColor(Color.GRAY);
        this.setEffect(shadow);

        // -------------------------
        // Padding interno e tamanho mínimo
        // -------------------------
        this.setPadding(new Insets(15));
        this.setMinWidth(580);
        this.setMinHeight(120);

        // -------------------------
        // Componentes
        // -------------------------
        AvatarPane avatarPane = new AvatarPane(null, "MK"); // Avatar ou iniciais
        UserInfoPane userInfoPane = new UserInfoPane(
                "Mateus K S Oliveira",
                "Conta: 123456-7",
                "Agência: 0001"
        );

        // -------------------------
        // Montagem do painel
        // -------------------------
        this.setLeft(avatarPane);
        this.setCenter(userInfoPane);

        // Espaçamento entre avatar e labels
        BorderPane.setMargin(avatarPane, new Insets(0, 15, 0, 0));
    }
}
