package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lineales.Concordancia;

public class Concor {

	private static Concordancia concordancia;
	final static String separadores = "[\\p{Space}\\p{Punct}\\p{Digit}¡¿]";
	private static String nombreFichero = "";

	public static void main(String[] args) {

		if (args.length > 2) {
			System.out.println("Se esperaban solo dos argumentos");
			System.exit(0);
		}
		switch (args.length) {
		case 1:
			if (args[0].equals("-o"))
				lecturaEstandar(true);
			else {
				lecturaFicheroO(false);
				nombreFichero = args[0];
			}
			break;

		case 2:
			lecturaFicheroO(true);
			nombreFichero = args[1];
			break;

		default:
			lecturaEstandar(false);
			break;
		}

	}

	/**
	 * Metodo privado para realizar la lectura por teclado
	 * 
	 * @param hayOrden
	 *            cierto si el parametro de entrada es "-o" falso si no hay
	 *            orden
	 */
	private static void lecturaEstandar(boolean hayOrden) {
		System.out.print("Escribe aqui el texto: ");
		Scanner ent = new Scanner(System.in);
		concordancia = new Concordancia();
		String line = "";
		while (ent.hasNext()) {
			String lineaAux = ent.nextLine().trim();
			if (lineaAux.equals("."))
				break;
			line += lineaAux + "\n";
		}

		String aux[] = line.split(separadores);

		if (!hayOrden)
			for (int i = 0; i < aux.length; i++)
				concordancia.insertar(aux[i], 1);
		else
			for (int i = 0; i < aux.length; i++)
				concordancia.insOrd(aux[i], 1);

		System.out.println(concordancia);
		ent.close();
	}

	/**
	 * Metodo privado para realizar la lectura de un fichero
	 * 
	 * @param hayOrden
	 *            cierto si el parametro de entrada es "-o" falso si no hay
	 *            orden
	 */

	private static void lecturaFicheroO(boolean hayOrden) {
		Scanner ent = null;
		concordancia = new Concordancia();
		try {
			ent = new Scanner(new File(nombreFichero));
			int numLinea = 1;
			while (ent.hasNext()) {
				String linea = ent.nextLine().trim();
				String aux[] = linea.split(separadores);
				if (!hayOrden)
					for (int i = 0; i < aux.length; i++)
						concordancia.insertar(aux[i], numLinea);
				else
					for (int i = 0; i < aux.length; i++)
						concordancia.insOrd(aux[i], numLinea);

				numLinea++;
			}
		} catch (FileNotFoundException e) {
			ent = new Scanner(System.in);
			System.out.println("Error con el fichero, no existe");
		} finally {
			System.out.println(concordancia);
			ent.close();
		}
	}

}
