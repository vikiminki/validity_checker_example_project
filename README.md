# Validity Checker

Ett maven-projekt med en liten implementation av en "Validity Checker" som:
* Kan ha flera (eller inga) validitest-kontroller
* Kontrollerar indata mot alla sina validitetskontroller
* Loggar till stdout om en validitetskontroll inte passerar

Tre validitetskontroller:
* NotNullCheck - kollar om indata inte är null
* SsnCheck - kollar om indata är ett svenskt personnummer
* LicensePlateCheck - kollar om indata är ett svenskt registreringsnummer

Jag har lite (icke-uttömmande) tester som även tjänar till att visa några antaganden jag gjort om indatan, tex att registreringsnummer får innehålla mellanslag med mera.

Jag har inte skrivit några tester för loggandet, men för att se det in action, kör "main"!