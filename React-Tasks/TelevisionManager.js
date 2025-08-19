import React, { Component } from "react";
//object destructuring of props; same as props.models.
const TelevisionList = ({ models }) => {
  return (
    <div>
      <h3> Television Models</h3>
      {/*/Inline style object removes bullets (listStyleType: "none") and padding.*/}
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {models.map((model, index) => (
          <li key={index}>{model}</li>//{model} inserts the current model string.
        ))}
      </ul>
    </div>
  );
};


 //Class Component to manage TV models
class TelevisionManager extends Component {
  constructor(props) {
    super(props);//calls the base Component constructor, enabling this.props.
    this.state = {
      models: ["Samsung QLED", "LG OLED", "Sony Bravia"], // starting list displayed in the UI.
      newModel: "" // For storing input text
    };
  }

  // Update state when typing in input
  handleChange = (e) => {
    this.setState({ newModel: e.target.value });//Updates newModel in state with the input’s value (e.target.value).
  };

  // Add new TV model to the list
  //When “Add Model” is clicked, check that the input isn’t empty
  addModel = () => {
    if (this.state.newModel.trim() !== "") {
      this.setState((prev) => ({
        models: [...prev.models, prev.newModel], //  Spread operator used
        newModel: "" // Clear input after adding
      }));
    }
  };

  render() {
    return (
      <div style={{ padding: "20px", textAlign: "center" }}>
        <h2> Television Manager</h2>
        {/* Input box */}
        <input
          type="text"
          value={this.state.newModel}//is bound to this.state.newModel.
          onChange={this.handleChange}//update the states
          placeholder="Enter TV model"// show a hint when it is empty
        />
        {/* Button triggers addModel to append the new it*/}
        
        <button onClick={this.addModel} style={{ marginLeft: "10px" }}>
          Add Model
        </button>

        {/* Passing state as props to TelevisionList */}
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}


export default TelevisionManager;
