import React, { useState } from "react";                  // Import React and the useState hook for local state

// ✅ Chair Component
const Chair = ({ item }) => (                             // Define a functional component 'Chair' that receives 'item' prop
  <div className="card p-3 m-3 shadow">                   {/* A styled container (Bootstrap utility classes, optional) */}
    <h3>🪑 {item.name}</h3>                               {/* Show an emoji + chair name from the item prop */}
    <p><b>Price:</b> ₹{item.price}</p>                   
    <p><b>Material:</b> {item.material}</p>               
    <p><b>Size:</b> {item.size}</p>                       
    <p><b>Brand:</b> {item.brand}</p>                     
  </div>
);

// ✅ Table Component
const Table = ({ item }) => (                             // Define 'Table' component that also takes an 'item' prop
  <div className="card p-3 m-3 shadow">                   {/* Reuse the same card styling */}
    <h3>🛋️ {item.name}</h3>                              {/* Heading for table (emoji is decorative only) */}
    <p><b>Price:</b> ₹{item.price}</p>                  
    <p><b>Material:</b> {item.material}</p>             
    <p><b>Size:</b> {item.size}</p>                     
    <p><b>Brand:</b> {item.brand}</p>                   
  </div>
);

// ✅ Sofa Component
const Sofa = ({ item }) => (                              // Define 'Sofa' component with 'item' prop
  <div className="card p-3 m-3 shadow">                   {/* Same card layout */}
    <h3>🛋️ {item.name}</h3>                              {/* Sofa label +   */}
    <p><b>Material:</b> {item.material}</p>               
    <p><b>Size:</b> {item.size}</p>                      
    <p><b>Brand:</b> {item.brand}</p>                   
  </div>
);

// ✅ Bed Component
const Bed = ({ item }) => (                               // Define 'Bed' component with 'item' prop
  <div className="card p-3 m-3 shadow">                  
    <h3>🛏️ {item.name}</h3>                             
    <p><b>Price:</b> ₹{item.price}</p>                    
    <p><b>Material:</b> {item.material}</p>             
    <p><b>Size:</b> {item.size}</p>                      
    <p><b>Brand:</b> {item.brand}</p>                    
  </div>
);

// ✅ Switch–case rendering function
const renderFurniture = (type, item) => {                 // A helper that returns the correct component based on 'type'
  switch (type) {                                         // Choose which component to render
    case "Chair":                                         // If type is 'Chair'
      return <Chair item={item} />;                       // Render Chair with the provided item
    case "Table":                                        
      return <Table item={item} />;                      
    case "Sofa":                                        
      return <Sofa item={item} />;                        
    case "Bed":                                          
      return <Bed item={item} />;                        
    default:                                              // Fallback if no type matches
      return <p>Please select a furniture type.</p>;      // Show a simple instruction message
  }
};

// ✅ App Component
const App = () => {                                       // Root component
  const [selected, setSelected] = useState("");           // State: which furniture type is currently selected (empty = none)

  // Sample furniture data
  const furnitureData = {                                 // A lookup object: keys are types, values are item details
    Chair: { name: "Wooden Chair",                        // Chair: name field
             price: 2500,                               
             material: "Teak Wood",                       
             size: "Medium",                            
             brand: "UrbanLadder" },                     
    Table: { name: "Dining Table",                      
             price: 12000,                               
             material: "Sheesham Wood",                  
             size: "6-Seater",                          
             brand: "Ikea" },                            
    Sofa:  { name: "Leather Sofa",                       
             price: 30000,                              
             material: "Leather",                    
             size: "3-Seater",                         
             brand: "Godrej" },                          
    Bed:   { name: "King Size Bed",                 
             price: 45000,                               
             material: "Engineered Wood",                
             size: "King",                               
             brand: "Pepperfry" }                       
  };

  return (                                                // Start of JSX to render
    <div className="container mt-5">                      {/* Outer container with top margin (Bootstrap classes) */}
      <h2 className="mb-3">🏠 Furniture Store</h2>        {/* Page title with spacing */}

      {/* Dropdown for selection */}
      <select                                            // Native HTML <select> for choosing a furniture type
        className="form-select w-50 mb-4"                // Styling: form-select look, 50% width, margin bottom
        value={selected}                                  // Controlled component: its value mirrors 'selected' state
        onChange={(e) => setSelected(e.target.value)}     // When user picks an option, update 'selected' state
      >
        <option value="">-- Select Furniture --</option>  {/* Placeholder option (empty value = none selected) */}
        <option value="Chair">Chair</option>             
        <option value="Table">Table</option>             
        <option value="Sofa">Sofa</option>              
        <option value="Bed">Bed</option>                
      </select>

      {/* Render based on switch–case */}
      {selected && renderFurniture(selected, furnitureData[selected])}
      {/* Short-circuit render: if 'selected' is non-empty, call renderFurniture with the matching data */}
    </div>
  );
};

export default App;                                       
