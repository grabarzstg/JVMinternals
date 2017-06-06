# JVM 1 - OutOfMemoryError

Napisać dowolny program, który zobrazuje zjawisko przepełnienia sterty Java (Java heap)

• Program powinien kończyć swoje działanie wyjątkiem OutOfMemoryError

• Projekt Maven 3 z wykorzystaniem Exec plugin (http://www.mojohaus.org/exec-maven-plugin/) do uruchomienia

Uruchomienie: **mvn package exec:java**

Przepełnienie sterty Java występuje poprzez zapełnienie mapy wieloma elementami, jednocześnie oszukując GC javy w ten sposób, żeby nie powodował on usunięcia z pamięci zbędnych elementów.
