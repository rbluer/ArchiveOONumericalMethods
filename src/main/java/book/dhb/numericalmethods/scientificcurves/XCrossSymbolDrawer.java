package book.dhb.numericalmethods.scientificcurves;

/**
 * Class used to draw crosses as point symbol in curves.
 * 
 */
public class XCrossSymbolDrawer extends AbstractSymbolDrawer
{

	/**
	 * Symbol plotting method.
	 * @param g java.awt.Graphics context used to perform the drawing.
	 * @param x int Position x position of symbol
	 * @param y int Position y position of symbol
	 * @param size int Size of symbol
	 */
	public void plotSymbol(java.awt.Graphics g, int x, int y, int size)
	{
		g.drawLine( x - size / 2, y - size / 2, x + size / 2, y + size / 2);
		g.drawLine( x - size / 2, y + size / 2, x + size / 2, y - size / 2);
	}
}
