
import React from "react";
import ServiceCard from "./ServiceCard";
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap

const TailorShop = () => {
  // Array of tailoring services (JSON objects)
  const services = [
    {
      serviceName: "Shirt",
      price: 20,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"],
    },
    {
      serviceName: "Pants",
      price: 30,
      fabricsAvailable: ["Denim", "Wool", "Chino"],
    },
    {
      serviceName: "Huddies",
      price: 150,
      fabricsAvailable: ["Silk", "Georgette", "Chiffon"],
    },
    {
      serviceName: "T-Shirts",
      price: 40,
      fabricsAvailable: ["Cotton", "Silk", "Satin"],
    },
  ];

  return (
    //Bootstrap container for centered layout, with mt-5 (margin-top spacing).
    <div className="container mt-5">/
      {/* Page Title */}
      <h2 className="text-center mb-4 text-primary fw-bold">
        ✂️ Tailoring Services
      </h2>

      {/* Card Grid */}
      <div className="row">
        {services.map((service, index) => (
          <div key={index} className="col-md-3 col-sm-6 mb-4 d-flex">
            <ServiceCard service={service} />
          </div>
        ))}
      </div>
    </div>
  );
};

export default TailorShop;

      //starts a responsive grid row.
      //Loops over the services array using .map().

//For each service object, it will return JSX.

//index is the array index, used as a unique key.
//React requires a unique key when rendering lists.

