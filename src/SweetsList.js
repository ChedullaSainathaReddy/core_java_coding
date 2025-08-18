import React from "react";

const SweetsList = () => {
  // Array of sweets as JSON objects
  const sweets = [
    { id: 1, name: "Gulab Jamun", price: 20 },
    { id: 2, name: "Rasgulla", price: 25 },
    { id: 3, name: "Kaju Katli", price: 40 },
    { id: 4, name: "Laddu", price: 15 },
    { id: 5, name: "Jalebi", price: 30 },
  ];

  return (
    <div>
      <h2> Sweets List</h2>
      {sweets.map((sweet) => (
        <p key={sweet.id}>
          {sweet.name} - Price: ₹{sweet.price}
        </p>
      ))}
    </div>
  );
};

export default SweetsList;
