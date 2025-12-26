import React, { Component } from "react";

// ✅ Functional Component to display fruits
const FruitList = ({ fruits }) => {
  return (
    <div>
      <h3>Fruit List</h3>
      <ul>
        {fruits.map((fruit, index) => (
          <li key={index}>{fruit}</li>
        ))}
      </ul>
    </div>
  );
};

// ✅ Class Component to manage fruits
class Fruits extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fruits: ["Apple", "Banana", "Mango"], // initial fruits
      newFruit: "" // input value
    };
  }

  // Handle input change
  handleChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  // Add new fruit to the list
  addFruit = () => {
    if (this.state.newFruit.trim() !== "") {
      this.setState((prevState) => ({
        fruits: [...prevState.fruits, prevState.newFruit],
        newFruit: "" // clear input
      }));
    }
  };

  render() {
    return (
      <div className="container mt-4">
        <h2>🍎 Fruits Manager</h2>

        {/* Input + Button */}
        <input
          type="text"
          placeholder="Enter a fruit"
          value={this.state.newFruit}
          onChange={this.handleChange}
        />
        <button onClick={this.addFruit} style={{ marginLeft: "10px" }}>
          Add Fruit
        </button>

        {/* Pass fruits as props to FruitList */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

export default Fruits;
