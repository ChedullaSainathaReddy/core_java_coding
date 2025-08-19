 import React, { Component } from "react";
 import "bootstrap/dist/css/bootstrap.min.css";

 class MarriageForm extends Component {
   constructor(props) {
     super(props);//Calls the parent constructor so we can use this.
     this.state = {//Component’s local state
      brideName: "",// Stroing the input values
      groomName: "",
      date: "",
      venue: "",
      submitted: false,//Boolean flag to track whether the form is submitted.
    };
  }

  //  Handle input changes dynamically
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });//refers to the name attribute,new value typed in i/p
  };

  // runs when form is submitted.
  handleSubmit = (e) => {
    e.preventDefault();//Stops page reload
    this.setState({ submitted: true });//Marks the form as submitted so we can display the details.
  };

  render() {
    return (
      <div className="container mt-5">
        <div className="card shadow p-4">
          <h2 className="text-center text-primary mb-4">💍 Marriage Form</h2>

          {/* Calls our handler when submitted.*/}
          <form onSubmit={this.handleSubmit}>
            {/* Bride Name */}
            <div className="form-group mb-3">
              <label>Bride Name:</label>
              <input
                type="text"
                className="form-control"
                name="brideName"//Matches state property
                value={this.state.brideName}//Controlled the input values from the state
                onChange={this.handleChange}//updates the state
                placeholder="Enter Bride's Name"
                required
              />
            </div>

            {/* Groom Name */}
            <div className="form-group mb-3">
              <label>Groom Name:</label>
              <input
                type="text"
                className="form-control"
                name="groomName"
                value={this.state.groomName}
                onChange={this.handleChange}
                placeholder="Enter Groom's Name"
                required
              />
            </div>

            {/* Date */}
            <div className="form-group mb-3">
              <label>Date:</label>
              <input
                type="date"
                className="form-control"
                name="date"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Venue */}
            <div className="form-group mb-3">
              <label>Venue:</label>
              <input
                type="text"
                className="form-control"
                name="venue"
                value={this.state.venue}
                onChange={this.handleChange}
                placeholder="Enter Venue"
                required
              />
            </div>

            {/* Submit Button Green full-width button.*/}
            <button type="submit" className="btn btn-success w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show Submitted Details */}
        {this.state.submitted && (
          <div className="card shadow p-4 mt-4">
            <h3 className="text-center text-success"> Marriage Details</h3>
            <p><b>Bride:</b> {this.state.brideName}</p>
            <p><b>Groom:</b> {this.state.groomName}</p>
            <p><b>Date:</b> {this.state.date}</p>
            <p><b>Venue:</b> {this.state.venue}</p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;
