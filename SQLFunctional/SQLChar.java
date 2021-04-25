package SQLFunctional;

import java.util.Random;




abstract class CharGenerator 
{
	protected Random random;
	
	public CharGenerator()
	{
		random = new Random();
	}
	
	public abstract String generate();
}

class CharCity extends CharGenerator
{
	private final String cities[] = 
	{
		"Anversa", "Londra", "Parigi", "New York", "Boston", "Bruxelles",
		"Roma", "Milano", "Berlino", "Monaco", "Beirut", "Sydney", "Torino"
	};
	
	public String generate()
	{
		int count = cities.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return cities[index];
	}
}

class CharID extends CharGenerator
{
	private int IDCounter = 0;
	
	@Override
	public String generate() 
	{
		String idCode = ((Integer)IDCounter).toString();
		IDCounter++;
		return idCode;
	}
	
}

class CharName extends CharGenerator
{
	private final String names[] = 
	{
		"Alessio", "Alessia", "Alessandro", "Antonio", "Andrea",				
		"Asia", "Beatrice", "Benedetta", "Carlo", "Carlotta", 
		"Debora", "Eleonora", "Erik", "Erica", "Francesco", "Francesca",
		"Giulia", "Giuliano"
	};
	
	public String generate()
	{
		int count = names.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return names[index];
	}
}

class CharAddress extends CharGenerator
{

	private final String address[] = 
	{
		"Verdi", "Neri", "Bianchi", "Rossi", "Indipendenza", "Giglioli", "Roma", "Capri",
		"Settimo", "Cesare"
	};

	@Override
	public String generate() 
	{
		int count = address.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return "Via " + address[index] + " " + random.nextInt(100);
	}
	
}

class CharSport extends CharGenerator
{
	
	private final String sport[] = 
	{
		"Karate", "Calcio", "Baseball", "Tennis", "Rugby", "Football", "Pallamano", "Ciclismo",
		"Corsa", "MMA", "Boxe"
	};
	
	@Override
	public String generate() 
	{
		int count = sport.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return sport[index];
	}
}

class CharNation extends CharGenerator
{
	
	private final String values[] = 
	{
		"Italia", "Francia", "Germania", "Belgio", "Olanda", "Spagna", "Paesi Bassi", "Portogallo",
		"USA", "Turchia", "Svezia"
	};
	
	@Override
	public String generate() 
	{
		int count = values.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return values[index];
	}
}

class CharLanguage extends CharGenerator
{
	
	private final String values[] = 
	{
		"Italiano", "Francese", "Tedesco", "Olandese", "Spagnolo", "Portoghese",
		"Americano", "Turco", "Svedese"
	};
	
	@Override
	public String generate() 
	{
		int count = values.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return values[index];
	}
}

class CharMovie extends CharGenerator
{
	
	private final String values[] = 
	{
		"Marvel", "Spiderman", "Batman", "Simspon", "Hacker", "Act of Valor", "Revenant", "Pirati dei caraibi",
		"Avengers", "Captain America"
	};
	
	@Override
	public String generate() 
	{
		int count = values.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return values[index];
	}
}

class CharGenre extends CharGenerator
{
	
	private final String values[] = 
	{
		"Horror", "Commedia", "Thriller", "Azione", "Corto", "Drammatico", "Avventura"
	};
	
	@Override
	public String generate() 
	{
		int count = values.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return values[index];
	}
}

class CharUserType extends CharGenerator
{
	
	private final String values[] = 
	{
		"Principiante", "Intermedio", "Esperto",
	};
	
	@Override
	public String generate() 
	{
		int count = values.length;
		int index;
		
		index = random.ints(0, count-1).findFirst().getAsInt();
		return values[index];
	}
}

class CharRandValues extends CharGenerator
{
	private final Character letters[] = 
	{
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z'
	};
	
	@Override
	public String generate() 
	{
		int count = letters.length;
		int index;
		String str = new String();
		
		for(int i=0;i<5;i++)
		{
			index = random.ints(0, count-1).findFirst().getAsInt();
			str += letters[index];
		}
		return str;
	}

}

class SQLChar extends Attribute 
{
	private int size;
	private CharGenerator toGenerate;
	boolean isPrimaryKey;
	
	SQLChar(String attributeName, String attributeType, boolean isPrimaryKey, int size, boolean isReferenceKey)
	{
		super(attributeName, attributeType, isReferenceKey);
		this.isPrimaryKey = isPrimaryKey;
		this.size = size;
		
		int executionCode = 0;
		
		if(attributeName.toUpperCase().contains("CITTA")==true || attributeName.toUpperCase().contains("CITY")==true)
			executionCode = 1;
		if(attributeName.toUpperCase().contains("NOME")==true || attributeName.toUpperCase().contains("NAME")==true)
			executionCode = 2;
		if(attributeName.toUpperCase().contains("ID")==true)
			executionCode = 3;
		if(attributeName.toUpperCase().contains("ADDRESS")==true || attributeName.toUpperCase().contains("INDIRIZZO")==true)
			executionCode = 4;
		if(attributeName.toUpperCase().contains("SPORT")==true)
			executionCode = 5;
		if(attributeName.toUpperCase().contains("NATION")==true || attributeName.toUpperCase().contains("NAZIONE")==true)
			executionCode = 6;
		if(attributeName.toUpperCase().contains("LANGUAGE")==true || attributeName.toUpperCase().contains("LINGUA")==true)
			executionCode = 7;
		if(attributeName.toUpperCase().contains("MOVIE")==true || attributeName.toUpperCase().contains("FILM")==true)
			executionCode = 8;
		if(attributeName.toUpperCase().contains("GENRE")==true || attributeName.toUpperCase().contains("GENERE")==true)
			executionCode = 9;
		if(attributeName.toUpperCase().contains("USERTYPE")==true || attributeName.toUpperCase().contains("TIPOUTENTE")==true)
			executionCode = 10;
		if(isPrimaryKey)
			executionCode = 3;
		
		switch(executionCode)
		{
			case 0:
				toGenerate = new CharRandValues(); 
				break;
			case 1:
				toGenerate = new CharCity();
				break;
			case 2:
				toGenerate = new CharName();
				break;
			case 3:
				toGenerate = new CharID();
				break;
			case 4:
				toGenerate = new CharAddress();
				break;
			case 5:
				toGenerate = new CharSport();
				break;
			case 6:
				toGenerate = new CharNation();
				break;
			case 7:
				toGenerate = new CharLanguage();
				break;
			case 8:
				toGenerate = new CharMovie();
				break;
			case 9:
				toGenerate = new CharGenre();
				break;
			case 10:
				toGenerate = new CharUserType();
				break;
		}
	}
	
	@Override
	public String createAttribute() 
	{
		String str = attributeName;
		str = str + " CHAR(" + size + ")";
		return str;
	}
	
	@Override
	public String generateAttribute()
	{
			String value = toGenerate.generate();
			if(toGenerate instanceof CharID)
			{
				String temp = value;
				value = this.attributeName.charAt(0) + temp;
			}
			listOfAttributes.add(value);
			return "'" + value + "'";
	}
	
	@Override
	public String generateAttribute(String value) 
	{
		listOfAttributes.add(value);
		return "'" + value + "'";
	}
	
	@Override
	public boolean isPrimaryKey()
	{
		return this.isPrimaryKey;
	}
}
