// ======================================================================================
// client.js
// Jewellery Store TCP Client using Node.js
// ======================================================================================

// 1. Import 'net' module → Helps the client connect to TCP server (like making a call).
const net = require("net");

// 2. Create client socket (phone for the customer).
const client = new net.Socket();

// 3. Connect to server → shop address: localhost (127.0.0.1), port 5000.
client.connect(5000, "127.0.0.1", () => {
  console.log("Connected to server...");
});

// 4. Event: Whenever server sends a response, show it in console.
client.on("data", (data) => {
  console.log("Server Response:\n" + data.toString());
});

// 5. Event: When connection is closed by server (EXIT).
client.on("close", () => {
  console.log("Connection closed.");
});

// 6. Event: Handle client-side errors.
client.on("error", (err) => {
  console.error("Client error:", err.message);
});

// ======================================================================================
// 7. Allow user to type commands into terminal and send them to server.
// ======================================================================================

// Import readline module → lets us type interactively in console.
const readline = require("readline");

// Create input/output interface → user types in console, server sees it.
const rl = readline.createInterface({
  input: process.stdin,  // read keyboard input
  output: process.stdout // print output to terminal
});

// Listen to every line user types.
rl.on("line", (input) => {
  // Send input to server.
  client.write(input);

  // If user typed EXIT → close input & disconnect client.
  if (input.trim().toUpperCase() === "EXIT") {
    rl.close();
    client.end();
  }
});
