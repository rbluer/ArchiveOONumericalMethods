package book.dhb.numericalmethods.interfaces;

import book.dhb.numericalmethods.scientificcurves.CurveDefinition;
import book.dhb.numericalmethods.scientificcurves.Scatterplot;

/**
 * A CurveMouseClickListener defines an interface to handle mouse click
 * performed on a scatterplot and passed to a curve definition.
 * @see Scatterplot
 * @see CurveDefinition
 *
 *
 * @version 1.0 23 Jul 1998
 * @author Didier H. Besset
 */
public interface CurveMouseClickListener
{


	/**
	 * Processes the mouse clicks received from the scatterplot.
	 * If a mouse listener has been defined, each point is tested for mouse click.
	 * If the mouse click falls within the symbol size of a point, the index of
	 * that point is passed to the mouse listener, along with the defined parameter.
	 * 
	 * @param index int index of the curve point on which the mouse was clicked.
	 * @param param Object the curve identifier.
	 * @return boolean
	 */
	public boolean handleMouseClick( int index, Object param);
}
