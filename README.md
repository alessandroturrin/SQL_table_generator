# SQL_table_generator
LIBRERIA PER LA DEFINIZIONE E LA CREAZIONE DI DATABASE IN LINGUAGGIO SQL

@INFORMAZIONI SULLA LIBRERIA
Libreria utilizzata per la creazione di attributi random di un database.
E' possibile definire mediante input da tastiera lo schema del database.
Una volta definito lo schema, il software genera in automatico determinati valori, a seconda dei dati forniti in input.

Per lo schema, vengono richieste le seguenti informazioni:
1)Nome database
2)Numero di tabelle del database
   2.1)Nome tabella
   2.2)Numero di attributi della tabella
      2.2.1)Nome dell'attributo
      2.2.2)Specifiche dell'attributo:
         2.2.2.1)Per il tipo 'Char' è richiesta la dimensione
         2.2.2.2)Per il tipi 'Decimal' sono richieste la precisione e la scala
      2.2.2)Tipo dell'attributo ['Int','Char','Decimal',Date']
      2.2.3)Chiave primaria [Y/N] (non disponibile per il tipo 'Date')
      2.2.3)Reference key[Y/N]
         2.2.3.1)Tabella di riferimento
         2.2.3.2)Chiave di riferimento
Per ulteriori informazioni riguardanti i tipi di dato, fare riferimento al paragrafo '@DETTAGLI TIPI DI DATO'.
E' consigliabile impostare tutte le chiavi primarie come Char e non come int.


@DETTAGLI COMANDI
#public String create_database(String directory, String fileName)
Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.
Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:
1)numero di tabelle da generare;
2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.
Tipi di attributo disponibili: Int, Char, Decimal, Date;
3)per ogni tabella, le caratteristiche di ciascun attributo;
Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la
generazione delle varie tabelle quanto più realistica possibile.
I dati generati vengono stampati su file.

#public void create_database()
Sono di richiesti in input mediante System.in gli inserimenti dei seguenti dati:
1)numero di tabelle da generare;
2)per ogni attributo vengono richiesti nome, tipo, (chiave primaria,) tabella e chiave di riferimento.
Tipi di attributo disponibili: Int, Char, Decimal, Date;
3)per ogni tabella, le caratteristiche di ciascun attributo;
Il software riconosce autonomamente la presenza di determinati tipi di attributi assegnando così, in modo randomico, determinati valori selezionati da una serie di elenchi predefiniti, così da poter rendere la
generazione delle varie tabelle quanto più realistica possibile.
I dati generati vengono stampati a video.

#public static void info()
Stampa a video il presente modulo di utilizzo.

#public static void info(String directory)
Riceve come parametri la directory del file di output (con aggiunta finale di '/' a carico dell'utente) e il nome del file.
Stampa successivamente il presente modulo di utilizzo.


@DETTAGLI TIPI DI DATO
CHAR
1)Per la dimensione, sono consigliabili i seguenti accorgimenti:
   1.1)Se il char è una chiave primaria, il programma genera in automatico il valore della chiave secondo un ordine crescente. La chiave segue il formato CN, dove C è il primo char del nome dell'attributo, mentre
       N è un numero crescente, il cui conteggio è a carica del software.
       La dimensione consigliata è 5.
   2.2)Se il char non è una chiave primaria, le seguenti keywords vengono riconosciute:
       -[Citta|City]
       -[Nome|Name]
       -[ID]
       -[Indirizzo|Address]
       -[Sport]
       -[Nazione|Nation]
       -[Lingua|Language]
       -[Film|Movie]
       -[Genere|Genre]
       -[Tipodiutente|UserType]
       In caso i dati forniti in input non dovessero corrispondere a nessuna keyword, il software genera in automatico un valore random da inserire nella tabella.
       La dimensione consigliata è 20.


@NOTE
E' consigliabile impostare tutte le chiavi primarie come Char e non come int.
Non sono momentaneamente stati aggiunti i controlli per tabelle con reference keys(potrebbero esserci valori duplicati), pertanto si consiglia di utilizzare la presente libreria con le dovute cautele.


@AUTORE
Alessandro Turrin, 21/Apr/2021


