import SQLFunctional.Database;

public class Main {

	public static void main(String[] args) 
	{
		Database db = new Database();
		//db.create_database("/Users/alessandroturrin/Desktop/", "databaseProva.sql");
		db.create_database("/Users/alessandroturrin/Desktop/", "homework2_table.sql");
	}

}
