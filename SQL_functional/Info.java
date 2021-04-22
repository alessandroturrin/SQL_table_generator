package SQLFunctional;

class Info 
{
	public static String getInfo()
	{
		String info = 
				"SOFTWARE PER LA GESTIONE E LA CREAZIONE DI DATABASE IN LINGUAGGIO SQL\n"
				+ "\n"
				+ "@COMANDI DISPONIBILI\n"
				+ "#create_database(String directory, String fileName)\n"
				+ "Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.\n"
				+ "Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:\n"
				+ "1)numero di tabelle da generare;\n"
				+ "2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.\n"
				+ "Tipi di attributo disponibili: Int, Char, Decimal, Date;\n"
				+ "3)per ogni tabella, le caratteristiche di ciascun attributo;\n"
				+ "Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la generazione delle varie tabelle quanto più realistica possibile.\n"
				+ "I dati generati vengono stampati su file.\n"
				+ "Le seguenti keywords vengono riconosciute:\n"
				+ "-[Citta|City]\n"
				+ "-[Nome|Name]\n"
				+ "-[ID]\n"
				+ "-[Indirizzo|Address]\n"
				+ "-[Sport]\n"
				+ "-[Nazione|Nation]\n"
				+ "-[Lingua|Language]\n"
				+ "-[Film|Movie]\n"
				+ "-[Genere|Genre]\n"
				+ "-[Tipodiutente|UserType]\n"
				+ "\n"
				+ "#create_database()\n"
				+ "Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:\n"
				+ "1)numero di tabelle da generare;\n"
				+ "2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.\n"
				+ "Tipi di attributo disponibili: Int, Char, Decimal, Date;\n"
				+ "3)per ogni tabella, le caratteristiche di ciascun attributo;\n"
				+ "Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la generazione delle varie tabelle quanto più realistica possibile.\n"
				+ "I dati generati vengono stampati a video.\n"
				+ "\n"
				+ "#info()\n"
				+ "Stampa a video il presente modulo di utilizzo.\n"
				+ "\n"
				+ "#info(String directory)\n"
				+ "Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.\n"
				+ "Stampa successivamente il presente modulo di utilizzo.\n"
				+ "\n"
				+ "@NOTE\n"
				+ "Non sono momentaneamente stati aggiunti i controlli e la gestione delle eccezioni sugli input, pertanto si richiede di utilizzare con cautela la presente libreria.\n"
				+ "\n"
				+ "\n"
				+ "@AUTORE\n"
				+ "Alessandro Turrin, 21/Apr/2021\n";
			return info;
	}
}
