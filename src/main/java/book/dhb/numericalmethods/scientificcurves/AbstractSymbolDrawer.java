package book.dhb.numericalmethods.scientificcurves;


import java.awt.Graphics;
/**
 * The subclasses of this class are used to draw curve symbols.
 * 
 */
abstract class AbstractSymbolDrawer
{

	/**
	 * Symbol plotting method.
	 * @param g Graphics graphics context used to perform the drawing.
	 * @param x int Position x position of symbol
	 * @param y int Position y position of symbol
	 * @param size int Size of symbol
	 */
	public abstract void plotSymbol ( Graphics g, int x, int y, int size);
}
