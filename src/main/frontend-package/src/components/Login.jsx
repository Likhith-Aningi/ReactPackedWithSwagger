import React, { useEffect } from 'react'
import { useForm } from 'react-hook-form'
import RestClient from '../service/RestClient';
import { useLocation, useNavigate, Navigate } from 'react-router-dom';
function Login() {
    const { register, handleSubmit, formState: { errors } } = useForm();
    const { state } = useLocation();
    const navigate = useNavigate();
    const onSubmit = async (data) => {
        const resp = await RestClient.post('/api/login', data);
        console.log(resp);
        console.log(state);
        if (resp.data?.token)
            localStorage.setItem("jwt", resp.data?.token)
        else localStorage.removeItem("jwt");
        if (state?.from === 'admin') {
            navigate('/admin')
        }else if (state?.from === 'user') {
            navigate('/user')
        } else {
            navigate('/');
        }

    }
    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <input {...register("username", { required: true })} type='text' placeholder='username' /><br />
            {errors.username && <><span style={{ color: 'red' }}>user name is required</span><br /></>}
            <input {...register("password", { required: true, minLength: 4 })} type='password' placeholder='password' /><br />
            {errors.password && <><span style={{ color: 'red' }}>password is required with minimum of 4 chars</span><br /></>}
            <button type='submit'>Login</button>
        </form>
    )
}

export default Login