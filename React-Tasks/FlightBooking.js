import React, { Component, createRef } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

// ================= CONTROLLED COMPONENT ==================
class FlightBookingControlled extends Component {//class component
  constructor(props) {//initialize the compomnent
    super(props);
    this.state = {//stores the form filed values
      passengerName: "",
      email: "",
      gender: "",
      meal: "Veg",
      request: "",
      submittedData: null,//stores submitted details for display.
    };
  }

  // update the state when the user give text
  handleChange = (e) => {
    const { name, value } = e.target;//Dynamically updates i/p fields
    this.setState({ [name]: value });
  };

  // On form submit
  handleSubmit = (e) => {//prevents page refresh to  e.preventDefault()
    e.preventDefault();
    this.setState({
      submittedData: { ...this.state },//copies all the state values
    });
  };
//Destructures state values for easier usage inside JSX.
  render() {
    const { passengerName, email, gender, meal, request, submittedData } =
      this.state;

    return (
      <div className="card p-4 shadow mb-4">
        <h3 className="mb-3">Controlled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          {/* Passenger Name */}
          <div className="form-group mb-3">
            <label>Passenger Name</label>{/*matches state key.*/}
            <input
              type="text"
              className="form-control"
              name="passengerName"
              value={passengerName}//controlled by state.
              onChange={this.handleChange}//updates state
              required
            />
          </div>

          {/* Email */}
          <div className="form-group mb-3">
            <label>Email</label>
            <input
              type="email"
              className="form-control"
              name="email"
              value={email}
              onChange={this.handleChange}
              required
            />
          </div>

          {/* Gender (Radio) */}
          <div className="form-group mb-3">
            <label>Gender</label> <br />
            <div className="form-check form-check-inline">
              <input
                type="radio"
                name="gender"
                value="Male"
                checked={gender === "Male"}//ensures correct radio button is selected.
                onChange={this.handleChange}
                className="form-check-input"
              />
              <label className="form-check-label">Male</label>
            </div>
            <div className="form-check form-check-inline">
              <input
                type="radio"
                name="gender"
                value="Female"
                checked={gender === "Female"}
                onChange={this.handleChange}
                className="form-check-input"
              />
              <label className="form-check-label">Female</label>
            </div>
          </div>

          {/* Meal Preference dropdown or (Select) */}
          <div className="form-group mb-3">
            <label>Meal Preference</label>
            {/*value stored in state.*/}
            <select 
              name="meal"
              className="form-control"
              value={meal}
              onChange={this.handleChange}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          {/* Special Request for Textarea */}
          <div className="form-group mb-3">
            <label>Special Request</label>
            <textarea
              className="form-control"
              name="request"
              value={request}
              onChange={this.handleChange}
              rows="3"
            ></textarea>
          </div>

          {/* Submit */}
          <button className="btn btn-primary">Submit</button>
        </form>

        {/* Displays submitted form data inside a Bootstrap table. */}
        {submittedData && (
          <div className="mt-4">
            <h5>Submitted Details</h5>
            <table className="table table-bordered">
              <thead className="table-dark">
                <tr>
                  <th>Passenger</th>
                  <th>Email</th>
                  <th>Gender</th>
                  <th>Meal</th>
                  <th>Request</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{submittedData.passengerName}</td>
                  <td>{submittedData.email}</td>
                  <td>{submittedData.gender}</td>
                  <td>{submittedData.meal}</td>
                  <td>{submittedData.request}</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

// ================= UNCONTROLLED COMPONENT ==================
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);
    // Uses createRef() instead of state to access input values
    this.flightNoRef = createRef();
    this.sourceRef = createRef();
    this.destRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();

    this.state = { submitted: null };//Stores submitted data in state.
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submitted: {
        flightNo: this.flightNoRef.current.value,
        source: this.sourceRef.current.value,//Reads values directly from .current.value of refs.
        destination: this.destRef.current.value,
        travelDate: this.dateRef.current.value,
        terms: this.termsRef.current.checked,//Checkbox uses .checked.
      },
    });
  };
//Similar card and form structure.
  render() {
    const { submitted } = this.state;
    return (
      <div className="card p-4 shadow">
        <h3 className="mb-3">Uncontrolled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          {/* Flight No */}
          <div className="form-group mb-3">
            <label>Flight Number</label>
            <input
              type="text"
              className="form-control"
              ref={this.flightNoRef}//Instead of value/onChange, uses ref={this.flightNumberRef}.
              required
            />
          </div>

          {/* Source */}
          <div className="form-group mb-3">
            <label>Source</label>
            <input type="text" className="form-control" ref={this.sourceRef} />
          </div>

          {/* Destination */}
          <div className="form-group mb-3">
            <label>Destination</label>
            <input
              type="text"
              className="form-control"
              ref={this.destRef}
              required
            />
          </div>

          {/* Travel Date */}
          <div className="form-group mb-3">
            <label>Travel Date</label>
            <input type="date" className="form-control" ref={this.dateRef} />
          </div>

          {/* Terms */}
          <div className="form-check mb-3">
            <input type="checkbox" className="form-check-input" ref={this.termsRef} />
            <label className="form-check-label">Accept Terms</label>
          </div>

          {/* Submit */}
          <button className="btn btn-success">Submit</button>
        </form>

        {/* Submit & Display Data in Card */}
        {submitted && (
          <div className="card mt-4 p-3 shadow">
            <h5>Submitted Flight Details</h5>
            <p><b>Flight No:</b> {submitted.flightNo}</p>
            <p><b>Source:</b> {submitted.source}</p>
            <p><b>Destination:</b> {submitted.destination}</p>
            <p><b>Date:</b> {submitted.travelDate}</p>
            <p><b>Terms Accepted:</b> {submitted.terms ? "Yes" : "No"}</p>
          </div>
        )}
      </div>
    );
  }
}

// ================= PARENT COMPONENT ==================
class App extends Component {//Parent component that renders both forms.
  render() {
    return (
      <div className="container mt-5">
        <h2 className="text-center mb-4">Flight Booking Forms</h2>
        <div className="row">{/*adds a horizontal line separator.*/}
          <div className="col-md-6">
            <FlightBookingControlled />
          </div>
          <div className="col-md-6">
            <FlightBookingUncontrolled />
          </div>
        </div>
      </div>
    );
  }
}

export default App;
