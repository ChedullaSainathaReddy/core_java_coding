// Import required packages
const mysql = require("mysql2");
const readline = require("readline");

// MySQL connection
const db = mysql.createConnection({
  host: "localhost",
  user: "root",        // change if different
  password: "20082001",    // your MySQL password
  database: "stock_market"
});

// Connect to database
db.connect((err) => {
  if (err) throw err;
  console.log("Connected to MySQL database!");
  mainMenu();
});

// Setup readline for console input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Main Menu
function mainMenu() {
  console.log(`
  Stock Market Management System
  ------------------------------
  1. Add Stock
  2. View All Stocks
  3. View Stock By ID
  4. Update Stock Price & Volume
  5. Delete Stock
  6. Exit
  `);

  rl.question("Enter your choice: ", (choice) => {
    switch (choice) {
      case "1": addStock(); break;
      case "2": viewAllStocks(); break;
      case "3": viewStockById(); break;
      case "4": updateStock(); break;
      case "5": deleteStock(); break;
      case "6": exitApp(); break;
      default: console.log("Invalid choice, try again."); mainMenu();
    }
  });
}

// 1. Add Stock
function addStock() {
  rl.question("Enter Stock Symbol: ", (symbol) => {
    rl.question("Enter Company Name: ", (companyName) => {
      rl.question("Enter Price: ", (price) => {
        rl.question("Enter Volume: ", (volume) => {
          if (!symbol || !companyName || isNaN(price) || isNaN(volume)) {
            console.log("Invalid input!");
            return mainMenu();
          }
          const query = "INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)";
          db.query(query, [symbol, companyName, parseFloat(price), parseInt(volume)], (err) => {
            if (err) throw err;
            console.log("Stock added successfully!");
            mainMenu();
          });
        });
      });
    });
  });
}

// 2. View All Stocks
function viewAllStocks() {
  db.query("SELECT * FROM stocks", (err, results) => {
    if (err) throw err;
    console.table(results);
    mainMenu();
  });
}

// 3. View Stock By ID
function viewStockById() {
  rl.question("Enter Stock ID: ", (id) => {
    db.query("SELECT * FROM stocks WHERE id = ?", [id], (err, results) => {
      if (err) throw err;
      if (results.length === 0) {
        console.log("No stock found with that ID.");
      } else {
        console.table(results);
      }
      mainMenu();
    });
  });
}

// 4. Update Stock
function updateStock() {
  rl.question("Enter Stock ID: ", (id) => {
    rl.question("Enter New Price: ", (price) => {
      rl.question("Enter New Volume: ", (volume) => {
        if (isNaN(price) || isNaN(volume)) {
          console.log("Invalid input!");
          return mainMenu();
        }
        const query = "UPDATE stocks SET price = ?, volume = ? WHERE id = ?";
        db.query(query, [parseFloat(price), parseInt(volume), id], (err) => {
          if (err) throw err;
          console.log("Stock updated successfully!");
          mainMenu();
        });
      });
    });
  });
}

// 5. Delete Stock
function deleteStock() {
  rl.question("Enter Stock ID: ", (id) => {
    const query = "DELETE FROM stocks WHERE id = ?";
    db.query(query, [id], (err) => {
      if (err) throw err;
      console.log("Stock deleted successfully!");
      mainMenu();
    });
  });
}

// 6. Exit
function exitApp() {
  console.log("Exiting... Goodbye!");
  rl.close();
  db.end();
}
