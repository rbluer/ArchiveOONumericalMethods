package book.dhb.numericalmethods.optimizing;

import book.dhb.numericalmethods.interfaces.ManyVariableFunction;
import book.dhb.numericalmethods.interfaces.OneVariableFunction;
import book.dhb.numericalmethods.matrixalgebra.DhbVector;
/**
 * Factory of point/vector &amp; function holders for optimizing functions.
 *
 * @author Didier H. Besset
 */
public abstract class OptimizingPointFactory {
	/**
	 * Constructor method.
	 */
	public OptimizingPointFactory() {
	    super();
	}
	/**
	 * @return DhbOptimizing.OptimizingPoint
	 * @param x double
	 * @param f OneVariableFunction
	 */
	public abstract OptimizingPoint createPoint( double x,
	                                            OneVariableFunction f);
	/**
	 * @return DhbOptimizing.OptimizingVector
	 * @param v double[]
	 * @param f ManyVariableFunction
	 */
	public abstract OptimizingVector createVector( double[] v,
	                                            ManyVariableFunction f);
	/**
	 * @return DhbOptimizing.OptimizingVector
	 * @param v DhbVector
	 * @param f ManyVariableFunction
	 */
	public OptimizingVector createVector( DhbVector v,
	                                ManyVariableFunction f)
	{
	    return createVector( v.toComponents(), f);
	}
}
