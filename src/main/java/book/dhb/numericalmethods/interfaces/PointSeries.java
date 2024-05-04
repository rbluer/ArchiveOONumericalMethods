package book.dhb.numericalmethods.interfaces;

/**
 * PointSeries is an interface used by many classes of the package numericalMethods.
 *
 * A PointSeries has the responsibility of handling mathematical
 * points in 2-dimensional space.
 * It is a BRIDGE to a vector containing the points.
 *
 * @author Didier H. Besset
 */
public interface PointSeries
{

	/**
	 * Returns the number of points in the series.
	 * @return size int
	 */
	public int size();
	/**
	 * Returns the x coordinate of the point at the given index.
	 * @param index the index of the point.
	 * @return double x coordinate
	 */
	public double xValueAt( int index);
	/**
	 * Returns the y coordinate of the point at the given index.
	 * @param index the index of the point.
	 * @return double y coordinate
	 */
	public double yValueAt( int index);
}
