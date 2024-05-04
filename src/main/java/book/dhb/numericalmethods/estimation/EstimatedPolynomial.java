package book.dhb.numericalmethods.estimation;

import book.dhb.numericalmethods.functionevaluation.PolynomialFunction;
import book.dhb.numericalmethods.matrixalgebra.DhbIllegalDimension;
import book.dhb.numericalmethods.matrixalgebra.DhbVector;
import book.dhb.numericalmethods.matrixalgebra.SymmetricMatrix;
/**
 * Polynomial with error estimation
 * 
 * @author Didier H. Besset
 */
public class EstimatedPolynomial extends PolynomialFunction
{
    /**
     * Error matrix.
     */
    SymmetricMatrix errorMatrix;
	/**
	 * Constructor method.
	 * @param coeffs double[]
	 * @param e double[]    error matrix
	 */
	public EstimatedPolynomial(double[] coeffs, SymmetricMatrix e)
	{
	    super(coeffs);
	    errorMatrix = e;
	}
	/**
	 * @return double
	 * @param x double
	 */
	public double error( double x)
	{
	    int n = degree() + 1;
	    double[] errors = new double[n];
	    errors[0] = 1;
	    for ( int i = 1; i < n; i++)
	        errors[i] = errors[i-1] * x;
	    DhbVector errorVector = new DhbVector( errors);
	    double answer;
	    try { answer = errorVector.product( 
	                                errorMatrix.product( errorVector));
	        } catch (DhbIllegalDimension e) { answer = Double.NaN;};
	    return Math.sqrt( answer);
	}
}
