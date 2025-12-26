import React, { Component } from "react";
import MenuItem from "./MenuItem";

class Restaurant extends Component { //Parent component
  render() {
    return (
      <div>
        <h1> Welcome to Foodie's Paradise</h1>
        <p><b>Location:</b> Hyderabad</p>
        <p><b>Open Hours:</b> 9:00 AM - 11:00 PM</p>

        <h2> Menu</h2>
        <MenuItem name="Idli" price={40} category="Breakfast" available="Yes" />
        <MenuItem name="Veg Biryani" price={180} category="Lunch" available="Yes" />
        <MenuItem name="Samosa" price={20} category="Snack" available="No" />
        <MenuItem name="Paneer Butter Masala" price={220} category="Dinner" available="Yes" />
      </div>
    );
  }
}

export default Restaurant;
//component to display one dish:
//A sub-heading for the restaurant’s menu section.
//It then renders multiple MenuItem child components, each representing a food dish with props like name, price, category, and availability.
//Restaurant so that it stores all menu items in an array and renders them using .map() instead of hardcoding each <MenuItem />
