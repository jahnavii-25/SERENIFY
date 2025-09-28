import React, { useEffect, useState } from "react";
import { getJournals } from "../services/api";

function History({ refreshSignal }) {
  const [journals, setJournals] = useState([]);

  useEffect(() => {
    getJournals().then((res) => setJournals(res.data));
  }, [refreshSignal]);

  return (
    <div className="card p-3 shadow mt-3">
      <h4>Mood History</h4>
      {journals.map((j) => (
        <div key={j.id} className="border-bottom py-2">
          <p><b>{j.mood}</b>: {j.text}</p>
          <small>{new Date(j.createdAt).toLocaleString()}</small>
          <br />
          <a href={j.playlistUrl} target="_blank" rel="noreferrer">
            🎵 Playlist
          </a>
        </div>
      ))}
    </div>
  );
}

export default History;