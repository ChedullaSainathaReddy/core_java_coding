import React from "react";
import Juice from "./Juice"; 
// Imports the Juice component (child component that renders each row)

const JuiceList = () => {
  // Creates an array of juice objects
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 }
  ];

  return (
    <div>
      <h2>Juice Menu</h2>

      {/* Creates a table with border and padding */}
      <table border="1" cellPadding="10">
        {/* Table header */}
        <thead>
          <tr>
            <th>ID</th> {/* Header for ID */}
            <th>Juice Name</th> {/* Header for Name */}
            <th>Price</th> {/* Header for Price */}
          </tr>
        </thead>

        {/* Table body */}
        <tbody>
          {/* Loop through juices array, return a Juice component for each item */}
          {juices.map((juice) => (
            <Juice
              key={juice.id}   // Unique key for each row
              id={juice.id}    // Passes ID as prop
              name={juice.name} // Passes Name as prop
              price={juice.price} // Passes Price as prop
            />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;
