import React from "react";
import JuiceList from "./JuiceList";
import GroceryList from "./GroceryList";
import Car from "./Car";
import Phone from "./Phone";
import SweetsList from "./SweetsList"; 
import Electronics from "./Electronics";
import Restaurant from "./Restaurant";
import TempleList from "./TempleList";
import "bootstrap/dist/css/bootstrap.min.css";
import TailorShop from "./TailorShop";

function App() {
   const groceryItems = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];
  return (
    <div>
      <h1>React Practice</h1>
      <JuiceList />
       <h1>Grocery Store </h1>
      <GroceryList items={groceryItems} />
        <h1>Welcome to Car Showroom </h1>
        {/* Passing props to Car */}
        <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
         <h1>React Practice</h1>
      <Phone />
       <h1>Welcome to Sweet Shop </h1>
      <SweetsList />
      <Electronics />
        <Restaurant />
        <TempleList />
         <TailorShop />
    </div>
  );
}

export default App