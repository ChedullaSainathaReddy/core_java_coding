// ======================================================================================
// app.js
// Main application that imports vatCalculator.js
// Handles multiple jewellery items and configurable VAT
// ======================================================================================

// Import the function calculateVAT from vatCalculator.js.
const calculateVAT = require("./vatCalculator");

// Define multiple jewellery items inside an array.
// Each item has id, name, and price.
let jewelleryItems = [
  { id: 1, name: "Gold Necklace", price: 50000 },
  { id: 2, name: "Silver Ring", price: 2000 },
  { id: 3, name: "Diamond Bracelet", price: 80000 }
];

// Define a custom VAT percentage (if you want to change from default 3%).
let customVAT = 5; // Example: 5% VAT instead of 3%

// Loop through each jewellery item in the array.
jewelleryItems.forEach(item => {
  // Call calculateVAT, pass item.price and customVAT.
  let result = calculateVAT(item.price, customVAT);

  // Print details of each item with VAT.
  console.log("\nJewellery ID :", item.id);     // shows id
  console.log("Name         :", item.name);     // shows name
  console.log("Price        :", item.price);    // shows original price
  console.log(`VAT (${customVAT}%) :`, result.vat); // shows VAT at chosen %
  console.log("Total Price  :", result.totalPrice); // shows final price
});
