package book.dhb.numericalmethods.optimizing;

import book.dhb.numericalmethods.interfaces.ManyVariableFunction;
import book.dhb.numericalmethods.interfaces.OneVariableFunction;

/**
 * Factory of point/vector & function holders for minimizing functions.
 *
 * @author Didier H. Besset
 */
public class MinimizingPointFactory extends OptimizingPointFactory
{
/**
 * Constructor method.
 */
public MinimizingPointFactory() {
    super();
}
/**
 * @return OptimizingPoint    an minimizing point strategy.
 */
public OptimizingPoint createPoint(double x, OneVariableFunction f)
{
    return new MinimizingPoint( x, f);
}
/**
 * @return OptimizingVector    an minimizing vector strategy.
 */
public OptimizingVector createVector(double[] v, ManyVariableFunction f)
{
    return new MinimizingVector( v, f);
}
}
