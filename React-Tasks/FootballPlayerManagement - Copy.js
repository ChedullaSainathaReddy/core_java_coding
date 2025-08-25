// src/FootballPlayerManagement.js

import React, { useState, useEffect } from "react";
import axios from "axios";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "bootstrap/dist/css/bootstrap.min.css";

const FootballPlayerManagement = () => {
  const [players, setPlayers] = useState([]);
  const [editingPlayer, setEditingPlayer] = useState(null);

  const apiURL = "http://localhost:5000/players"; // JSON Server URL

  // Fetch all players from JSON Server
  const fetchPlayers = async () => {
    try {
      const response = await axios.get(apiURL);
      setPlayers(response.data);
    } catch (error) {
      console.error("Error fetching players:", error);
    }
  };

  useEffect(() => {
    fetchPlayers();
  }, []);

  // Validation schema using Yup
  const validationSchema = Yup.object().shape({
    name: Yup.string().required("Name is required").min(3, "Min 3 chars"),
    age: Yup.number().required("Age required").min(16, "Min age 16").max(50, "Max age 50"),
    position: Yup.string().required("Position required"),
    club: Yup.string().required("Club required"),
    nationality: Yup.string().required("Nationality required"),
    goals: Yup.number().required("Goals required").min(0),
    matchesPlayed: Yup.number().required("Matches played required").min(0),
    jerseyNumber: Yup.number().required("Jersey number required").min(1).max(99),
    email: Yup.string().email("Invalid email").required("Email required"),
    contactNumber: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Must be 10 digits starting with 6-9")
      .required("Contact required"),
  });

  // Add or update player
  const handleSubmit = async (values, { resetForm }) => {
    try {
      if (editingPlayer) {
        // Update
        await axios.put(`${apiURL}/${editingPlayer.id}`, values);
        setEditingPlayer(null);
      } else {
        // Create
        await axios.post(apiURL, values);
      }
      resetForm();
      fetchPlayers();
    } catch (error) {
      console.error("Error saving player:", error);
    }
  };

  // Delete player
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure to delete?")) {
      try {
        await axios.delete(`${apiURL}/${id}`);
        fetchPlayers();
      } catch (error) {
        console.error("Error deleting player:", error);
      }
    }
  };

  // Edit player
  const handleEdit = (player) => {
    setEditingPlayer(player);
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4 text-center">⚽ Football Player Management</h2>

      <Formik
        enableReinitialize
        initialValues={
          editingPlayer || {
            name: "",
            age: "",
            position: "",
            club: "",
            nationality: "",
            goals: "",
            matchesPlayed: "",
            jerseyNumber: "",
            email: "",
            contactNumber: "",
          }
        }
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ isValid }) => (
          <Form>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label>Name</label>
                <Field name="name" className="form-control" />
                <ErrorMessage name="name" component="div" className="text-danger" />
              </div>
              <div className="col-md-6 mb-3">
                <label>Age</label>
                <Field type="number" name="age" className="form-control" />
                <ErrorMessage name="age" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Position</label>
                <Field as="select" name="position" className="form-control">
                  <option value="">Select Position</option>
                  <option value="Forward">Forward</option>
                  <option value="Midfielder">Midfielder</option>
                  <option value="Defender">Defender</option>
                  <option value="Goalkeeper">Goalkeeper</option>
                </Field>
                <ErrorMessage name="position" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Club</label>
                <Field name="club" className="form-control" />
                <ErrorMessage name="club" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Nationality</label>
                <Field name="nationality" className="form-control" />
                <ErrorMessage name="nationality" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Goals</label>
                <Field type="number" name="goals" className="form-control" />
                <ErrorMessage name="goals" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Matches Played</label>
                <Field type="number" name="matchesPlayed" className="form-control" />
                <ErrorMessage name="matchesPlayed" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Jersey Number</label>
                <Field type="number" name="jerseyNumber" className="form-control" />
                <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Email</label>
                <Field type="email" name="email" className="form-control" />
                <ErrorMessage name="email" component="div" className="text-danger" />
              </div>

              <div className="col-md-6 mb-3">
                <label>Contact Number</label>
                <Field name="contactNumber" className="form-control" />
                <ErrorMessage name="contactNumber" component="div" className="text-danger" />
              </div>
            </div>

            <button
              type="submit"
              className="btn btn-primary mb-4"
              disabled={!isValid}
            >
              {editingPlayer ? "Update Player" : "Add Player"}
            </button>
          </Form>
        )}
      </Formik>

      {/* Players Table */}
      <h4>Players List</h4>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Club</th>
            <th>Nationality</th>
            <th>Goals</th>
            <th>Matches</th>
            <th>Jersey</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map((player) => (
            <tr key={player.id}>
              <td>{player.name}</td>
              <td>{player.age}</td>
              <td>{player.position}</td>
              <td>{player.club}</td>
              <td>{player.nationality}</td>
              <td>{player.goals}</td>
              <td>{player.matchesPlayed}</td>
              <td>{player.jerseyNumber}</td>
              <td>{player.email}</td>
              <td>{player.contactNumber}</td>
              <td>
                <button
                  className="btn btn-sm btn-warning me-2"
                  onClick={() => handleEdit(player)}
                >
                  Edit
                </button>
                <button
                  className="btn btn-sm btn-danger"
                  onClick={() => handleDelete(player.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FootballPlayerManagement;
