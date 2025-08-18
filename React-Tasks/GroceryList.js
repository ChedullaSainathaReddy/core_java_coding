import React from "react";

const GroceryList = ({ items }) => {//({ items }) uses object destructuring to directly extract items from props.
  return (
    <div>    
      <h2> Grocery List</h2>
      <ul>
        {items.map((item, index) => (//iterates through the items array.
          <li key={index}>{item}</li> // unique key using index
        ))}
      </ul>
      <button onClick={() => alert("Groceries Added to Cart!")}> 
      </button>
    </div>
  );
};

export default GroceryList;
// //SX (<div>...</div>) compiles into React function calls, so React must be available.
//When the button is clicked, an arrow function runs.
        

