package book.dhb.numericalmethods.inheritancecheck;
/**
 * My subclass
 */
public class MySubclass extends MyClass {
	/**
	 * constructor
	 */
	public MySubclass() {
	    super();
	}
	/**
	 * 
	 * @param args String[]
	 */
	public static void main(java.lang.String[] args)
	{
	    MySubclass objectB = new MySubclass();
	    System.out.println("Start running MySubclass.privateSub");
	    objectB.privateSub();
	}
	/**
	 * 
	 */
	public void privateCommon()
	{
	    System.out.println("\t=> Executing private method in subclass.");
	}
	/**
	 * 
	 */
	private void privateSub() {
	    privateCommon();
	}
	/**
	 * 
	 */
	protected void protectedCommon()
	{
	    System.out.println("\t=> Executing protected method in subclass.");
	}
}
