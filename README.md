# About 

** Getting on-line stock quotes from Yahoo **

This Lab is to write a program that uses the URL class to create a reference to finance.yahoo.com/q. You provide the symbol for a specific stock in your command line. Your program could apply openConnection() method to the URL which underneath creates a socket connection to the URL.
Send the name/value pair (i.e., s=ibm) to the URLConnection as the yahoo site expects. Then read the returned information which is in the format described above. Parse and extract the characters of interest that is the price between <b> and </b> on a line with more than 25 chars. Print out the result on the screen as:
ibm is at 101.28

