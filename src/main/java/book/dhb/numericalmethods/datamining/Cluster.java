package book.dhb.numericalmethods.datamining;

import book.dhb.numericalmethods.matrixalgebra.DhbVector;
/**
 * Abstract cluster.
 * 
 * @author Didier H. Besset
 */
public abstract class Cluster
{
    protected long previousSampleSize = 0;
	/**
	 * Default constructor method.
	 */
	public Cluster() {
	}
	/**
	 * Constructor method.
	 * @param v DhbVector
	 */
	public Cluster(DhbVector v)
	{
	    initialize(v);
	}
	/**
	 * @param dataPoint DhbVector    data point
	 */
	public abstract void accumulate(DhbVector dataPoint);
	/**
	 * @param dataPoint DhbVector   data point
	 * @return double
	 */
	public abstract double distanceTo(DhbVector dataPoint);
	/**
	 * @return long    number of data points taken from or added to the receiver
	 */
	public long getChanges()
	{
	    return Math.abs( getSampleSize() - previousSampleSize);
	}
	/**
	 * @return long    number of data points accumulated in the receiver
	 */
	public abstract long getSampleSize();
	/**
	 * @param v DhbVector
	 */
	public abstract void initialize( DhbVector v);
	/**
	 * @return boolean    true if no data was accumulated in the receiver
	 */
	public boolean isEmpty()
	{
	    return getSampleSize() == 0;
	}
	/**
	 * @return boolean    true if the receiver should be dropped from
	 *                                                     the cluster finder
	 * @param finder ClusterFinder
	 */
	public boolean isInsignificantIn( ClusterFinder finder)
	{
	    return getSampleSize() <= finder.minimumClusterSize();
	}
	/**
	 * @return boolean    true if the cluster is in an undefined state.
	 */
	public abstract boolean isUndefined( );
	/**
	 * reset
	 */
	public void reset()
	{
	    previousSampleSize = getSampleSize();
	}
}
