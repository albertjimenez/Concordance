package lineales;

public class ColaIntEnla {

	private NodoInt primero;
	// TODO hacer ultimo?
	private int talla;

	public ColaIntEnla() {
		this.primero = null;
		this.talla = 0;
	}

	public boolean esVacia() {
		return talla == 0;
	}

	public void encolar(int num) {
		switch (talla) {
		case 0:
			primero = new NodoInt(num, null);
			break;

		case 1:
			primero.siguiente = new NodoInt(num);
			break;
		default:

			NodoInt aux;
			for (aux = primero; aux.siguiente != null; aux = aux.siguiente)
				;

			aux.siguiente = new NodoInt(num);

			break;
		}
		talla++;

	}

	public int primero() {
		return esVacia() ? 0 : primero.dato;
	}

	public int desencolar() {
		if (esVacia())
			return 0;
		int elemento = primero.dato;

		if (primero.siguiente != null)
			primero = primero.siguiente;
		else
			primero = null;
		talla--;
		return elemento;
	}

	public int talla() {
		return talla;
	}

	@Override
	public String toString() {
		String cadena = "[";
		final String delimitador = ", ";
		switch (talla) {
		case 0:
			return "[]";
		case 1:
			return "[" + primero.dato + "]";
		default:
			NodoInt aux = primero;
			while (aux.siguiente != null) {
				cadena += aux.dato + delimitador;
				aux = aux.siguiente;
			}

			cadena += aux.dato + "]";
			return cadena;
		}
	}

}
