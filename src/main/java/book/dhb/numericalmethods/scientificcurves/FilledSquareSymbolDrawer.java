package book.dhb.numericalmethods.scientificcurves;


import java.awt.Graphics;
/**
 * Class used to draw squares as point symbol in curves.
 * 
 */
public class FilledSquareSymbolDrawer extends AbstractSymbolDrawer
{

	/**
	 * Symbol plotting method.
	 * @param g Graphics graphics context used to perform the drawing.
	 * @param x int Position x position of symbol
	 * @param y int Position y position of symbol
	 * @param size int Size of symbol
	 */
	public void plotSymbol ( Graphics g, int x, int y, int size)
	{
		g.fillRect( x - size / 2, y - size / 2, size, size);
	}
}
