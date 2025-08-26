package br.com.mk.components.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import br.com.mk.components.avatarPane.AvatarPane;
import br.com.mk.components.userInfoPane.UserInfoPane;
import br.com.mk.dto.FatureHistory;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreditoOperations extends VBox {

    private TableView<FatureHistory> tabelaHistorico;

    public CreditoOperations() {

        // Inicializa a tabela
        tabelaHistorico = new TableView<>();
        tabelaHistorico.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS); 
        
        BorderPane cardBox = new BorderPane();

        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 1, // diagonal 45°
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(24, 28, 34)),
                new Stop(0.45, Color.rgb(39, 42, 51)),
                new Stop(1, Color.rgb(0, 0, 0))
        );

        DropShadow shadow = new DropShadow();
        shadow.setRadius(10);
        shadow.setOffsetX(5);
        shadow.setOffsetY(5);
        shadow.setSpread(0.2);
        shadow.setColor(Color.GRAY);
        cardBox.setEffect(shadow);

        cardBox.setPadding(new Insets(15));
        cardBox.setMinWidth(280);
        cardBox.setMinHeight(120);

        cardBox.setBackground(new Background(
                new BackgroundFill(gradient, new CornerRadii(10), null)
        ));

        UserInfoPane userInfoPane = new UserInfoPane(
                "Mateus K S Oliveira",
                "Conta: 123456-7",
                "Agência: 0001"
        );

        TableColumn<FatureHistory, String> colName = new TableColumn<>("Fatura");
        colName.setCellValueFactory(new PropertyValueFactory<>("fatura"));

        TableColumn<FatureHistory, BigDecimal> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        TableColumn<FatureHistory, String> colData = new TableColumn<>("Data");
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        tabelaHistorico.getColumns().addAll(Arrays.asList(colName, colValor, colData));
        tabelaHistorico.setPrefHeight(200);

        // Avatar
        Image cardBand = new Image("/imagens/cardBand.png");
        AvatarPane cardPane = new AvatarPane(cardBand, "Card");

        cardBox.setLeft(cardPane);
        cardBox.setCenter(userInfoPane);

        // Adiciona 4 faturas com datas em sequência (mais antigas → mais novas)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tabelaHistorico.getItems().addAll(
                new FatureHistory("Fatura 1", new BigDecimal("120.50"), LocalDate.now().minusDays(30).format(formatter)),
                new FatureHistory("Fatura 2", new BigDecimal("89.90"), LocalDate.now().minusDays(20).format(formatter)),
                new FatureHistory("Fatura 3", new BigDecimal("150.00"), LocalDate.now().minusDays(10).format(formatter)),
                new FatureHistory("Fatura 4", new BigDecimal("75.25"), LocalDate.now().format(formatter))
        );

        VBox.setMargin(cardBox, new Insets(10, 10, 0, 10));
        VBox.setMargin(tabelaHistorico, new Insets(10, 10, 0, 10));

        this.getChildren().addAll(cardBox, tabelaHistorico);
    }
}
