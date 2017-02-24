# Zadanie 1
Napisać dowolny program, który zobrazuje zjawisko przepełnienia sterty Java (Java heap)

• Program powinien kończyć swoje działanie wyjątkiem OutOfMemoryError

• Projekt Maven 3 z wykorzystaniem Exec plugin (http://www.mojohaus.org/exec-maven-plugin/) do uruchomienia


Wywołanie programu poleceniem mvn exec:java po ustawieniu sie na katalogu ~/exercise1

Przepełnienie sterty Java występuje poprzez zapełnienie mapy wieloma elementami, jednocześnie oszukując GC javy w ten sposób, żeby nie powodował on usunięcia z pamięci zbędnych elementów.
