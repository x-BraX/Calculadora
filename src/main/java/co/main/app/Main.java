package co.main.app;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import co.dominio.app.Calculadora;

public class Main {
	public static ArrayList<Double> numeros=new ArrayList<Double>();

	public static void main(String[] args) {
		while(true) {
			JCheckBox redondear= new JCheckBox("Redondear");
			ImageIcon icono=new ImageIcon(Calculadora.class.getResource("icono.png"));
			int operacion= JOptionPane.showOptionDialog(null, "     Bienvenido a la Calculadora,  ¿Que quieres hacer?", "Calculadora", 0,JOptionPane.PLAIN_MESSAGE, icono, new Object[] {"Sumar","Restar","Multiplicar","Dividir",redondear},"Sumar");
			switch (operacion) {
			case 0:
				recibirNumeros();
				if(redondear.isEnabled()) {
					mostrarMensaje(Math.floor(Calculadora.sumar(numeros)));
				}else {
					mostrarMensaje(Calculadora.sumar(numeros));
				}
				break;

			case 1:
				recibirNumeros();
				if(redondear.isEnabled()) {
					mostrarMensaje(Math.floor(Calculadora.restar(numeros)));
				}else {
					mostrarMensaje(Calculadora.restar(numeros));
				}
				break;
				
			case 2:
				recibirNumeros();
				if(redondear.isEnabled()) {
					mostrarMensaje(Math.floor(Calculadora.multiplicar(numeros)));
				}else {
					mostrarMensaje(Calculadora.multiplicar(numeros));
				}
				break;
				
			case 3:
				int num1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
				int num2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));			
				if(redondear.isEnabled()) {
					mostrarMensaje(Math.floor(Calculadora.dividir(num1,num2)));
				}else {
					mostrarMensaje(Calculadora.dividir(num1, num2));
				}
				break;
				
			default:
				break;
			}
			
			if(operacion==JOptionPane.CLOSED_OPTION) {
				break;
			}
		}
	}
	
	public static void mostrarCuadrodeDialogo() {
		String num=JOptionPane.showInputDialog("Ingrese un numero");	
		String condicion=""; 
		if(num.equals(condicion)) {
			while(num.equals(condicion)) {
				num=JOptionPane.showInputDialog("Ingrese un numero","Debes ingresar algun numero");
				condicion="Debes ingresar algun numero";
			}			
		}else {
			double numero=Double.parseDouble(num);
			numeros.add(numero);
		}		
	}
	
	public static int cuadroContinuar() {
		int confirmacion=JOptionPane.showConfirmDialog(null, "¿Desea agregar mas numeros?", "", JOptionPane.YES_NO_OPTION);
		int si_no=0;
		switch (confirmacion) {
		case JOptionPane.YES_OPTION:
			si_no=1;
			break;
		default:
			break;
		}
		return si_no;
	}
	
	public static void mostrarMensaje(double dato) {
		JOptionPane.showMessageDialog(null, dato, "Resultado", JOptionPane.INFORMATION_MESSAGE, null);
	}
	
	public static void recibirNumeros() {
		int si_no;

		mostrarCuadrodeDialogo();
		mostrarCuadrodeDialogo();
		si_no=cuadroContinuar();
		if(si_no==1) {
			mostrarCuadrodeDialogo();
			si_no=cuadroContinuar();
		}	
	}

}
