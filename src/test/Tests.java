package test;

import org.junit.Assert;
import org.junit.Test;

import lineales.ColaIntEnla;
import lineales.Concordancia;

public class Tests {

	@Test
	public void testCola() {
		ColaIntEnla miCola = new ColaIntEnla();
		// comprobamos que sea 0;
		Assert.assertEquals(0, miCola.talla(), 0);

		// Comprobamos si esta vacia
		Assert.assertEquals("[]", miCola.toString());
		Assert.assertEquals(true, miCola.esVacia());
		Assert.assertEquals(0, miCola.primero(), 0);
		System.out.println("Cola " + miCola.toString());

		miCola.encolar(2);
		Assert.assertEquals(1, miCola.talla(), 0);
		Assert.assertEquals("[2]", miCola.toString());
		Assert.assertEquals(2, miCola.primero(), 0);
		System.out.println("Cola " + miCola.toString());

		miCola.encolar(31);
		Assert.assertEquals(2, miCola.talla(), 0);
		Assert.assertEquals(2, miCola.primero(), 0);
		Assert.assertEquals("[2, 31]", miCola.toString());
		System.out.println("Cola " + miCola.toString());

		miCola.encolar(4);
		Assert.assertEquals(3, miCola.talla(), 0);
		Assert.assertEquals(false, miCola.esVacia());
		System.out.println("Cola " + miCola.toString());

		miCola.encolar(4);
		System.out.println("Cola " + miCola.toString());
		Assert.assertEquals(4, miCola.talla(), 0);
		Assert.assertEquals("[2, 31, 4, 4]", miCola.toString());

		miCola.encolar(21);
		System.out.println("Cola " + miCola.toString());
		Assert.assertEquals(5, miCola.talla(), 0);
		Assert.assertEquals("[2, 31, 4, 4, 21]", miCola.toString());
		Assert.assertEquals(2, miCola.primero(), 0);

		// Desencolando
		System.out.println("\n\tDesencolando\n");
		Assert.assertEquals(2, miCola.desencolar(), 0);
		Assert.assertEquals(4, miCola.talla(), 0);
		System.out.println("Cola " + miCola.toString());

		Assert.assertEquals(31, miCola.desencolar(), 0);
		Assert.assertEquals(3, miCola.talla(), 0);
		System.out.println("Cola " + miCola.toString());

		while (!miCola.esVacia()) {
			System.out.println("Cola " + miCola.toString());
			miCola.desencolar();
		}

	}

	@Test
	public void testInsercionConcordancia() {
		Concordancia con = new Concordancia();
		con.insertar("Un", 0);
		Assert.assertEquals("Un(1) ->[0]", con.toString());
		con.insertar("Un", 1);
		Assert.assertEquals("Un(2) ->[0, 1]", con.toString());
		con.insertar("Una", 3);
		String c = "Un(2) ->[0, 1]" + "\n" + "Una(1) ->[3]" + "\n";
		Assert.assertEquals(c, con.toString());
	}

	@Test
	public void testInsercionOrdenadaConcordancia() {
		Concordancia con = new Concordancia();
		con.insOrd("Hola", 0);
		con.insOrd("Hola", 1);
		con.insOrd("Hola", 1);
		con.insOrd("X", 4);
		con.insOrd("Af", 3);
		String c = "Af(1) ->[3]" + "\n" + "Hola(3) ->[0, 1, 1]" + "\n" + "X(1) ->[4]" + "\n";
		Assert.assertEquals(c, con.toString());
	}

}
