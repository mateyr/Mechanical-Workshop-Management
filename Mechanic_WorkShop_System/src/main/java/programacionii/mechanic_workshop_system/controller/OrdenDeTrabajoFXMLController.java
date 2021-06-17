/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import enums.Departamentos;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class OrdenDeTrabajoFXMLController implements Initializable {

    @FXML
    public Button btnPrint;
    @FXML
    public Button btnNewOrdenSinDatos;
    @FXML
    public Button btnNewOrdenConDatos;
    @FXML
    public Button btnSaveOrden;
    @FXML
    public Button btnCancelar;
    @FXML
    public TextField txtCodCliente;
    @FXML
    public TextField txtNombreCompleto;
    @FXML
    public TextField txtCedula;
    @FXML
    public TextField txtCorreoElectronico;
    @FXML
    public TextField txtTelefono;
    @FXML
    public Button btnSugerenciaCliente;
    @FXML
    public ComboBox<?> cmbMunicipio;
    @FXML
    public TextArea txtADireccion;
    @FXML
    public ComboBox<Departamentos> cmbDepartamento;
    @FXML
    public ComboBox<?> cmbBoColonia;
    @FXML
    public TextField txtCelular;
    @FXML
    public Label lblIconCar;
    @FXML
    public ComboBox<?> cmbTipoVehiculo;
    @FXML
    public ComboBox<?> cmbMarca;
    @FXML
    public TextField txtPlaca;
    @FXML
    public TextField txtMotor;
    @FXML
    public TextField txtVIN;
    @FXML
    public TextField txtCodVehiculo;
    @FXML
    public Label cmbColor;
    @FXML
    public Button btnSugereciaVehiculo;
    @FXML
    public ComboBox<?> cmbYearVehiculo;
    @FXML
    public ComboBox<?> cmbModelo;
    @FXML
    public ComboBox<?> cmbColorVehiculo;
    @FXML
    public Spinner<?> spnKms;
    @FXML
    public TextField txtChasis;
    @FXML
    public TextArea txtARevisar;
    @FXML
    public TextField txtPresupuesto;
    @FXML
    public TextField txtCodProducto;
    @FXML
    public TextField txtDescpProducto;
    @FXML
    public TextField txtCantidadProducto;
    @FXML
    public TextField txtDtoProducto;
    @FXML
    public TextField txtPrecioProducto;
    @FXML
    public TextField txtTotalProductos;
    @FXML
    public TableView<?> tblProductos;
    @FXML
    public TableColumn<?, ?> tblColumnCodigo;
    @FXML
    public TableColumn<?, ?> tblColumnDescripcion;
    @FXML
    public TableColumn<?, ?> tblColumnPrecio;
    @FXML
    public TableColumn<?, ?> tblColumnSubtotal;
    @FXML
    public TableColumn<?, ?> tblColumnDescuento;
    @FXML
    public TableColumn<?, ?> tblColumnTotal;
    @FXML
    public TextField txtSubTotal;
    @FXML
    public TextField txtDto;
    @FXML
    public TextField txtSubTotalNeto;
    @FXML
    public TextField txtIVA;
    @FXML
    public TextField txtTotal;
    @FXML
    public TextField txtMO;
    @FXML
    public TableColumn<?, ?> tblColumnCantidad;
    @FXML
    public Button btnAddProducto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        editFuntionTableView();
        //addImageButtons();
        loadcomboxes();
    }
    public void loadcomboxes()
    {
        ObservableList<Departamentos> departamentos = FXCollections.observableArrayList(Departamentos.values());
        this.cmbDepartamento.setItems(departamentos);
        this.cmbDepartamento.setValue(Departamentos.Atlantico_Norte);
    }
    private void editFuntionTableView() {
        tblColumnCodigo.setReorderable(false);
        tblColumnDescripcion.setReorderable(false);
        tblColumnCantidad.setReorderable(false);
        tblColumnPrecio.setReorderable(false);
        tblColumnSubtotal.setReorderable(false);
        tblColumnDescuento.setReorderable(false);
        tblColumnTotal.setReorderable(false);
    }

    @FXML
    public void btnPrintAction(ActionEvent event) {
    }

    @FXML
    public void btnNewOrdenSinDatosAction(ActionEvent event) {
    }

    @FXML
    public void btnNewOrdenConDatosAction(ActionEvent event) {
    }

    @FXML
    public void btnSaveOrdenAction(ActionEvent event) {
    }

    @FXML
    public void btnCancelarAction(ActionEvent event) 
    {
       ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void btnSugerenciaClienteAction(ActionEvent event) {
    }

    @FXML
    public void btnSugereciaVehiculoAction(ActionEvent event) {
    }

    @FXML
    public void btnAddProductoAction(ActionEvent event) {
    }
    
    private void addImageButtons() {
        URL linkPrintImage = getClass().getResource("/img/printer.png");
        
        Image imagenPrint = new Image(linkPrintImage.toString(), 32, 32, false, true);
        
        btnPrint.setGraphic((new ImageView(imagenPrint)));
    }
}
