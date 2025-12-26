const mysql = require("mysql2");

const connection = mysql.createConnection({
  host: "localhost",
  user: "root",              // default MySQL user
  password: "20082001",      // 🔑 your MySQL Workbench password
  database: "stock_market"   // the DB you created
});

connection.connect((err) => {
  if (err) {
    console.error("❌ Connection failed:", err);
  } else {
    console.log("✅ MySQL Connected!");
  }
});

module.exports = connection;
