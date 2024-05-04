package book.dhb.numericalmethods.optimizing;

import book.dhb.numericalmethods.interfaces.OneVariableFunction;
/**
 * Point &amp; function holder used in maximizing one-variable functions.
 *
 * @author Didier H. Besset
 */
public class MaximizingPoint extends OptimizingPoint {
	/**
	 * Constructor method.
	 * @param x double
	 * @param f book.dhb.numericalmethods.interfaces.OneVariableFunction
	 */
	public MaximizingPoint(double x, OneVariableFunction f)
	{
	    super(x, f);
	}
	/**
	 * @return boolean    true if the receiver is "better" than 
	 *                                                 the supplied point
	 * @param point OptimizingPoint
	 */
	public boolean betterThan(OptimizingPoint point)
	{
	    return getValue() > point.getValue();
	}
	/**
	 * (used by method toString).
	 * @return java.lang.String
	 */
	protected final String printedKey()
	{
	    return " max@";
	}
}
