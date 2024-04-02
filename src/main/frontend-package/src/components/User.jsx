import React, { useEffect, useState } from 'react';
import { Navigate } from 'react-router-dom';
import RestClient from '../service/RestClient';

function User() {
    const [data, setData] = useState('loading');
    const [redirectToLogin, setRedirectToLogin] = useState(false);
    const getUserData = async () => {
        const resp = await RestClient.get("/api/user");
        setData(resp.data.data);
    }
    useEffect(() => {
        if (localStorage.getItem('jwt') == null) {
            setRedirectToLogin(true);
            return
        }
        try {
            getUserData();
        } catch (error) {
            console.error(error);
            setData('Try Again')
        }
    }, [])
    if (redirectToLogin)
        return <Navigate to="/login" state={{ from: 'user' }} replace />
    return (
        <div>Hello this is {data}</div>
    )
}

export default User