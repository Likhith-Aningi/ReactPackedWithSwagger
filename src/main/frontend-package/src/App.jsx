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
import { useState } from 'react';
function App() {
  const [mode, setMode] = useState(localStorage.getItem('mode') ?? 'dark');
  const appMode = mode == 'dark' ? 'app-dark' : 'app';
  return (<div className={appMode}>
    <Context.Provider value={{ cData: 'japan', theme: mode, setMode }}>

      <BrowserRouter>
        <div>
          <nav id="navBar" style={{ paddingTop: '10px' }}>
            <NavLink to="/home" style={{ padding: 5 }} >home</NavLink>
            <NavLink to="/" style={{ padding: 5 }}>index</NavLink>

          </nav>
        </div>
        <Theme />
        <Routes>
          <Route path="/" element={<Index />} />
          <Route path="/home" element={<Home />} />
          <Route path="*" element={<NotFound />} />
        </Routes>

      </BrowserRouter>
    </Context.Provider>
  </div>
  );

}

export default App
