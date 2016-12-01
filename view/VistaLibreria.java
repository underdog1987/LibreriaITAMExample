package mx.itam.diplomado.libreria.view;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Vista de la libreria
 */
public class VistaLibreria extends JFrame {
    // Botones Centros
    protected JLabel lblCentros;
    protected JButton btnAddCentro;
    protected JButton btnDeleteCentro;
    protected JButton btnEditCentro;
    protected JButton btnContarCentros;
    protected JButton btnInfoCentros;
    protected JButton btnLoadCentros;
    // Botones Categorias
    protected JLabel lblCates;
    protected JButton btnAddCate;
    protected JButton btnDeleteCate;
    protected JButton btnEditCate;
    protected JButton btnContarCates;
    protected JButton btnInfoCates;
    protected JButton btnLoadCates;
    // Botones Productos
    protected JLabel lblProductos;
    protected JButton btnAddProducto;
    protected JButton btnDeleteProducto;
    protected JButton btnEditProducto;
    protected JButton btnContarProductos;
    protected JButton btnInfoProductos;
    protected JButton btnLoadProductos;
    //
    public VistaLibreria(String title) {
            super(title); // Barra de tï¿½tulo
            // Instanciacion de los botones
            lblCentros=new JLabel("Centros");
            btnAddCentro=new JButton("Añadir centro");
            btnDeleteCentro=new JButton("Eliminar centro");
            btnEditCentro=new JButton("Editar centro");
            btnContarCentros=new JButton("Cuenta centros");
            btnInfoCentros=new JButton("Info de centros");
            btnLoadCentros=new JButton("Cargar centros");
            // Botones Categorias
            lblCates=new JLabel("Categorias");
            btnAddCate=new JButton("Añadir categoria");
            btnDeleteCate=new JButton("Eliminar categoria");
            btnEditCate=new JButton("Editar categoria");
            btnContarCates=new JButton("Cuenta categorias");
            btnInfoCates=new JButton("Info de categorias");
            btnLoadCates=new JButton("Cargar categorias");
            // Botones Productos
            lblProductos=new JLabel("Productos");
            btnAddProducto=new JButton("Añadir producto");
            btnDeleteProducto=new JButton("Eliminar producto");
            btnEditProducto=new JButton("Editar producto");
            btnContarProductos=new JButton("Cuenta productos");
            btnInfoProductos=new JButton("Info de productos");
            btnLoadProductos=new JButton("Cargar productos");
            // Crear el panel
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(8,3)); // 5 renglones 2 x columnas
            // espacios entre bordes
            Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
            // Agregar los componenrtes en el grid en el orden en que deben aparecer
            p.setBorder(gap);
            p.add(lblCentros);
            p.add(lblCates);
            p.add(lblProductos);
            p.add(btnAddCentro);
            p.add(btnAddCate);
            p.add(btnAddProducto);
            p.add(btnDeleteCentro);
            p.add(btnDeleteCate);
            p.add(btnDeleteProducto);
            p.add(btnEditCentro);
            p.add(btnEditCate);
            p.add(btnEditProducto);
            p.add(btnContarCentros);
            p.add(btnContarCates);
            p.add(btnContarProductos);
            p.add(btnInfoCentros);
            p.add(btnInfoCates);
            p.add(btnInfoProductos);
            p.add(btnLoadCentros);
            p.add(btnLoadCates);
            p.add(btnLoadProductos);
            //Aï¿½adir al jframe
            add(p);
            // Posicion de la ventana
            setBounds(0,0,600,400); // top, left, width, height
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
    }
    
}