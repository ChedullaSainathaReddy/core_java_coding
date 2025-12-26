import React from "react";

const TempleList = () => {
  // Array of temples with nested array of deities
  const temples = [
    {
      id: 1,
      name: "Tirupati Balaji Temple",
      location: "Andhra Pradesh",
      deities: ["Lord Venkateswara", "Goddess Padmavathi"],
    },
    {
      id: 2,
      name: "Kashi Vishwanath Temple",
      location: "Varanasi, Uttar Pradesh",
      deities: ["Lord Shiva", "Goddess Annapurna"],
    },
    {
      id: 3,
      name: "Meenakshi Amman Temple",
      location: "Madurai, Tamil Nadu",
      deities: ["Goddess Meenakshi", "Lord Sundareswarar"],
    },
  ];

  return (
    <div>
      <h2> Famous Temples in India</h2>
      <table border="1" cellPadding="8" style={{ borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple) => (
            <tr key={temple.id}>
              <td>{temple.id}</td>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                <ul>
                  {temple.deities.map((deity, index) => (
                    <li key={index}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TempleList;
