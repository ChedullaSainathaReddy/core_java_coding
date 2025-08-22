// Import React and the useState hook from the React library
import React, { useState } from "react";

// =======================
// Child A: shows fruit list and lets user select one
// =======================
function ChildA({ fruits, onSelect }) { // Receive props: 'fruits' (array) and 'onSelect' (callback)
  return (
    <div style={{ margin: "10px", padding: "10px", border: "1px solid black" }}> {/* Simple box styling */}
      <h3>Child A: Fruit List</h3> {/* Title for this child */}
      <ul> {/* Unordered list to display fruits */}
        {
          // Map over the fruits array to render each fruit as a clickable <li>
          fruits.map((fruit, index) => (
            <li
              key={index}                            // React key to help list rendering (index OK for static/simple lists)
              onClick={() => onSelect(fruit)}        // When a fruit is clicked, notify parent with selected fruit
              style={{ cursor: "pointer" }}          // Make it look clickable
            >
              {fruit}                                 {/* Show the fruit name */}
            </li>
          ))
        }
      </ul>
      <p>(Click a fruit to select it)</p> {/* Little UX hint */}
    </div>
  );
}

// =======================
// Child B: sends a new fruit to the parent when button is clicked
// =======================
function ChildB({ addFruit }) {           // Receive 'addFruit' callback from parent
  return (
    <div style={{ margin: "10px", padding: "10px", border: "1px solid black" }}> {/* Simple box styling */}
      <h3>Child B</h3>                    {/* Title */}
      <button onClick={() => addFruit("Orange")}> {/* On click, ask parent to add "Orange" */}
        Send Fruit (Orange)
      </button>
    </div>
  );
}

// =======================
// Child C: displays whichever fruit is currently selected
// =======================
function ChildC({ selectedFruit }) {      // Receive 'selectedFruit' value from parent
  return (
    <div style={{ margin: "10px", padding: "10px", border: "1px solid black" }}> {/* Simple box styling */}
      <h3>Child C</h3>                    {/* Title */}
      {
        // If selectedFruit exists, show it; otherwise show a fallback message
        selectedFruit
          ? <p>Selected Fruit: <b>{selectedFruit}</b></p>
          : <p>No fruit selected yet</p>
      }
    </div>
  );
}

// =======================
// Parent component: holds source of truth (state) and passes props/callbacks to children
// =======================
export default function Parent() {
  // Parent state for the fruit list; starts with Apple and Mango as required
  const [fruits, setFruits] = useState(["Apple", "Mango"]);

  // Parent state for the currently selected fruit (used to feed Child C)
  const [selectedFruit, setSelectedFruit] = useState("");

  // Callback passed to Child B: adds a new fruit to the list in parent state
  const addFruit = (fruit) => {
    setFruits([...fruits, fruit]);        // Create a new array (immutable update) appending the new fruit
  };

  // Callback passed to Child A: updates which fruit is selected (used by Child C)
  const handleSelect = (fruit) => {
    setSelectedFruit(fruit);              // Store selected fruit in parent state
  };

  // Render the parent and all three children, wiring props for communication patterns
  return (
    <div style={{ margin: "20px" }}>      {/* Outer container with spacing */}
      <h2>Parent Component</h2>           {/* Title of parent */}
      <p>Fruits in Parent: {fruits.join(", ")}</p> {/* Show current fruit list in parent (Apple, Mango, ... ) */}

      {/* Parent → Child (props): give Child A the fruit list and a selection callback */}
      <ChildA fruits={fruits} onSelect={handleSelect} />

      {/* Child → Parent: give Child B a function it can call to add "Orange" to the list */}
      <ChildB addFruit={addFruit} />

      {/* Sibling → Sibling via Parent: Child C reads selectedFruit that Child A set through parent */}
      <ChildC selectedFruit={selectedFruit} />
    </div>
  );
}
