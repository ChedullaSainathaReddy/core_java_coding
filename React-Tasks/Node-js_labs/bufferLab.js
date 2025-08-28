// ======================================================================================
// Lab 1: Working with Node.js Buffers
// ======================================================================================
// (These three lines are just a decorative header — they do nothing at runtime.)

// 1) CREATE A BUFFER (256 bytes filled with zeros)
// Allocate a Buffer object of length 256 bytes and fill it with zeros.
let buffer = Buffer.alloc(256); // Buffer.alloc creates a safe zero-filled buffer of given size.

// 2) WRITE DATA TO BUFFER (student #1 -> JSON string -> bytes)
// Define a JavaScript object representing student #1.
let student1 = { id: 1, name: "Thannmaya", age: 20, grade: "A" }; // JS object literal holding student data

// Convert the JavaScript object to a JSON string so it can be stored as bytes in the buffer.
let studentStr = JSON.stringify(student1); // JSON.stringify: object -> string (e.g. '{"id":1,...}')

// Write the string into the buffer starting at offset 0 and capture how many bytes were written.
let bytesWritten = buffer.write(studentStr); // buffer.write returns number of bytes actually written.
// (Note: if the string were longer than the buffer, write would write as many bytes as fit and return that count.)

// Print how many bytes we wrote into the buffer (useful to know the valid portion).
console.log("Bytes written to buffer:", bytesWritten); // shows a number, e.g. 43

// 3) READ DATA BACK (only the bytes we wrote, not the whole 256)
// Convert only the portion of the buffer we actually used back into a UTF-8 string.
// toString(encoding, startIndex, endIndex) — endIndex is exclusive.
let bufferContent = buffer.toString("utf8", 0, bytesWritten); // read only bytes [0 .. bytesWritten-1]

// Parse the JSON string back into a JavaScript object.
let parsedStudent = JSON.parse(bufferContent); // JSON.parse: string -> object

// Print a human-friendly header; "\n" starts a new line for clearer console output.
console.log("\nParsed Student Data:"); // prints a blank line then the header

// Print individual fields from the parsed object, each on its own line for readability.
console.log("Student ID :", parsedStudent.id);   // prints the id property
console.log("Name       :", parsedStudent.name); // prints the name property
console.log("Age        :", parsedStudent.age);  // prints the age property
console.log("Grade      :", parsedStudent.grade);// prints the grade property

// 4) BUFFER OPERATIONS
// (a) Append a second student if space permits
// Define a second student object.
let student2 = { id: 2, name: "Suhas", age: 22, grade: "B" }; // another student record

// Convert the second student object to a JSON string so it can be stored as bytes.
let studentStr2 = JSON.stringify(student2); // object -> JSON string

// Write the second student's string into the buffer starting at offset = bytesWritten (end of first record).
let bytesWritten2 = buffer.write(studentStr2, bytesWritten); // second arg is the write offset
// (If there isn't enough space left in the buffer this write will be truncated. bytesWritten2 is how many bytes were actually written.)

// Print the total bytes used (first record bytes + second record bytes we just wrote).
console.log("\nAppended another student. Total bytes:", bytesWritten + bytesWritten2); // sum shows used bytes

// (b) Read only the first student's slice
// Convert only the first student's bytes (0..bytesWritten) back to a string.
let firstStudentOnly = buffer.toString("utf8", 0, bytesWritten); // slice that contains first record

// Print the first student's raw JSON string (helps verify append didn't corrupt first record).
console.log("\nFirst Student Only:\n", firstStudentOnly); // prints the JSON string for student1

// (c) Copy a portion of buffer into a new buffer
// Allocate another buffer to copy data into (size 256 again to be safe).
let copyBuffer = Buffer.alloc(256); // new zero-filled buffer as copy destination

// Copy from the original buffer into copyBuffer:
// copy(targetBuffer, targetStart=0, sourceStart=0, sourceEnd=buffer.length)
buffer.copy(copyBuffer, 0, 0, bytesWritten); // copy only the first record (0..bytesWritten-1) into copyBuffer at position 0

// Convert the copied bytes in copyBuffer back to string to verify copy success and print.
console.log("\nCopied Buffer Content:", copyBuffer.toString("utf8", 0, bytesWritten)); // shows the same JSON as firstStudentOnly

// 5) ENCODING & DECODING DEMO
// Print a small header to separate encoding examples in the console.
console.log("\nEncoding Demonstration:"); // visual separator in output

// Show the bytes read as UTF-8 text (this is how we stored them originally).
console.log("Buffer content in UTF-8 :", buffer.toString("utf8", 0, bytesWritten)); // normal readable text

// Show the same bytes interpreted as ASCII (non-ASCII characters would change here).
console.log("Buffer content in ASCII :", buffer.toString("ascii", 0, bytesWritten)); // ASCII rendering

// Show the buffer content encoded as base64 — a compact ASCII-safe representation of the bytes.
console.log("Buffer content in Base64:", buffer.toString("base64", 0, bytesWritten)); // base64 string representation
