
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap

const ServiceCard = ({ service }) => {
  return (
    <div className="col-md-4 mb-4">
      <div className="card shadow-lg h-100 border-0 rounded-3">
        <div className="card-header bg-primary text-white text-center">
          <h5 className="card-title mb-0">{service.serviceName}</h5>
        </div>

        <div className="card-body">
          <p className="card-text">
            <strong>Price:</strong> ${service.price}
          </p>
          <p className="mb-1"><strong>Fabrics:</strong></p>
          <ul className="list-group list-group-flush">
            {service.fabricsAvailable.map((fabric, idx) => (
              <li key={idx} className="list-group-item">
                {fabric}
              </li>
            ))}
          </ul>
        </div>

        <div className="card-footer text-center bg-light">
          <button className="btn btn-success w-100">
            Book Service
          </button>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;


//shadow-lg → applies a large drop shadow.
//list-group-flush → removes outer borders and makes the list blend with the card.
//in bold, introducing the list of fabrics.
//Each element (fabric) represents a fabric name (e.g., "Cotton", "Silk").

//idx is the current index in the array (0, 1, 2 …).
//styles each list item with Bootstrap list group design.
//key={idx} → gives each item a unique key