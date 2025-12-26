import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const BakingItemsForm = () => {
  // Creates a state variable formData and its setter setFormData for the form fields
  const [formData, setFormData] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake",
  });

  //  Store for submitted items list initially an empty array.
  const [items, setItems] = useState([]);

  //Declares an event handler for any form input change.
  const handleChange = (e) => {
    const { name, value } = e.target;//Extracts name and value from the input that triggered the event.
    setFormData({ ...formData, [name]: value });//updates only the field that changed
  };

  //  Handle form submit
  const handleSubmit = (e) => {
    e.preventDefault();
    // Add formData to items array
    setItems([...items, formData]);

    // Reset form after submission
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake",
    });
  };

  return (
    <div className="container mt-5">
      <div className="card shadow p-4">
        <h2 className="text-center text-primary mb-4">🍰 Baking Items Form</h2>

        {/* Baking Form */}
        <form onSubmit={handleSubmit}>
          {/* Item Name */}
          <div className="form-group mb-3">
            <label>Item Name:</label>
            <input
              type="text"
              className="form-control"
              name="itemName"//ties it to formData.itemName.
              value={formData.itemName}
              onChange={handleChange}
              placeholder="Enter Item Name"
              required
            />
          </div>

          {/* New form group and label for quantity. */}
          <div className="form-group mb-3">
            <label>Quantity:</label>
            <input
              type="number"//Controlled input for quantity
              className="form-control"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
              placeholder="Enter Quantity"
              required
            />
          </div>

          {/* Ingredients */}
          <div className="form-group mb-3">
            <label>Ingredients:</label>
            <input
              type="text"//Controlled text input for ingredients.
              className="form-control"
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChange}
              placeholder="Enter Ingredients"
              required
            />
          </div>

          {/* Baking Time */}
          <div className="form-group mb-3">
            <label>Baking Time (in minutes):</label>
            <input
              type="number"
              className="form-control"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChange}
              placeholder="Enter Baking Time"
              required
            />
          </div>

          {/* Category */}
          <div className="form-group mb-3">
            <label>Category:</label>
            <select
              className="form-control"
              name="category"
              value={formData.category}//Controlled select element bound to formData.category.
              onChange={handleChange}
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          {/* Full-width green submit button that triggers the form’s onSubmit. */}
          <button type="submit" className="btn btn-success w-100">
            Add Item
          </button>
        </form>
      </div>

      {/* Table to Display Items */}
      {items.length > 0 && (//only show the table if there’s at least one submitted item.
        <div className="card shadow p-4 mt-4">
          <h3 className="text-center text-success mb-3">📋 Baking Items List</h3>
          <table className="table table-bordered table-striped">
            <thead className="table-dark">{/*Table header row with column titles; dark styling.*/}
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {items.map((item, index) => (
                <tr key={index}>{/*Table row it give a react key*/}
                  <td>{index + 1}</td>{/*Serial number column (1-based index).*/}
                  <td>{item.itemName}</td>{/*Cells showing each property of the item.*/}
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime} mins</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default BakingItemsForm;
