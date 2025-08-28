// ======================================================================================
// vatCalculator.js
// Local module for calculating VAT (Value Added Tax) on jewellery items
// Enhanced: Accepts configurable VAT percentage
// ======================================================================================

// Define a default VAT percentage (3%).
// If the user doesn't pass a custom VAT, this default will be used.
const DEFAULT_VAT_PERCENT = 3;

// Define a function named calculateVAT that takes price and an optional VAT percentage.
function calculateVAT(price, vatPercent = DEFAULT_VAT_PERCENT) {
  // Calculate VAT by multiplying price × (vatPercent ÷ 100).
  let vat = (price * vatPercent) / 100;

  // Add VAT to original price to get the total.
  let totalPrice = price + vat;

  // Return both VAT and total price as an object.
  return {
    vat: vat,              // VAT amount in INR
    totalPrice: totalPrice // Price including VAT
  };
}

// Export this function so that other files (like app.js) can use it.
module.exports = calculateVAT;
