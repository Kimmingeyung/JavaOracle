import React from "react";
import { Route,Routes } from "react-router";
import { BrowserRouter } from "react-router-dom";

import MovieList from "./components/MovieList";
import WriteMovie from "./components/WriteMovie";
import DetailMovie from "./components/DetailMovie";

function App() {
  return(
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MovieList />} />
          <Route path ="/writeMovie" element ={<WriteMovie/>}/>
          <Route path="/detail/:id" element={<DetailMovie />} />
        </Routes>
      </BrowserRouter>
     
    </div>
  );
}

export default App;
