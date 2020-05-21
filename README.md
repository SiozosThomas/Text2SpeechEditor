# Text2SpeechEditor

Στόχος του project είναι η δημιουργία εφαρμογής η οποία αναπαράγει ένα αρχείο
κειμένου.

## Getting Started

Main class: StartMenuView.java

## UML

<div align="center"><b>Package Diagram</b></div>

![Package Diagram](/uml/package_diagram.png)

<div align="center"><b>Class Diagram</b></div>

![Class Diagram](/uml/class_diagram.png)

## Design Patterns used

Package: commands<br/>
<b>Command Pattern</b>
<br/>
Package: encodingStategies<br/>
<b>Strategy Pattern</b>
<br/>
Package: text2SpeechAPI<br/>
<b>Adapter Pattern</b>

## Run the tests

Χρησιμοποιόντας το framework [JUnit](https://junit.org/junit5/), ελέγξαμε τις
μεθόδους από ορισμένες κλάσεις. Τα tests βρίσκονται στο package testing.

## FreeTTS

Για να αναπαραχθεί το κείμενο χρησιμοποιήθηκε το [FreeTTS](https://freetts.sourceforge.io/)
 API.

## Copyright

[![GitHub license](https://github.com/SiozosThomas/Text2SpeechEditor/blob/master/LICENSE)](https://github.com/SiozosThomas/Text2SpeechEditor/blob/master/LICENSE)
[MIT](https://github.com/SiozosThomas/Text2SpeechEditor/blob/master/LICENSE) © 2020 Thomas Siozos, Georgia Kalitsi
