package book.dhb.numericalmethods.inheritancecheck;

/**
 * My class
 */
public class MyClass {
	/**
	 * constructor
	 */
	public MyClass() {
	    super();
	}
	/**
	 * 
	 * @param args String[]
	 */
	public static void main(java.lang.String[] args)
	{
	    MyClass objectA = new MyClass();
	    System.out.println("Start running MyClass.privateCommon");
	    objectA.privateCommon();
	    MySubclass objectB = new MySubclass();
	    System.out.println("Start running MySubclass.privateCommon");
	    objectB.privateCommon();
	    System.out.println("Start running MyClass.protectedCommon");
	    objectA.protectedCommon();
	    System.out.println("Start running MySubclass.protectedCommon");
	    objectB.protectedCommon();
	}
	/**
	 * 
	 */
	private void privateCommon()
	{
	    System.out.println("\t=> Executing private method in superclass.");
	}
	/**
	 * 
	 */
	@SuppressWarnings( "unused" )
	private void privateSuper() {
	    privateCommon();
	}
	/**
	 * 
	 */
	protected void protectedCommon()
	{
	    System.out.println("\t=> Executing protected method in superclass.");
	}
	/**
	 * 
	 */
	protected void protectedSuper() {
	    protectedCommon();
	}
}
