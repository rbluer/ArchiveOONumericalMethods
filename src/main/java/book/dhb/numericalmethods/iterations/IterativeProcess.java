package book.dhb.numericalmethods.iterations;

import book.dhb.numericalmethods.functionevaluation.DhbMath;
/**
 * An iterative process is a general structure managing iterations.
 *
 * @author Didier H. Besset
 */
public abstract class IterativeProcess
{
    /**
     * Number of iterations performed.
     */
    private int iterations;
    /**
     * Maximum allowed number of iterations.
     */
    private int maximumIterations = 50;
    /**
     * Desired precision.
     */
    private double desiredPrecision = DhbMath.defaultNumericalPrecision();
    /**
     * Achieved precision.
     */
    private double precision;


	/**
	 * Generic constructor.
	 */
	public IterativeProcess() {
	}
	/**
	* Performs the iterative process.
	* Note: this method does not return anything because Java does not
	* allow mixing double, int, or objects
	*/
	public void evaluate()
	{
	    iterations = 0;
	    initializeIterations();
	    while ( iterations++ < maximumIterations )
	    {
	        precision = evaluateIteration();
	        if ( hasConverged() )
	            break;
	    }
	    finalizeIterations();
	}
	/**
	* Evaluate the result of the current interation.
	* @return the estimated precision of the result.
	*/
	abstract public double evaluateIteration();
	/**
	 * Perform eventual clean-up operations
	 * (must be implement by subclass when needed).
	 */
	public void finalizeIterations ( )
	{
	}
	/**
	 * @return double Returns the desired precision.
	 */
	public double getDesiredPrecision( )
	{
	    return desiredPrecision;
	}
	/**
	 * @return int Returns the number of iterations performed.
	 */
	public int getIterations()
	{
	    return iterations;
	}
	/**
	 * @return int Returns the maximum allowed number of iterations.
	 */
	
	public int getMaximumIterations( )
	{
	    return maximumIterations;
	}
	/**
	 * @return double Returns the attained precision.
	 */
	public double getPrecision()
	{
	    return precision;
	}
	/**
	 * Check to see if the result has been attained.
	 * @return boolean
	 */
	public boolean hasConverged()
	{
	    return precision < desiredPrecision;
	}
	/**
	* Initializes internal parameters to start the iterative process.
	*/
	public void initializeIterations()
	{
	}
	/**
	 * @return double
	 * @param epsilon double
	 * @param x double
	 */
	public double relativePrecision( double epsilon, double x)
	{
	    return x > DhbMath.defaultNumericalPrecision()
	                                            ? epsilon / x: epsilon;
	}
	/**
	 * Defines the desired precision.
	 * @param prec double
	 * @throws IllegalArgumentException non-positive precision
	 */
	public void setDesiredPrecision( double prec )
	                                    throws IllegalArgumentException
	{
	    if ( prec <= 0 )
	        throw new IllegalArgumentException
	                                ( "Non-positive precision: "+prec);
	    desiredPrecision = prec;
	}
	/**
	 * Defines the maximum allowed number of iterations.
	 * @param maxIter int
	 * @throws IllegalArgumentException non-positive maximum iteration
	 */
	public void setMaximumIterations( int maxIter)
	                                    throws IllegalArgumentException
	{
	    if ( maxIter < 1 )
	        throw new IllegalArgumentException
	                        ( "Non-positive maximum iteration: "+maxIter);
	    maximumIterations = maxIter;
	}
}
