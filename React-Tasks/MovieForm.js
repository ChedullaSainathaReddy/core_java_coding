import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class MovieForm extends Component {
  constructor(props) {
    super(props);
    console.log("constructor executed");

    // Initial state
    this.state = {
      title: "",
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: [],
      movies: [],
      showForm: true, // For demonstrating componentWillUnmount
    };
  }

  // Lifecycle method: Runs before render (rarely used)
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null; // we’re not changing state from props here
  }

  componentDidMount() {
    console.log("componentDidMount executed");
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true; // allow re-render always
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null;
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  // Handle input changes
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    if (type === "checkbox") {
      // Add/remove platforms from array
      let updatedPlatforms = [...this.state.platforms];
      if (checked) {
        updatedPlatforms.push(value);
      } else {
        updatedPlatforms = updatedPlatforms.filter((p) => p !== value);
      }
      this.setState({ platforms: updatedPlatforms });
    } else {
      this.setState({ [name]: value });
    }
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault();
    const { title, director, year, genre, rating, description, platforms } =
      this.state;

    const newMovie = {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms,
    };

    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie],
      title: "",
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: [],
    }));
  };

  // Toggle form visibility to test componentWillUnmount
  toggleForm = () => {
    this.setState((prevState) => ({ showForm: !prevState.showForm }));
  };

  render() {
    console.log("render executed");

    return (
      <div className="container mt-5">
        <button className="btn btn-warning mb-3" onClick={this.toggleForm}>
          {this.state.showForm ? "Unmount Form" : "Mount Form"}
        </button>

        {this.state.showForm && (
          <div className="card shadow p-4">
            <h2 className="text-center text-primary">🎬 Add a Movie</h2>

            <form onSubmit={this.handleSubmit}>
              {/* Movie Title */}
              <div className="form-group mb-3">
                <label>Movie Title:</label>
                <input
                  type="text"
                  name="title"
                  className="form-control"
                  value={this.state.title}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Director */}
              <div className="form-group mb-3">
                <label>Director:</label>
                <input
                  type="text"
                  name="director"
                  className="form-control"
                  value={this.state.director}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Release Year */}
              <div className="form-group mb-3">
                <label>Release Year:</label>
                <input
                  type="number"
                  name="year"
                  className="form-control"
                  value={this.state.year}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Genre */}
              <div className="form-group mb-3">
                <label>Genre:</label>
                <select
                  name="genre"
                  className="form-control"
                  value={this.state.genre}
                  onChange={this.handleChange}
                >
                  <option>Action</option>
                  <option>Comedy</option>
                  <option>Drama</option>
                  <option>Sci-Fi</option>
                  <option>Horror</option>
                </select>
              </div>

              {/* Rating */}
              <div className="form-group mb-3">
                <label>Rating:</label>
                <div>
                  {[1, 2, 3, 4, 5].map((num) => (
                    <label key={num} className="me-3">
                      <input
                        type="radio"
                        name="rating"
                        value={num}
                        checked={this.state.rating === String(num)}
                        onChange={this.handleChange}
                      />{" "}
                      {num}
                    </label>
                  ))}
                </div>
              </div>

              {/* Description */}
              <div className="form-group mb-3">
                <label>Description:</label>
                <textarea
                  name="description"
                  className="form-control"
                  value={this.state.description}
                  onChange={this.handleChange}
                />
              </div>

              {/* Platforms */}
              <div className="form-group mb-3">
                <label>Available on:</label>
                <div>
                  {["Netflix", "Amazon Prime", "Disney+", "Others"].map(
                    (p) => (
                      <label key={p} className="me-3">
                        <input
                          type="checkbox"
                          value={p}
                          checked={this.state.platforms.includes(p)}
                          onChange={this.handleChange}
                        />{" "}
                        {p}
                      </label>
                    )
                  )}
                </div>
              </div>

              <button type="submit" className="btn btn-success w-100">
                Add Movie
              </button>
            </form>
          </div>
        )}

        {/* Movies Table */}
        {this.state.movies.length > 0 && (
          <div className="card shadow p-4 mt-4">
            <h3 className="text-center text-success">🎥 Movies List</h3>
            <table className="table table-bordered">
              <thead className="table-dark">
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Description</th>
                  <th>Platforms</th>
                </tr>
              </thead>
              <tbody>
                {this.state.movies.map((movie, index) => (
                  <tr key={index}>
                    <td>{movie.title}</td>
                    <td>{movie.director}</td>
                    <td>{movie.year}</td>
                    <td>{movie.genre}</td>
                    <td>{movie.rating}</td>
                    <td>{movie.description}</td>
                    <td>{movie.platforms.join(", ")}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default MovieForm;
