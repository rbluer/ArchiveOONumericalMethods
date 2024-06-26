package book.dhb.numericalmethods.matrixalgebra;

/**
 * Symmetric matrix
 * 
 * @author Didier H. Besset
 */
public class SymmetricMatrix extends Matrix {

    private static int lupCRLCriticalDimension = 36;
	/**
	 * Creates a symmetric matrix with given components.
	 * @param a double[][]
	 */
	protected SymmetricMatrix(double[][] a)
	{
	    super(a);
	}
	/**
	 * @param n int
	 * @exception java.lang.NegativeArraySizeException if n &lt;&#61; 0
	 */
	public SymmetricMatrix (int n ) throws NegativeArraySizeException
	{
	    super( n, n);
	}
	/**
	 * Constructor method.
	 * @param n int
	 * @param m int
	 * @exception java.lang.NegativeArraySizeException if n,m &lt;&#61; 0
	 */
	public SymmetricMatrix(int n, int m) throws NegativeArraySizeException {
	    super(n, m);
	}
	/**
	 * @return SymmetricMatrix    sum of the matrix with the supplied matrix.
	 * @param a DhbMatrix
	 * @exception DhbIllegalDimension if the supplied matrix does not
	 *                                            have the same dimensions.
	 */
	public SymmetricMatrix add ( SymmetricMatrix a)
	                                            throws DhbIllegalDimension
	{
	    return new SymmetricMatrix( addComponents( a));
	}
	/**
	 * Answers the inverse of the receiver computed via the CRL algorithm.
	 * @return SymmetricMatrix
	 * @exception java.lang.ArithmeticException if the matrix is singular.
	 */
	private SymmetricMatrix crlInverse ( ) throws ArithmeticException
	{
	    if ( rows() == 1)
	        return inverse1By1();
	    else if ( rows() == 2)
	        return inverse2By2();
	    Matrix[] splitMatrices = split();
	    SymmetricMatrix b1 = (SymmetricMatrix) splitMatrices[0].inverse();
	    Matrix cb1 = splitMatrices[2].secureProduct( b1);
	    SymmetricMatrix cb1cT = new SymmetricMatrix(
	                cb1.productWithTransposedComponents(splitMatrices[2]));
	    splitMatrices[1] = ( (SymmetricMatrix)
	                    splitMatrices[1]).secureSubtract( cb1cT).inverse();
	    splitMatrices[2] = splitMatrices[1].secureProduct( cb1);
	    splitMatrices[0] = b1.secureAdd( new SymmetricMatrix( 
	                cb1.transposedProductComponents( splitMatrices[2])));
	    return SymmetricMatrix.join( splitMatrices);
	}
	/**
	 * @return SymmetricMatrix
	 * @param    comp double[][]    components of the matrix
	 * @exception DhbIllegalDimension
	 *             The supplied components are not those of a square matrix.
	 * @exception DhbNonSymmetricComponents
	 *            The supplied components are not symmetric.
	 */
	public static SymmetricMatrix fromComponents ( double[][] comp)
	                throws DhbIllegalDimension, DhbNonSymmetricComponents
	{
	    if ( comp.length != comp[0].length)
	        throw new DhbIllegalDimension( "Non symmetric components: a "
	                                    +comp.length+" by "+comp[0].length
	                                    +" matrix cannot be symmetric");
	    for ( int i = 0; i < comp.length; i++)
	    {
	        for ( int j = 0; j < i; j++)
	        {
	            if ( comp[i][j] != comp[j][i])
	                throw new DhbNonSymmetricComponents(
	                    "Non symmetric components: a["+i+"]["+j
	                                    +"]= "+comp[i][j]+", a["+j+"]["
	                                                +i+"]= "+comp[j][i]);
	        }    
	    }    
	    return new SymmetricMatrix( comp);
	}
	/**
	 * @return SymmetricMatrix    an identity matrix of size n
	 * @param n int
	 */
	public static SymmetricMatrix identityMatrix ( int n)
	{
	    double[][] a = new double[n][n];
	    for ( int i = 0; i < n; i++)
	    {
	        for ( int j = 0; j < n; j++) a[i][j] = 0;
	        a[i][i] = 1;
	    }    
	    return new SymmetricMatrix( a);
	}
	/**
	 * @return DhbMatrix        inverse of the receiver.
	 * @exception java.lang.ArithmeticException if the receiver is
	 *                                                    a singular matrix.
	 */
	public Matrix inverse ( ) throws ArithmeticException
	{
	    return rows() < lupCRLCriticalDimension
	                     ? new SymmetricMatrix( 
	             (new LUPDecomposition( this)).inverseMatrixComponents())
	                     : crlInverse( );
	}
	/**
	 * Compute the inverse of the receiver in the case of a 1 by 1 matrix.
	 * Internal use only: no check is made.
	 * @return SymmetricMatrix
	 */
	private SymmetricMatrix inverse1By1 ( )
	{
	    double[][] newComponents = new double[1][1];
	    newComponents[0][0] = 1 / components[0][0];
	    return new SymmetricMatrix( newComponents);
	}
	/**
	 * Compute the inverse of the receiver in the case of a 2 by 2 matrix.
	 * Internal use only: no check is made.
	 * @return SymmetricMatrix
	 */
	private SymmetricMatrix inverse2By2 ( )
	{
	    double[][] newComponents = new double[2][2];
	    double inverseDeterminant = 1 / ( components[0][0] * components[1][1]
	                                - components[0][1] * components[1][0]);
	    newComponents[0][0] = inverseDeterminant * components[1][1];
	    newComponents[1][1] = inverseDeterminant * components[0][0];
	    newComponents[0][1] = newComponents[1][0] = 
	                            -inverseDeterminant * components[1][0];
	    return new SymmetricMatrix( newComponents);
	}
	/**
	 * Build a matrix from 3 parts (inverse of split).
	 * @return SymmetricMatrix
	 * @param a Matrix[]
	 */
	private static SymmetricMatrix join ( Matrix[] a)
	{
	    int p = a[0].rows();
	    int n = p + a[1].rows();
	    double[][] newComponents = new double[n][n];
	    for ( int i = 0; i < p; i++)
	    {
	        for ( int j = 0; j < p; j++)
	            newComponents[i][j] = a[0].components[i][j];
	        for ( int j = p; j < n; j++)
	            newComponents[i][j] = newComponents[j][i] =
	                                            -a[2].components[j-p][i];
	    }    
	    for ( int i = p; i < n; i++)
	    {
	        for ( int j = p; j < n; j++)
	            newComponents[i][j] = a[1].components[i-p][j-p];
	    }    
	    return new SymmetricMatrix( newComponents);
	}
	/**
	 * @return int
	 * @param n int
	 */
	private int largestPowerOf2SmallerThan ( int n)
	{
	    int m = 2;
	    int m2;
	    while (true)
	    {
	        m2 = 2 * m;
	        if ( m2 >= n )
	            return m;
	        m = m2;
	    }    
	}
	/**
	 * @return SymmetricMatrix
	 * @param a double
	 */
	public Matrix product ( double a)
	{
	    return new SymmetricMatrix( productComponents( a));
	}
	/**
	 * @return SymmetricMatrix        product of the receiver with the supplied matrix
	 * @param a SymmetricMatrix
	 * @exception DhbIllegalDimension If the number of columns of
	 * the receivers are not equal to the number of rows
	 * of the supplied matrix.
	 */
	public SymmetricMatrix product ( SymmetricMatrix a) throws DhbIllegalDimension
	{
	    return new SymmetricMatrix( productComponents( a));
	}
	/**
	 * @return SymmetricMatrix    product of the receiver with
	 *                                 the transpose of the supplied matrix
	 * @param a SymmetricMatrix
	 * @exception DhbIllegalDimension If the number of
	 *            columns of the receiver are not equal to the number of
	 *            columns of the supplied matrix.
	 */
	public SymmetricMatrix productWithTransposed ( SymmetricMatrix a)
	                                        throws DhbIllegalDimension
	{
	    if ( a.columns() != columns() )
	        throw new DhbIllegalDimension(
	                    "Operation error: cannot multiply a "
	                    +rows()+" by "+columns()
	                    +" matrix with the transpose of a "
	                    +a.rows()+" by "+a.columns()+" matrix");
	    return new SymmetricMatrix( productWithTransposedComponents( a));
	}
	/**
	 * Same as add ( SymmetricMatrix a), but without dimension checking.
	 * @return SymmetricMatrix
	 * @param a SymmetricMatrix
	 */
	protected SymmetricMatrix secureAdd ( SymmetricMatrix a)
	{
	    return new SymmetricMatrix( addComponents( a));
	}    
	/**
	 * Same as product(DhbSymmetricMatrix a), but without dimension checking.
	 * @return SymmetricMatrix
	 * @param a SymmetricMatrix
	 */
	protected SymmetricMatrix secureProduct ( SymmetricMatrix a)
	{
	    return new SymmetricMatrix( productComponents( a));
	}
	/**
	 * Same as subtract ( SymmetricMatrix a), but without dimension checking.
	 * @return SymmetricMatrix
	 * @param a SymmetricMatrix
	 */
	protected SymmetricMatrix secureSubtract ( SymmetricMatrix a)
	{
	    return new SymmetricMatrix( subtractComponents( a));
	}
	/**
	 * Divide the receiver into 3 matrices or approximately equal dimension.
	 * @return Matrix[]    Array of splitted matrices
	 */
	private Matrix[] split ( )
	{
	    int n = rows();
	    int p = largestPowerOf2SmallerThan( n);
	    int q = n - p;
	    double[][] a = new double[p][p];
	    double[][] b = new double[q][q];
	    double[][] c = new double[q][p];
	    for ( int i = 0; i < p; i++)
	    {
	        for ( int j = 0; j < p; j++)
	            a[i][j] = components[i][j];
	        for ( int j = p; j < n; j++)
	            c[j-p][i] = components[i][j];
	    }    
	    for ( int i = p; i < n; i++)
	    {
	        for ( int j = p; j < n; j++)
	            b[i-p][j-p] = components[i][j];
	    }
	    Matrix[] answer = new Matrix[3];
	    answer[0] = new SymmetricMatrix( a);
	    answer[1] = new SymmetricMatrix( b);
	    answer[2] = new Matrix( c);
	    return answer;
	}
	/**
	 * @return SymmetricMatrix
	 * @param a SymmetricMatrix
	 * @exception DhbIllegalDimension (from constructor).
	 */
	public SymmetricMatrix subtract ( SymmetricMatrix a)
	                                        throws DhbIllegalDimension
	{
	    return new SymmetricMatrix( subtractComponents( a));
	}
	/**
	 * @return Matrix        the same matrix
	 */
	public Matrix transpose()
	{
	    return this;
	}
	/**
	 * @return SymmetricMatrix    product of the transpose
	 *                             of the receiver with the supplied matrix
	 * @param a SymmetricMatrix
	 * @exception DhbIllegalDimension If the number of
	 *                        rows of the receiver are not equal to
	 *                        the number of rows of the supplied matrix.
	 */
	public SymmetricMatrix transposedProduct ( SymmetricMatrix a)
	                                            throws DhbIllegalDimension
	{
	    if ( a.rows() != rows() )
	        throw new DhbIllegalDimension(
	                "Operation error: cannot multiply a tranposed "
	                +rows()+" by "+columns()+" matrix with a "+
	                a.rows()+" by "+a.columns()+" matrix");
	    return new SymmetricMatrix( transposedProductComponents( a));
	}
}
