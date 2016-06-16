package lineales;

public class Concordancia {

	private NodoCnc primero;
	private int talla;

	/**
	 * Constructor que inicializa los atributos a sus valores por defecto
	 */

	public Concordancia() {
		primero = null;
		talla = 0;
	}

	/**
	 * Metodo para insertar elementos NO ordenados en la LISTA de NodosCNC
	 * 
	 * @param pal
	 *            Palabra a buscar o insertar en funcion de si existe o no
	 * @param numLin
	 *            Numero de linea en la que se encuentra para ser encolada
	 */

	public void insertar(String pal, int numLin) {
		if (!pal.equals("")) {
			switch (talla) {
			case 0:
				primero = new NodoCnc(pal, numLin, null);
				talla++;
				break;

			case 1:
				if (!primero.pal.equals(pal)) {
					primero.siguiente = new NodoCnc(pal, numLin);
					talla++;
				} else
					primero.numLins.encolar(numLin);

				break;

			default:
				NodoCnc aux;
				boolean encontrado = false;
				for (aux = primero; aux.siguiente != null; aux = aux.siguiente) {
					if (aux.siguiente.pal.equals(pal)) {
						encontrado = true;
						break;
					}
				}
				if (encontrado)
					aux.siguiente.numLins.encolar(numLin);
				else {
					aux.siguiente = new NodoCnc(pal, numLin);
					talla++;
				}
				break;
			}
		}
	}

	/**
	 * Metodo para insertar en la LISTA de nodosNCN lexicograficamente
	 * 
	 * @param pal
	 *            Palabra a insertar, revisa si no existe y la inserta o encola
	 *            en caso de existir
	 * @param numLin
	 *            Numero de linea en la que se encuentra dicha palabra
	 */

	public void insOrd(String pal, int numLin) {

		if (!pal.equals("")) {
			int c = 0;
			boolean existe = buscarCadena(pal);
			int posicion = buscarPosicion(pal);
			switch (posicion) {

			case 0:
				NodoCnc n = new NodoCnc(pal, numLin);
				if (!existe) {
					n.siguiente = primero;
					primero = n;
					talla++;
				} else
					primero.numLins.encolar(numLin);

				break;

			default:
				NodoCnc nuevo = new NodoCnc(pal, numLin);
				NodoCnc aux = primero;

				while (c < posicion - 1) {
					aux = aux.siguiente;
					c++;
				}
				if (!existe) {
					if (nuevo.siguiente != null)
						insertar(pal, numLin);
					else {
						nuevo.siguiente = aux.siguiente;
						aux.siguiente = nuevo;
						talla++;
					}
				} else
					aux.siguiente.numLins.encolar(numLin);

				break;
			}
		}

	}

	/**
	 * Metodo privado usado para encontrar y devolver la posicion de una palabra
	 * lexicograficamente
	 * 
	 * @param pal
	 *            Palabra a buscar
	 * @return numero de posicion
	 */

	private int buscarPosicion(String pal) {

		switch (talla) {
		case 0:
			return 0;

		default:
			int contador = 0;

			NodoCnc aux = primero;
			while (aux != null && aux.pal.compareTo(pal) < 0) {
				aux = aux.siguiente;
				contador++;
			}
			return contador;

		}

	}

	/**
	 * Metodo privado para buscar la palabra, devolviendo cierto o falso segun
	 * si exista o no
	 * 
	 * @param pal
	 *            Palabra a buscar
	 * @return Cierto o falso segun si existe o no
	 */

	private boolean buscarCadena(String pal) {
		switch (talla) {
		case 0:

			return false;

		case 1:
			return primero.pal.equals(pal);

		default:
			NodoCnc aux;
			for (aux = primero; aux != null; aux = aux.siguiente)
				if (aux.pal.equals(pal))
					return true;
			return false;
		}
	}

	@Override
	public String toString() {
		String c = "";
		switch (talla) {
		case 0:

			return "()";
		case 1:
			return primero.pal + "(" + primero.numLins.talla() + ") ->" + primero.numLins.toString();

		default:

			NodoCnc aux = primero;
			while (aux != null) {
				c += aux.pal + "(" + aux.numLins.talla() + ") ->" + aux.numLins.toString() + "\n";
				aux = aux.siguiente;
			}
			return c;
		}
	}

}
