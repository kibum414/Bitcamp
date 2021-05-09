import axios from 'axios'

const fetch = () => axios.get(`http://localhost:8080/users/fetch`)
const signup = () => axios.get(`http://localhost:8080/users/signup`, {})

export default { fetch, signup }