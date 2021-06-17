/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import enums.Departamentos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import programacionii.mechanic_workshop_system.dao.implementation.JsonClienteDaoImpl;
import programacionii.mechanic_workshop_system.dao.implementation.JsonPresupuestoOrdenTrabajoDaoImpl;
import programacionii.mechanic_workshop_system.dao.implementation.JsonVehiculoDaoImpl;
import programacionii.mechanic_workshop_system.pojo.Cliente;
import programacionii.mechanic_workshop_system.pojo.OrdenDeTrabajo;
import programacionii.mechanic_workshop_system.pojo.PresupuestoOrdenDeTrabajo;
import programacionii.mechanic_workshop_system.pojo.Vehiculo;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class OrdenDeTrabajoFXMLController implements Initializable {

    JsonClienteDaoImpl jc;
    JsonVehiculoDaoImpl jv;
    JsonPresupuestoOrdenTrabajoDaoImpl jpot;
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
    public ComboBox<Departamentos> cmbMunicipio;
    @FXML
    public TextArea txtADireccion;
    @FXML
    public ComboBox<Departamentos> cmbDepartamento;
    @FXML
    public ComboBox<Departamentos> cmbBoColonia;
    @FXML
    public TextField txtCelular;
    @FXML
    public Label lblIconCar;
    @FXML
    public ComboBox<Departamentos> cmbTipoVehiculo;
    @FXML
    public ComboBox<Departamentos> cmbMarca;
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
    public ComboBox<Integer> cmbYearVehiculo;
    @FXML
    public ComboBox<Departamentos> cmbModelo;
    @FXML
    public ComboBox<Departamentos> cmbColorVehiculo;
    @FXML
    public Spinner<Integer> spnKms;
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
        SpinnerValueFactory<Integer> valueF =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueF.setValue(1);
        this.spnKms.setValueFactory(valueF);
        //this.spnKms.getValue()
        editFuntionTableView();
        //addImageButtons();
        loadcomboxes();
    }
    public void loadcomboxes()
    {
        ObservableList<Departamentos> departamentos = FXCollections.observableArrayList(Departamentos.values());
        this.cmbDepartamento.setItems(departamentos);
        this.cmbDepartamento.setValue(Departamentos.Atlantico_Norte);
        this.cmbBoColonia.setItems(departamentos);
        this.cmbBoColonia.setValue(Departamentos.Atlantico_Norte);
        this.cmbColorVehiculo.setItems(departamentos);
        this.cmbColorVehiculo.setValue(Departamentos.Atlantico_Norte);
        this.cmbMarca.setItems(departamentos);
        this.cmbMarca.setValue(Departamentos.Atlantico_Norte);
        this.cmbModelo.setItems(departamentos);
        this.cmbModelo.setValue(Departamentos.Atlantico_Norte);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ObservableList <Integer> years = FXCollections.observableArrayList(list);
        this.cmbYearVehiculo.setItems(years);
        
        this.cmbYearVehiculo.setValue(list.get(0));
        this.cmbTipoVehiculo.setItems(departamentos);
        this.cmbTipoVehiculo.setValue(Departamentos.Atlantico_Norte);
        this.cmbMunicipio.setItems(departamentos);
        this.cmbMunicipio.setValue(Departamentos.Atlantico_Norte);
    }
    
    public void validarEntrada() throws Exception
    {
        //Lectura de datos del cliente
        String codigoCliente = this.txtCodCliente.getText();
        if( codigoCliente.isEmpty() || codigoCliente.isBlank())
            throw new Exception("El codigo del cliente es requerido");
        
        String nombreCliente = this.txtNombreCompleto.getText();
        if( nombreCliente.isEmpty() || nombreCliente.isBlank())
            throw new Exception("El nombre del cliente es requerido");
        
        String cedula = this.txtCedula.getText();
        if( cedula.isEmpty() || cedula.isBlank())
            throw new Exception("La cedula del cliente es requerido");
        
        // validar si el txt del numero esta vacio
        if((this.txtCelular.getText()).isEmpty() || (this.txtCelular.getText()).isBlank())
            throw new Exception("El numero celular del cliente es requerido");
        try
        {
            long cel = Long.parseLong((String)this.txtCelular.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtCelular.getText()));
	}
        String correo = this.txtCorreoElectronico.getText();
        if(correo.isEmpty() || correo.isBlank())
            throw new Exception("El correo del cliente es requerido");
        
        if((this.txtTelefono.getText()).isEmpty() || (this.txtTelefono.getText()).isBlank())
            throw new Exception("El numero telefono del cliente es requerido");
        try
        {
            long fon = Long.parseLong((String)this.txtTelefono.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtTelefono.getText()));
	}
        String departamento = this.cmbDepartamento.getSelectionModel().getSelectedItem().toString();
        String municipio = this.cmbMunicipio.getSelectionModel().getSelectedItem().toString();
        String barrio = this.cmbBoColonia.getSelectionModel().getSelectedItem().toString();
        
        String direccion = this.txtADireccion.getText();
        if(direccion.isEmpty() || direccion.isBlank())
            throw new Exception("La direccion es requerido");
        
        //Lectura de datos del vehiculo
        String codigoVehiculo = this.txtCodVehiculo.getText();
        if(codigoVehiculo.isEmpty() || codigoVehiculo.isBlank())
            throw new Exception("El codigo del vehiculo es requerido");
        
        String tipoVehiculo = this.cmbTipoVehiculo.getSelectionModel().getSelectedItem().toString();
        
        String placa = this.txtPlaca.getText();
        
        if(placa.isEmpty() || placa.isBlank())
            throw new Exception("La placa es requerido");
        
        if((this.spnKms.getValue().toString()).isEmpty() || (this.spnKms.getValue().toString()).isBlank())
            throw new Exception("El kilometraje es requerido");
        
        String marca = this.cmbMarca.getSelectionModel().getSelectedItem().toString();
        String modelo = this.cmbModelo.getSelectionModel().getSelectedItem().toString();
        String motor = this.txtMotor.getText();
        
        if(motor.isEmpty() || motor.isBlank())
            throw new Exception("El motor es requerido");
            
        String color = this.cmbColorVehiculo.getSelectionModel().getSelectedItem().toString();
        String vin = this.txtVIN.getText();
        
        if(vin.isEmpty() || vin.isBlank())
            throw new Exception("El vin es requerido");
            
        String chasis = this.txtChasis.getText();
        
        if(chasis.isEmpty() || chasis.isBlank())
            throw new Exception(" es requerido");
        
        String revisar = this.txtARevisar.getText();
        
        if(revisar.isEmpty() || revisar.isBlank())
            throw new Exception(" es requerido");
            
        //Presupuesto de orden de trabajo
        if((this.txtPresupuesto.getText()).isEmpty() || (this.txtPresupuesto.getText()).isBlank())
            throw new Exception("El presupuesto es requerido");
        try
        {
            double presupuesto = Double.parseDouble((String)this.txtPresupuesto.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtPresupuesto.getText()));
	}
        
        String codigoProducto = this.txtCodProducto.getText();
        if(codigoProducto.isEmpty() || codigoProducto.isBlank())
            throw new Exception("El codigo del productoes requerido");
        try
        {
            int codigoProduct = Integer.parseInt(codigoProducto);
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + codigoProducto);
	}
        
        if((this.txtDtoProducto.getText()).isEmpty() || (this.txtDtoProducto.getText()).isBlank())
            throw new Exception("El Descuento del producto no puede ser vacio");
        try
        {
            double descuento = Double.parseDouble( (String)this.txtDtoProducto.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtDtoProducto.getText()));
	}
        
        String descripcion = this.txtDescpProducto.getText();
        
        if(descripcion.isEmpty() || descripcion.isBlank())
            throw new Exception("La descripcion es requerido");
        
        if((this.txtPrecioProducto.getText()).isEmpty() || (this.txtPrecioProducto.getText()).isBlank())
            throw new Exception("El precio del producto no puede ser vacio");
        try
        {
            double precio = Double.parseDouble((String)this.txtPrecioProducto.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtPrecioProducto.getText()));
	}
        
        if((this.txtCantidadProducto.getText()).isEmpty() || (this.txtCantidadProducto.getText()).isBlank())
            throw new Exception("La cantidad del producto no puede ser vacio");
        try
        {
            int cantidad = Integer.parseInt((String)this.txtCantidadProducto.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtCantidadProducto.getText()));
	}
        
        if((this.txtTotalProductos.getText()).isEmpty() || (this.txtTotalProductos.getText()).isBlank())
            throw new Exception("El total es requerido");
        try
        {
            double total = Double.parseDouble((String)this.txtTotalProductos.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtTotalProductos.getText()));
	}
        
        // Datos de calculo
        if((this.txtMO.getText()).isEmpty() || (this.txtMO.getText()).isBlank())
            throw new Exception("La mano de obra es requerido");
        try
        {
            double manoDeObra = Double.parseDouble((String)this.txtMO.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtMO.getText()));
	}
        
        if((this.txtSubTotal.getText()).isEmpty() || (this.txtSubTotal.getText()).isBlank())
            throw new Exception("El subtotal es requerido");
        try
        {
            double subtotal = Double.parseDouble((String)this.txtSubTotal.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtSubTotal.getText()));
	}
        if((this.txtDto.getText()).isEmpty() || (this.txtDto.getText()).isBlank())
            throw new Exception("La mano de obra es requerido");
        try
        {
            double dto = Double.parseDouble((String)this.txtDto.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtDto.getText()));
	}
        
        if((this.txtSubTotalNeto.getText()).isEmpty() || (this.txtSubTotalNeto.getText()).isBlank())
            throw new Exception("El subtotal es requerido");
        try
        {
            double subtn = Double.parseDouble((String)this.txtSubTotalNeto.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtSubTotalNeto.getText()));
	}
        
        if((this.txtIVA.getText()).isEmpty() || (this.txtIVA.getText()).isBlank())
            throw new Exception("El iva es requerido");
        try
        {
            double iva = Double.parseDouble((String)this.txtIVA.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtIVA.getText()));
	}
        
        if((this.txtTotal.getText()).isEmpty() || (this.txtTotal.getText()).isBlank())
            throw new Exception("El iva es requerido");
        try
        {
            double total = Double.parseDouble((String)this.txtTotal.getText());
	}catch(NumberFormatException nfe)
        {
            throw new Exception("Entrada invalida: " + (this.txtTotal.getText()));
	}
        /*
        if(.isEmpty() || .isBlank())
            throw new Exception(" es requerido");
        */
        
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
    public void btnSaveOrdenAction(ActionEvent event)
    {
        try
        {
            validarEntrada();
        } catch (Exception ex)
        {
            Alert a = new Alert(Alert.AlertType.ERROR,"Entrada invalidad. " + ex.getMessage(), ButtonType.OK);
            a.showAndWait();
            Logger.getLogger(OrdenDeTrabajoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Vehicle
        String placa = this.txtPlaca.getText();
        String motor = this.txtMotor.getText();
        String vin = this.txtVIN.getText();
        String chasis = this.txtChasis.getText();
        String year = this.cmbYearVehiculo.getSelectionModel().getSelectedItem().toString();
        String kms = this.spnKms.getValue().toString();
        String modelo = this.cmbModelo.getSelectionModel().getSelectedItem().toString();
        String color = this.cmbColorVehiculo.getSelectionModel().getSelectedItem().toString();
        String marcaVehiculo = this.cmbMarca.getSelectionModel().getSelectedItem().toString();
        String tipoVehiculo = this.cmbTipoVehiculo.getSelectionModel().getSelectedItem().toString();
        
        Vehiculo v = new Vehiculo(placa, motor, vin, chasis, year, kms, modelo, color, marcaVehiculo, tipoVehiculo);
        try
        {
            jv.create(v);
        } catch (IOException ex)
        {
            Logger.getLogger(OrdenDeTrabajoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Cliente
        String nombre = this.txtNombreCompleto.getText();
        String cedula = this.txtCedula.getText();
        String celular = this.txtCelular.getText();
        String correo = this.txtCorreoElectronico.getText();
        String telefono = this.txtTelefono.getText();
        String departamento = this.cmbDepartamento.getSelectionModel().getSelectedItem().toString();
        String municipio = this.cmbMunicipio.getSelectionModel().getSelectedItem().toString();
        String barrio = this.cmbBoColonia.getSelectionModel().getSelectedItem().toString();
        String dir = this.txtADireccion.getText();
        
        Cliente c = new Cliente( nombre, cedula,  celular,  correo,  telefono, departamento,  municipio,  barrio,  dir, v);
        try
        {
            jc.create(c);
        } catch (IOException ex)
        {
            Logger.getLogger(OrdenDeTrabajoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Presupues de orden de trabajo
        int codigo = Integer.parseInt(this.txtCodProducto.getText());
        String descripcion = this.txtDescpProducto.getText();
        int cantidad = Integer.parseInt(this.txtCantidadProducto.getText());
        double precio = Double.parseDouble(this.txtPrecioProducto.getText());
        double subTotal = Double.parseDouble(this.txtSubTotal.getText());
        double descuento = Double.parseDouble(this.txtDtoProducto.getText());
        double total = Double.parseDouble(this.txtTotalProductos.getText());
        
        PresupuestoOrdenDeTrabajo pot = new PresupuestoOrdenDeTrabajo(codigo, descripcion, cantidad, precio, subTotal, descuento, total);
        try
        {
            jpot.create(pot);
        } catch (IOException ex)
        {
            Logger.getLogger(OrdenDeTrabajoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Orden de trabajo
        int codCliente = c.getId();
        int codVehiculo = v.getId();
        String revision = this.txtARevisar.getText();
        double presupuesto = Double.parseDouble(this.txtPresupuesto.getText());
        PresupuestoOrdenDeTrabajo presupuestoOrdenDeTrabajo = pot;
        
        OrdenDeTrabajo odt = new OrdenDeTrabajo(codCliente, codVehiculo, revision, presupuesto, presupuestoOrdenDeTrabajo);
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
