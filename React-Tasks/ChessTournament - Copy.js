// Importing React and hooks
import React, { useMemo, useState, useEffect } from "react";

// Importing Formik components for form handling
import { Formik, Form, Field, ErrorMessage } from "formik";

// Importing Yup for validation rules
import * as Yup from "yup";

// Utility function: calculates age from DOB string
const getAge = (dobStr) => {
  if (!dobStr) return ""; // if DOB empty, return empty
  const today = new Date();
  const dob = new Date(dobStr);
  let age = today.getFullYear() - dob.getFullYear();
  const m = today.getMonth() - dob.getMonth();
  // adjust if birthday hasn’t happened yet this year
  if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) age--;
  return age;
};

// Custom hook: injects Bootstrap CSS if not already loaded
const useBootstrapCdn = () => {
  useEffect(() => {
    const id = "bootstrap-cdn-css";
    if (!document.getElementById(id)) {
      const link = document.createElement("link");
      link.id = id;
      link.rel = "stylesheet";
      link.href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css";
      document.head.appendChild(link);
    }
  }, []);
};

// Initial form values (empty/default)
const initialValues = {
  playerName: "",
  dob: "",
  gender: "",
  fideId: "",
  rating: "",
  email: "",
  mobile: "",
  country: "",
  category: "",
  parentContact: "",
  paymentConfirmed: false,
  termsAccepted: false,
};

// Validation rules for each field using Yup
const validationSchema = Yup.object({
  playerName: Yup.string().min(3, "Must be at least 3 characters").required("Required"),
  dob: Yup.date()
    .typeError("Invalid date")
    .required("Required")
    .test("age-range", "Age must be between 5 and 90 years", (value) => {
      if (!value) return false;
      const today = new Date();
      const dob = new Date(value);
      let age = today.getFullYear() - dob.getFullYear();
      const m = today.getMonth() - dob.getMonth();
      if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) age--;
      return age >= 5 && age <= 90;
    }),
  gender: Yup.string().oneOf(["Male", "Female", "Other"], "Select a valid option").required("Required"),
  fideId: Yup.string()
    .matches(/^\d{8}$/g, "FIDE ID must be exactly 8 digits")
    .required("Required"),
  rating: Yup.number()
    .typeError("Rating must be a number")
    .min(100, "Minimum rating is 100")
    .max(3000, "Maximum rating is 3000")
    .required("Required"),
  email: Yup.string().email("Invalid email").required("Required"),
  mobile: Yup.string()
    .matches(/^[6-9]\d{9}$/g, "Must be 10 digits starting with 6-9")
    .required("Required"),
  country: Yup.string().required("Required"),
  category: Yup.string().oneOf(["Under 12", "Under 18", "Open"], "Select a valid option").required("Required"),
  parentContact: Yup.string().when("category", {
    is: (val) => val === "Under 12",
    then: (schema) =>
      schema
        .required("Parent contact is required for Under 12")
        .matches(/^\d{10}$/g, "Enter a valid 10-digit number"),
    otherwise: (schema) => schema.notRequired().nullable(),
  }),
  paymentConfirmed: Yup.boolean().oneOf([true], "Payment must be confirmed"),
  termsAccepted: Yup.boolean().oneOf([true], "You must accept the Terms & Conditions"),
});

// Main component
export default function ChessTournamentForm() {
  useBootstrapCdn(); // Load Bootstrap
  const [entries, setEntries] = useState([]); // Store submitted players

  // Handle form submission
  const handleSubmit = (values, { resetForm }) => {
    const payload = { ...values, rating: Number(values.rating) }; // ensure rating is number
    console.log("Chess Registration Submitted:", payload); // log to console
    setEntries((prev) => [...prev, payload]); // add to table
    resetForm(); // clear form
  };

  // Pre-calculate min/max DOB allowed (age 5–90)
  const { minDob, maxDob } = useMemo(() => {
    const today = new Date();
    const max = new Date(today.getFullYear() - 5, today.getMonth(), today.getDate());
    const min = new Date(today.getFullYear() - 90, today.getMonth(), today.getDate());
    const toISO = (d) => d.toISOString().slice(0, 10);
    return { minDob: toISO(min), maxDob: toISO(max) };
  }, []);

  // JSX (UI rendering)
  return (
    <div className="container py-4">
      <h1 className="mb-4">Chess Tournament Registration</h1>

      {/* Formik wrapper */}
      <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={handleSubmit}>
        {({ values }) => (
          <Form className="row g-3">
            {/* Player Name */}
            <div className="col-md-6">
              <label className="form-label">Player Name</label>
              <Field name="playerName" type="text" className="form-control" placeholder="e.g., Viswanathan Anand" />
              <div className="form-text text-danger"><ErrorMessage name="playerName" /></div>
            </div>

            {/* DOB + Age */}
            <div className="col-md-3">
              <label className="form-label">Date of Birth</label>
              <Field name="dob" type="date" className="form-control" min={minDob} max={maxDob} />
              <div className="form-text text-danger"><ErrorMessage name="dob" /></div>
            </div>
            <div className="col-md-3">
              <label className="form-label">Age</label>
              <input className="form-control" value={getAge(values.dob)} readOnly />
            </div>

            {/* Gender */}
            <div className="col-md-4">
              <label className="form-label">Gender</label>
              <Field as="select" name="gender" className="form-select">
                <option value="">-- Select --</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </Field>
              <div className="form-text text-danger"><ErrorMessage name="gender" /></div>
            </div>

            {/* FIDE ID */}
            <div className="col-md-4">
              <label className="form-label">FIDE ID</label>
              <Field name="fideId" type="text" className="form-control" placeholder="8 digits" />
              <div className="form-text text-danger"><ErrorMessage name="fideId" /></div>
            </div>

            {/* Rating */}
            <div className="col-md-4">
              <label className="form-label">Rating</label>
              <Field name="rating" type="number" className="form-control" placeholder="100 - 3000" />
              <div className="form-text text-danger"><ErrorMessage name="rating" /></div>
            </div>

            {/* Email */}
            <div className="col-md-6">
              <label className="form-label">Email</label>
              <Field name="email" type="email" className="form-control" placeholder="name@example.com" />
              <div className="form-text text-danger"><ErrorMessage name="email" /></div>
            </div>

            {/* Mobile */}
            <div className="col-md-6">
              <label className="form-label">Mobile Number</label>
              <Field name="mobile" type="text" className="form-control" placeholder="10 digits starting 6-9" />
              <div className="form-text text-danger"><ErrorMessage name="mobile" /></div>
            </div>

            {/* Country */}
            <div className="col-md-6">
              <label className="form-label">Country</label>
              <Field name="country" type="text" className="form-control" placeholder="e.g., India" />
              <div className="form-text text-danger"><ErrorMessage name="country" /></div>
            </div>

            {/* Category */}
            <div className="col-md-6">
              <label className="form-label">Category</label>
              <Field as="select" name="category" className="form-select">
                <option value="">-- Select --</option>
                <option value="Under 12">Under 12</option>
                <option value="Under 18">Under 18</option>
                <option value="Open">Open</option>
              </Field>
              <div className="form-text text-danger"><ErrorMessage name="category" /></div>
            </div>

            {/* Parent Contact (only if Under 12) */}
            {values.category === "Under 12" && (
              <div className="col-md-6">
                <label className="form-label">Parent Contact</label>
                <Field name="parentContact" type="text" className="form-control" placeholder="10-digit number" />
                <div className="form-text text-danger"><ErrorMessage name="parentContact" /></div>
              </div>
            )}

            {/* Checkboxes */}
            <div className="col-12">
              <div className="form-check">
                <Field name="paymentConfirmed" type="checkbox" className="form-check-input" id="paymentConfirmed" />
                <label className="form-check-label" htmlFor="paymentConfirmed">Payment Confirmation</label>
              </div>
              <div className="form-text text-danger"><ErrorMessage name="paymentConfirmed" /></div>
            </div>
            <div className="col-12">
              <div className="form-check">
                <Field name="termsAccepted" type="checkbox" className="form-check-input" id="termsAccepted" />
                <label className="form-check-label" htmlFor="termsAccepted">I agree to the Terms & Conditions</label>
              </div>
              <div className="form-text text-danger"><ErrorMessage name="termsAccepted" /></div>
            </div>

            {/* Buttons */}
            <div className="col-12 d-flex gap-2">
              <button type="submit" className="btn btn-primary">Register Player</button>
              <button type="reset" className="btn btn-outline-secondary">Reset</button>
            </div>
          </Form>
        )}
      </Formik>

      {/* Table of registered players */}
      <div className="mt-5">
        <h2 className="h4 mb-3">Registered Players</h2>
        {entries.length === 0 ? (
          <div className="text-muted">No entries yet.</div>
        ) : (
          <div className="table-responsive">
            <table className="table table-striped table-bordered align-middle">
              <thead className="table-light">
                <tr>
                  <th>#</th>
                  <th>Player Name</th>
                  <th>DOB</th>
                  <th>Age</th>
                  <th>Gender</th>
                  <th>FIDE ID</th>
                  <th>Rating</th>
                  <th>Email</th>
                  <th>Mobile</th>
                  <th>Country</th>
                  <th>Category</th>
                  <th>Parent Contact</th>
                  <th>Payment</th>
                  <th>Terms</th>
                </tr>
              </thead>
              <tbody>
                {entries.map((e, idx) => (
                  <tr key={idx}>
                    <td>{idx + 1}</td>
                    <td>{e.playerName}</td>
                    <td>{e.dob}</td>
                    <td>{getAge(e.dob)}</td>
                    <td>{e.gender}</td>
                    <td>{e.fideId}</td>
                    <td>{e.rating}</td>
                    <td>{e.email}</td>
                    <td>{e.mobile}</td>
                    <td>{e.country}</td>
                    <td>{e.category}</td>
                    <td>{e.category === "Under 12" ? e.parentContact || "-" : "-"}</td>
                    <td>{e.paymentConfirmed ? "Yes" : "No"}</td>
                    <td>{e.termsAccepted ? "Yes" : "No"}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
