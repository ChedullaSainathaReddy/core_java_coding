// server1.js
// ---------------------------------------
// Import Express (web framework for Node.js)
const express = require("express");

// Create an app instance from express
const app = express();

// Middleware to parse form data (from POST requests)
// express.urlencoded converts form data into JS object
app.use(express.urlencoded({ extended: true }));

// Import path module (used to work with file paths)
const path = require("path");

// Route: When user goes to home page "/" → show index.html form
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html")); 
  // __dirname gives current folder path
  // path.join combines folder path + filename
  // res.sendFile sends the HTML file to browser
});

// Route: When form is submitted → POST request to "/submit"
app.post("/submit", (req, res) => {
  // Extract data from request body
  // req.body contains form fields (because of middleware)
  const { trackingId, senderName, receiverName, pickupAddress, deliveryAddress, weight } = req.body;

  // Convert weight to a number (comes as string)
  const wt = parseFloat(weight);

  // Calculate delivery cost = 50 + (weight * 20)
  const cost = 50 + (wt * 20);

  // Create confirmation message using template literal
  const message = `
    <h2>Courier Booking Confirmed ✅</h2>
    <p><b>Courier Tracking ID:</b> ${trackingId}</p>
    <p><b>Sender:</b> ${senderName}</p>
    <p><b>Receiver:</b> ${receiverName}</p>
    <p><b>Pickup Address:</b> ${pickupAddress}</p>
    <p><b>Delivery Address:</b> ${deliveryAddress}</p>
    <p><b>Weight:</b> ${wt} kg</p>
    <p><b>Delivery Cost:</b> ₹${cost}</p>
  `;

  // Send confirmation message back to browser
  res.send(message);
});

// Start server at port 3000
// http://localhost:3000 will open the app
app.listen(3000, () => {
  console.log("Server running at http://localhost:3000");
});
