package book.dhb.numericalmethods.scientificcurves;


import java.awt.Polygon;
/**
 * Class used to draw down triangles as point symbol in curves.
 * 
 */
public class DownTriangleSymbolDrawer extends AbstractSymbolDrawer
{

	/**
	 * Symbol ploting method.
	 * @param g graphics context used to perform the drawing.
	 * @param xPosition x position of symbol
	 * @param yPosition y position of symbol
	 * @param size of symbol
	 */
	public void plotSymbol(java.awt.Graphics g, int x, int y, int size)
	{
		int h = size / 3;
		Polygon p = new Polygon();
		p.addPoint( x, y + h * 2);
		p.addPoint( x - h, y - h);
		p.addPoint( x + h, y - h);
		p.addPoint( x, y + h * 2);
		g.drawPolygon( p);
	}
}
