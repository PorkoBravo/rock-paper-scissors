import React from 'react'
import {getTotalMatchHistory} from '../api/api'


class MatchHistory extends React.Component {
    constructor(props) {
       super()
       this.state = {
           totalRounds: 0,
           totalWinsPlayer1: 0,
           totalWinsPlayer2: 0,
           totalDraws:0
       }
    }

    componentDidMount() {
        getTotalMatchHistory()
          .then((res) => {
              console.log(res.data)
            this.setState({
                totalRounds: res.data.rounds,
                totalWinsPlayer1: res.data.winsForPlayer1,
                totalWinsPlayer2: res.data.winsForPlayer2,
                totalDraws: res.data.draws
            });
          })
          .catch((err) => console.log(err));
      }

      render() {
        return (
           <div>
              <h1 id='title'>All time Statistics</h1>
                <ul class="center history">
                    <li>Total rounds played: <span class="bold green">{this.state.totalRounds}</span></li>
                    <li>Total wins for player 1: <span class="bold green">{this.state.totalWinsPlayer1}</span></li>
                    <li>Total wins for player 2: <span class="bold green">{this.state.totalWinsPlayer2}</span></li>
                    <li>Total draws: <span class="bold green">{this.state.totalDraws}</span></li>
                </ul> 
           </div>
        )
     }
}

export default MatchHistory
