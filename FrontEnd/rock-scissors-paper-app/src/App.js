import React from 'react';
import './App.css';
import MatchTable from './components/matchTable';
import MatchHistory from './components/matchHistory';

class App extends React.Component {

  constructor(props) {
    super()
    this.state = { viewMatchHistory: false }
  }

  alternateMatchHistory() {
    let _viewMatchHistory = !this.state.viewMatchHistory
    this.setState((state) => {
      return {viewMatchHistory: _viewMatchHistory}
    });
  }
  
  render() {
    return (
      <div className="App">
        <button class="secondary-button" id="alternate" onClick={() => this.alternateMatchHistory()}>Alternate History View</button>
        {!this.state.viewMatchHistory && <MatchTable />}
        {this.state.viewMatchHistory && <MatchHistory />}
      </div>
    );
  }
}




export default App;
