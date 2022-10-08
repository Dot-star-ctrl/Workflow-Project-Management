import axios from "axios";

const axiosClient = axios.create({
    baseURL: "http://localhost:8443/"
})

export default axiosClient;
