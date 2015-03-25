# 4-in-memory-file-system

Command Line Execution steps:

// creates a new dir 
java FileOperationsExecute mkdir <absoluteDirPath>
// create new file
java FileOperationsExecute create <absoluteFilePath>
// copy file from src to dest. 
java FileOperationsExecute cp <absoluteSrcFilePath>  <absoluteDestFilePath>
// Append content to the file
java FileOperationsExecute write <content>  <absoluteFilePath>
// finds file by fileName in current wordking dir
java FileOperationsExecute find <fileName>
// display file contents
java FileOperationsExecute cat <absoluteFilePath>
// display list of files in dir recursively
java FileOperationsExecute ls <absoluteDirPath>

