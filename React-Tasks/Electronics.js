import React, { useState } from "react";  //useState is a React Hook that lets you add state (variables that can change) to functional components

const Electronics = () => { //functional components that return jsx
  // multiple useState hooks
  const [name] = useState("Laptop");//Creates a state variable called name with initial value "Laptop".
  const [brand, setBrand] = useState("Dell");//setBrand is the function you’ll call to update the brand.
  const [price, setPrice] = useState(50000);

  // function to update brand
  const updateBrand = () => {
    setBrand("HP"); // When called, it updates the brand to "HP" by using the setter setBrand
  };

  // function to increase price
  const increasePrice = () => {
    setPrice(price + 5000); // increase price by 5000
  };

  return (
    <div>
      <h2> Electronics Item</h2>
      <p><b>Name:</b> {name}</p>
      <p><b>Brand:</b> {brand}</p>
      <p><b>Price:</b> ₹{price}</p>

      <button onClick={updateBrand}>Update Brand</button>
      
      <button onClick={increasePrice} style={{ marginLeft: "10px" }}> 
        Increase Price
      </button>
    </div>
  );
};

export default Electronics;
//adds inline CSS to create spacing between the two buttons.


