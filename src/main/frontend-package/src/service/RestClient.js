import axios from 'axios'
const axiosInstance = axios.create({
    baseURL: import.meta.env.VITE_API_URL,
    
})
axiosInstance.interceptors.request.use(
    config => {
        if (config.url.startsWith("/api/admin") || config.url.startsWith("/api/user")) {
            const jwtToken = localStorage.getItem('jwt');
            if (jwtToken) {
                config.headers.Authorization = `Bearer ${jwtToken}`;
            }
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);
const RestClient = {
    get:
        async (endpoint, config = {}) => {
            try {
                let resp = await axiosInstance.get(endpoint, config);
                return resp;
            } catch (error) {
                if(error.response?.status===403) return error.response 
                console.log('Error @ Get in RestClient', error)

            }
        },
    post:
        async (endpoint, body = {}, config = {}) => {
            try {
                let resp = await axiosInstance.post(endpoint, body, config);
                return resp;
            } catch (error) {
                if(error.response?.status===404&&error.response.config.url==='/api/login') return error.response 
                console.log('Error @ Post in RestClient', error)
            }
        },
}
export default RestClient