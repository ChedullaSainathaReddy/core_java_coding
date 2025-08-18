import React, { useState } from "react";

const Phone = () => {
  // useState for phone details
  const [phone, setPhone] = useState({
    brand: "Samsung",
    model: "Galaxy S23",
    price: 60000,
  });

  // function to update price
  const increasePrice = () => {
    setPhone({ ...phone, price: phone.price + 5000 }); // increase price
  };

  return (
    <div>
      <h2> Phone Details</h2>
      <p><b>Brand:</b> {phone.brand}</p>
      <p><b>Model:</b> {phone.model}</p>
      <p><b>Price:</b> ₹{phone.price}</p>

      <button onClick={increasePrice}>Increase Price</button>
    </div>
  );
};

export default Phone;
