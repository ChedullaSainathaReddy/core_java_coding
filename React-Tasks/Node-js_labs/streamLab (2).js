// ======================================================================================
// Lab 2: Working with Node.js Streams
// Objective: Learn to use Node.js streams to read, write, and manipulate data efficiently.
// ======================================================================================

// Import the Node.js "fs" module (file system) so we can work with files and streams.
const fs = require("fs"); // fs = file system (built-in module in Node.js)

// --------------------------------------------------------------------------------------
// 1. CREATE A WRITABLE STREAM
// --------------------------------------------------------------------------------------

// Create a writable stream for a new file "fruits.txt".
// "utf8" means the text we write will be encoded as UTF-8 characters.
let writeStream = fs.createWriteStream("fruits.txt", { encoding: "utf8" });

// Prepare fruit data (array of objects).
let fruits = [
  { id: 1, name: "Apple", color: "Red", price: 120 },
  { id: 2, name: "Banana", color: "Yellow", price: 40 },
  { id: 3, name: "Mango", color: "Orange", price: 150 }
];

// Write fruit records to the stream, one by one, as JSON strings.
// JSON.stringify converts each fruit object → string, then add a newline ("\n") to separate lines.
fruits.forEach(fruit => {
  writeStream.write(JSON.stringify(fruit) + "\n"); // writing to fruits.txt
});

// Close the stream once writing is done.
writeStream.end(); // very important! signals no more data will be written

// Print a message once the file is successfully written.
writeStream.on("finish", () => {
  console.log("Data written to fruits.txt successfully.");
});

// --------------------------------------------------------------------------------------
// 2. CREATE A READABLE STREAM
// --------------------------------------------------------------------------------------

// Create a readable stream to read fruits.txt.
let readStream = fs.createReadStream("fruits.txt", { encoding: "utf8" });

// Variable to accumulate chunks of data while reading.
let data = "";

// "data" event fires whenever a chunk of data is read.
readStream.on("data", chunk => {
  data += chunk; // accumulate chunks into one string
});

// "end" event fires when the file has been completely read.
readStream.on("end", () => {
  console.log("\nReading from fruits.txt using stream:");

  // Split data into lines (each line contains one JSON fruit string).
  let lines = data.trim().split("\n");

  // Parse each line back into an object and display it.
  lines.forEach(line => {
    let fruit = JSON.parse(line); // string → object
    console.log(`Fruit ID: ${fruit.id}`);
    console.log(`Name   : ${fruit.name}`);
    console.log(`Color  : ${fruit.color}`);
    console.log(`Price  : ${fruit.price}`);
    console.log(); // blank line for readability
  });
});

// --------------------------------------------------------------------------------------
// 3. PIPE STREAMS
// --------------------------------------------------------------------------------------

// Create another writable stream for fruits_copy.txt.
let copyStream = fs.createWriteStream("fruits_copy.txt");

// Use the pipe() method to copy contents from fruits.txt → fruits_copy.txt.
// readStream = source, copyStream = destination.
let copyReadStream = fs.createReadStream("fruits.txt");
copyReadStream.pipe(copyStream); // pipe automatically handles data transfer

// Print message when copying finishes.
copyStream.on("finish", () => {
  console.log("Data copied to fruits_copy.txt successfully.");
});

// --------------------------------------------------------------------------------------
// 4. STREAM EVENTS (error handling)
// --------------------------------------------------------------------------------------

// Handle possible errors on the read stream.
readStream.on("error", err => {
  console.error("Error while reading fruits.txt:", err.message);
});

// Handle possible errors on the write stream.
writeStream.on("error", err => {
  console.error("Error while writing fruits.txt:", err.message);
});
