package SQLFunctional;

import java.util.Random;

class SQLInt extends Attribute
{
	boolean isPrimaryKey;
	public int lastID;
	
	public SQLInt(String attributeName, String attributeType, boolean isPrimaryKey, boolean isReferenceKey)
	{
		super(attributeName, attributeType, isReferenceKey);
		this.isPrimaryKey = isPrimaryKey;
		lastID = 0;
	}
	
	@Override
	public String createAttribute() 
	{
		String str = attributeName;
		str = str + " INT";
		return str;
	}

	@Override
	public String generateAttribute() 
	{
		if(isPrimaryKey==false)
		{
			Random rand = new Random();
			Integer value = rand.nextInt(100);
			listOfAttributes.add(value.toString());
			return value.toString();
		}
		else
		{
			Integer id = lastID++;
			listOfAttributes.add(id.toString());
			return id.toString();
		}
	}
	
	@Override
	public String generateAttribute(String[] values) 
	{
		Random rand = new Random();
		String value = values[rand.nextInt(values.length-1)];
		listOfAttributes.add(value);
		return value;
	}
	
	@Override
	public boolean isPrimaryKey()
	{
		return this.isPrimaryKey;
	}
}
