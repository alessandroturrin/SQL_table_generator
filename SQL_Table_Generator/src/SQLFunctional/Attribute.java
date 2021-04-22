package SQLFunctional;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Attribute 
{
	protected String attributeName;
	protected String attributeType;
	protected ArrayList<String> listOfAttributes;
	protected boolean isForeignKey;
	protected String referenceTable, referenceKey;
	
	public Attribute(String attributeName, String attributeType, boolean isForeignKey)
	{
		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.isForeignKey = isForeignKey;
		listOfAttributes = new ArrayList<String>();
	}
	
	public String getName()
	{
		return attributeName;
	}
	
	public void referenceSet()
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Tabella di riferimento: ");
		this.referenceTable = input.next();
		System.out.print("Chiave di riferimento: ");
		this.referenceKey = input.next();
	}
	
	public String referenceGet()
	{
		String code = new String();
		
		code = "\tFOREIGN KEY(" + attributeName + ") REFERENCES " +
				referenceTable + "(" + referenceKey + ")";
		return code;
	}
	
	public boolean isForeignKey()
	{
		return isForeignKey;
	}
	
	public String getReferenceTable()
	{
		return referenceTable;
	}
	
	public String getReferenceKey()
	{
		return referenceKey;
	}
	
	public String[] getListOfValues()
	{
		String values[] = new String[listOfAttributes.size()];
		
		for(int i=0;i<listOfAttributes.size();i++)
			values[i] = listOfAttributes.get(i);
		return values;
	}
	
	public void reset()
	{
		listOfAttributes.clear();
	}
	
	public abstract String createAttribute();
	
	public abstract String generateAttribute();
	
	public abstract String generateAttribute(String values[]);

	public abstract boolean isPrimaryKey();
}
