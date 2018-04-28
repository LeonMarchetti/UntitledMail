#UntitledMail
Projecto básico para enviar mails usando el servidor SMTP de Gmail. 

##Primeros Pasos
* Descargar la librería JavaMail (por ej. desde [Maven Repository](http://mvnrepository.com)) y agregarla al Build Path.
* Convertir proyecto en proyecto Maven.
* Agregar la dependencia Maven:
    * groupId: com.sun.mail
    * artifactId: javax.mail
* En src/Main.java modificar:
    * usuario y contraseña para la cuenta de Gmail desde la cual se va a enviar el mail;
    * la dirección de mail a la cual se va a enviar el mail.

##Notas
Sirvió para enviar un e-mail desde una cuenta de Gmail a una de Hotmail.
