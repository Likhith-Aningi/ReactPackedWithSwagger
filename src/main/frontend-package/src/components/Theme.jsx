import React, { useContext } from 'react'
import Context from './Context'
function Theme() {
    const {theme,setMode} = useContext(Context);
    const changeTheme=e=>{
        localStorage.setItem('mode',e.target.checked?'dark':'light');
        setMode(e.target.checked?'dark':'light')
    }
    return (
        <span style={{ float: 'right' }}>
            <label>
                Need Dark?
                <input type='checkbox'
                    checked={theme==='dark'}
                    onChange={e=>changeTheme(e)}   
                />
            </label>
        </span>
    )
}

export default Theme