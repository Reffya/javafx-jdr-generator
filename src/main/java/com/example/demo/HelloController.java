package com.example.demo;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    private String[] FantasyClasses = {"Guerrier","Chasseur","Ombre", "Bard", "Mage", "Prêtre"};

    private String[] WarpClasses = {"Pilote","Artilleur", "Méchanicien", "Navigateur", "Scientifique", "Echo"};

    private String[] Settings = {"Fantasy", "Warp"};

    private String[] Ethnies = {"Géno", "Xill", "Reptoid", "Kitt", "Mecha", "armure phantom"};

    private List<String> Setting;

    @FXML
    private ComboBox<String> EthnieCombo;

    @FXML
    private ComboBox<String> SettingCombo;

    @FXML
    private ComboBox<String> ClassCombo;

    @FXML
    private TextField ForceField;

    @FXML
    private TextField IntField;

    @FXML
    private TextField DextField;

    @FXML
    private TextField WisdomField;

    @FXML
    private TextField ConstField;

    @FXML
    private TextField CharField;

    @FXML
    private ImageView ClassImage;

    @FXML
    private ImageView SettingImage;

    @FXML
    private ImageView EthnieImage;

    @FXML
    private Button GenerateButton;

    @FXML
    protected void onGenerateClick() {
        CharField.setText("a");
    }

    @FXML
    protected void onSettingChange(ActionEvent actionEvent) throws BadAttributeValueExpException {
        switch(SettingCombo.getValue()) {
                case "Fantasy":
                    ClassCombo.setItems(FXCollections.observableArrayList(FantasyClasses));
                    ClassCombo.setValue(FantasyClasses[0]);
                    break;
                case "Warp":
                    ClassCombo.setItems(FXCollections.observableArrayList(WarpClasses));
                    ClassCombo.setValue(WarpClasses[0]);
                    break;
                default:
                    throw new BadAttributeValueExpException("bad attribute for setting: " + actionEvent.toString());
        }
    }


    @FXML
    protected void onClassChange(ActionEvent actionEvent) throws BadAttributeValueExpException {
        ClassImage.setImage(new Image(HelloController.class.getResource("imgs/classes/" + ClassCombo.getValue() +".jpg").toString()));
    }

    @FXML
    public void initialize() {
        // TODO: put the values for each combobox
        ObservableList<String> classes = FXCollections.observableArrayList(FantasyClasses);
        ClassCombo.setItems(classes); ClassCombo.setValue(classes.getFirst());
        ObservableList<String> ethnies = FXCollections.observableArrayList(Ethnies);
        EthnieCombo.setItems(ethnies); EthnieCombo.setValue(ethnies.getFirst());
        ObservableList<String> settings = FXCollections.observableArrayList(Settings);
        SettingCombo.setItems(settings); SettingCombo.setValue(settings.getFirst());

    }
}