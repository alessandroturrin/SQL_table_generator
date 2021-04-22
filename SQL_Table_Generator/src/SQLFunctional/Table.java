package SQLFunctional;

import java.util.ArrayList;
import java.util.Scanner;

class Table 
{
	private String tableName;
	
	private ArrayList<Attribute> attributes;
	private int numberOfAttributes;
	private int numberOfData;
	private boolean areThereReferences = false;
	
	public Table(String tableName)
	{
		this.tableName = tableName;
		numberOfAttributes = numberOfData = 0;
		attributes = new ArrayList<Attribute>();
	}
	
	public String getName()
	{
		return tableName;
	}
	
	public int getNumberOfData()
	{
		return numberOfData;
	}
	
	public int getNumberOfAttributes()
	{
		return numberOfAttributes;
	}
	
	public String attributeNameByIndex(int index)
	{
		return attributes.get(index).getName();
	}
	
	public String[] getValuesByIndex(int index)
	{
		return attributes.get(index).getListOfValues();
	}
	
	public void setNumberOfData(int n)
	{
		this.numberOfData = n;
	}
	
	public boolean areThereReferences()
	{
		return this.areThereReferences;
	}
	
	public void addAttribute()
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String attributeName, attributeType, isKey;
		String attrToUpper;
		boolean isPrimaryKey = false, isReferenceKey = false;
		
		System.out.println("-Attributo #" + (numberOfAttributes+1) + "-");
		System.out.print("Nome: ");
		attributeName = input.next();
		System.out.print("Tipo: ");
		attributeType = input.next();
		attrToUpper = attributeType.toUpperCase();
		
		switch(attrToUpper)
		{
			case "CHAR":
				System.out.print("Dimensione: ");
				int size = input.nextInt();
				System.out.print("Chiave primaria[Y/N]: ");
				isKey = input.next();
				if(isKey.toUpperCase().compareTo("Y")==0)
					isPrimaryKey = true;
				System.out.print("Chiave esterna[Y/N]: ");
				isKey = input.next();
				if(isKey.toUpperCase().compareTo("Y")==0)
					isReferenceKey = true;
				attributes.add(new SQLChar(attributeName, attributeType, isPrimaryKey, size, isReferenceKey));
				if(isReferenceKey)
					attributes.get(numberOfAttributes).referenceSet();
				numberOfAttributes++;
				break;
			case "INT":
				System.out.print("Chiave primaria[Y/N]: ");
				isKey = input.next();
				if(isKey.toUpperCase().compareTo("Y")==0)
					isPrimaryKey = true;
				System.out.print("Chiave esterna[Y/N]: ");
				isKey = input.next();
				if(isKey.toUpperCase().compareTo("Y")==0)
					isReferenceKey = true;
				attributes.add(new SQLInt(attributeName, attributeType, isPrimaryKey, isReferenceKey));
				if(isReferenceKey)
					attributes.get(numberOfAttributes).referenceSet();
				numberOfAttributes++;
				break;
			case "DECIMAL":
				System.out.print("Precisione: ");
				int precision = input.nextInt();
				System.out.print("Scala: ");
				int scale = input.nextInt();
				System.out.print("Chiave esterna[Y/N]: ");
				isKey = input.next();
				if(isKey.toUpperCase().compareTo("Y")==0)
					isReferenceKey = true;
				attributes.add(new SQLDecimal(attributeName, attributeType, precision, scale, isReferenceKey));
				if(isReferenceKey)
					attributes.get(numberOfAttributes).referenceSet();
				numberOfAttributes++;
				break;
			case "DATE":
				System.out.print("Chiave esterna[Y/N]: ");
				isKey = input.next();
				if(isKey.toUpperCase().compareTo("Y")==0)
					isReferenceKey = true;
				attributes.add(new SQLDate(attributeName, attributeType, isReferenceKey));
				if(isReferenceKey)
					attributes.get(numberOfAttributes).referenceSet();
				numberOfAttributes++;
				break;
			default:
				System.out.println("ERRORE NELLA DEFINIZIONE DEL TIPO!");
				break;
		}
		if(isReferenceKey==true)
			areThereReferences = true;
		System.out.println();
	}
	
	public String getAttributes()
	{
		String code = new String();
		String primaryKeys[] = new String[numberOfAttributes];
		String foreignKeys[] = new String[numberOfAttributes];
		int numberOfPrimaryKeys = 0, numberOfForeignKeys = 0;
		
		for(int i=0;i<numberOfAttributes;i++)
		{
			if(attributes.get(i).isPrimaryKey()==true)
				primaryKeys[numberOfPrimaryKeys++] = attributes.get(i).getName();
			if(attributes.get(i).isForeignKey()==true)
				foreignKeys[numberOfForeignKeys++] = attributes.get(i).referenceGet();
			
			code += "\t" + attributes.get(i).createAttribute();
			code += " NOT NULL";
			code += ",\n";
		}
		
		code += "\tPRIMARY KEY(";
		for(int i=0;i<numberOfPrimaryKeys;i++)
		{
			code += primaryKeys[i];
			if(i<numberOfPrimaryKeys-1)
				code += ", ";
		}
		
		if(numberOfForeignKeys>0)
			code+="),\n";
		else
			code += ")";
		
		for(int i=0;i<numberOfForeignKeys;i++)
		{
			code += foreignKeys[i];
			if(i<numberOfForeignKeys-1)
				code += ",\n";
		}
		
		code += "\n";
		
		return code;
	}
	
	public String getAttributesNames()
	{
		String code = new String();
		
		for(int i=0;i<numberOfAttributes;i++)
		{
			code += attributes.get(i).getName();
			if(i<numberOfAttributes-1)
				code += ", ";
		}
		return code;
	}
	
	public String generateAttributes(Database db)
	{
		String code = new String();

		String values[];
		
		for(int i=0;i<numberOfAttributes;i++)
		{
			if(attributes.get(i).isForeignKey==false)
				code += attributes.get(i).generateAttribute();
			else
			{
				values = db.getListOfAttributes(attributes.get(i).getReferenceTable(), attributes.get(i).getReferenceKey());
				code += attributes.get(i).generateAttribute(values);
			}
			
			if(i<numberOfAttributes-1)
				code += ", ";
		}
		return code;
	}
	
	public void reset()
	{
		for(int i=0;i<numberOfAttributes;i++)
			attributes.get(i).reset();
		numberOfAttributes = 0;
		attributes.clear();
	}
}
