// Importing React and required hooks
import React, { useState, useEffect } from "react";

// Functional component
export default function RestaurantForm() {
  // -----------------------------
  // 1. State for form inputs
  // -----------------------------
  const [formData, setFormData] = useState({
    restaurantName: "",   // Restaurant Name field
    ownerName: "",        // Owner Name field
    email: "",            // Email field
    contactNumber: "",    // Contact Number field
    address: "",          // Address field
    cuisineType: "",      // Cuisine Type field
    openingHours: "",     // Opening Hours field
  });

  // State to hold submitted data (for JSON display)
  const [submittedData, setSubmittedData] = useState(null);

  // -----------------------------
  // 2. useEffect → Run on every render
  // -----------------------------
  useEffect(() => {
    console.log("Component rendered!"); // Logs whenever component re-renders
  });

  // -----------------------------
  // 3. useEffect → Run only once (on mount)
  // -----------------------------
  useEffect(() => {
    console.log("Restaurant Registration Form Mounted"); // Runs only on first load
  }, []); // Empty dependency → only runs once

  // -----------------------------
  // 4. useEffect → Run when formData changes
  // -----------------------------
  useEffect(() => {
    console.log("Form data changed:", formData); // Logs whenever user types in the form
  }, [formData]); // Dependency → runs whenever formData is updated

  // -----------------------------
  // 5. useEffect → Auto-save every 5 seconds
  // -----------------------------
  useEffect(() => {
    // Start an interval timer
    const interval = setInterval(() => {
      console.log("Auto-saving data:", formData); // Show saving log
      localStorage.setItem("restaurantForm", JSON.stringify(formData)); // Save to browser storage
    }, 5000);

    // Cleanup function → clears old interval before setting a new one
    return () => clearInterval(interval);
  }, [formData]); // Runs whenever formData changes

  // -----------------------------
  // 6. Handle input changes
  // -----------------------------
  const handleChange = (e) => {
    const { name, value } = e.target; // Extract input name and value
    setFormData({ ...formData, [name]: value }); // Update specific field in formData
  };

  // -----------------------------
  // 7. Handle form submission
  // -----------------------------
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevents page reload
    setSubmittedData(formData); // Save final formData to submittedData
  };

  // -----------------------------
  // 8. UI (JSX)
  // -----------------------------
  return (
    <div style={{ margin: "20px" }}>
      <h2>Restaurant Registration Form</h2>

      {/* Form starts */}
      <form onSubmit={handleSubmit}>
        {/* Restaurant Name */}
        <div>
          <label>Restaurant Name: </label>
          <input
            type="text"
            name="restaurantName"
            value={formData.restaurantName}
            onChange={handleChange}
            required
          />
        </div>

        {/* Owner Name */}
        <div>
          <label>Owner Name: </label>
          <input
            type="text"
            name="ownerName"
            value={formData.ownerName}
            onChange={handleChange}
            required
          />
        </div>

        {/* Email */}
        <div>
          <label>Email: </label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>

        {/* Contact Number */}
        <div>
          <label>Contact Number: </label>
          <input
            type="tel"
            name="contactNumber"
            value={formData.contactNumber}
            onChange={handleChange}
            required
          />
        </div>

        {/* Address */}
        <div>
          <label>Address: </label>
          <textarea
            name="address"
            value={formData.address}
            onChange={handleChange}
            required
          />
        </div>

        {/* Cuisine Type */}
        <div>
          <label>Cuisine Type: </label>
          <input
            type="text"
            name="cuisineType"
            value={formData.cuisineType}
            onChange={handleChange}
            required
          />
        </div>

        {/* Opening Hours */}
        <div>
          <label>Opening Hours: </label>
          <input
            type="text"
            name="openingHours"
            value={formData.openingHours}
            onChange={handleChange}
            placeholder="e.g., 10 AM - 11 PM"
            required
          />
        </div>

        {/* Submit Button */}
        <button type="submit">Submit</button>
      </form>

      {/* Show JSON output only after submission */}
      {submittedData && (
        <div style={{ marginTop: "20px" }}>
          <h3>Submitted Data (JSON):</h3>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}
