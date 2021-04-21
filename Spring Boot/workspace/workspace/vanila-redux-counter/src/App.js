import logo from 'logo.svg';
import 'App.css';
import { Route } from 'react-router-dom'
import { CounterContainer, CounterSliceContainer } from 'counter/index'
import { TodoApp } from 'todos/index'

function App() {
  return (
    <Route exact path='/todos' component={TodoApp} />
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <Route exact path='/' component={CounterContainer} />
    //     <Route exact path='/counter/counter-slice' component={CounterSliceContainer} />
        
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
  );
}

export default App;
