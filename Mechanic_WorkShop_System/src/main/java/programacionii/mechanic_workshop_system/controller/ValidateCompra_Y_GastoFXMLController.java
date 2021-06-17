/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.App;
import static programacionii.mechanic_workshop_system.controller.MainController.loadFXML;
import programacionii.mechanic_workshop_system.pojo.OrdenCompraGasto;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class ValidateCompra_Y_GastoFXMLController implements Initializable {
    
    // Posicion X: 511, Posicion Y: 244
    // Tamaño -> Altura: 300, Ancho: 500
    //setResizable(false);
    
    @FXML
    public TableView<OrdenCompraGasto> tblViewContent;
    @FXML
    public TableColumn<OrdenCompraGasto, String> tblColumnNumOrden;
    @FXML
    public TableColumn<OrdenCompraGasto, String> tblColumnMecanico;
    @FXML
    public TableColumn<OrdenCompraGasto, String> tblColumnEstado;
    @FXML
    public TextField txtBuscar;
    @FXML
    public Button btnOk;
    @FXML
    public Button btnCancelar;
    
    ObservableList<OrdenCompraGasto> list = FXCollections.observableArrayList(
            new OrdenCompraGasto("1", "Ramiro", "Activo"),
            new OrdenCompraGasto("2", "Lorenzo", "Activo"),
            new OrdenCompraGasto("3", "Valmasceda", "Inactivo"),
            new OrdenCompraGasto("4", "Menbreno", "Inactivo")
    
    );

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        tblColumnNumOrden.setReorderable(false);
//        tblColumnMecanico.setReorderable(false);
//        tblColumnEstado.setReorderable(false);
        
        tblColumnNumOrden.setCellValueFactory(new PropertyValueFactory<OrdenCompraGasto,String>("N° de Orden"));
        tblColumnMecanico.setCellValueFactory(new PropertyValueFactory<OrdenCompraGasto,String>("Mecanico"));
        tblColumnEstado.setCellValueFactory(new PropertyValueFactory<OrdenCompraGasto,String>("Estado"));
        
        tblViewContent.setItems(list);
    }    

    @FXML
    public void btnOkAction(ActionEvent event) throws IOException {
        Scene scene = new Scene(loadFXML("Compras_Y_GastosFXML"));
        Stage stage = new Stage();
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setX(142); //Valor x para centrar el frame.
        stage.setY(39); //Valor y para centrar el frame.
        stage.setWidth(1239); //Valor para ajustar al tamaño adecuado.
        stage.setHeight(710); //Valor para ajustar al tamaño adecuado.
        stage.setResizable(false); //Para evitar que el usuario cambie el tamaño del frame.
        stage.showAndWait();
    }

    @FXML
    public void btnCancelarAction(ActionEvent event){
    }
    
}
