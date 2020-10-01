import React from 'react'
import {playNewRound} from '../api/api'

class MatchTable extends React.Component {
    constructor(props) {
       super()
       this.state = {
          matchs: [
             {}
          ],
          tableHeader: ["#Rounds","Player 1 Shape", "Player 2 Shape", "Result"],
          totalRounds: 0
       }
    }


    restartMatchTable() {
      this.setState((state) => {
         return {matchs: [{}], totalRounds: 0}
       });
    }

    playRound() {
      playNewRound()
      .then((res) => {
        this.addMatch({ shape1: res.data.player1Shape, shape2: res.data.player2Shape, result: res.data.result })
      })
      .catch((err) => console.log(err));
    }

    addMatch(match) {
      let updatedMatches = this.state.matchs
      updatedMatches.push( { round: this.state.totalRounds, shape1: match.shape1, shape2:  match.shape2, result:  match.result })
      const _totalRounds = this.state.totalRounds +1 
      this.setState({matchs: updatedMatches, totalRounds: _totalRounds})
   }
 
    renderTableData() {
      return this.state.matchs.map((match, index) => {
         const { round, shape1, shape2, result } = match
         return (
            <tr key={round}>
               <td>{round}</td>
               <td>{shape1}</td>
               <td>{shape2}</td>
               <td>{result}</td>
            </tr>
         )
      })
   }

   renderTableHeader() {
      let header = Object.values(this.state.tableHeader)
      return header.map((key, index) => {
         return <th key={index}>{key}</th>
      })
   }

   render() {
      return (
         <div>
            <h1 id='title'>Rock Scissors Paper Matches</h1>
            <button id="restartTable" onClick={() => this.restartMatchTable()}>Restart</button>
            <button id="playRound" onClick={() => this.playRound()}>Play round!</button>
            <table id='matchs'>
               <tbody>
                  <tr>{this.renderTableHeader()}</tr>
                  {this.renderTableData()}
               </tbody>
            </table>
         </div>
      )
   }
 }

 export default MatchTable
 