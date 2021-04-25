package SQLFunctional;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database 
{
	private ArrayList<Table> tables;
	private int tablesCounter;
	private String directory, fileName;
	private String databaseName;
	
	public Database()
	{
		tables = new ArrayList<Table>();
		tablesCounter = 0;
	}
	
	private void clearScreen(int space)
	{    
		for(int i=0;i<space;i++)
			System.out.println("\n");
	}
	
	private String dropTableCode()
	{
		String code = new String();
		
		code += "CREATE DATABASE IF NOT EXISTS " + databaseName + ";\n";
		code += "--USE " + databaseName + ";\n\n";
		
		for(int i=0;i<tablesCounter;i++)
			code += "DROP TABLE IF EXISTS " + tables.get(i).getName() + ";\n";
		code += "\n\n";
		return code;
	}
	
	private String createTableCode()
	{
		String code = new String();
		
		for(int i=0;i<tablesCounter;i++)
		{
			code += "CREATE TABLE " + tables.get(i).getName() + "\n(\n";
			code += tables.get(i).getAttributes();
			code += ");\n\n";
		}
		
		code += "\n";
		
		return code;
	}
	
	private String createInsertCode()
	{
		String code = new String();
		
		for(int i=0;i<tablesCounter;i++)
		{
			for(int j=0;j<tables.get(i).getNumberOfData();j++)
			{
				if(tables.get(i).areThereReferences()==true)
					code += "INSERT INTO " + tables.get(i).getName() + "\n\tVALUES (";
				else
				{
					code += "INSERT INTO " + tables.get(i).getName() + " (";
					code += tables.get(i).getAttributesNames() + ")\n\tVALUES (";
				}
				code += tables.get(i).generateAttributes(this);
				code += ");\n\n";
			}
			
			code += "\n\n";
		}
		
		return code;
	}
	
	private void createNewTable() 
	{
		boolean fine = false;
		String tmp;
		int numberOfData = 0;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int nOfAttributes = 0;
		
		System.out.print("Nome tabella: ");		
		tables.add(new Table(input.next()));
			
		do
		{
			try
			{
				System.out.print("Numero di attributi: ");
				tmp = input.next();
				nOfAttributes = Integer.parseInt(tmp);
				fine = true;
			}
			catch(Exception e)
			{
				System.out.println("\n[expected value of type 'Int']");
				fine = false;
			}
		}while(fine!=true);
		
		this.clearScreen(1);
		for(int i=0;i<nOfAttributes;i++)
			tables.get(tablesCounter).addAttribute();
		
		
		do
		{
			try
			{
				System.out.print("Dati da generare: ");
				tmp = input.next();
				numberOfData = Integer.parseInt(tmp);
				fine = true;
			}
			catch(Exception e)
			{
				System.out.println("\n[expected value of type 'Int']");
				fine = false;
			}
		}while(fine!=true);
		
		tables.get(tablesCounter).setNumberOfData(numberOfData);
		tablesCounter++;
	}
	
	private String getCode()
	{
		String code = new String();
		
		code += this.dropTableCode();
		code += this.createTableCode();
		code += this.createInsertCode();
		
		return code;
	}
	
	String[] getListOfAttributes(String table, String key)
	{
		for(int i=0;i<tablesCounter;i++)
			if(table.compareTo(tables.get(i).getName())==0)
			{
				for(int j=0;j<tables.get(i).getNumberOfAttributes();j++)
					if(key.compareTo(tables.get(i).attributeNameByIndex(j))==0)
						return tables.get(i).getValuesByIndex(j);
			}
		return null;
	}
	
	private void printOnFile()
	{
		FileWriter outFile;
		String code = this.getCode();
		String cDir = this.directory + this.fileName;
		
	    try 
	    {
			outFile=new FileWriter(cDir);
			outFile.write(code);
			outFile.flush();
			outFile.close();
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
	
	private void reset()
	{
		for(int i=0;i<tablesCounter;i++)
			tables.get(i).reset();
		tablesCounter = 0;
		tables.clear();
	}
	
	/**
	 * Prints on video this library's doc. 
	 */
	public static void info()
	{
		System.out.println(Info.getInfo());
	}
	
	/**
	 * Prints on the given directory this library's doc.
	 * @param directory
	 */
	public static void info(String directory)
	{
		FileWriter outFile;
		
	    try 
	    {
			outFile=new FileWriter(directory+"sql_info");
			outFile.write(Info.getInfo());
			outFile.flush();
			outFile.close();
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generates a database system by using random values, following
	 * the constraints given in input by the user.
	 * Generated values are printed by file.
	 * @param directory
	 * @param fileName
	 */
	@SuppressWarnings("resource")
	public void create_database(String directory, String fileName)
	{
		boolean fine;
		String tmp;
		
		this.directory = directory;
		this.fileName = fileName;
		
		this.reset();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Nome database: ");
		databaseName = scan.next();
		
		int numberOfTables = 0;
		
		do
		{
			try
			{
				System.out.print("\nNumero di tabelle: ");
				tmp = scan.next();
				numberOfTables = Integer.parseInt(tmp);
				fine = true;
			}
			catch(Exception e)
			{
				System.out.println("[expected value of type 'Int']");
				fine = false;
			}
		}while(fine!=true);
		
		this.clearScreen(2);
		
		for(int i=0;i<numberOfTables;i++)
		{
			System.out.println("### Tabella " + (i+1) + " ###");
			this.createNewTable();
			System.out.println("#################");
			System.out.println("[Tabella generata con successo]\n");
			this.clearScreen(1);
		}
		
		this.printOnFile();
	}
	
	/**
	 * Generates a database system by using random values, following
	 * the constraints given in input by the user.
	 * Generated values are printed by System.out
	 */
	public void create_database()
	{
		boolean fine;
		String tmp;
		
		this.reset();
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Nome database: ");
		databaseName = scan.next();
		
		int numberOfTables = 0;
		
		do
		{
			try
			{
				System.out.print("\nNumero di tabelle: ");
				tmp = scan.next();
				numberOfTables = Integer.parseInt(tmp);
				fine = true;
			}
			catch(Exception e)
			{
				System.out.println("[expected value of type 'Int']");
				fine = false;
			}
		}while(fine!=true);
		
		this.clearScreen(2);
		
		for(int i=0;i<numberOfTables;i++)
		{
			System.out.println("### Tabella " + (i+1) + " ###");
			this.createNewTable();
			System.out.println("#################");
			System.out.println("\n[Tabella generata con successo]");
			this.clearScreen(1);
		}
		
		System.out.println("##### CODE #####\n");
		System.out.println(this.getCode());
		System.out.println("################");
	}
	
	
}
