/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.diplomado.libreria.view;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author guillermo
 */
public class VistaAddCentro extends JDialog {
    // Labels
    protected JLabel lblDatos;
    protected JLabel lblEmpty;
    protected JLabel lblId;
    protected JLabel lblNombre;
    protected JLabel lblDireccion;
    protected JLabel lblStatus;
    protected JLabel lblEmpty2;
    // Cuadros de Texo
    protected JTextField txtId;
    protected JTextField txtNombre;
    protected JTextField txtDireccion;
    protected JTextField txtStatus;
    //Botones
    protected JButton btnClose;

    public VistaAddCentro(){
        //super("Añadir nuevo centro"); // Barra de tï¿½tulo
        // Instanciacion de las cosas
        // Labels
        lblDatos=new JLabel("Escribe los datos del nuevo centro:");
        lblEmpty=new JLabel();
        lblId=new JLabel("ID: ");
        lblNombre=new JLabel("Nombre del centro: ");
        lblDireccion=new JLabel("Dirección: ");
        lblStatus=new JLabel("Status: ");
        lblEmpty2=new JLabel();
        // Cuadros de Texo
        txtId=new JTextField(10);
        txtNombre=new JTextField(20);
        txtDireccion=new JTextField(30);
        txtStatus=new JTextField(10);
        //Botones
        btnClose=new JButton("Listo");

        // Crear el panel
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6,3)); // 5 renglones 2 x columnas
        // espacios entre bordes
        Border gap = BorderFactory.createEmptyBorder(10,10,10,10);
        // Agregar los componenrtes en el grid en el orden en que deben aparecer
        p.setBorder(gap);
        p.add(lblDatos);
        p.add(lblEmpty);
        p.add(lblId);
        p.add(txtId);
        p.add(lblNombre);
        p.add(txtNombre);
        p.add(lblDireccion);
        p.add(txtDireccion);
        p.add(lblStatus);
        p.add(txtStatus);
        p.add(lblEmpty2);
        p.add(btnClose);
        //Aï¿½adir al jframe
        add(p);
        // Posicion de la ventana
        setBounds(0,0,600,200); // top, left, width, height
        setTitle("Añadir nuevo centro");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
    }
}
