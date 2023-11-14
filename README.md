# COSC450A2

CHECK OFF STEPS WHEN COMPLETED 

COSC 450				Assignment 2					Fall 2023
Due Friday Nov 17, 11:59 pm. This is a group assignment.
Save the client code in GroupNameA2Client.java and the server code in GroupNameA2Server.java and submit these files.
Do all GPG4Win operations below manually. 
1.	Use GPG4Win to create OpenPGP certificates for the client and the server
2.	The server listens on port 12123 for a TCP connection from the client (use Java sockets)
3.	The client prints “Sending public key”
4.	The client sends its .asc public key file to the server over the socket

   NEED TO DO:
6.	The server receives the public key file, prints and saves it
7.	The server prints “Received public key”
8.	The server prints “Sending public key”
9.	The server sends its .asc public key file to the client over the socket
10.	The client receives the public key file, prints and saves it
11.	The client prints “Received public key”
12.	The client prints “Enter message” and reads the message entered by the user
13.	The client saves the message in a file message.txt
14.	Use GPG4Win to sign and encrypt the message.txt file
15.	The client prints “Sending message”
16.	The client sends the signed encrypted message to the server
17.	The server receives the signed encrypted file, prints and saves it
18.	The server prints “Received message”
19.	Use GPG4Win to decrypt/verify the signed encrypted message file and save the decrypted verified file as results.txt.
