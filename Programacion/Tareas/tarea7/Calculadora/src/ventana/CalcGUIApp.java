/**
 * @author Nelson Blanco Charro
 * @date 20/02/2022
 * @description: Realizacion de la calculadora de la tarea 7 de Programacion con WindowBuilder
 * @comentario: la logica puede hacerse mejor utilizando arrays, objetos, etc. o incluso separandola en distintos paquetes.
 * Pero lo que se busca en esta tarea es centrarse en una aproximacion al diseño de interfaces en Java con WindowBuilder
*/

package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CalcGUIApp extends JFrame {

	/**
	 * COMPONENTES
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField textResultado;
	/**
	 * ATRIBUTOS
	 */
	private String numeroActual = "0";
	private String operacion = "";
	private double numGuardado;
	private JTextField txtDisenadoPor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcGUIApp frame = new CalcGUIApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalcGUIApp() {
		setResizable(false);
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		/**
		 * CONTENEDOR DE LOS BOTONES
		 */
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.window);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.window);
		panelBotones.setBounds(12, 12, 316, 130);
		panelPrincipal.add(panelBotones);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton boton0 = new JButton("0");
		boton0.setToolTipText("Número 0");
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("0");
			}
		});
		boton0.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton0);

		JButton boton1 = new JButton("1");
		boton1.setToolTipText("Número 1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("1");
			}
		});
		boton1.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton1);

		JButton boton2 = new JButton("2");
		boton2.setToolTipText("Número 2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("2");
			}
		});
		boton2.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton2);

		JButton boton3 = new JButton("3");
		boton3.setToolTipText("Número 3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("3");
			}
		});
		boton3.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton3);

		JButton boton4 = new JButton("4");
		boton4.setToolTipText("Número 4");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("4");
			}
		});
		boton4.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton4);

		JButton boton5 = new JButton("5");
		boton5.setToolTipText("Número 5");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("5");
			}
		});
		boton5.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton5);

		JButton boton6 = new JButton("6");
		boton6.setToolTipText("Número 6");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("6");
			}
		});
		boton6.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton6);

		JButton boton7 = new JButton("7");
		boton7.setToolTipText("Número 7");
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("7");
			}
		});
		boton7.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton7);

		JButton boton8 = new JButton("8");
		boton8.setToolTipText("Número 8");
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("8");
			}
		});
		boton8.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton8);

		JButton boton9 = new JButton("9");
		boton9.setToolTipText("Número 9");
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerNumeros("9");
			}
		});
		boton9.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(boton9);

		JButton botonSuma = new JButton("+");
		botonSuma.setToolTipText("Sumar");
		botonSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = "suma";
				operacionNumeros();
			}
		});
		botonSuma.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(botonSuma);

		JButton botonResta = new JButton("-");
		botonResta.setToolTipText("Restar");
		botonResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = "resta";
				operacionNumeros();
			}
		});
		botonResta.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(botonResta);

		JButton botonMulti = new JButton("x");
		botonMulti.setToolTipText("Multiplicar");
		botonMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = "multiplicacion";
				operacionNumeros();
			}
		});
		botonMulti.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(botonMulti);

		JButton botonDiv = new JButton("/");
		botonDiv.setToolTipText("Dividir");
		botonDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = "division";
				operacionNumeros();
			}
		});
		botonDiv.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(botonDiv);

		JButton botonIgual = new JButton("=");
		botonIgual.setToolTipText("Igual");
		botonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (numGuardado == 0 || operacion.equals("") || numeroActual.equals("")) {
					return;
				}
				if (operacion.equals("suma")) {
					numGuardado = numGuardado + Integer.parseInt(numeroActual);
				}
				;
				if (operacion.equals("resta")) {
					numGuardado = numGuardado - Integer.parseInt(numeroActual);
				}
				;
				if (operacion.equals("multiplicacion")) {
					numGuardado = numGuardado * Integer.parseInt(numeroActual);
				}
				;
				if (operacion.equals("division")) {
					numGuardado = numGuardado / Integer.parseInt(numeroActual);
				}
				;
				textResultado.setText(Double.toString(numGuardado));
				numeroActual = "";
			}
		});
		botonIgual.setPreferredSize(new Dimension(55, 25));
		panelBotones.add(botonIgual);

		JButton botonReset = new JButton("Reset");
		botonReset.setToolTipText("Reiniciar");
		botonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = "";
				numeroActual = "0";
				numGuardado = 0;
				textResultado.setText(numeroActual);
			}
		});
		panelBotones.add(botonReset);

		/**
		 * CONTENEDOR RESULTADO
		 */
		JPanel panelResultado = new JPanel();
		panelResultado.setBackground(SystemColor.window);
		panelResultado.setBounds(12, 201, 316, 50);
		panelPrincipal.add(panelResultado);
		panelResultado.setLayout(new BorderLayout(0, 0));
		textResultado = new JTextField();
		textResultado.setToolTipText("Resultado");
		textResultado.setFont(new Font("Dialog", Font.BOLD, 16));
		textResultado.setBackground(Color.WHITE);
		textResultado.setEditable(false);
		textResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		panelResultado.add(textResultado);
		textResultado.setColumns(10);
		textResultado.setText(numeroActual);
		txtDisenadoPor = new JTextField();
		txtDisenadoPor.setBorder(null);
		txtDisenadoPor.setBounds(57, 140, 271, 50);
		panelPrincipal.add(txtDisenadoPor);
		txtDisenadoPor.setEditable(false);
		txtDisenadoPor.setBackground(SystemColor.window);
		txtDisenadoPor.setFont(new Font("FreeMono", Font.BOLD | Font.ITALIC, 14));
		txtDisenadoPor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisenadoPor.setText("Diseñado por Nelson Blanco Charro");
		txtDisenadoPor.setColumns(10);
		
		JLabel icono = new JLabel("");
		icono.setBounds(12, 151, 52, 38);
		panelPrincipal.add(icono);
		icono.setHorizontalAlignment(SwingConstants.CENTER);
		icono.setBackground(SystemColor.window);
		icono.setIcon(new ImageIcon("/home/nelson/EclipseProjects/Calculadora/src/ventana/icono.png"));

	}

	/**
	 * CONTENEDOR DE METODOS
	 */
	// Metodo para la lectura de los numeros
	private void leerNumeros(String numero) {
		if (numeroActual.equals("0") || numeroActual.equals("")) {
			numeroActual = numero;
		} else {
			numeroActual = numeroActual + numero;
		}
		;
		textResultado.setText(numeroActual);
	};

	// Metodo para la realizacion de las operaciones
	private void operacionNumeros() {
		try {
			// Si no hay ningun numero introducido, el programa no hace nada
			if (numeroActual.equals("0") && numGuardado == 0) {
				return;
			}
			// Dependiendo de la operacion seleccionada, y de si es el primer o segundo
			// numero, el programa hara distintas cosas
			if (!numeroActual.equals("")) {
				switch (operacion) {
				case "suma":
					numGuardado = numGuardado + Integer.parseInt(numeroActual);
					textResultado.setText(numGuardado + " +");
					break;
				case "resta":
					numGuardado = numGuardado - Integer.parseInt(numeroActual);
					textResultado.setText(numGuardado + " -");
					break;
				case "multiplicacion":
					numGuardado = numGuardado * Integer.parseInt(numeroActual);
					if (numGuardado == 0) {
						textResultado.setText(numeroActual + " x");
					} else {
						textResultado.setText(numGuardado + " x");
					}
					;
					break;
				case "division":
					numGuardado = numGuardado / Integer.parseInt(numeroActual);
					if (numGuardado == 0) {
						textResultado.setText(numeroActual + " /");
					} else {
						textResultado.setText(numGuardado + " /");
					}
					;
					break;
				}
			}
			if (numeroActual.equals("")) {
				textResultado.setText(Double.toString(numGuardado));
				switch (operacion) {
				case "suma":
					textResultado.setText(numGuardado + " +");
					break;
				case "resta":
					textResultado.setText(numGuardado + " -");
					break;
				case "multiplicacion":
					textResultado.setText(numGuardado + " x");
					break;
				case "division":
					textResultado.setText(numGuardado + " /");
					break;
				}
			} else {
				numGuardado = Integer.parseInt(numeroActual);
			}
			;
			numeroActual = "";
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
