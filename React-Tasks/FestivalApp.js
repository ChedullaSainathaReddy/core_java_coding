// Import React core and two hooks we'll use in this component
import React, { useState, useEffect } from "react";

// Define a functional component named FestivalApp (default export is at the bottom)
function FestivalApp() {
  // -------------------- STATE --------------------

  // Declare a state variable 'festival' with initial value "Diwali"
  // 'setFestival' is the setter function to update 'festival'
  const [festival, setFestival] = useState("Diwali");

  // Declare a state variable 'countdown' with initial value 10
  // 'setCountdown' is the setter function to update 'countdown'
  const [countdown, setCountdown] = useState(10);

  // -------------------- EFFECTS --------------------

  // Q1: Run on EVERY render (no dependency array).
  // This effect runs after every commit (mount + every update).
  useEffect(() => {
    console.log("Festival App Rendered"); // Log a message every time the component renders
  }); // no dependency array => runs on every render

  // Q2: Run ONCE when component loads (empty dependency array [])
  // This effect runs only on mount (and cleanup on unmount).
  useEffect(() => {
    alert("Welcome to Diwali Festival App"); // Show welcome alert once on first mount

    // (optional) return cleanup function if needed; we don't need cleanup here
  }, []); // empty array => run only once on mount

  // Q3: Run whenever 'festival' CHANGES (dependency [festival])
  // This effect observes 'festival' and triggers whenever it updates.
  useEffect(() => {
    console.log(`Festival changed to: ${festival}`); // Log the new festival value
  }, [festival]); // only re-run when 'festival' changes

  // Q4: Countdown timer with CLEANUP (dependency [])
  // Start an interval once on mount that decrements count every second.
  useEffect(() => {
    console.log("Countdown started..."); // Helpful log to know timer started

    // Create an interval that runs every 1000ms (1 second)
    const timer = setInterval(() => {
      // Use functional update to ensure we always read the latest state value
      setCountdown((prev) => prev - 1); // Decrease countdown by 1
    }, 1000); // interval period in milliseconds

    // Return a cleanup function that stops the interval
    // React calls this when the component unmounts (or before re-running this effect)
    return () => {
      console.log("Cleaning up countdown timer..."); // Helpful log for cleanup
      clearInterval(timer); // Prevent memory leaks and stray timers
    };
  }, []); // empty array => set the timer once on mount, cleanup on unmount

  // Q5: MULTIPLE dependencies (run when either changes)
  // This effect runs whenever 'festival' OR 'countdown' changes.
  useEffect(() => {
    console.log(`Festival: ${festival}, Countdown: ${countdown}`); // Combined log
  }, [festival, countdown]); // re-run if either dependency changes

  // -------------------- UI (JSX) --------------------
  return (
    // A simple container div with inline styles for center alignment and spacing
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      {/* Main heading for the app */}
      <h1> Festival App </h1>

      {/* Display the current festival from state */}
      <h2>Current Festival: {festival}</h2>

      {/* Display the current countdown from state */}
      <h2>Countdown: {countdown}</h2>

      {/* Button to change festival to "Holi"; clicking calls setFestival */}
      <button onClick={() => setFestival("Holi")}>Change to Holi</button>

      {/* Button to change festival to "Pongal" */}
      <button onClick={() => setFestival("Pongal")}>Change to Pongal</button>

      {/* Button to reset festival back to "Diwali" */}
      <button onClick={() => setFestival("Diwali")}>Reset to Diwali</button>
    </div>
  );
}

// Export this component as the default export so it can be rendered in index.js
export default FestivalApp;
