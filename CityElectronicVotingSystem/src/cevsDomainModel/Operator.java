package cevsDomainModel;

/**
 * <p>
 * Defines valid Operator types.
 * </p>
 *
 */
public enum Operator
{
    EQUALS(100), GREATER(5000), LESSTHAN(1000), DOESNOTEXIST(999);

    /**
     * <p>
     * The values
     * <p>
     */
    private int value;


    /**
     * <p>
     * Constructor with value.
     * </p>
     * @param value
     */
    Operator(int value) 
    {
    	this.setValue(value);
    }
    
    /**
     * <p>
     * Disabled constructor
     * </p>
     */
    private Operator()
    {
    }

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
 }