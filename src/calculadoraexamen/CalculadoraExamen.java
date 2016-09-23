/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraexamen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Irene
 */
public class CalculadoraExamen extends JFrame {
        JTextField pantalla;

	/** guarda el resultado de la operacion anterior o el número tecleado */
	double resultado;

	/** para guardar la operacion a realizar */
	String operacion;

	/** Los paneles donde colocaremos los botones */
	JPanel panelNumeros, panelOperaciones;

    
    public CalculadoraExamen()
    {
    
        super();
        setSize(350, 400);
	setTitle("Calculadora Examen");
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setResizable(false);
    
    JPanel panel = (JPanel) this.getContentPane();
    panel.setLayout(new BorderLayout());
    

		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		pantalla.setBackground(Color.WHITE);
		panel.add("North", pantalla);

		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

		for (int n = 9; n >= 0; n--) {
			BotonNum("" + n); /*le da valor a cada boton*/
		}

		BotonNum(".");

		panel.add("Center", panelNumeros);
                
                panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(2,1));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

		botonOperacion("CE");
		botonOperacion("Convertir");

		panel.add("East", panelOperaciones);

		validate();

    }

private void BotonNum(String digito) {
		JButton btn = new JButton();
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() {

			@Override
		public void mouseReleased(MouseEvent evt) {
		JButton btn = (JButton) evt.getSource();
		numeroPulsado(btn.getText());
			}
		});

		panelNumeros.add(btn);
	}

private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0")) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		
	
}

private void botonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
		btn.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseReleased(MouseEvent evt) {
		JButton btn = (JButton) evt.getSource();
		operaciones(btn.getText());
			}
		}
              );

		panelOperaciones.add(btn);
	}

private void operaciones(String tecla) {
		if (tecla.equals("Convertir")) {
                     resultado=new Double(pantalla.getText()) / 19;
                     pantalla.setText("" + resultado);
		} else if (tecla.equals("CE")) {
			resultado = 0;
			pantalla.setText("");
			
		} 
	}

     
    /**
     * @param args the command line arguments
     */
 
}
