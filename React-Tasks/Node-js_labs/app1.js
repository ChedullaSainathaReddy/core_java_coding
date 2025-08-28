// app.js
// ------------------------------------------------------
// Import the MySQL connection from our file
const db = require("./mysqlConnection");

// ----------------- CREATE -----------------
// Function to add a stock
function addStock(symbol, companyName, price, volume, callback) {
  const query = "INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)";
  db.query(query, [symbol, companyName, price, volume], (err, result) => {
    if (err) return callback(err);
    console.log("✅ Stock Added with ID:", result.insertId);
    callback(null, result);
  });
}

// ----------------- READ -----------------
// Function to list all stocks
function listStocks(callback) {
  const query = "SELECT * FROM stocks";
  db.query(query, (err, rows) => {
    if (err) return callback(err);
    console.log("📊 Stock List:", rows);
    callback(null, rows);
  });
}

// ----------------- UPDATE -----------------
// Function to update stock price and volume by ID
function updateStockPriceAndVolume(id, price, volume, callback) {
  const query = "UPDATE stocks SET price = ?, volume = ? WHERE id = ?";
  db.query(query, [price, volume, id], (err, result) => {
    if (err) return callback(err);
    console.log("✏️ Stock Updated ID:", id);
    callback(null, result);
  });
}

// ----------------- DELETE -----------------
// Function to delete stock by ID
function deleteStock(id, callback) {
  const query = "DELETE FROM stocks WHERE id = ?";
  db.query(query, [id], (err, result) => {
    if (err) return callback(err);
    console.log("🗑️ Stock Deleted ID:", id);
    callback(null, result);
  });
}

// ----------------- Sequential Execution -----------------
addStock("AAPL", "Apple Inc.", 175.50, 1000, (err) => {
  if (err) return console.error(err);

  // Step 2: List all stocks
  listStocks((err, stocks) => {
    if (err) return console.error(err);

    // Get first stock ID
    const stockId = stocks[0].id;

    // Step 3: Update stock
    updateStockPriceAndVolume(stockId, 180.00, 1200, (err) => {
      if (err) return console.error(err);

      // Step 4: Delete stock
      deleteStock(stockId, (err) => {
        if (err) return console.error(err);

        // Step 5: Close DB connection
        db.end();
        console.log("🔒 MySQL connection closed.");
      });
    });
  });
});
