import axios from 'axios'


export function playNewRound() {
    return axios.post('http://localhost:8085/match');
}