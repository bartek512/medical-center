# medical-center

Stworzono system obsługujący sieć placówek medycznych. Zaimplementowany został model od podstaw, klasy TO, potrzebne mappery, walidatory, serwisy oraz repozytoria. 
W encjach znajdują się query, umożliwiające wykonanie kilku podstawowych operacji na nich, np wyszukanie lekarzy przypisanych tylko do jednej konkretnej placówki 
lub wyszukanie pacjentów z największą ilością odwołanych wizyt. Wykorzystano równiez kilka metod z JPARepository. Wszystkie encje posiadają czas utorzenia oraz aktualizacji, 
wersję (w celu kontroli wersji oraz w razie konieczności rzucenia wyjątku OptimisticLocking).
Wszystkie query w encjach posiadają swoje testy, dodatkowo otestowano rzucanie wyjątku OptimisticLocking oraz kaskadowe usuwanie obiektów. 

W przyszłości w planach jest poprawienie metody update oraz dalszy rozwój aplikacji. 
