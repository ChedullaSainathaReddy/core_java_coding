import React, { Component } from "react";

// Declares a class named MenuItem that inherits from React.Component
class MenuItem extends Component {
  render() {
    // Destructures properties from this.props for concise access
    const { name, price, category, available } = this.props;

    return (
      // A container <div> with inline styles (border, margin, padding, rounded corners)
      <div style={{ border: "1px solid gray", margin: "8px", padding: "10px", borderRadius: "5px" }}>
        <h3>{name}</h3> {/* Displays the menu item name */}
        <p><b>Category:</b> {category}</p> {/* Shows category */}
        <p><b>Price:</b> ₹{price}</p> {/* Shows price with rupee symbol */}
        <p><b>Available:</b> {available}</p> {/* Shows availability */}
      </div>
    );
  }
}

// Exports MenuItem so it can be used in other files
export default MenuItem;
