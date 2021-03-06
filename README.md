# SQL_table_generator
LIBRERIA PER LA DEFINIZIONE E LA CREAZIONE DI DATABASE IN LINGUAGGIO SQL

@INFORMAZIONI SULLA LIBRERIA
Libreria utilizzata per la creazione di attributi random di un database.</br>
E' possibile definire mediante input da tastiera lo schema del database.</br>
Una volta definito lo schema, il software genera in automatico determinati valori, a seconda dei dati forniti in input.</br>

Per lo schema, vengono richieste le seguenti informazioni:</br>
1)Nome database</br>
2)Numero di tabelle del database</br>
   2.1)Nome tabella</br>
   2.2)Numero di attributi della tabella</br>
      2.2.1)Nome dell'attributo</br>
      2.2.2)Specifiche dell'attributo:</br>
         2.2.2.1)Per il tipo 'Char' è richiesta la dimensione</br>
         2.2.2.2)Per il tipi 'Decimal' sono richieste la precisione e la scala</br>
      2.2.2)Tipo dell'attributo ['Int','Char','Decimal',Date']</br>
      2.2.3)Chiave primaria [Y/N] (non disponibile per il tipo 'Date')</br>
      2.2.3)Reference key[Y/N]</br>
         2.2.3.1)Tabella di riferimento</br>
         2.2.3.2)Chiave di riferimento</br>
Per ulteriori informazioni riguardanti i tipi di dato, fare riferimento al paragrafo '@DETTAGLI TIPI DI DATO'.</br>
E' consigliabile impostare tutte le chiavi primarie come Char e non come int.</br>


@DETTAGLI COMANDI</br>
#public String create_database(String directory, String fileName)</br>
Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.</br>
Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:</br>
1)numero di tabelle da generare;</br>
2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.</br>
Tipi di attributo disponibili: Int, Char, Decimal, Date;</br>
3)per ogni tabella, le caratteristiche di ciascun attributo;</br>
Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la generazione delle varie tabelle quanto più realistica possibile.</br>
I dati generati vengono stampati su file.</br>
</br>
#public void create_database()</br>
Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:</br>
1)numero di tabelle da generare;</br>
2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.</br>
Tipi di attributo disponibili: Int, Char, Decimal, Date;</br>
3)per ogni tabella, le caratteristiche di ciascun attributo;</br>
Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la generazione delle varie tabelle quanto più realistica possibile.</br>
I dati generati vengono stampati a video.</br>
</br>
#public static void info()</br>
Stampa a video il presente modulo di utilizzo.</br>
</br>
#public static void info(String directory)</br>
Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.</br>
Stampa successivamente il presente modulo di utilizzo.</br>
</br>
</br>
@DETTAGLI TIPI DI DATO</br>
CHAR</br>
1)Per la dimensione, sono consigliabili i seguenti accorgimenti:</br>
   1.1)Se il char è una chiave primaria, il programma genera in automatico il valore della chiave secondo un ordine crescente. La chiave segue il formato CN, dove C è il primo char del nome dell'attributo, mentre</br>
       N è un numero crescente, il cui conteggio è a carica del software.</br>
       La dimensione consigliata è 5.</br>
   2.2)Se il char non è una chiave primaria, le seguenti keywords vengono riconosciute:</br>
       -[Citta|City]</br>
       -[Nome|Name]</br>
       -[ID]</br>
       -[Indirizzo|Address]</br>
       -[Sport]</br>
       -[Nazione|Nation]</br>
       -[Lingua|Language]</br>
       -[Film|Movie]</br>
       -[Genere|Genre]</br>
       -[Tipodiutente|UserType]</br>
       In caso i dati forniti in input non dovessero corrispondere a nessuna keyword, il software genera in automatico un valore random da inserire nella tabella.</br>
       La dimensione consigliata è 20.</br>
</br>
</br>
@NOTE
E' consigliabile impostare tutte le chiavi primarie come Char e non come int.</br>
Non sono momentaneamente stati aggiunti i controlli per tabelle con reference keys(potrebbero esserci valori duplicati), pertanto si consiglia di utilizzare la presente libreria con le dovute cautele.</br>
</br>
</br>
@AUTORE</br>
Alessandro Turrin, 21/Apr/2021</br>


