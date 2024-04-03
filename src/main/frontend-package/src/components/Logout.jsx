import RestClient from '../service/RestClient';
import {useNavigate} from 'react-router-dom'
const Logout = () => {
  const navigate=useNavigate();
  const handleLogout = async () => {
    if (localStorage.getItem('jwt') !== null) {
      try {
        const resp = await RestClient.post('/api/logout', localStorage.getItem('jwt'),{responseType:'text'});
        alert(resp.data);
      } catch (error) {
        console.error("Error occurred during logout:", error);
      } finally {
        localStorage.removeItem('jwt');
      }
    }
    navigate('/')
  }

  return (
    <button onClick={handleLogout}>Logout</button>
  );
}

export default Logout