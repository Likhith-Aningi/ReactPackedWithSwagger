import React, { useEffect, useState } from 'react'
import { Navigate } from 'react-router-dom'
import RestClient from '../service/RestClient';

function Admin() {
    const [data, setData] = useState('loading');
    const [redirectToLogin, setRedirectToLogin] = useState(false);
    const getAdminData = async () => {
        const resp = await RestClient.get("/api/admin");
        if(resp.status===403){
            setData('you are not authroized')
            return;
        }
        setData(resp.data.data);
    }
    useEffect(
        () => {
            if (localStorage.getItem('jwt') == null) {
                setRedirectToLogin(true);
                return
            }
            try {
                getAdminData();
            } catch (error) {
                console.error(error);
                setData('Try Again')
            }
        }, []
    );
    if (redirectToLogin)
        return <Navigate to="/login" state={{ from: 'admin' }} replace />
    return (
        <div>{data}</div>
    )
}

export default Admin