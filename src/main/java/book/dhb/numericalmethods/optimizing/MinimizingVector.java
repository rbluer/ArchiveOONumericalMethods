package book.dhb.numericalmethods.optimizing;

import book.dhb.numericalmethods.interfaces.ManyVariableFunction;

/**
 * Vector & function holder used in minimizing many-variable functions.
 *
 * @author Didier H. Besset
 */
public class MinimizingVector extends OptimizingVector {
	/**
	 * Constructor method.
	 * @param v double[]
	 * @param f DhbInterfaces.ManyVariableFunction
	 */
	public MinimizingVector(double[] v, ManyVariableFunction f) {
	    super(v, f);
	}
	/**
	 * @return boolean    true if the receiver is "better" than
	 *                                                the supplied point
	 * @param point OptimizingVector
	 */
	public boolean betterThan(OptimizingVector point)
	{
	    return getValue() < point.getValue();
	}
	/**
	 * (used by method toString).
	 * @return java.lang.String
	 */
	protected final String printedKey()
	{
	    return " min@";
	}
}
