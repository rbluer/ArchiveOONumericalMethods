package book.dhb.numericalmethods.interpolation;

import book.dhb.numericalmethods.interfaces.PointSeries;

/**
 * Bulirsch-Stoer interpolation 
 *
 * @author Didier H. Besset
 */
public class BulirschStoerInterpolator extends NevilleInterpolator
{
/**
 * Constructor method.
 * @param pts DhbInterfaces.PointSeries
 */
public BulirschStoerInterpolator(PointSeries pts) {
    super(pts);
}
/**
 * @param m int
 * @param n int
 * @param x double
 */
protected void computeNextDifference( int m, int n, double x)
{
    double ratio = ( points.xValueAt(n) - x) * rightErrors[n]
                                / ( points.xValueAt(n + m + 1) - x);
    double diff = ( leftErrors[n+1] - rightErrors[n])
                                        / ( ratio - leftErrors[n+1]);
    if( Double.isNaN( diff) )
    {
        diff = 0;
    }
    rightErrors[n] = leftErrors[n+1] * diff;
    leftErrors[n] = ratio * diff;
}
}
