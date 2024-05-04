package book.dhb.numericalmethods.utilityclasses;


import java.awt.TextField;
/**
 * Abstract class to build text fields returning a value.
 * 
 */
public abstract class ValuedField extends TextField
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * is minimum defined
	 */
	protected boolean minimumDefined = false;
	/**
	 * is maximum defined
	 */
	protected boolean maximumDefined = false;



	/**
	 * General constructor method
	 * @param defaultValue the string to put in the field.
	 * @param size the size of the text field in columns.
	 */
	public ValuedField( String defaultValue, int size)
	{
		super( defaultValue, size);
	}
	/**
	 * General error recovery when illegal input is performed:
	 * ring the bell, select the entire text and set the focus on the text field.
	 */
	public void standardErrorRecovery()
	{
		char [] bell = {'\u0007'};
		System.out.println(new String( bell));
		requestFocus();
		selectAll();
	}
}