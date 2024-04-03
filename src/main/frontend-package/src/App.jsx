import './App.css'
import {
  Route,
  Routes,
  NavLink,
  BrowserRouter,
} from "react-router-dom";
import Index from './components/Index';
import Home from './components/Home';
import NotFound from './components/NotFound';
import Theme from './components/Theme';
import Context from './components/Context';
import Login from './components/Login';
import User from './components/User';
import Admin from './components/Admin';
import Logout from './components/Logout';
import { useState } from 'react';
function App() {
  const [mode, setMode] = useState(localStorage.getItem('mode') ?? 'dark');
  const appMode = mode == 'dark' ? 'app-dark' : 'app';
  return (<div className={appMode}>
    <Context.Provider value={{ cData: 'japan', theme: mode, setMode }}>

      <BrowserRouter>
        <div>
          <nav id="navBar" style={{ paddingTop: '10px' }}>
            <NavLink to="/" style={{ padding: 5 }}>index</NavLink>
            <NavLink to="/home" style={{ padding: 5 }} >home</NavLink>
            <NavLink to="/user" style={{ padding: 5 }}>User sec</NavLink>
            <NavLink to="/admin" style={{ padding: 5 }}>Admin sec</NavLink>
            <Logout/>
          </nav>
        </div>
        <Theme />
        <Routes>
          <Route path="/" element={<Index />} />
          <Route path="/login" element={<Login />}/>
          <Route path="/home" element={<Home />} />
          <Route path="/user" element={<User />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="*" element={<NotFound />} />
        </Routes>

      </BrowserRouter>
    </Context.Provider>
  </div>
  );

}

export default App
