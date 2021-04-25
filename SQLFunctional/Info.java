package SQLFunctional;

class Info 
{
	public static String getInfo()
	{
		String info = 
				"LIBRERIA PER LA DEFINIZIONE E LA CREAZIONE DI DATABASE IN LINGUAGGIO SQL\n"
				+ "\n"
				+ "@INFORMAZIONI SULLA LIBRERIA\n"
				+ "Libreria utilizzata per la creazione di attributi random di un database.\n"
				+ "E' possibile definire mediante input da tastiera lo schema del database.\n"
				+ "Una volta definito lo schema, il software genera in automatico determinati valori, a seconda dei dati forniti in input.\n"
				+ "\n"
				+ "Per lo schema, vengono richieste le seguenti informazioni:\n"
				+ "1)Nome database\n"
				+ "2)Numero di tabelle del database\n"
				+ "   2.1)Nome tabella\n"
				+ "   2.2)Numero di attributi della tabella\n"
				+ "      2.2.1)Nome dell'attributo\n"
				+ "      2.2.2)Specifiche dell'attributo:\n"
				+ "         2.2.2.1)Per il tipo 'Char' è richiesta la dimensione\n"
				+ "         2.2.2.2)Per il tipi 'Decimal' sono richieste la precisione e la scala\n"
				+ "      2.2.2)Tipo dell'attributo ['Int','Char','Decimal',Date']\n"
				+ "      2.2.3)Chiave primaria [Y/N] (non disponibile per il tipo 'Date')\n"
				+ "      2.2.3)Reference key[Y/N]\n"
				+ "         2.2.3.1)Tabella di riferimento\n"
				+ "         2.2.3.2)Chiave di riferimento\n"
				+ "Per ulteriori informazioni riguardanti i tipi di dato, fare riferimento al paragrafo '@DETTAGLI TIPI DI DATO'.\n"
				+ "E' consigliabile impostare tutte le chiavi primarie come Char e non come int.\n"
				+ "\n"
				+ "\n"
				+ "@DETTAGLI COMANDI\n"
				+ "#public String create_database(String directory, String fileName)\n"
				+ "Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.\n"
				+ "Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:\n"
				+ "1)numero di tabelle da generare;\n"
				+ "2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.\n"
				+ "Tipi di attributo disponibili: Int, Char, Decimal, Date;\n"
				+ "3)per ogni tabella, le caratteristiche di ciascun attributo;\n"
				+ "Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la\n"
				+ "generazione delle varie tabelle quanto più realistica possibile.\n"
				+ "I dati generati vengono stampati su file.\n"
				+ "\n"
				+ "#public void create_database()\n"
				+ "Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:\n"
				+ "1)numero di tabelle da generare;\n"
				+ "2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.\n"
				+ "Tipi di attributo disponibili: Int, Char, Decimal, Date;\n"
				+ "3)per ogni tabella, le caratteristiche di ciascun attributo;\n"
				+ "Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la\n"
				+ "generazione delle varie tabelle quanto più realistica possibile.\n"
				+ "I dati generati vengono stampati a video.\n"
				+ "\n"
				+ "#public static void info()\n"
				+ "Stampa a video il presente modulo di utilizzo.\n"
				+ "\n"
				+ "#public static void info(String directory)\n"
				+ "Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.\n"
				+ "Stampa successivamente il presente modulo di utilizzo.\n"
				+ "\n"
				+ "\n"
				+ "@DETTAGLI TIPI DI DATO\n"
				+ "CHAR\n"
				+ "1)Per la dimensione, sono consigliabili i seguenti accorgimenti:\n"
				+ "   1.1)Se il char è una chiave primaria, il programma genera in automatico il valore della chiave secondo un ordine crescente. La chiave segue il formato CN, dove C è il primo char del nome dell'attributo, mentre\n"
				+ "       N è un numero crescente, il cui conteggio è a carica del software.\n"
				+ "       La dimensione consigliata è 5.\n"
				+ "   2.2)Se il char non è una chiave primaria, le seguenti keywords vengono riconosciute:\n"
				+ "       -[Citta|City]\n"
				+ "       -[Nome|Name]\n"
				+ "       -[ID]\n"
				+ "       -[Indirizzo|Address]\n"
				+ "       -[Sport]\n"
				+ "       -[Nazione|Nation]\n"
				+ "       -[Lingua|Language]\n"
				+ "       -[Film|Movie]\n"
				+ "       -[Genere|Genre]\n"
				+ "       -[Tipodiutente|UserType]\n"
				+ "       In caso i dati forniti in input non dovessero corrispondere a nessuna keyword, il software genera in automatico un valore random da inserire nella tabella.\n"
				+ "       La dimensione consigliata è 20.\n"
				+ "\n"
				+ "\n"
				+ "@NOTE\n"
				+ "E' consigliabile impostare tutte le chiavi primarie come Char e non come int.\n"
				+ "Non sono momentaneamente stati aggiunti i controlli per tabelle con reference keys(potrebbero esserci valori duplicati), pertanto si consiglia di utilizzare la presente libreria con le dovute cautele.\n"
				+ "\n"
				+ "\n"
				+ "@AUTORE\n"
				+ "Alessandro Turrin, 21/Apr/2021";
			return info;
		}
}