package mx.itam.diplomado.libreria.controller;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import mx.itam.diplomado.libreria.model.*;
import mx.itam.diplomado.libreria.utils.ListaIndexadaOrdenada;
import mx.itam.diplomado.libreria.view.VistaLibreria;


/**
 *
 * @author Guillermo hernandez
 */
public class MainController extends VistaLibreria {
    ManejadorCentros mCentros=new ManejadorCentros();
    ManejadorCategorias mCategorias = new ManejadorCategorias();
    ManejadorProductos mProductos = new ManejadorProductos();
    ManejadorExistencias mExistencias = new ManejadorExistencias();
    
    public MainController(String t){
        super(t);
        btnAddCentro.addActionListener(new AltaCentroListener());
        btnDeleteCentro.addActionListener(new DeleteCentroListener());
        btnEditCentro.addActionListener(new EditaCentroListener());
        btnContarCentros.addActionListener(new CuentaCentroListener());
        btnInfoCentros.addActionListener(new InfoCentroListener());
        btnLoadCentros.addActionListener(new LoadCentroListener());
        //
        btnAddCate.addActionListener(new AltaCategoriaListener());
        btnDeleteCate.addActionListener(new DeleteCategoriaListener());
        btnEditCate.addActionListener(new EditaCategoriaListener());
        btnContarCates.addActionListener(new CuentaCategoriaListener());
        btnInfoCates.addActionListener(new InfoCategoriaListener());
        btnLoadCates.addActionListener(new LoadCategoriaListener());
        //
        btnAddProducto.addActionListener(new AltaProductoListener());
        btnDeleteProducto.addActionListener(new DeleteProductoListener());
        btnEditProducto.addActionListener(new EditaProductoListener());
        btnContarProductos.addActionListener(new CuentaProductoListener());
        btnInfoProductos.addActionListener(new InfoProductoListener());
        btnLoadProductos.addActionListener(new LoadProductoListener());
    }
    
    public class AltaCentroListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            JLabel lblId=new JLabel("ID: ",JLabel.RIGHT);
            JLabel lblNombre=new JLabel("Nombre del centro: ",JLabel.RIGHT);
            JLabel lblDireccion=new JLabel("Dirección: ",JLabel.RIGHT);
            // Cuadros de Texo
            JTextField txtId=new JTextField(25);
            JTextField txtNombre=new JTextField(25);
            JTextField txtDireccion=new JTextField(25);
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(3,3));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblId);
            jp.add(txtId);
            jp.add(lblNombre);
            jp.add(txtNombre);
            jp.add(lblDireccion);
            jp.add(txtDireccion);
            if(JOptionPane.showConfirmDialog(null,jp,"Escribe los datos del nuevo centro",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                try{
                    int pId=Integer.parseInt(txtId.getText());
                    if(mCentros.addCentro(pId, txtNombre.getText(), txtDireccion.getText())){
                        JOptionPane.showMessageDialog(null, "Se añadió con éxito", "Añadir centro", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo añadir el centro", "Añadir centro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public class DeleteCentroListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            String res;
            int x;
            res=JOptionPane.showInputDialog("Escribe el numero de centro a eliminar");
            try{
                x=Integer.parseInt(res);
                if(mCentros.removeCentro(x)!=null){
                    JOptionPane.showMessageDialog(null, "Se eliminó con éxito", "Eliminar centro", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el centro", "Eliminar centro", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public class EditaCentroListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblId=new JLabel("ID: ",JLabel.RIGHT);
            JLabel lblNombre=new JLabel("Nombre del centro: ",JLabel.RIGHT);
            JLabel lblDireccion=new JLabel("Dirección: ",JLabel.RIGHT);
            JTextField txtId=new JTextField(25);
            JTextField txtNombre=new JTextField(25);
            JTextField txtDireccion=new JTextField(25);
            JPanel jp= new JPanel();
            String res;
            int x;
            Centro centrito;
            // Pedir el número de centro a editar
            try{
                res=JOptionPane.showInputDialog("Escribe el numero de centro a editar");
                x=Integer.parseInt(res);
                centrito=mCentros.containsCentro(new Centro (x));
                if(centrito!=null){
                    txtId.setText(String.valueOf(centrito.getIdCentro()));
                    txtId.setEditable(false);
                    txtNombre.setText(centrito.getNombre());
                    txtDireccion.setText(centrito.getDireccion());
                    jp.setLayout(new GridLayout(3,3));
                    Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
                    // Agregar los componenrtes en el grid en el orden en que deben aparecer
                    jp.setBorder(gap);
                    jp.add(lblId);
                    jp.add(txtId);
                    jp.add(lblNombre);
                    jp.add(txtNombre);
                    jp.add(lblDireccion);
                    jp.add(txtDireccion);
                    if(JOptionPane.showConfirmDialog(null,jp,"Escribe los datos centro",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                        int pId=Integer.parseInt(txtId.getText());
                        String nom=txtNombre.getText();
                        String dir=txtDireccion.getText();
                        if(mCentros.renameCentro(pId, nom) && mCentros.changeAddressCentro(pId, dir)){
                            JOptionPane.showMessageDialog(null, "Se editó con éxito", "Editar centro", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo editar el centro", "Editar centro", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El centro "+x+" no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public class InfoCentroListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblI=new JLabel(" ** Información de centros **");
            JTextArea txtin = new JTextArea(10, 40);
            txtin.setEditable(false);
            txtin.setText(mCentros.toString());
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(0,1));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblI);
            jp.add(txtin);
            JOptionPane.showMessageDialog(null, jp);
        }
        
    }
    
    public class CuentaCentroListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Centros registrados: "+mCentros.countCentros(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public class LoadCentroListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            File archivaldo;
            JFileChooser chooser = new JFileChooser();
            Scanner archivo;
            if(JOptionPane.showConfirmDialog(null, "Al cargar centros se eliminaran los existentes\n¿Continuar de todas formas?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal==JFileChooser.APPROVE_OPTION) {
                    try{
                        archivaldo=chooser.getSelectedFile();
                        archivo=new Scanner(archivaldo);
                        int counter=0,added=0;
                        mCentros.clear();
                        while(archivo.hasNextLine()){
                            String linea=archivo.nextLine();
                            String[] partes=linea.split("\\:");
                            added=mCentros.addCentro(Integer.parseInt(partes[0]), partes[1], partes[2])?added+1:added;
                            counter++;
                        }
                        JOptionPane.showMessageDialog(null, "Se añadieron "+added+" de "+counter+" centros que hay registrados en el archivo", "Carga de centros", JOptionPane.INFORMATION_MESSAGE);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error al cargar los centros\n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }               
                }
            }
        }
    }
    //--- Separator
    public class AltaCategoriaListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            JLabel lblId=new JLabel("Número de categoría: ",JLabel.RIGHT);
            JLabel lblNombre=new JLabel("Nombre de la categoria: ",JLabel.RIGHT);
            // Cuadros de Texo
            JTextField txtId=new JTextField(25);
            JTextField txtNombre=new JTextField(25);
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(3,2));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblId);
            jp.add(txtId);
            jp.add(lblNombre);
            jp.add(txtNombre);
            if(JOptionPane.showConfirmDialog(null,jp,"Escribe los datos de la nueva categoria",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                try{
                    int pId=Integer.parseInt(txtId.getText());
                    if(mCategorias.addCategoria(pId, txtNombre.getText())){
                        JOptionPane.showMessageDialog(null, "Se añadió con éxito", "Añadir categoria", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo añadir la categoría", "Añadir categoria", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public class DeleteCategoriaListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            String res;
            int x;
            res=JOptionPane.showInputDialog("Escribe el numero de categoria a eliminar");
            try{
                x=Integer.parseInt(res);
                if(mCategorias.removeCategoria(x)!=null){
                    JOptionPane.showMessageDialog(null, "Se eliminó con éxito", "Eliminar categoría", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar la categoría", "Eliminar categoría", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public class EditaCategoriaListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblId=new JLabel("ID: ",JLabel.RIGHT);
            JLabel lblNombre=new JLabel("Nombre de la categoría: ",JLabel.RIGHT);
            JTextField txtId=new JTextField(25);
            JTextField txtNombre=new JTextField(25);
            JPanel jp= new JPanel();
            String res;
            int x;
            Categoria cate;
            // Pedir el número de centro a editar
            try{
                res=JOptionPane.showInputDialog("Escribe el numero de categoría a editar");
                x=Integer.parseInt(res);
                cate=mCategorias.containsCategoria(new Categoria (x));
                if(cate!=null){
                    txtId.setText(String.valueOf(cate.getId()));
                    txtId.setEditable(false);
                    txtNombre.setText(cate.getNombre());
                    jp.setLayout(new GridLayout(2,2));
                    Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
                    // Agregar los componenrtes en el grid en el orden en que deben aparecer
                    jp.setBorder(gap);
                    jp.add(lblId);
                    jp.add(txtId);
                    jp.add(lblNombre);
                    jp.add(txtNombre);
                    if(JOptionPane.showConfirmDialog(null,jp,"Escribe los datos de la categoría",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                        int pId=Integer.parseInt(txtId.getText());
                        String nom=txtNombre.getText();
                        if(mCategorias.renameCategoria(pId, nom)){
                            JOptionPane.showMessageDialog(null, "Se editó con éxito", "Editar Categoria", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo editar la categoria", "Editar centro", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El categoria "+x+" no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public class InfoCategoriaListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblI=new JLabel(" ** Información de categoria **");
            JTextArea txtin = new JTextArea(10, 40);
            txtin.setEditable(false);
            txtin.setText(mCategorias.toString());
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(0,1));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblI);
            jp.add(txtin);
            JOptionPane.showMessageDialog(null, jp);
        }
    }
    
    public class CuentaCategoriaListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Categorías registradas: "+mCategorias.countCategories(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public class LoadCategoriaListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            File archivaldo;
            JFileChooser chooser = new JFileChooser();
            Scanner archivo;
            if(JOptionPane.showConfirmDialog(null, "Al cargar categorías se eliminaran las existentes\n¿Continuar de todas formas?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal==JFileChooser.APPROVE_OPTION) {
                    try{
                        archivaldo=chooser.getSelectedFile();
                        archivo=new Scanner(archivaldo);
                        int counter=0,added=0;
                        mCategorias.clear();
                        while(archivo.hasNextLine()){
                            String linea=archivo.nextLine();
                            String[] partes=linea.split("\\:");
                            added=mCategorias.addCategoria(Integer.parseInt(partes[0]), partes[1])?added+1:added;
                            counter++;
                        }
                        JOptionPane.showMessageDialog(null, "Se añadieron "+added+" de "+counter+" categorías que hay registradas en el archivo", "Carga de categorías", JOptionPane.INFORMATION_MESSAGE);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error al cargar las centros\n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }               
                }
            }
        }
    }
    
    public class AltaProductoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int i;
            JLabel lblId=new JLabel("Categoría: ",JLabel.RIGHT);
            JLabel lblClave=new JLabel("Clave Producto: ",JLabel.RIGHT);
            JLabel lblDescripcion=new JLabel("Descripcion: ",JLabel.RIGHT);
            JLabel lblCosto=new JLabel("Costo: ",JLabel.RIGHT);
            JLabel lblPrecio=new JLabel("Precio: ",JLabel.RIGHT);
            JLabel lblNomCate=new JLabel("Nombre de Categoria: ",JLabel.RIGHT);
            // Cuadros de Texto
            JTextField txtClave=new JTextField(25);
            JTextField txtDescripcion=new JTextField(25);
            JTextField txtCosto=new JTextField(15);
            JTextField txtPrecio=new JTextField(15);
            final JTextField txtNomCate=new JTextField(15);
            txtNomCate.setEditable(false);
            // Kombos
            final JComboBox cmbCate=new JComboBox();
            cmbCate.addItem("Seleccionar");
            for(i=0;i<mCategorias.countCategories();i++){
                cmbCate.addItem(String.valueOf(mCategorias.getCategoria(i+1).getId()));
            }
            cmbCate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selected =cmbCate.getSelectedItem().toString();
                    int iSelected=Integer.parseInt(selected);
                    Categoria cate=mCategorias.getCategoria(iSelected);
                    //System.out.println(iSelected);
                    txtNomCate.setText(cate.getNombre());
                }
            });

            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(6,2));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblId);
            jp.add(cmbCate);
            jp.add(lblNomCate);
            jp.add(txtNomCate);
            jp.add(lblClave);
            jp.add(txtClave);
            jp.add(lblDescripcion);
            jp.add(txtDescripcion);
            jp.add(lblCosto);
            jp.add(txtCosto);
            jp.add(lblPrecio);
            jp.add(txtPrecio);
            if(JOptionPane.showConfirmDialog(null,jp,"Escribe los datos del nuevo producto",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                try{
                    ListaIndexadaOrdenada<Centro> listaCentros;
                    int pCate=Integer.parseInt((String)cmbCate.getSelectedItem());
                    int pId=Integer.parseInt(txtClave.getText());
                    Producto pro=new Producto(pCate, pId, txtDescripcion.getText(), Float.parseFloat(txtCosto.getText()), Float.parseFloat(txtPrecio.getText()));
                    if(mProductos.addProducto(pro)){
                        listaCentros=mCentros.getCentros();
                        for(int r=0;r<listaCentros.size();r++){
                            mExistencias.addExistencia(listaCentros.get(r), pro);
                        }
                        JOptionPane.showMessageDialog(null, "Se añadió con éxito", "Añadir producto", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo añadir el producto", "Añadir producto", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public class DeleteProductoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblId=new JLabel("Categoría: ",JLabel.RIGHT);
            JLabel lblC=new JLabel("Nombre de la categoría: ",JLabel.RIGHT);
            JLabel lblClave=new JLabel("Clave Producto: ",JLabel.RIGHT);
            final JComboBox cmbCate=new JComboBox();
            final JComboBox cmbProdu=new JComboBox();
            final JTextField txtNomCate=new JTextField(15);
            cmbCate.addItem("Seleccionar");
            for(int i=0;i<mCategorias.countCategories();i++){
                cmbCate.addItem(String.valueOf(mCategorias.getCategoria(i+1).getId()));
            }
            cmbCate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selected =cmbCate.getSelectedItem().toString();
                    int iSelected=Integer.parseInt(selected);
                    Categoria cate=mCategorias.getCategoria(iSelected);
                    cmbProdu.removeAllItems();
                    cmbProdu.addItem("Seleccionar");
                    ListaIndexadaOrdenada<Producto> lista=mProductos.getProductsByCat(iSelected);
                    txtNomCate.setText(cate.getNombre());
                    for(int j=0;j<lista.size();j++){
                        cmbProdu.addItem(String.valueOf(lista.get(j).getId()));
                    }
                }
            });
            
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(3,2));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblId);
            jp.add(cmbCate);
            jp.add(lblC);
            jp.add(txtNomCate);
            jp.add(lblClave);
            jp.add(cmbProdu);
            
            if(JOptionPane.showConfirmDialog(null,jp,"Selecciona el producto a eliminar",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                try{
                    int pCate=Integer.parseInt((String)cmbCate.getSelectedItem());
                    int pId=Integer.parseInt((String)cmbProdu.getSelectedItem());
                    if(mProductos.removeProducto(pCate,pId)!=null){
                        JOptionPane.showMessageDialog(null, "Se eliminó con éxito", "Eliminar producto", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto", "Eliminar producto", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Algo salió mal :(\n ("+e.getMessage()+")", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public class EditaProductoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblCentro=new JLabel("Centro: ",JLabel.RIGHT);
            final JComboBox cmbCentro=new JComboBox();
            final JLabel lblNombreCentro=new JLabel("",JLabel.LEFT);
            
            JLabel lblCate=new JLabel("Categoría: ",JLabel.RIGHT);
            JComboBox cmbCate=new JComboBox();
            JLabel lblNombreCate=new JLabel("",JLabel.LEFT);
            
            JLabel lblClave=new JLabel("Clave del producto: ",JLabel.RIGHT);
            JTextField txtIdProd=new JTextField(25);
            JButton btnBuscar=new JButton("Buscar");
            
            JLabel lblDescribe=new JLabel("Descripcion: ",JLabel.RIGHT);
            JTextField txtIdDescProd=new JTextField(25);
            JLabel lblVacio2=new JLabel();
            
            JLabel lblCosto=new JLabel("Costo: ",JLabel.RIGHT);
            JTextField txtCosto=new JTextField(25);
            JLabel lblVacio3=new JLabel();
            
            JLabel lblPrecio=new JLabel("Precio: ",JLabel.RIGHT);
            JTextField txtPrecio=new JTextField(25);
            JLabel lblVacio4=new JLabel();

            JLabel lblExistencia=new JLabel("Existencias: ",JLabel.RIGHT);
            JTextField txtIdExistencias=new JTextField(25);
            JLabel lblVacio5=new JLabel();
            //
            ListaIndexadaOrdenada<Centro> listaCentros=mCentros.getCentros();
            cmbCentro.addItem("Seleccionar");
            System.out.println(listaCentros.toString());    
            for(int xx=0;xx<listaCentros.size();xx++){
                cmbCentro.addItem(String.valueOf(listaCentros.get(xx).getIdCentro()));
            }
            
            cmbCentro.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String selected =cmbCentro.getSelectedItem().toString();
                    int iSelected=Integer.parseInt(selected);
                    Centro c=mCentros.getCentro(iSelected);
                    lblNombreCentro.setText(c.getNombre());
                }
            });
            //
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(7,3));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            
            jp.add(lblCentro);
            jp.add(cmbCentro);
            jp.add(lblNombreCentro);
            
            jp.add(lblCate);
            jp.add(cmbCate);
            jp.add(lblNombreCate);
            
            jp.add(lblClave);
            jp.add(txtIdProd);
            jp.add(btnBuscar);
            
            jp.add(lblDescribe);
            jp.add(txtIdDescProd);
            jp.add(lblVacio2);
            
            jp.add(lblCosto);
            jp.add(txtCosto);
            jp.add(lblVacio3);
            
            jp.add(lblPrecio);
            jp.add(txtPrecio);
            jp.add(lblVacio4);
            
            jp.add(lblExistencia);
            jp.add(txtIdExistencias);
            jp.add(lblVacio5);

            if(JOptionPane.showConfirmDialog(null,jp,"Modifica los datos del producto",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION){
                
            }
        }
    }
    
    public class InfoProductoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JLabel lblI=new JLabel(" ** Información de Productos **");
            JTextArea txtin = new JTextArea(10, 40);
            txtin.setEditable(false);
            txtin.setText(mProductos.toString());
            JPanel jp= new JPanel();
            jp.setLayout(new GridLayout(0,1));
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            jp.setBorder(gap);
            jp.add(lblI);
            jp.add(txtin);
            JOptionPane.showMessageDialog(null, jp);
        }
        
    }
    
    public class CuentaProductoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Productos registrados: "+mProductos.countProductos(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public class LoadProductoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            File archivaldo;
            JFileChooser chooser = new JFileChooser();
            Scanner archivo;
            if(JOptionPane.showConfirmDialog(null, "Al cargar productos se eliminarán los existentes\n¿Continuar de todas formas?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal==JFileChooser.APPROVE_OPTION) {
                    try{
                        ListaIndexadaOrdenada<Centro> listaCentros;
                        archivaldo=chooser.getSelectedFile();
                        archivo=new Scanner(archivaldo);
                        int counter=0,added=0;
                        mProductos.clear();
                        while(archivo.hasNextLine()){
                            String linea=archivo.nextLine();
                            String[] partes=linea.split("\\:");
                            int cc=Integer.parseInt(partes[0]);
                            if(mCategorias.containsCategoria(
                                    new Categoria(cc)).getId()
                                    >=0){
                                Producto toAdd=new Producto(cc,Integer.parseInt(partes[1]), partes[2], Float.parseFloat(partes[3]), Float.parseFloat(partes[4]));
                                if(mProductos.addProducto(toAdd)){
                                    added++;
                                    listaCentros=mCentros.getCentros();
                                    for(int r=0;r<listaCentros.size();r++){
                                        mExistencias.addExistencia(listaCentros.get(r), toAdd);
                                    }
                                }
                                counter++;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Se añadieron "+added+" de "+counter+" producto que hay registrados en el archivo", "Carga de Productos", JOptionPane.INFORMATION_MESSAGE);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error al cargar los productos\n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }               
                }
            }
        }
    }
    
    public static void main(String args[]){
        MainController ma=new MainController("Libreria XYZ");
    }
    
    
}
