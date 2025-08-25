// src/PowerCutContext.js

import React, { createContext, useState } from "react";

// Create a Context to manage global announcements state
export const PowerCutContext = createContext();

// Provider component that wraps the app to provide context values
export const PowerCutProvider = ({ children }) => {
  // State to hold all announcements
  const [announcements, setAnnouncements] = useState([]);

  // Function to add a new announcement
  const addAnnouncement = (street, message) => {
    const newAnnouncement = {
      id: Date.now(), // unique id using timestamp
      street, // street name from form
      message, // announcement content from form
      time: new Date().toLocaleString(), // current date and time
    };
    // Add new announcement at the top of the array
    setAnnouncements([newAnnouncement, ...announcements]);
  };

  // Provide announcements array and addAnnouncement function to children
  return (
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}>
      {children}
    </PowerCutContext.Provider>
  );
};
export default PowerCutContext;