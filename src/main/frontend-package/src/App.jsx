import { useState } from 'react';
import {
  BrowserRouter,
  NavLink,
  Route,
  Routes,
} from "react-router-dom";
import './App.css';
import Admin from './components/Admin';
import Context from './components/Context';
import Home from './components/Home';
import Index from './components/Index';
import Login from './components/Login';
import Logout from './components/Logout';
import NotFound from './components/NotFound';
import Theme from './components/Theme';
import User from './components/User';
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
