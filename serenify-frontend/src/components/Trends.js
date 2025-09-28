import React, { useEffect, useState } from "react";
import { getTrends } from "../services/api";
import { LineChart, Line, XAxis, YAxis, Tooltip, CartesianGrid } from "recharts";

function Trends() {
  const [data, setData] = useState([]);

  useEffect(() => {
    getTrends().then((res) => setData(res.data));
  }, []);

  return (
    <div className="card p-3 shadow mt-3">
      <h4>Mood Trends</h4>
      <LineChart width={500} height={300} data={data}>
        <CartesianGrid stroke="#ccc" />
        <XAxis dataKey="date" />
        <YAxis />
        <Tooltip />
        <Line type="monotone" dataKey="count" stroke="#8884d8" />
      </LineChart>
    </div>
  );
}

export default Trends;