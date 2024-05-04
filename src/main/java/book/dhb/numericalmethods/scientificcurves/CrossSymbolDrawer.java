package book.dhb.numericalmethods.scientificcurves;

/**
 * Class used to draw crosses as point symbol in curves.
 * 
 */
public class CrossSymbolDrawer extends AbstractSymbolDrawer
{

	/**
	 * Symbol ploting method.
	 * @param g java.awt.Graphics graphics context used to perform the drawing.
	 * @param x int Position x position of symbol
	 * @param y int Position y position of symbol
	 * @param symbolSize int Size of symbol
	 */
	public void plotSymbol(java.awt.Graphics g, int x, int y, int symbolSize)
	{
		g.drawLine( x, y - symbolSize / 2, x, y + symbolSize / 2);
		g.drawLine( x - symbolSize / 2, y, x + symbolSize / 2, y);
	}
}
