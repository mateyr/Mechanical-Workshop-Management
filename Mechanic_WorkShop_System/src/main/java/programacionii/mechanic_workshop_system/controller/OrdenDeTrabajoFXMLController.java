/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import programacionii.mechanic_workshop_system.dao.implementation.JsonClienteDaoImpl;
import programacionii.mechanic_workshop_system.dao.implementation.JsonPresupuestoOrdenTrabajoDaoImpl;
import programacionii.mechanic_workshop_system.dao.implementation.JsonVehiculoDaoImpl;
import programacionii.mechanic_workshop_system.enums.Color;
import programacionii.mechanic_workshop_system.enums.Departamento;
import programacionii.mechanic_workshop_system.enums.MarcaVehiculo;
import programacionii.mechanic_workshop_system.enums.Modelos;
import programacionii.mechanic_workshop_system.enums.TipoVehiculo;
import programacionii.mechanic_workshop_system.enums.Municipios;
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
    public ComboBox<Enum> cmbMunicipio;
    @FXML
    public TextArea txtADireccion;
    @FXML
    public ComboBox<Departamento> cmbDepartamento;
    @FXML
    public ComboBox<?> cmbBoColonia;
    @FXML
    public TextField txtCelular;
    @FXML
    public Label lblIconCar;
    @FXML
    public ComboBox<TipoVehiculo> cmbTipoVehiculo;
    @FXML
    public ComboBox<MarcaVehiculo> cmbMarca;
    @FXML
    public TextField txtPlaca;
    @FXML
    public TextField txtMotor;
    @FXML
    public TextField txtVIN;
    @FXML
    public TextField txtCodVehiculo;
    @FXML
    public Button btnSugereciaVehiculo;
    @FXML
    public ComboBox<Integer> cmbYearVehiculo;
    @FXML
    public ComboBox<Enum> cmbModelo;
    @FXML
    public ComboBox<Color> cmbColorVehiculo;
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
    @FXML
    public Button btnCalcularAll;
    @FXML
    public Label lblNumOrden;

    private JsonVehiculoDaoImpl jv;
    private JsonClienteDaoImpl jc;
    private JsonPresupuestoOrdenTrabajoDaoImpl jpot;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnNewOrdenSinDatos.setText("Nueva orden\nSin datos ✖");
        btnNewOrdenConDatos.setText("Nueva Orden\nCon datos ✔");
        editFuntionTableView();
        loadComboBoxs();
        validateMunicipio();
        validateModelos();
        jv = new JsonVehiculoDaoImpl();
        jc = new JsonClienteDaoImpl();
        jpot = new JsonPresupuestoOrdenTrabajoDaoImpl();
//        Alert a = new Alert(Alert.AlertType.INFORMATION, "Indice: " + cmbDepartamento.getSelectionModel().getSelectedIndex(), ButtonType.OK);
//        a.showAndWait();
        //addImageButtons();
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

    private void loadComboBoxs() {
        List<Integer> years = new ArrayList<>();
       int[] year = new int[]{
            1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,
            2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019,
            2020, 2021
        };
        
        for (int i = 0; i < year.length; i++) {
            years.add(year[i]);
        }
        
        ObservableList<Color> colores = FXCollections.observableArrayList(Color.values());
        ObservableList<Departamento> departamentos = FXCollections.observableArrayList(Departamento.values());
        ObservableList<MarcaVehiculo> marcaVehiculo = FXCollections.observableArrayList(MarcaVehiculo.values());
        ObservableList<TipoVehiculo> tipoVehiculo = FXCollections.observableArrayList(TipoVehiculo.values());
        //ObservableList<Municipios.BoacoMunicipio> municipio = FXCollections.observableArrayList(Municipios.BoacoMunicipio.values());
        ObservableList<Integer> yearVehiculo = FXCollections.observableArrayList(years);
        
        cmbColorVehiculo.setItems(colores);
        cmbDepartamento.setItems(departamentos);
        cmbMarca.setItems(marcaVehiculo);
        cmbTipoVehiculo.setItems(tipoVehiculo);
        //cmbMunicipio.setItems(municipio);
        cmbYearVehiculo.setItems(yearVehiculo);
        
        cmbColorVehiculo.setValue(Color.Blanco);
        cmbDepartamento.getSelectionModel().select(0);
        cmbMarca.setValue(MarcaVehiculo.Toyota);
        cmbTipoVehiculo.setValue(TipoVehiculo.Carro);
        //cmbMunicipio.getSelectionModel().select(0);
        cmbYearVehiculo.getSelectionModel().select(0);
    }
    
    private void validateMunicipio() {
        ObservableList<Departamento> departamentos = cmbDepartamento.getItems();
        ObservableList<Enum> municipio = null;
        for (int i = 0; i < departamentos.size(); i++) {
            if(departamentos.get(i).equals(cmbDepartamento.getSelectionModel().getSelectedItem())){
                switch(i) {
                    case 0: //Boaco
                        municipio = FXCollections.observableArrayList(Municipios.BoacoMunicipio.values());
                        break;
                    case 1: //Carazo
                        municipio = FXCollections.observableArrayList(Municipios.CarazoMunicipio.values());
                        break;
                    case 2: //Chinandega
                        municipio = FXCollections.observableArrayList(Municipios.ChinandegaMunicipio.values());
                        break;
                    case 3: //Chontales
                        municipio = FXCollections.observableArrayList(Municipios.ChontalesMunicipio.values());
                        break;
                    case 4: //Costa caribe norte
                        municipio = FXCollections.observableArrayList(Municipios.CostaCaribeNorteMunicipio.values());
                        break;
                    case 5: //Costa caribe sur
                        municipio = FXCollections.observableArrayList(Municipios.CostaCaribeSurMunicipio.values());
                        break;
                    case 6: //Esteli
                        municipio = FXCollections.observableArrayList(Municipios.EsteliMunicipio.values());
                        break;
                    case 7: //Granada
                        municipio = FXCollections.observableArrayList(Municipios.GranadaMunicipio.values());
                        break;
                    case 8: //Jinotega
                        municipio = FXCollections.observableArrayList(Municipios.JinotegaMunicipio.values());
                        break;
                    case 9: //Leon
                        municipio = FXCollections.observableArrayList(Municipios.LeonMunicipio.values());
                        break;
                    case 10: //Madriz
                        municipio = FXCollections.observableArrayList(Municipios.MadrizMunicipio.values());
                        break;
                    case 11: //Managua
                        municipio = FXCollections.observableArrayList(Municipios.ManaguaMunicipio.values());
                        break;
                    case 12: //Masaya
                        municipio = FXCollections.observableArrayList(Municipios.MasayaMunicipio.values());
                        break;
                    case 13: //Matagalpa
                        municipio = FXCollections.observableArrayList(Municipios.MatagalpaMunicipio.values());
                        break;
                    case 14: //Nueva Segovia
                        municipio = FXCollections.observableArrayList(Municipios.NuevaSegoviaMunicipio.values());
                        break;
                    case 15: //Rio san juan
                        municipio = FXCollections.observableArrayList(Municipios.RioSanJuanMunicipio.values());
                        break;
                    case 16: //Rivas
                        municipio = FXCollections.observableArrayList(Municipios.RivasMunicipio.values());
                        break;
                    default: break;
                }
                break;
            }
        }
        cmbMunicipio.setItems(municipio);
        cmbMunicipio.getSelectionModel().select(0);
    }

    private void validateModelos() {
        ObservableList<MarcaVehiculo> marcas = cmbMarca.getItems();
        ObservableList<Enum> modelos = null;
        
        for (int i = 0; i < marcas.size(); i++) {
            if(marcas.get(i).equals(cmbMarca.getSelectionModel().getSelectedItem())) {
                switch(i) {
                    case 0: //Toyota
                        modelos = FXCollections.observableArrayList(Modelos.ToyotaModel.values());
                        break;
                    case 1: //Honda
                        modelos = FXCollections.observableArrayList(Modelos.HondaModel.values());
                        break;
                    case 2: //Hyuundai
                        modelos = FXCollections.observableArrayList(Modelos.HyundaiModel.values());
                        break;
                    case 3: //Ford
                        modelos = FXCollections.observableArrayList(Modelos.FordModel.values());
                        break;
                    case 4: //Kia
                        modelos = FXCollections.observableArrayList(Modelos.KiaModel.values());
                        break;
                    case 5: //Chevrolet
                        modelos = FXCollections.observableArrayList(Modelos.ChevroletModel.values());
                        break;
                    case 6: //Suzuki
                        modelos = FXCollections.observableArrayList(Modelos.SuzukiModel.values());
                        break;
                    case 7: //Mazda
                        modelos = FXCollections.observableArrayList(Modelos.MazdaModel.values());
                        break;
                    case 8: //Nissan
                        modelos = FXCollections.observableArrayList(Modelos.NissanModel.values());
                        break;
                    case 9: //Mitsubishi
                        modelos = FXCollections.observableArrayList(Modelos.MitsubishiModel.values());
                        break;
                    case 10: //BMW
                        modelos = FXCollections.observableArrayList(Modelos.BmwModel.values());
                        break;
                    case 11: //Mercedes Benz
                        modelos = FXCollections.observableArrayList(Modelos.MercedesBenzModel.values());
                        break;
                    case 12: //Daihatsu
                        modelos = FXCollections.observableArrayList(Modelos.DaihatsuModel.values());
                        break;
                    case 13: //Volkswagen
                        modelos = FXCollections.observableArrayList(Modelos.VolkswagenModel.values());
                        break;
                    default: break;
                }
                break;
            }
        }
        
        cmbModelo.setItems(modelos);
        cmbModelo.getSelectionModel().select(0);
    }
    
    public void btnPrintAction(ActionEvent event) {
    }

    @FXML
    public void btnNewOrdenSinDatosAction(ActionEvent event) {
    }

    @FXML
    public void btnNewOrdenConDatosAction(ActionEvent event) {
    }

    /*@FXML
    /*public void btnSaveOrdenAction(ActionEvent event) {
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
        //double total = Double.parseDouble(this.txtTotalProductos.getText());  // Da Error 
        
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

    /*private void validarEntrada() throws Exception
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
        
        Lectura de datos del vehiculo
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
        
        if((this.txtTotalProductos.getText()).isEmpty() || (this.txtTotalProductos.getText()).isBlank())   //Da Error
            throw new Exception("El total es requerido");
        try  
        /*{
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
	}*/
        
        //if(.isEmpty() || .isBlank())
          //  throw new Exception(" es requerido");
        
        
       
    //}

    /*@FXML
    private void btnCancelarAction(ActionEvent event)
    {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnSugerenciaClienteAction(ActionEvent event)
    {
    }

    @FXML
    private void cmbMunicipioAction(ActionEvent event)
    {
    }

    @FXML
    private void cmbDepartamentoAction(ActionEvent event)
    {
         validateMunicipio();
    }

    @FXML
    private void cmbMarcaAction(ActionEvent event)
    {
         validateModelos();
    }

    @FXML
    private void btnSugereciaVehiculoAction(ActionEvent event)
    {
    }

    @FXML
    private void btnAddProductoAction(ActionEvent event)
    {
    }

    @FXML
    private void btnCalcularAllAction(ActionEvent event)
    {
    }
}*/
     

    /**
     * Initializes the controller class.
     */
    /*@Override
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
    }*/
   

    
   /* private void addImageButtons() 
                    {
        URL linkPrintImage = getClass().getResource("/img/printer.png");
        
        Image imagenPrint = new Image(linkPrintImage.toString(), 32, 32, false, true);
        
        btnPrint.setGraphic((new ImageView(imagenPrint)));
    }*/

}