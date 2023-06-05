import RouterWeb from "./RouterWeb.js";

function App() {

fetch("/api")
.then((response)=>{
          return response.json();
        })
  return (
    <div className="App">
      <RouterWeb/>
    </div>
  );
}

export default App;
