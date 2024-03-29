import React from 'react'
import axios from 'axios'
const axiosInstance=axios.create({
    baseURL:import.meta.env.VITE_API_URL
})
const RestClient={
    get:
        async(endpoint,headers={},params={})=>{
            try {
                let resp=await axiosInstance.get(endpoint);
                return resp;
            } catch (error) {
                console.log('Error @ Get in RestClient',error)
            }
        },
    post:
    async(endpoint,headers={},body={})=>{
        try {
            let resp=await axiosInstance.post(endpoint);
                return resp;
        } catch (error) {
            console.log('Error @ Post in RestClient',error)
        }
    },
}
export default RestClient