import React, { useState } from "react";
import JournalForm from "./components/JournalForm";
import History from "./components/History";
import Trends from "./components/Trends";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [refreshSignal, setRefreshSignal] = useState(false);

  const refresh = () => setRefreshSignal(!refreshSignal);

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">🎶 Serenify - Mood-Based Music</h2>
      <JournalForm refresh={refresh} />
      <History refreshSignal={refreshSignal} />
      <Trends />
    </div>
  );
}

export default App;