# Zadatak: Aplikaciju za Auto servise.

<span><b style="font-size:0.8rem">Tehnologije:</b> Spring Boot, REST, JSON, PostgreSQL

<span><b style="font-size:0.8rem">Summary:</b>
Aplikacija je zamišljena kao aplikacija za vođenje servisa za automobile. Omogućava praćenje aktivnosti servisa te automobila i korisnika koji ih koriste. Ovaj dio aplikacije je <i>backend</i> to jest <i>API</i> dio.<span>

<b style="font-size:1.1rem">User stories:</b>

### 1. Kreiranje backend osnove korisnika

- U svrhe praćenja aktivnosti servisa za automobile potrebno je zabilježiti korisnike koji se koriste istim.
- Implementacija korisnika će imati sljedeća polja:
	- <i>firstName</i> (ime)
	- <i>lastName</i> (prezime)
	- <i>oib</i>
	- <i>address</i> (adresa)
- Neka je <i>address</i> tipa <i>embeddable</i> i neka sadrži sljedeća polja:
	- <i>country</i> (država)
	- <i>city</i> (grad)
	- <i>postalNumber</i> (poštanski broj)
	- <i>street</i> (ulica)
	- <i>streetNumber</i> (ulični broj)
- Zadatak ovog user story-a je omogućiti kreiranje korisnika što znači:
	- Kreiranje entiteta <i>User</i> (korisnik)
	- Kreiranje repozitorija
	- Kreiranje servisa preko kojeg je omogućeno dodavanje korisnika

<i style="font-size:0.6rem">Napomena: dopušteno je proizvoljno imenovanje entiteta i njihovih polja sve dok to imenovanje ima nekog smisla i razumne podloge</i>

### 2. Dodavanja korisnika

- Potrebno je napraviti <i>Endpoint</i> u svrhu omogućavanja korištenja našeg <i>API</i>-a "vanjskom svjetu"
- U ovom slučaju to znači kreiranje <i>UserController</i>-a u svrhu omogućavanja dodavanja korisnika te cijelog sloja potrebnog za komunikaciju s "vanjskim svijetom" (<i>DTO</i> + <i>Mapper</i>)
- Potrebno je napraviti:
	- <i>UserDTO</i> koji će predstavljati JSON objekt kojeg očekujemo od korisnika <i style="font-size:0.6rem">(Napomena: U ovom slučaju "korisnik" ovog backend-a je frontend dio aplikacije)</i>
	- <i>UserMapper</i> koji služi za pretvaranje <i>UserDto</i>-a u <i>User</i> objekt.
- Ovaj sloj abstrakcije služi za odvajanje <i>backend</i> djela aplikacije od <i>frontend</i> dijela, postiže se neovisnost našeg <i>API</i>-a o bilo kom korisniku tog <i>API</i>-a
	- Moguće je koristiti objekt <i>User</i>-a kao objekt koji se razmijenjuje između <i>frontend</i>-a i <i>backend</i>-a ali vrlo je vjerojatno da korisnici nemaju potrebe za nekim od polja <i>User</i> objekta kao što je polje <i>Long id</i> koje se koristi prilikom spremanja entiteta u bazu.
	- Također nam omogućuje neovisnost o izgledu to jest strukturi <i>frontend</i> <i>request</i>-ova. U slučaju izmjene <i>request</i>-a koji se šalje s <i>frontend</i>-a nije potrebno mijenjati naš entitet (<i>User</i>) nego samo <i>UserDto</i> i <i>UserMapper</i>.
		- Promjena <i>User</i> znači da je vrlo vjerojatno potrebna promjena baze podataka, servisa koji rukuju tim objektom i sinkronizacija ostalih "korisnika")
	- U drugom slučaju korištenje <i>User</i> entiteta kao objekta koji se koristi za komunikaciju nam onemogućuje promjenu <i>User</i> entiteta bez promjene strukture <i>request</i>-a.
	- <i style="font-size:0.6rem">Napomena: Tipično je backend to jest API onaj koji propisuje strukturu request-ova.</i>
- Propisani izgled <i>request</i>-a:

<i style="font-size:0.6rem">Napomena: napraviti identifikaciju korisnika prema OIB-u (svaki korisnik ima svoj OIB te su po tome unikatni) te u slučaju da se pošalje korisnik koji već postoji u bazi podataka - on se <i>update</i>-a umjesto da se kreira novi.</i>

<b>Request:</b><i>`POST /user/add`</i>
```
{
    "firstName": "Matea",
    "lastName": "Novak",
    "oib": 41551951987,
    "address": {
        "country:": "Croatia",
        "city": "Dubrovnik",
        "postalNumber": 20000,
        "street": "Iva Vojnovića",
        "streetNumber": 9
    }
}
```

<b>Response:</b>
- <div><b><i>201 (Created)</i></b> u slučaju kada je korisnik uspješno kreiran</div>
- Header: Location `/user/<user_id>`
	- <i>user_id</i> treba biti id usera koji je kreiran iz podataka poslanim <i>request</i>-om
- <div><b><i>400 (Bad Request)</i></b> u slučaju da nedostaje jedno od polja</div>

<i style="font-size:0.6rem">Napomena: bilo kakvo modificiranje request-ova ili response-ova nije dopušteno</i>

### 3. Dohvaćanje korisnika

- Potrebno je napraviti <i>endpoint</i> koji služi za prikaz korisnika

<b>Request:</b><i>`GET /user/<user_id>`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada je korisnik uspješno dohvaćen</div>
- Body:
```
{
    "id": 1,
    "firstName": "Matea",
    "lastName": "Novak",
    "oib": 41551951987,
    "address": {
        "country:": "Croatia",
        "city": "Dubrovnik",
        "postalNumber": 20000,
        "street": "Iva Vojnovića",
        "streetNumber": 9
    }
}
```
- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji korisnik s id-om <i>user_id</i></div>

<b>Request:</b><i>`GET /user/all`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada su korisnici uspješno dohvaćeni</div>
- Body:
```
[
    {
    	"id": 1,
        "firstName": "Matea",
        "lastName": "Novak",
        "oib": 41551951987,
        "address": {
            "country:": "Croatia",
            "city": "Dubrovnik",
            "postalNumber": 20000,
            "street": "Iva Vojnovića",
            "streetNumber": 9
        }
    },
    {
    	"id": 2,
        "firstName": "Josip",
        "lastName": "Kovačević",
        "oib": 93684546183,
        "address": {
            "country:": "Croatia",
            "city": "Zagreb",
            "postalNumber": 10000,
            "street": "Dragutina Golika",
            "streetNumber": 3
        }
    }
    ...
]
```

### 4. Brisanje korisnika

- Potrebno je napraviti <i>endpoint</i> koji služi za brisanje korisnika

<b>Request:</b><i>`DELETE /user/<user_id>`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada je korisnik uspješno obrisan</div>

- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji korisnik s id-om <i>user_id</i></div>

### 5. Kreiranje backend osnove automobila

- Implementacija automobila će imati sljedeća polja:
	- <i>manufacturerModel</i> (proizvođač i model)
	- <i>productionYear</i> (godina proizvodnje)
	- <i>registration</i> (registracija)
	- <i>color</i> (boja)
	- <i>user</i> (veza na vlasnika automobila, foreign key!)
- Za manufacturerModel koristiti <i>Enum</i>
	- Dodati neke modele i proizvođače kao:
	    - `BMW_X6("BMW", "X6")`
    	- `MERCEDES_MAYBACH("Mercedes", "Maybach")`
    	- `SEAT_IBIZA("Seat", "Ibiza")`
- Zadatak ovog user story-a je omogućiti kreiranje automobila što znači:
	- Kreiranje entiteta <i>Car</i> (automobil)
	- Kreiranje repozitorija
	- Kreiranje servisa preko kojeg je omogućeno dodavanje automobila

<i style="font-size:0.6rem">Napomena: dopušteno je proizvoljno imenovanje entiteta i njihovih polja sve dok to imenovanje ima nekog smisla i razumne podloge</i>

### 6. Dodavanje automobila

- Potrebno je, vrlo slično kao i za korisnike, napraviti <i>endpoint</i> koji će služiti za dodavanje automobila
- <i>User</i>-i posjeduju <i>Car</i>-ove

<b>Request:</b><i>`POST /car/add`</i>
```
{
    "owner": 1,
    "manufacturerModel": 2,
    "productionYear": 2017,
    "registration": "KA 723-NO",
    "color": "red"
}
```

<b>Response:</b>
- <div><b><i>201 (Created)</i></b> u slučaju kada je korisnik uspješno kreiran</div>
- Header: Location `/car/<car_id>`
	- <i>car_id</i> treba biti id automobila koji je kreiran iz podataka poslanim <i>request</i>-om
- <div><b><i>400 (Bad Request)</i></b> u slučaju da nedostaje jedno od polja</div>

### 7. Dohvaćanje automobila

- Potrebno je napraviti <i>endpoint</i> koji služi za prikaz automobila

<b>Request:</b><i>`GET /car/<car_id>`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada je automobil uspješno dohvaćen</div>
- Body:
```
{
	"id": 1,
    "owner": 1,
    "manufacturerModel": 2,
    "productionYear": 2017,
    "registration": "KA 723-NO",
    "color": "red"
}
```
- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji automobil s id-om <i>car_id</i></div>

<b>Request:</b><i>`GET /car/all`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada su automobili uspješno dohvaćeni</div>
- Body:
```
[
    {
		"id": 1,
	    "owner": 1,
	    "manufacturerModel": 2,
	    "productionYear": 2017,
	    "registration": "KA 723-NO",
	    "color": "red"
	},
    {
		"id": 2,
	    "owner": 1,
	    "manufacturerModel": 3,
	    "productionYear": 2020,
	    "registration": "ZG 623-HR",
	    "color": "black"
	},
    {
		"id": 3,
	    "owner": 2,
	    "manufacturerModel": 1,
	    "productionYear": 1993,
	    "registration": "ZG 9212-IO",
	    "color": "white"
	}
    ...
]
```

<b>Request:</b><i>`GET /user/<user_id>/cars`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada su automobili uspješno dohvaćeni</div>
- Body:
```
[
    {
		"id": 3,
	    "owner": 2,
	    "manufacturerModel": 1,
	    "productionYear": 1993,
	    "registration": "ZG 9212-IO",
	    "color": "white"
	}
	...
]
```
- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji korisnik s id-om <i>user_id</i></div>

### 8. Brisanje automobila

- Potrebno je napraviti <i>endpoint</i> koji služi za brisanje automobila

<b>Request:</b><i>`DELETE /car/<car_id>`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada je automobil uspješno obrisan</div>

- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji automobil s id-om <i>car_id</i></div>

### 9. Kreiranje backend osnove servisa

- Ovaj entitet predstavlja jednu instancu servisa koja je obavljena na jednom od automobila

- Implementacija servisa će imati sljedeća polja:
	- <i>dateAndTime</i> (datum i vrijeme servisa)
	- <i>employeeFirstName</i> (ime radnika koji je napravio servis)
	- <i>employeeLastName</i> (prezime radnika koji je napravio servis)
	- <i>workDescription</i> (opis radova)
	- <i>price</i> (cijena)
	- <i>payment</i> (informacija da li je plaćeno ili ne)
	- <i>car</i> (veza na automobil za koji se radi servis, foreign key!)
- Zadatak ovog user story-a je omogućiti kreiranje automobila što znači:
	- Kreiranje entiteta <i>Car Service</i> (servis automobila)
	- Kreiranje repozitorija
	- Kreiranje servisa preko kojeg je omogućeno dodavanje automobila

<i style="font-size:0.6rem">Napomena: dopušteno je proizvoljno imenovanje entiteta i njihovih polja sve dok to imenovanje ima nekog smisla i razumne podloge</i>

### 10. Dodavanje servisa

- Potrebno je, vrlo slično kao i korisnike i automobile, napraviti <i>endpoint</i> koji će služiti za dodavanje servisa

<b>Request:</b><i>`POST /car-service/add`</i>
```
{
    "dateAndTime": "2023-02-01T12:30:00.000Z",
    "employeeFirstName": "Ivan",
    "employeeLastName": "Ivanović",
    "workDescription": "Mali servis",
    "price": "100",
    "payment": true
}
```

<b>Response:</b>
- <div><b><i>201 (Created)</i></b> u slučaju kada je servis uspješno kreiran</div>
- Header: Location `/car/<service_id>`
	- <i>service_id</i> treba biti id servisa koji je kreiran iz podataka poslanim <i>request</i>-om
- <div><b><i>400 (Bad Request)</i></b> u slučaju da nedostaje jedno od polja</div>

### 11. Dohvaćanje servisa

- Potrebno je napraviti <i>endpoint</i> koji služi za prikaz servisa

<b>Request:</b><i>`GET /car-service/<service_id>`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada je servis uspješno dohvaćen</div>
- Body:
```
{
    "id": 1,
    "dateAndTime": "2023-02-01T12:30:00.000Z",
    "employeeFirstName": "Ivan",
    "employeeLastName": "Ivanović",
    "workDescription": "Mali servis",
    "price": "100",
    "payment": true
}
```
- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji servis s id-om <i>service_id</i></div>

<b>Request:</b><i>`GET /car-service/all`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada su servisi uspješno dohvaćeni</div>
- Body:
```
[
    {
            "id": 1,
            "dateAndTime": "2023-02-01T12:30:00.000Z",
    	    "employeeFirstName": "Ivan",
    	    "employeeLastName": "Ivanović",
    	    "workDescription": "Mali servis",
    	    "price": "100",
    	    "payment": true
	},
    {
	    "id": 2,
            "dateAndTime": "2023-03-01T12:30:00.000Z",
    	    "employeeFirstName": "Petar",
    	    "employeeLastName": "Petrović",
    	    "workDescription": "Veliki servis",
    	    "price": "200",
    	    "payment": true
	},
    {
	    "id": 3,
            "dateAndTime": "2023-04-01T12:30:00.000Z",
    	    "employeeFirstName": "Marko",
    	    "employeeLastName": "Marković",
    	    "workDescription": "Mali servis",
    	    "price": "100",
    	    "payment": false
	}
    ...
]
```

### 12. Brisanje servisa

- Potrebno je napraviti <i>endpoint</i> koji služi za brisanje servisa

<b>Request:</b><i>`DELETE /car-service/<service_id>`</i>

<b>Response:</b>
- <div><b><i>200 (OK)</i></b> u slučaju kada je servis uspješno obrisan</div>

- <div><b><i>404 (Not Found)</i></b> u slučaju kada ne postoji servis s id-om <i>service_id</i></div>
