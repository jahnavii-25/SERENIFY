import React, { useState } from "react";
import { addJournal } from "../services/api";

function JournalForm({ refresh }) {
  const [text, setText] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!text.trim()) return;
    await addJournal({ text });
    setText("");
    refresh();
  };

  return (
    <div className="card p-3 shadow">
      <h4>Write Your Journal</h4>
      <form onSubmit={handleSubmit}>
        <textarea
          className="form-control mb-2"
          rows="4"
          value={text}
          onChange={(e) => setText(e.target.value)}
          placeholder="How are you feeling today?"
        />
        <button className="btn btn-primary w-100" type="submit">
          Detect Mood & Get Playlist
        </button>
      </form>
    </div>
  );
}

export default JournalForm;