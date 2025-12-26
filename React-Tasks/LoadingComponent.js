import React, { useState, useEffect } from "react";

// ✅ Loading Component
const LoadingComponent = () => (
  <div className="alert alert-info">Loading product details...</div>
);

// ✅ Error Component
const ErrorComponent = () => (
  <div className="alert alert-danger">
    ⚠️ Error fetching product details
  </div>
);

// ✅ Product Component
const ProductComponent = ({ product }) => {
  return (
    <div className="card p-3 m-3 shadow">
      <h3>{product.name}</h3>  {/* Show product name from props */}
      <p>
        <b>Brand:</b> {product.brand}
      </p>
      <p>
        <b>Price:</b> ₹{product.price}{" "} {/* Show price with ₹ symbol; {" "} forces a space in JSX */}
        {product.price > 50000 ? (// decide Premium vs Budget by price
          <span className="badge bg-warning">Premium Product</span>
        ) : (
          <span className="badge bg-success">Budget Product</span>
        )}
      </p>
      <p>
        <b>Warranty:</b>{" "}
        {product.warranty > 0//Template string inserts the number dynamically
          ? `Warranty: ${product.warranty} years` // Ternary #2: if warranty > 0, show "X years", else "No Warranty"
          : "No Warranty"}
      </p>
      <p>
        <b>Availability:</b>{" "}
        {product.availability ? (
          <span className="text-success">✅ In Stock</span>
        ) : (
          <span className="text-danger">❌ Out of Stock</span>
        )}
      </p>
      <p>
        <b>Category:</b> {product.category}
      </p>
      {product.category === "Laptop" ? (
        <p className="text-primary">🎒 Free Laptop Bag Offer</p>
      ) : (
        ""
      )}
    </div>
  );
};

// ✅ App Component
const App = () => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [product, setProduct] = useState(null);

  useEffect(() => {    // Side effect runs after initial render
    // Simulate API Call
    setTimeout(() => {//// Delay to mimic network latency
      // Randomly simulate error or success
      const success = Math.random() > 0.3; // 70% success, 30% error
      if (success) {
        setProduct({
          name: "MacBook Pro",
          brand: "Apple",
          price: 120000,
          category: "Laptop",
          warranty: 2,
          availability: true,
        });
        setLoading(false);//  // Turn off loading (will trigger rerender)
      } else {// // If "API" fails
        setError(true);//  // Mark error as true
        setLoading(false);// // Turn off loading
      }
    }, 2000);//// Simulated 2-second API delay
  }, []);//// Empty dependency array => run once after first render

  //  Conditional Rendering with only Ternary
  return (//// Render the UI based on current state
    <div className="container mt-5">{/* Page container with margin top */}
      <h2 className="mb-3">Electronic Product Details</h2>
      {loading ? (// // Ternary A: if loading, show loading component
        <LoadingComponent />
      ) : error ? (//   // Else, nested ternary B: if error, show error component
        <ErrorComponent />
      ) : (//   // Else (not loading and no error): show product
        <ProductComponent product={product} />//// Pass the product object as a prop
      )}
    </div>
  );
};

export default App;
