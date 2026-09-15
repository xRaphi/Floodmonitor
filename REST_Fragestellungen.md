# REST-Schnittstelle -- Fragestellungen

## 1. Was sind die Hauptmerkmale von JSON?

-   JSON ist nativ in vielen Programmiersprachen implementiert.
-   Es ist leicht lesbar.
-   Unterstützt Key-Value-Paare.

### Beispielaufbau

``` json
{
  "name": "Raphael",
  "alter": 18,
  "aktiv": true,
  "hobbys": ["Gaming", "Programmieren"]
}
```

## 2. Was sind die Hauptmerkmale von XML?

-   Für Menschen lesbar.
-   Unterstützt Attribute.
-   Hierarchisch verschachtelte Daten.
-   XML-Dokumente müssen korrekt verschachtelt sein.

### Beispielaufbau

``` xml
<person>
    <name>Raphael</name>
    <alter>18</alter>
    <aktiv>true</aktiv>
    <hobbys>
        <hobby>Gaming</hobby>
        <hobby>Programmieren</hobby>
    </hobbys>
</person>
```

## 3. Wie unterscheidet die Applikation in diesem Beispiel, ob die Rückgabewerte in JSON oder XML zurückgegeben werden?

-   Spring Boot erkennt anhand des Headers, welches Format zurückgegeben
    werden soll.
-   `Accept: application/json`
-   `Accept: application/xml`

## 4. Was zeichnet ein REST Interface aus und warum wird es heute sehr oft als standardisierte Schnittstelle verwendet?

REST (Representational State Transfer) ist ein Architekturstil für
Web-Schnittstellen.

### Merkmale

-   Ressourcen werden über eindeutige URLs angesprochen.
-   Verwendung standardisierter HTTP-Methoden.
-   Zustandslosigkeit: Jede Anfrage enthält alle notwendigen
    Informationen.
-   Daten werden in Repräsentationen wie JSON oder XML übertragen.
-   Verwendung von HTTP-Statuscodes.
-   Trennung von Client und Server.

### Warum wird REST häufig verwendet?

-   Einfach und leicht verständlich.
-   Plattform- und sprachunabhängig.
-   Gut skalierbar.
-   Einfache Integration verschiedener Anwendungen.
-   Nutzung bestehender HTTP-Standards.

## 5. Was ist der Unterschied zwischen den HTTP-Methoden GET, POST, PUT und PATCH?

  Methode   Verwendung
  --------- --------------------------------
  GET       Daten abrufen
  POST      Neue Ressource erstellen
  PUT       Ressource vollständig ersetzen
  PATCH     Ressource teilweise ändern

## 6. Ich will eine neue Request-Methode / einen neuen Pfad in meinem REST-Interface zur Verfügung stellen. Welche Stellen des Quellcodes muss ich verändern?

Je nach Funktion müssen folgende Bereiche angepasst werden:

1.  **Controller:** Neue HTTP-Methode und URL mit beispielsweise
    `@GetMapping` oder `@PostMapping` definieren.
2.  **Service:** Neue Geschäftslogik implementieren.
3.  **Repository:** Falls erforderlich, Datenbankzugriffe oder
    Suchmethoden ergänzen.
4.  **Model:** Falls neue Daten benötigt werden, Klassen oder Attribute
    erweitern.
5.  **Exception Handling:** Neue mögliche Fehler berücksichtigen.
6.  **Tests:** Automatisierte Tests für den neuen Endpunkt erstellen.
7.  **API-Dokumentation:** Den neuen Endpunkt dokumentieren.

## 7. Kann man OpenAPI und Swagger vergleichen? Wenn ja, dann vergleichen Sie beide Themengebiete. Wenn nein, dann begründen Sie die Antwort.

Ja. OpenAPI und Swagger hängen eng zusammen, sind aber nicht dasselbe.

-   **OpenAPI:** Eine standardisierte Spezifikation zur Beschreibung von
    REST-Schnittstellen. Sie definiert beispielsweise Endpunkte,
    Parameter, Datenmodelle und Antworten.
-   **Swagger:** Eine Sammlung von Werkzeugen zur Arbeit mit OpenAPI,
    beispielsweise zur automatischen Dokumentation und zum Testen von
    APIs.

**Zusammenhang:** OpenAPI beschreibt die Schnittstelle, während Swagger
Werkzeuge bereitstellt, um diese Beschreibung zu verwenden.

## 8. Wo liegt im folgenden Code-Snippet der Fehler? Begründe die Antwort.

``` java
@GetMapping("/stations/add")
public String createStation(@RequestParam String name, @RequestParam double warning) {
    stationService.save(new Station(name, warning));
    return "Station successfully created!";
}
```

Der Fehler liegt darin, dass **GET zum Erstellen einer neuen Ressource
verwendet wird**.

-   GET ist für das Abrufen von Daten vorgesehen.
-   Zum Erstellen einer neuen Station muss POST verwendet werden.
-   Die URL sollte beispielsweise `/stations` statt `/stations/add`
    lauten.
-   Die neuen Stationsdaten sollten im Request-Body übertragen werden.
-   Bei erfolgreicher Erstellung sollte der Server `201 Created`
    zurückgeben.

### Korrektur

``` java
@PostMapping("/stations")
@ResponseStatus(HttpStatus.CREATED)
public Station createStation(@RequestBody Station station) {
    return stationService.save(station);
}
```
