import axios from "axios";

const API = axios.create({
    baseURL : "http://localhost:8080/api/journals",
});

export const addJournal = (data) => API.post("/", data);
export const getJournals = () => API.get("/");
export const getTrends = () => API.get("/trends");