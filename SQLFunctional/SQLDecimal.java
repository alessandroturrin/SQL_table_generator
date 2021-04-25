package SQLFunctional;

import java.util.Random;

class SQLDecimal extends Attribute
{
	private int precision, scale;
	
	public SQLDecimal(String attributeName, String attributeType, int precision, int scale, boolean isReferenceKey)
	{
		super(attributeName, attributeType, isReferenceKey);
		this.precision = precision;
		this.scale = scale;
	}
	
	@Override
	public String createAttribute() 
	{
		String str = attributeName;
		str = str + " DECIMAL(" + precision + ", " + scale + ")";
		return str;
	}

	@Override
	public String generateAttribute() 
	{
		Random rand = new Random();
		Double value = rand.nextDouble()*10.0;
		listOfAttributes.add(value.toString());
		return value.toString();
	}
	
	@Override
	public String generateAttribute(String value) 
	{
		listOfAttributes.add(value);
		return value;
	}
	
	@Override
	public boolean isPrimaryKey()
	{
		return false;
	}
}
