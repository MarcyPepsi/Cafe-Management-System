/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Marcy GADEU
 */
public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Label info;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
@FXML
    void login(ActionEvent event) throws IOException {
     if (userName.getText().equals("marcy") && password.getText().equals("cycy")) {
            info.setStyle("-fx-background-color: #33CC00; ");
            info.setText("Good User name and password");
            Locale.setDefault(Locale.ENGLISH);
            Parent root = FXMLLoader.load(getClass().getResource("WelcomeView.fxml"));

            Scene scene = new Scene(root);

            Stage st = new Stage();
            st.setScene(scene);
            //st.getIcons().add(new Image(Main.class.getResourceAsStream("/Resources/images/logopkf.jpg")));
            st.setResizable(false);
            st.show();
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } else {
            info.setStyle("-fx-background-color: #ff0000; ");
            info.setText("Wrong User name and password");
        }
    }
    
    
}
