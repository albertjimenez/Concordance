package lineales;

/** Nodo entero. */
class NodoInt {

	int dato;
	NodoInt siguiente;

	/** Crea un nodo con el entero 'd'. */
	NodoInt(int d) {
		dato = d;
	}

	/** Crea un nodo con el entero 'd' y apuntando al nodo 's'. */
	NodoInt(int d, NodoInt s) {
		dato = d;
		siguiente = s;
	}

} // NodoInt
