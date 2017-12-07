This Java exercise was made under assignment of one software development company.
The following requirements for functionality were presented:
1. The application has to be able to read N text files from some directory. The text files
contain English words (English alphabet).
2. The application has to calculate how many times each word appears in all files.
3. The result (a word and its number of appearances) should be written in four output files:
	3.1 words starting with letters A-G;
	3.2 words starting with letters H-N;
	3.3 words starting with letters O-U;
	3.4 words starting with letters V-Z;
4. The application has to use multiple thread technology.

This application was made using Eclipse Neon3 IDE.

Input files are recognized according their extension - txt.
The input files have be located in the main project directory.
The path of input text files should be found automatically (one directory up from "src").

Result files are:
CountedFile_A-G.out
CountedFile_H-N.out
CountedFile_O-U.out
CountedFile_V-Z.out

The entry point of the application (main method) is located in:
lt.and.pac.textwordcounter -> TextWordCounter