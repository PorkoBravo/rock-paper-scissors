import axios from 'axios'


export function playNewRound() {
    return axios.post('http://localhost:8085/match');
}

export function getTotalMatchHistory() {
    return axios.get('http://localhost:8085/history');
}
