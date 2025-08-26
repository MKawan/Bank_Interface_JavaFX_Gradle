package br.com.mk.components.avatarPane;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class AvatarPane extends StackPane {
    public AvatarPane(Image userImage, String initialsText) {
        this.setPrefSize(80, 80);

        if (userImage != null) {
            ImageView imageView = new ImageView(userImage);
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            imageView.setClip(new Circle(40, 40, 40));
            this.getChildren().add(imageView);
        } else {
            Circle circle = new Circle(40, Color.LIGHTBLUE);
            Label initials = new Label(initialsText);
            initials.setFont(Font.font(24));
            this.getChildren().addAll(circle, initials);
        }
    }
}
