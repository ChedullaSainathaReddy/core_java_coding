// ======================================================================================
// server.js
// Jewellery Store TCP Server using Node.js
// ======================================================================================

// 1. Import the 'net' module → It helps us build a TCP server.
// Think of 'net' like the telephone operator that connects callers (clients) to the shop (server).
const net = require("net");

// 2. Store jewellery items in memory.
// This is like a small shelf inside the shop where items are kept temporarily.
// Array of objects → Each object = 1 jewellery item.
let jewelleryItems = [
  { id: 1, name: "Gold Ring", quantity: 5, price: 15000 },   // Item 1
  { id: 2, name: "Silver Necklace", quantity: 2, price: 5000 } // Item 2
];

// 3. Create the TCP server.
// net.createServer() = opens the shop’s main door for customers (clients).
// 'socket' is like the private phone line between server and one client.
const server = net.createServer((socket) => {
  console.log("Client connected..."); // Inform shopkeeper that a customer has entered.

  // 4. Send a welcome message to client → Like shopkeeper greeting.
  socket.write("Welcome to Jewellery Store TCP Server!\n");
  socket.write("Available Commands: LIST, ADD <id> <name> <qty> <price>, EXIT\n\n");

  // 5. Handle incoming data (what the customer says).
  socket.on("data", (data) => {
    // Convert the incoming raw Buffer to string, and trim spaces/newlines.
    const input = data.toString().trim();

    // Break the input into words for easier processing.
    // Example: "ADD 3 Ring 2 20000" → ["ADD", "3", "Ring", "2", "20000"]
    const parts = input.split(" ");
    const command = parts[0].toUpperCase(); // First word is command → LIST / ADD / EXIT

    // -------------------- Handle LIST command --------------------
    if (command === "LIST") {
      // If no items, tell the client shelf is empty.
      if (jewelleryItems.length === 0) {
        socket.write("No jewellery items available.\n");
      } else {
        // Otherwise list all jewellery items nicely.
        socket.write("Jewellery Items:\n");
        jewelleryItems.forEach(item => {
          socket.write(
            `ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}, Price: ${item.price}\n`
          );
        });
      }
    } 
    // -------------------- Handle ADD command --------------------
    else if (command === "ADD") {
      // Format must be → ADD <id> <name> <quantity> <price>
      if (parts.length < 5) {
        socket.write("Usage: ADD <id> <name> <quantity> <price>\n");
      } else {
        // Convert strings to numbers where needed.
        let id = parseInt(parts[1]);
        let name = parts[2];
        let quantity = parseInt(parts[3]);
        let price = parseInt(parts[4]);

        // Add the new item to our shelf (array).
        jewelleryItems.push({ id, name, quantity, price });

        // Confirm success to client.
        socket.write(`Jewellery item '${name}' added successfully!\n`);
      }
    } 
    // -------------------- Handle EXIT command --------------------
    else if (command === "EXIT") {
      // Say goodbye and close the connection (shop is closing for that client).
      socket.write("Goodbye!\n");
      socket.end();
    } 
    // -------------------- Handle Invalid command --------------------
    else {
      // If client typed nonsense → politely correct them.
      socket.write("Invalid command! Use LIST, ADD, or EXIT.\n");
    }
  });

  // 6. Event: When client disconnects.
  socket.on("end", () => {
    console.log("Client disconnected."); // Shopkeeper waves goodbye.
  });

  // 7. Event: Handle error (like bad network or unexpected crash).
  socket.on("error", (err) => {
    console.error("Socket error:", err.message);
  });
});

// 8. Start the server at port 5000.
// Think of port like the shop’s address → customers must dial this number to connect.
server.listen(5000, () => {
  console.log("TCP Jewellery Store Server running on port 5000...");
});
