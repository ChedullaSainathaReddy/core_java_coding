import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class AccessoriesForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      accessoryName: "",//text fields(controlled i/p)
      description: "",
      category: "Mobile",
      brand: "",
      inStock: false,// it return boolean and for to checkbox
      warranty: "",
      submittedData: null,//until form is submitted; afterward will hold a snapshot of form data.
    };
  }

  handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    this.setState({//update the component’s state.
      [name]: type === "checkbox" ? checked : value,//property name updates the specific field in stat
    });
  };

  handleSubmit = (e) => {
    e.preventDefault();//Prevents the browser’s default form submit (page reload).
    this.setState({
      submittedData: { ...this.state },//Stores a snapshot of the current state into submittedData using the spread operator.
    });
  };
//Destructures fields from state to avoid repeating this.state. in JSX.
  render() {
    const {
      accessoryName,
      description,
      category,
      brand,
      inStock,
      warranty,
      submittedData,
    } = this.state;

    return (
      <div className="container mt-4">
        <div className="card p-4 shadow-lg">
          <h3 className="mb-3">Accessories Form</h3>
          <form onSubmit={this.handleSubmit}>{/*Form element; submitting triggers handleSubmit.*/}
            {/* Text */}
            <div className="form-group mb-3">
              <label>Accessory Name</label>
              <input
                type="text"
                className="form-control"
                name="accessoryName"//ties it to state.accessoryName.
                value={accessoryName}//reads from state.
                onChange={this.handleChange}//writes to state.
                required
              />
            </div>

            {/* Controlled <textarea> for multi-line text. */}
            <div className="form-group mb-3">
              <label>Description</label>
              <textarea
                className="form-control"
                name="description"
                rows="3"
                value={description}
                onChange={this.handleChange}
              />
            </div>

            {/* Controlled <select>. Its value is bound to state.category.*/}
            <div className="form-group mb-3">
              <label>Category</label>
              <select
                className="form-control"
                name="category"
                value={category}//sets brand to this value when selected.
                onChange={this.handleChange}
              >
                <option value="Mobile">Mobile</option>
                <option value="Laptop">Laptop</option>
                <option value="Headphones">Headphones</option>
                <option value="Charger">Charger</option>
              </select>
            </div>

            {/* Radio */}
            <div className="form-group mb-3">
              <label>Brand</label> <br />
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="brand"
                  value="Samsung"//sets brand to this value when selected.
                  checked={brand === "Samsung"}//makes it controlled.
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Samsung</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="brand"
                  value="Apple"
                  checked={brand === "Apple"}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Apple</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="brand"
                  value="Sony"
                  checked={brand === "Sony"}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Sony</label>
              </div>
            </div>

            {/* Checkbox */}
            <div className="form-group mb-3 form-check">
              <input
                type="checkbox"
                className="form-check-input"
                name="inStock"
                checked={inStock}//comes from state.
                onChange={this.handleChange}//toggles it
              />
              <label className="form-check-label">Available in stock</label>
            </div>

            {/* Number */}
            <div className="form-group mb-3">
              <label>Warranty (Years)</label>
              <input
                type="number"
                className="form-control"
                name="warranty"
                value={warranty}
                onChange={this.handleChange}
                min="0"//disallows negatives. from controlled input
              />
            </div>

            {/* Submit */}
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </form>
        </div>

        {/* Display Submitted Data */}
        {submittedData && (
          <div className="mt-4">
            <h4>Submitted Details</h4>
            <table className="table table-bordered table-striped">
              <thead className="table-dark">
                <tr>
                  <th>Accessory Name</th>
                  <th>Description</th>
                  <th>Category</th>
                  <th>Brand</th>
                  <th>In Stock</th>
                  <th>Warranty (Years)</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{submittedData.accessoryName}</td>
                  <td>{submittedData.description}</td>
                  <td>{submittedData.category}</td>
                  <td>{submittedData.brand}</td>
                  <td>{submittedData.inStock ? "Yes" : "No"}</td>
                  <td>{submittedData.warranty}</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm;
