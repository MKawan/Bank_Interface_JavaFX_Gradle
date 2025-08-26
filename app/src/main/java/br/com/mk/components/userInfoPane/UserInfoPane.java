package br.com.mk.components.userInfoPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

public class UserInfoPane extends HBox {
    public UserInfoPane(String nameText, String accountText, String agencyText) {
        this.setAlignment(Pos.CENTER_RIGHT);
        this.setSpacing(10);

        // Labels
        VBox labelsBox = new VBox(5);
        labelsBox.setAlignment(Pos.CENTER_RIGHT);
        Label name = new Label(nameText);
        name.setFont(Font.font(16));
        Label account = new Label(accountText);
        Label agency = new Label(agencyText);
        labelsBox.getChildren().addAll(name, account, agency);

        this.getChildren().addAll(labelsBox);
    }
}
