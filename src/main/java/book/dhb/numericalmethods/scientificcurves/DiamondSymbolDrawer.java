package book.dhb.numericalmethods.scientificcurves;


import java.awt.Polygon;
/**
 * Class used to draw diamonds as point symbol in curves.
 * 
 */
public class DiamondSymbolDrawer extends AbstractSymbolDrawer
{

	/**
	 * Symbol plotting method.
	 * @param g java.awt.Graphics graphics context used to perform the drawing.
	 * @param x int Position x position of symbol
	 * @param y int Position y position of symbol
	 * @param size int Size of symbol
	 */
	public void plotSymbol(java.awt.Graphics g, int x, int y, int size)
	{
		int h = size / 2;
		Polygon p = new Polygon();
		p.addPoint( x, y - h);
		p.addPoint( x - h, y);
		p.addPoint( x, y + h);
		p.addPoint( x + h, y);
		p.addPoint( x, y - h);
		g.drawPolygon( p);
	}
}
